/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Database.DatabaseConnection;
import Model.Kostum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class KostumDAO {
    public void tambahKostum(Kostum kostum) {
        String sql = "INSERT INTO kostum "
                + "(id_kostum, nama, kategori, ukuran, harga_sewa) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kostum.getIdKostum());
            ps.setString(2, kostum.getNama());
            ps.setString(3, kostum.getKategori());
            ps.setInt(4, kostum.getUkuran());
            ps.setDouble(5, kostum.getHargaSewa());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Gagal menambah data kostum: " + e.getMessage());
        }
    }

    public ArrayList<Kostum> tampilKostum() {
        ArrayList<Kostum> daftarKostum = new ArrayList<>();

        String sql = "SELECT * FROM kostum";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Kostum kostum = new Kostum(
                        rs.getString("id_kostum"),
                        rs.getString("nama"),
                        rs.getString("kategori"),
                        rs.getInt("ukuran"),
                        rs.getDouble("harga_sewa")
                );

                daftarKostum.add(kostum);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengambil data kostum: " + e.getMessage());
        }

        return daftarKostum;
    }

    public Kostum cariKostum(String idKostum) {
        String sql = "SELECT * FROM kostum WHERE id_kostum = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idKostum);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Kostum(
                            rs.getString("id_kostum"),
                            rs.getString("nama"),
                            rs.getString("kategori"),
                            rs.getInt("ukuran"),
                            rs.getDouble("harga_sewa")
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Gagal mencari data kostum: " + e.getMessage());
        }

        return null;
    }

    public void updateKostum(String idKostum, String nama,
                             String kategori, int ukuran,
                             double hargaSewa) {

        String sql = "UPDATE kostum SET nama = ?, kategori = ?, "
                + "ukuran = ?, harga_sewa = ? WHERE id_kostum = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nama);
            ps.setString(2, kategori);
            ps.setInt(3, ukuran);
            ps.setDouble(4, hargaSewa);
            ps.setString(5, idKostum);

            int hasil = ps.executeUpdate();

            if (hasil == 0) {
                throw new IllegalArgumentException("Data kostum tidak ditemukan");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengubah data kostum: " + e.getMessage());
        }
    }

    public void hapusKostum(String idKostum) {
        String sql = "DELETE FROM kostum WHERE id_kostum = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idKostum);

            int hasil = ps.executeUpdate();

            if (hasil == 0) {
                throw new IllegalArgumentException("Data kostum tidak ditemukan");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Gagal menghapus data kostum: " + e.getMessage());
        }
    }
}
