/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import java.util.Scanner;
import Model.Kostum;
import Model.Pelanggan;
import Controller.KostumController;
import Controller.PelangganController;
import Controller.PeminjamanController;
/**
 *
 * @author LENOVO
 */
public class MenuView {
    
    private Scanner scanner;
    private KostumController kostumController;
    private PelangganController pelangganController;
    private PeminjamanController peminjamanController;

    public MenuView(){
        scanner = new Scanner(System.in);
        kostumController = new KostumController();
        pelangganController = new PelangganController();
        peminjamanController = new PeminjamanController();
    }

    public void tampilMenu(){
        int pilihan;

        do{
            System.out.println("\n==============================");
            System.out.println(" SISTEM PEMINJAMAN KOSTUM ");
            System.out.println("==============================");
            System.out.println("1. Kelola Kostum");
            System.out.println("2. Kelola Pelanggan");
            System.out.println("3. Kelola Peminjaman");
            System.out.println("0. Keluar");

            pilihan = inputInteger("Pilih menu : ");

            switch(pilihan){
                case 1:
                    menuKostum();
                    break;

                case 2:
                    menuPelanggan();
                    break;

                case 3:
                    menuPeminjaman();
                    break;

                case 0:
                    System.out.println("Program selesai");
                    break;

                default:
                    System.out.println("Menu tidak tersedia");
            }

        }while(pilihan != 0);
    }


    private void menuKostum(){
        int pilihan;

        do{
            System.out.println("\n===== MENU KOSTUM =====");
            System.out.println("1. Tambah Kostum");
            System.out.println("2. Lihat Kostum");
            System.out.println("3. Cari Kostum");
            System.out.println("4. Update Kostum");
            System.out.println("5. Hapus Kostum");
            System.out.println("0. Kembali");

            pilihan = inputInteger("Pilih menu : ");

            try{

                switch(pilihan){

                    case 1:
                        Kostum kostum = new Kostum(
                                inputString("ID Kostum (Contoh: K002) : "),
                                inputString("Nama Kostum (Contoh: Iron Man) : "),
                                inputString("Kategori (Contoh: Profesi, Superhero, Adat) : "),
                                inputInteger("Ukuran (Contoh: 39, 40, 41) : "),
                                inputDouble("Harga Sewa (Contoh: 150000) : ")
                         );

                            kostumController.tambahKostum(kostum);

                             System.out.println("Data kostum berhasil ditambahkan");
                             break;


                    case 2:
                        kostumController.tampil();
                        break;


                    case 3:
                        Kostum hasil = kostumController.cariKostum(
                                inputString("ID Kostum : ")
                        );

                        if(hasil != null){
                            hasil.tampilData();
                        }else{
                            System.out.println("Data tidak ditemukan");
                        }
                        break;


                    case 4:
                        kostumController.updateKostum(
                              inputString("ID Kostum (Contoh: K001) : "),
                              inputString("Nama Kostum baru (Contoh: Dokter) : "),
                              inputString("Kategori baru (Contoh: Profesi, Superhero, Adat) : "),
                              inputInteger("Ukuran baru (Contoh: 39, 40, 41) : "),
                              inputDouble("Harga baru (Contoh: 150000) : ")
                             );

                    System.out.println("Data berhasil diupdate");
                     break;


                    case 5:
                        kostumController.hapusKostum(
                                inputString("ID Kostum : ")
                        );

                        System.out.println("Data berhasil dihapus");
                        break;


                    case 0:
                        break;


                    default:
                        System.out.println("Menu tidak tersedia");
                }

            }catch(Exception e){
                System.out.println("Error : " + e.getMessage());
            }

        }while(pilihan != 0);
    }


    private void menuPelanggan(){
        int pilihan;

        do{
            System.out.println("\n===== MENU PELANGGAN =====");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Lihat Pelanggan");
            System.out.println("3. Cari Pelanggan");
            System.out.println("4. Update Pelanggan");
            System.out.println("5. Hapus Pelanggan");
            System.out.println("0. Kembali");

            pilihan = inputInteger("Pilih menu : ");

            try{

                switch(pilihan){

                    case 1:
                        Pelanggan pelanggan = new Pelanggan(
                                inputString("ID Pelanggan : "),
                                inputString("Nama : "),
                                inputString("Nomor Telepon : "),
                                inputString("Alamat : ")
                        );

                        pelangganController.tambahPelanggan(pelanggan);

                        System.out.println("Data pelanggan berhasil ditambahkan");
                        break;


                    case 2:
                        pelangganController.tampil();
                        break;


                    case 3:
                        Pelanggan hasil = pelangganController.cariPelanggan(
                                inputString("ID Pelanggan : ")
                        );

                        if(hasil != null){
                            hasil.tampilData();
                        }else{
                            System.out.println("Data tidak ditemukan");
                        }
                        break;


                    case 4:
                        pelangganController.updatePelanggan(
                        inputString("ID Pelanggan : "),
                        inputString("Nama baru : "),
                        inputString("Nomor Telepon baru : "),
                        inputString("Alamat baru : ")
                        );

                        System.out.println("Data berhasil diupdate");
                        break;


                    case 5:
                        pelangganController.hapusPelanggan(
                                inputString("ID Pelanggan : ")
                        );

                        System.out.println("Data berhasil dihapus");
                        break;


                    case 0:
                        break;


                    default:
                        System.out.println("Menu tidak tersedia");
                }

            }catch(Exception e){
                System.out.println("Error : " + e.getMessage());
            }

        }while(pilihan != 0);
    }


    private void menuPeminjaman(){
        int pilihan;

        do{
            System.out.println("\n===== MENU PEMINJAMAN =====");
            System.out.println("1. Tambah Peminjaman");
            System.out.println("2. Lihat Peminjaman");
            System.out.println("3. Pengembalian Kostum");
            System.out.println("4. Hapus Peminjaman");
            System.out.println("0. Kembali");

            pilihan = inputInteger("Pilih menu : ");

            try{

                switch(pilihan){

                    case 1:
                        peminjamanController.tambahPeminjaman(
                                inputString("ID Peminjaman : "),
                                inputString("ID Pelanggan : "),
                                inputString("ID Kostum : "),
                                inputString("Tanggal Pinjam (dd-MM-yyyy) : "),
                                inputString("Tanggal Pengembalian (dd-MM-yyyy) : ")
                        );

                        System.out.println("Peminjaman berhasil");
                        break;


                    case 2:
                        peminjamanController.tampil();
                        break;


                    case 3:
                        peminjamanController.kembalikanKostum(
                                inputString("ID Peminjaman : ")
                        );

                        System.out.println("Kostum berhasil dikembalikan");
                        break;


                    case 4:
                        peminjamanController.hapusPeminjaman(
                                inputString("ID Peminjaman : ")
                        );

                        System.out.println("Data berhasil dihapus");
                        break;


                    case 0:
                        break;


                    default:
                        System.out.println("Menu tidak tersedia");
                }

            }catch(Exception e){
                System.out.println("Error : " + e.getMessage());
            }

        }while(pilihan != 0);
    }


    private int inputInteger(String pesan){

        while(true){

            try{
                System.out.print(pesan);
                return Integer.parseInt(scanner.nextLine());

            }catch(Exception e){
                System.out.println("Input harus berupa angka");
            }

        }
    }


    private double inputDouble(String pesan){

        while(true){

            try{
                System.out.print(pesan);
                return Double.parseDouble(scanner.nextLine());

            }catch(Exception e){
                System.out.println("Input harus berupa angka");
            }

        }
    }


    private String inputString(String pesan){

        System.out.print(pesan);
        return scanner.nextLine();

    }

   public void mulai(){

    tampilMenu();

}

}