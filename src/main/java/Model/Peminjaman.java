/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author LENOVO
 */
public class Peminjaman {
    private final String idPeminjaman;
    private Pelanggan pelanggan;
    private Kostum kostum;
    private String tanggalPinjam;
    private String tanggalPengembalian;
    private String statusPeminjaman;


    public Peminjaman(
            String idPeminjaman,
            Pelanggan pelanggan,
            Kostum kostum,
            String tanggalPinjam,
            String tanggalPengembalian
    ) {

        if (idPeminjaman == null || idPeminjaman.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID Peminjaman tidak boleh kosong"
            );

        }


        this.idPeminjaman = idPeminjaman;

        setPelanggan(pelanggan);
        setKostum(kostum);
        
        this.statusPeminjaman = "Dipinjam";
        
        setTanggalPinjam(tanggalPinjam);
        setTanggalPengembalian(tanggalPengembalian);
    }


    public String getIdPeminjaman() {
        return idPeminjaman;
    }


    public Pelanggan getPelanggan() {
        return pelanggan;
    }


    public void setPelanggan(Pelanggan pelanggan) {

        if (pelanggan == null) {

            throw new IllegalArgumentException(
                    "Data pelanggan tidak boleh kosong"
            );

        }

        this.pelanggan = pelanggan;

    }


    public Kostum getKostum() {
        return kostum;
    }


    public void setKostum(Kostum kostum) {

        if (kostum == null) {

            throw new IllegalArgumentException(
                    "Data kostum tidak boleh kosong"
            );

        }

        this.kostum = kostum;

    }


    public String getTanggalPinjam() {
        return tanggalPinjam;
    }


    public void setTanggalPinjam(String tanggalPinjam) {

    if(tanggalPinjam == null ||
       tanggalPinjam.trim().isEmpty()) {

        throw new IllegalArgumentException(
                "Tanggal pinjam tidak boleh kosong"
        );

    }

    validasiFormatTanggal(tanggalPinjam);

    this.tanggalPinjam = tanggalPinjam;

}
    public String getTanggalPengembalian() {
    return tanggalPengembalian;
}

    public void setTanggalPengembalian(String tanggalPengembalian) {
        

    if(tanggalPengembalian == null ||
       tanggalPengembalian.trim().isEmpty()) {

        throw new IllegalArgumentException(
                "Tanggal pengembalian tidak boleh kosong"
        );

    }


    validasiFormatTanggal(tanggalPengembalian);


    DateTimeFormatter format =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");


    LocalDate pinjam =
            LocalDate.parse(
                    tanggalPinjam,
                    format
            );


    LocalDate kembali =
            LocalDate.parse(
                    tanggalPengembalian,
                    format
            );


    if(kembali.isBefore(pinjam)){

        throw new IllegalArgumentException(
                "Tanggal pengembalian tidak boleh sebelum tanggal pinjam"
        );

    }


    this.tanggalPengembalian = tanggalPengembalian;

}


    public String getStatusPeminjaman() {
        return statusPeminjaman;
    }

    public void kembalikanKostum(){

    if(statusPeminjaman.equals("Dikembalikan")){

        throw new IllegalStateException(
                "Kostum sudah dikembalikan"
        );

    }


    this.statusPeminjaman = "Dikembalikan";

}
    
    private void validasiFormatTanggal(String tanggal){

    DateTimeFormatter format =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");


    try{

        LocalDate.parse(
                tanggal,
                format
        );

    }catch(DateTimeParseException e){

        throw new IllegalArgumentException(
                "Format tanggal harus dd-MM-yyyy"
        );

    }

}


    public void tampilData(){

        System.out.println("ID Peminjaman : " + idPeminjaman);
        System.out.println(
                "Nama Pelanggan : "
                + pelanggan.getNama()
        );
        System.out.println(
                "Kostum : "
                + kostum.getNama()
        );
        System.out.println(
                "Tanggal Pinjam : "
                + tanggalPinjam
        );
        System.out.println(
                "Tanggal Pengembalian : "
                + tanggalPengembalian
        );
        System.out.println(
                "Status : "
                + statusPeminjaman
        );

    }

}
