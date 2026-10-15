/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import Model.Pelanggan;
import DAO.PelangganDAO;
import Interface.CRUDInterface;
/**
 *
 * @author LENOVO
 */
public class PelangganController implements CRUDInterface<Pelanggan> {
    private final PelangganDAO pelangganDAO;

    public PelangganController() {
        pelangganDAO = new PelangganDAO();
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        if (pelanggan == null) {
            throw new IllegalArgumentException(
                    "Data pelanggan tidak boleh kosong"
            );
        }

        if (pelangganDAO.cariPelanggan(
                pelanggan.getIdPelanggan()) != null) {

            throw new IllegalArgumentException(
                    "ID Pelanggan sudah digunakan"
            );
        }

        pelangganDAO.tambahPelanggan(pelanggan);
    }

    public ArrayList<Pelanggan> tampilSemuaPelanggan() {
        return pelangganDAO.tampilPelanggan();
    }

    public Pelanggan cariPelanggan(String idPelanggan) {
        if (idPelanggan == null ||
            idPelanggan.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID Pelanggan tidak boleh kosong"
            );
        }

        return pelangganDAO.cariPelanggan(idPelanggan);
    }

    public void updatePelanggan(
            String idPelanggan,
            String nama,
            String nomorTelepon,
            String alamat
    ) {

        if (idPelanggan == null ||
            idPelanggan.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID Pelanggan tidak boleh kosong"
            );
        }

        if (pelangganDAO.cariPelanggan(idPelanggan) == null) {
            throw new IllegalArgumentException(
                    "Data pelanggan tidak ditemukan"
            );
        }

        pelangganDAO.updatePelanggan(
                idPelanggan,
                nama,
                nomorTelepon,
                alamat
        );
    }

    public void hapusPelanggan(String idPelanggan) {
        if (idPelanggan == null ||
            idPelanggan.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID Pelanggan tidak boleh kosong"
            );
        }

        if (pelangganDAO.cariPelanggan(idPelanggan) == null) {
            throw new IllegalArgumentException(
                    "Data pelanggan tidak ditemukan"
            );
        }

        pelangganDAO.hapusPelanggan(idPelanggan);
    }

    @Override
    public void tambah(Pelanggan pelanggan) {
        tambahPelanggan(pelanggan);
    }

    @Override
    public void tampil() {
        ArrayList<Pelanggan> daftar =
                tampilSemuaPelanggan();

        if (daftar.isEmpty()) {
            System.out.println(
                    "Data pelanggan belum tersedia"
            );
            return;
        }

        for (Pelanggan p : daftar) {
            p.tampilData();
            System.out.println();
        }
    }

    @Override
    public void update(String id) {
        Pelanggan pelanggan =
                cariPelanggan(id);

        if (pelanggan == null) {
            throw new IllegalArgumentException(
                    "Data pelanggan tidak ditemukan"
            );
        }

        System.out.println(
                "Gunakan updatePelanggan() untuk mengubah data"
        );
    }

    @Override
    public void hapus(String id) {
        hapusPelanggan(id);
    }
}