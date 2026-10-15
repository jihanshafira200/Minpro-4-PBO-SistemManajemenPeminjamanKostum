package DAO;
import Database.DatabaseConnection;
import Model.Pelanggan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class PelangganDAO {
    public void tambahPelanggan(Pelanggan pelanggan) {
        String sql = "INSERT INTO pelanggan "
                + "(id_pelanggan, nama, nomor_telepon, alamat) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pelanggan.getIdPelanggan());
            ps.setString(2, pelanggan.getNama());
            ps.setString(3, pelanggan.getNomorTelepon());
            ps.setString(4, pelanggan.getAlamat());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Gagal menambah data pelanggan: " + e.getMessage()
            );
        }
    }

    public ArrayList<Pelanggan> tampilPelanggan() {
        ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();

        String sql = "SELECT * FROM pelanggan";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Pelanggan pelanggan = new Pelanggan(
                        rs.getString("id_pelanggan"),
                        rs.getString("nama"),
                        rs.getString("nomor_telepon"),
                        rs.getString("alamat")
                );

                daftarPelanggan.add(pelanggan);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Gagal mengambil data pelanggan: " + e.getMessage()
            );
        }

        return daftarPelanggan;
    }

    public Pelanggan cariPelanggan(String idPelanggan) {
        String sql =
                "SELECT * FROM pelanggan WHERE id_pelanggan = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idPelanggan);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Pelanggan(
                            rs.getString("id_pelanggan"),
                            rs.getString("nama"),
                            rs.getString("nomor_telepon"),
                            rs.getString("alamat")
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Gagal mencari data pelanggan: " + e.getMessage()
            );
        }

        return null;
    }

    public void updatePelanggan(
            String idPelanggan,
            String nama,
            String nomorTelepon,
            String alamat
    ) {

        String sql = "UPDATE pelanggan "
                + "SET nama = ?, nomor_telepon = ?, alamat = ? "
                + "WHERE id_pelanggan = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nama);
            ps.setString(2, nomorTelepon);
            ps.setString(3, alamat);
            ps.setString(4, idPelanggan);

            int hasil = ps.executeUpdate();

            if (hasil == 0) {
                throw new IllegalArgumentException(
                        "Data pelanggan tidak ditemukan"
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Gagal mengubah data pelanggan: " + e.getMessage()
            );
        }
    }

    public void hapusPelanggan(String idPelanggan) {
        String sql =
                "DELETE FROM pelanggan WHERE id_pelanggan = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idPelanggan);

            int hasil = ps.executeUpdate();

            if (hasil == 0) {
                throw new IllegalArgumentException(
                        "Data pelanggan tidak ditemukan"
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Gagal menghapus data pelanggan: " + e.getMessage()
            );
        }
    }
}
