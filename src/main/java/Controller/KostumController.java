/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import Model.Kostum;
import DAO.KostumDAO;
import Interface.CRUDInterface;
/**
 *
 * @author LENOVO
 */
public class KostumController implements CRUDInterface<Kostum> {
    private final KostumDAO kostumDAO;

    public KostumController() {
        kostumDAO = new KostumDAO();
    }

    public void tambahKostum(Kostum kostum) {
        if (kostum == null) {
            throw new IllegalArgumentException(
                    "Data kostum tidak boleh kosong"
            );
        }

        if (kostumDAO.cariKostum(kostum.getIdKostum()) != null) {
            throw new IllegalArgumentException(
                    "ID Kostum sudah digunakan"
            );
        }

        kostumDAO.tambahKostum(kostum);
    }

    public ArrayList<Kostum> tampilSemuaKostum() {
        return kostumDAO.tampilKostum();
    }

    public Kostum cariKostum(String idKostum) {
        if (idKostum == null ||
            idKostum.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID Kostum tidak boleh kosong"
            );
        }

        return kostumDAO.cariKostum(idKostum);
    }

    public void updateKostum(
            String idKostum,
            String nama,
            String kategori,
            int ukuran,
            double hargaSewa
    ) {

        if (idKostum == null ||
            idKostum.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID Kostum tidak boleh kosong"
            );
        }

        if (kostumDAO.cariKostum(idKostum) == null) {
            throw new IllegalArgumentException(
                    "Data kostum tidak ditemukan"
            );
        }

        kostumDAO.updateKostum(
                idKostum,
                nama,
                kategori,
                ukuran,
                hargaSewa
        );
    }

    public void hapusKostum(String idKostum) {
        if (idKostum == null ||
            idKostum.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID Kostum tidak boleh kosong"
            );
        }

        if (kostumDAO.cariKostum(idKostum) == null) {
            throw new IllegalArgumentException(
                    "Data kostum tidak ditemukan"
            );
        }

        kostumDAO.hapusKostum(idKostum);
    }

    @Override
    public void tambah(Kostum kostum) {
        tambahKostum(kostum);
    }

    @Override
    public void tampil() {
        ArrayList<Kostum> daftar =
                tampilSemuaKostum();

        if (daftar.isEmpty()) {
            System.out.println(
                    "Data kostum belum tersedia"
            );
            return;
        }

        for (Kostum k : daftar) {
            k.tampilData();
            System.out.println();
        }
    }

    @Override
    public void update(String id) {
        Kostum kostum = cariKostum(id);

        if (kostum == null) {
            throw new IllegalArgumentException(
                    "Data kostum tidak ditemukan"
            );
        }

        System.out.println(
                "Gunakan updateKostum() untuk mengubah data"
        );
    }

    @Override
    public void hapus(String id) {
        hapusKostum(id);
    }
}