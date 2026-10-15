/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Peminjaman;
import Model.Pelanggan;
import Model.Kostum;
import java.util.ArrayList;
import DAO.PeminjamanDAO;
import DAO.PelangganDAO;
import DAO.KostumDAO;
import Interface.CRUDInterface;
/**
 *
 * @author LENOVO
 */
public class PeminjamanController implements CRUDInterface<Peminjaman> {
    private final PeminjamanDAO peminjamanDAO;
    private final PelangganDAO pelangganDAO;
    private final KostumDAO kostumDAO;

    public PeminjamanController() {
        peminjamanDAO = new PeminjamanDAO();
        pelangganDAO = new PelangganDAO();
        kostumDAO = new KostumDAO();
    }

    public void tambahPeminjaman(
            String idPeminjaman,
            String idPelanggan,
            String idKostum,
            String tanggalPinjam,
            String tanggalPengembalian
    ) {

        if (idPeminjaman == null ||
            idPeminjaman.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID Peminjaman tidak boleh kosong"
            );
        }

        if (peminjamanDAO.cariPeminjaman(idPeminjaman) != null) {
            throw new IllegalArgumentException(
                    "ID Peminjaman sudah digunakan"
            );
        }

        Pelanggan pelanggan =
                pelangganDAO.cariPelanggan(idPelanggan);

        if (pelanggan == null) {
            throw new IllegalArgumentException(
                    "Pelanggan tidak ditemukan"
            );
        }

        Kostum kostum =
                kostumDAO.cariKostum(idKostum);

        if (kostum == null) {
            throw new IllegalArgumentException(
                    "Kostum tidak ditemukan"
            );
        }

        if (peminjamanDAO.cekKostumDipinjam(idKostum)) {
            throw new IllegalArgumentException(
                    "Kostum sedang dipinjam"
            );
        }

        Peminjaman peminjaman =
                new Peminjaman(
                        idPeminjaman,
                        pelanggan,
                        kostum,
                        tanggalPinjam,
                        tanggalPengembalian
                );

        peminjamanDAO.tambahPeminjaman(peminjaman);
    }

    public ArrayList<Peminjaman> tampilSemuaPeminjaman() {
        return peminjamanDAO.tampilPeminjaman();
    }

    public Peminjaman cariPeminjaman(
            String idPeminjaman
    ) {

        if (idPeminjaman == null ||
            idPeminjaman.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID Peminjaman tidak boleh kosong"
            );
        }

        return peminjamanDAO.cariPeminjaman(idPeminjaman);
    }

    public void kembalikanKostum(
            String idPeminjaman
    ) {

        Peminjaman peminjaman =
                cariPeminjaman(idPeminjaman);

        if (peminjaman == null) {
            throw new IllegalArgumentException(
                    "Data peminjaman tidak ditemukan"
            );
        }

        if ("Dikembalikan".equals(
                peminjaman.getStatusPeminjaman())) {

            throw new IllegalStateException(
                    "Kostum sudah dikembalikan"
            );
        }

        peminjamanDAO.updateStatusPengembalian(
                idPeminjaman
        );
    }

    public void hapusPeminjaman(
            String idPeminjaman
    ) {

        if (cariPeminjaman(idPeminjaman) == null) {
            throw new IllegalArgumentException(
                    "Data peminjaman tidak ditemukan"
            );
        }

        peminjamanDAO.hapusPeminjaman(
                idPeminjaman
        );
    }

    @Override
    public void tambah(Peminjaman peminjaman) {

        if (peminjaman == null) {
            throw new IllegalArgumentException(
                    "Data peminjaman tidak boleh kosong"
            );
        }

        if (peminjamanDAO.cariPeminjaman(
                peminjaman.getIdPeminjaman()) != null) {

            throw new IllegalArgumentException(
                    "ID Peminjaman sudah digunakan"
            );
        }

        if (peminjamanDAO.cekKostumDipinjam(
                peminjaman.getKostum().getIdKostum())) {

            throw new IllegalArgumentException(
                    "Kostum sedang dipinjam"
            );
        }

        peminjamanDAO.tambahPeminjaman(peminjaman);
    }

    @Override
    public void tampil() {

        ArrayList<Peminjaman> daftar =
                tampilSemuaPeminjaman();

        if (daftar.isEmpty()) {
            System.out.println(
                    "Data peminjaman belum tersedia"
            );
            return;
        }

        for (Peminjaman p : daftar) {
            p.tampilData();
            System.out.println();
        }
    }

    @Override
    public void update(String id) {
        kembalikanKostum(id);
    }

    @Override
    public void hapus(String id) {
        hapusPeminjaman(id);
    }
}