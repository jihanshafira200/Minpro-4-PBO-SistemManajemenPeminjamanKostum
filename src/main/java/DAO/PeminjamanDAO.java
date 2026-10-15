/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Database.DatabaseConnection;
import Model.Kostum;
import Model.Pelanggan;
import Model.Peminjaman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class PeminjamanDAO {
     public void tambahPeminjaman(Peminjaman peminjaman) {
        String sql = "INSERT INTO peminjaman "
                + "(id_peminjaman, id_pelanggan, id_kostum, "
                + "tanggal_pinjam, tanggal_pengembalian, status_peminjaman) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, peminjaman.getIdPeminjaman());
            ps.setString(2, peminjaman.getPelanggan().getIdPelanggan());
            ps.setString(3, peminjaman.getKostum().getIdKostum());
            ps.setString(4, peminjaman.getTanggalPinjam());
            ps.setString(5, peminjaman.getTanggalPengembalian());
            ps.setString(6, peminjaman.getStatusPeminjaman());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Gagal menambah data peminjaman: " + e.getMessage()
            );
        }
    }

    public ArrayList<Peminjaman> tampilPeminjaman() {
        ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();

        String sql =
                "SELECT p.id_peminjaman, "
                + "p.tanggal_pinjam, p.tanggal_pengembalian, "
                + "p.status_peminjaman, "
                + "pl.id_pelanggan, pl.nama AS nama_pelanggan, "
                + "pl.nomor_telepon, pl.alamat, "
                + "k.id_kostum, k.nama AS nama_kostum, "
                + "k.kategori, k.ukuran, k.harga_sewa "
                + "FROM peminjaman p "
                + "JOIN pelanggan pl "
                + "ON p.id_pelanggan = pl.id_pelanggan "
                + "JOIN kostum k "
                + "ON p.id_kostum = k.id_kostum";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Pelanggan pelanggan = new Pelanggan(
                        rs.getString("id_pelanggan"),
                        rs.getString("nama_pelanggan"),
                        rs.getString("nomor_telepon"),
                        rs.getString("alamat")
                );

                Kostum kostum = new Kostum(
                        rs.getString("id_kostum"),
                        rs.getString("nama_kostum"),
                        rs.getString("kategori"),
                        rs.getInt("ukuran"),
                        rs.getDouble("harga_sewa")
                );

                Peminjaman peminjaman = new Peminjaman(
                        rs.getString("id_peminjaman"),
                        pelanggan,
                        kostum,
                        ubahFormatTanggal(rs.getString("tanggal_pinjam")),
                        ubahFormatTanggal(rs.getString("tanggal_pengembalian"))
                );

                if ("Dikembalikan".equals(
                        rs.getString("status_peminjaman"))) {
                    peminjaman.kembalikanKostum();
                }

                daftarPeminjaman.add(peminjaman);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Gagal mengambil data peminjaman: " + e.getMessage()
            );
        }

        return daftarPeminjaman;
    }

    public Peminjaman cariPeminjaman(String idPeminjaman) {
        String sql =
                "SELECT p.id_peminjaman, "
                + "p.tanggal_pinjam, p.tanggal_pengembalian, "
                + "p.status_peminjaman, "
                + "pl.id_pelanggan, pl.nama AS nama_pelanggan, "
                + "pl.nomor_telepon, pl.alamat, "
                + "k.id_kostum, k.nama AS nama_kostum, "
                + "k.kategori, k.ukuran, k.harga_sewa "
                + "FROM peminjaman p "
                + "JOIN pelanggan pl "
                + "ON p.id_pelanggan = pl.id_pelanggan "
                + "JOIN kostum k "
                + "ON p.id_kostum = k.id_kostum "
                + "WHERE p.id_peminjaman = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idPeminjaman);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Pelanggan pelanggan = new Pelanggan(
                            rs.getString("id_pelanggan"),
                            rs.getString("nama_pelanggan"),
                            rs.getString("nomor_telepon"),
                            rs.getString("alamat")
                    );

                    Kostum kostum = new Kostum(
                            rs.getString("id_kostum"),
                            rs.getString("nama_kostum"),
                            rs.getString("kategori"),
                            rs.getInt("ukuran"),
                            rs.getDouble("harga_sewa")
                    );

                    Peminjaman peminjaman = new Peminjaman(
                            rs.getString("id_peminjaman"),
                            pelanggan,
                            kostum,
                            ubahFormatTanggal(
                                    rs.getString("tanggal_pinjam")
                            ),
                            ubahFormatTanggal(
                                    rs.getString("tanggal_pengembalian")
                            )
                    );

                    if ("Dikembalikan".equals(
                            rs.getString("status_peminjaman"))) {
                        peminjaman.kembalikanKostum();
                    }

                    return peminjaman;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Gagal mencari data peminjaman: " + e.getMessage()
            );
        }

        return null;
    }

    public void updateStatusPengembalian(String idPeminjaman) {
        String sql =
                "UPDATE peminjaman "
                + "SET status_peminjaman = ? "
                + "WHERE id_peminjaman = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "Dikembalikan");
            ps.setString(2, idPeminjaman);

            int hasil = ps.executeUpdate();

            if (hasil == 0) {
                throw new IllegalArgumentException(
                        "Data peminjaman tidak ditemukan"
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Gagal mengubah status peminjaman: "
                    + e.getMessage()
            );
        }
    }

    public void hapusPeminjaman(String idPeminjaman) {
        String sql =
                "DELETE FROM peminjaman "
                + "WHERE id_peminjaman = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idPeminjaman);

            int hasil = ps.executeUpdate();

            if (hasil == 0) {
                throw new IllegalArgumentException(
                        "Data peminjaman tidak ditemukan"
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Gagal menghapus data peminjaman: "
                    + e.getMessage()
            );
        }
    }

    public boolean cekKostumDipinjam(String idKostum) {
        String sql =
                "SELECT id_peminjaman FROM peminjaman "
                + "WHERE id_kostum = ? "
                + "AND status_peminjaman = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idKostum);
            ps.setString(2, "Dipinjam");

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Gagal mengecek status kostum: "
                    + e.getMessage()
            );
        }
    }

    private String ubahFormatTanggal(String tanggalDatabase) {
        String[] bagian = tanggalDatabase.split("-");

        return bagian[2] + "-"
                + bagian[1] + "-"
                + bagian[0];
    }
}