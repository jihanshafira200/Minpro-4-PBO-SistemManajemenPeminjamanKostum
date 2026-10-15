# Minpro-4-PBO-SistemManajemenPeminjamanKostum

# Jihan Shafira Rahmah - 2509116073

## Deskripsi Program

Sistem Manajemen Peminjaman Kostum merupakan program berbasis Java yang digunakan untuk mengelola proses penyewaan kostum secara sederhana. Program ini memiliki fitur pengelolaan data kostum, data pelanggan, dan data peminjaman. Pengguna dapat melakukan proses tambah, tampil, cari, update, dan hapus data (CRUD). Program ini dibuat dengan menerapkan konsep Object Oriented Programming (OOP) seperti encapsulation, inheritance, abstraction, polymorphism, serta menerapkan struktur MVC untuk memisahkan tampilan, logika program, dan pengelolaan data.

---

## Struktur Package

Program ini menggunakan beberapa package dengan fungsi sebagai berikut:

### 1. Package Model

Package Model berfungsi untuk menyimpan class yang merepresentasikan objek utama dalam sistem. Pada package ini terdapat atribut, constructor, getter-setter, validasi data, serta method yang berkaitan dengan objek.

<img width="127" height="74" alt="image" src="https://github.com/user-attachments/assets/559acb34-fc31-4c66-a54c-4907dce71b5f" />

Penjelasan:

- Data.java merupakan abstract class yang menjadi superclass dari class Kostum dan Pelanggan.
- Kostum.java menyimpan data kostum seperti ID kostum, nama kostum, kategori, ukuran, dan harga sewa.
- Pelanggan.java menyimpan data pelanggan seperti ID pelanggan, nama, nomor telepon, dan alamat.
- Peminjaman.java menyimpan data transaksi peminjaman kostum.

---

### 2. Package View

Package View berfungsi sebagai bagian yang berinteraksi langsung dengan pengguna. Package ini bertugas menampilkan tampilan menu, menerima input dari pengguna, serta menampilkan hasil proses program.

<img width="122" height="30" alt="image" src="https://github.com/user-attachments/assets/e186c9f4-e8a7-48ec-9bb8-0b6b135158fd" />

Penjelasan:

MenuView.java merupakan class yang digunakan untuk membuat tampilan menu utama program. Class ini menangani input pilihan pengguna, menampilkan menu pengelolaan kostum, pelanggan, dan peminjaman, serta meneruskan proses ke Controller sesuai pilihan pengguna.

---

### 3. Package Controller

Package Controller berfungsi sebagai penghubung antara View dengan Repository. Controller bertugas mengatur alur logika program sebelum data diproses atau disimpan.

<img width="157" height="56" alt="image" src="https://github.com/user-attachments/assets/a3aeaf95-13d2-4000-91cb-308d06b23303" />

Penjelasan:

- KostumController.java merupakan class yang mengatur proses pengelolaan data kostum. Class ini menangani proses tambah, tampil, cari, update, dan hapus data kostum dengan menghubungkan MenuView dan KostumRepository.
- PelangganController.java merupakan class yang mengatur proses pengelolaan data pelanggan. Class ini bertugas menjalankan proses CRUD pelanggan serta menghubungkan tampilan dengan penyimpanan data pelanggan.
- PeminjamanController.java merupakan class yang mengatur proses transaksi peminjaman kostum. Class ini bertugas melakukan validasi pelanggan dan kostum sebelum transaksi dibuat, mengatur proses peminjaman, pengembalian kostum, serta pengelolaan data peminjaman.

---

### 4. Package Repository

Package Repository berfungsi sebagai tempat pengelolaan dan penyimpanan data program. Data disimpan menggunakan ArrayList dan seluruh proses pengambilan, penambahan, perubahan, serta penghapusan data dilakukan melalui package ini.

<img width="161" height="68" alt="image" src="https://github.com/user-attachments/assets/0f99a193-bcdc-4429-908f-61cf3475e05c" />

Penjelasan:

- Database.java merupakan class yang digunakan sebagai pusat penyimpanan repository. Class ini memastikan setiap Controller menggunakan sumber data yang sama sehingga perubahan data dapat terbaca oleh seluruh bagian program.
- KostumRepository.java merupakan class yang mengelola penyimpanan data kostum menggunakan ArrayList. Class ini menangani proses tambah data kostum, menampilkan data, mencari berdasarkan ID, memperbarui data, dan menghapus data kostum.
- PelangganRepository.java merupakan class yang mengelola penyimpanan data pelanggan menggunakan ArrayList. Class ini bertanggung jawab terhadap proses penyimpanan, pencarian, perubahan, dan penghapusan data pelanggan.
- PeminjamanRepository.java merupakan class yang mengelola penyimpanan data transaksi peminjaman menggunakan ArrayList. Class ini menangani proses penyimpanan transaksi, pencarian peminjaman, perubahan status pengembalian, serta pengecekan apakah kostum sedang dipinjam atau tidak.

---

### 5. Package Interface

Package Interface berfungsi untuk menyediakan aturan atau kontrak method yang harus diterapkan oleh class tertentu.

<img width="132" height="32" alt="image" src="https://github.com/user-attachments/assets/b67602de-3ced-42fb-8838-a5d0276aac90" />

Penjelasan:

CRUDInterface.java merupakan interface yang berisi method standar CRUD yaitu tambah, tampil, update, dan hapus. Interface ini diterapkan pada Controller agar setiap Controller memiliki struktur method pengelolaan data yang sama.

---

### 6. Package Main

Package Main berfungsi sebagai titik awal program dijalankan.

<img width="90" height="27" alt="Screenshot 2026-10-08 200956" src="https://github.com/user-attachments/assets/a2163c7d-d1bd-41be-9dc3-3cd0e25bdc58" />

Penjelasan:

Main.java merupakan class utama yang digunakan untuk menjalankan program. Class ini hanya bertugas memanggil method awal pada MenuView, sedangkan seluruh proses program dilakukan oleh View, Controller, dan Repository.

---

##  Alur Program

Program Sistem Manajemen Peminjaman Kostum memiliki alur kerja yang dimulai dari proses menjalankan program hingga pengguna melakukan pengelolaan data kostum, pelanggan, dan peminjaman. Alur program dibuat menggunakan konsep MVC (Model, View, Controller) sehingga setiap bagian memiliki tugas masing-masing.

Berikut merupakan alur kerja program:

### - Tampilan Menu Utama Program

<img width="196" height="110" alt="image" src="https://github.com/user-attachments/assets/9f2a0dcc-2e19-49b3-84a5-f6c87dae4665" />

Output tersebut merupakan tampilan awal program Sistem Peminjaman Kostum yang digunakan sebagai halaman utama bagi pengguna untuk memilih fitur yang tersedia. Pada menu ini pengguna dapat memilih pengelolaan data kostum, data pelanggan, data peminjaman, atau keluar dari program melalui input pilihan menu.

### - Tampilan Menu Kostum

<img width="149" height="137" alt="image" src="https://github.com/user-attachments/assets/47da4b92-1175-4933-b7d2-a053e4baaaf0" />

Output tersebut merupakan tampilan menu pengelolaan data kostum pada program Sistem Peminjaman Kostum. Pada menu ini pengguna dapat melakukan proses CRUD data kostum, yaitu menambahkan data, melihat data, mencari data, memperbarui data, dan menghapus data kostum.

### - Proses Tambah Data Kostum

<img width="326" height="191" alt="image" src="https://github.com/user-attachments/assets/04f77f1e-e4e3-4ff4-aa41-e504bfc57d65" />

Output tersebut menunjukkan proses penambahan data kostum pada menu Kelola Kostum. Pengguna memasukkan informasi kostum berupa ID kostum, nama kostum, kategori, ukuran, dan harga sewa.
Setelah data melewati proses validasi, sistem menyimpan data kostum ke dalam ArrayList dan menampilkan pesan "Data kostum berhasil ditambahkan" sebagai tanda bahwa proses penambahan data berhasil dilakukan.

### - Tampilan Data Kostum

<img width="152" height="265" alt="image" src="https://github.com/user-attachments/assets/7131fb77-238e-466e-bd50-1026cba2c71f" />

Output tersebut menunjukkan proses menampilkan data kostum pada menu Kelola Kostum. Sistem mengambil data kostum yang tersimpan di dalam ArrayList dan menampilkan informasi setiap kostum berupa ID kostum, nama kostum, kategori, ukuran, dan harga sewa.

### - Proses Pencarian Data Kostum

<img width="147" height="192" alt="image" src="https://github.com/user-attachments/assets/6adbfdc7-a00c-4a68-a5ea-6f298d85e1c6" />

Output tersebut menunjukkan proses pencarian data kostum berdasarkan ID kostum yang dimasukkan oleh pengguna. Sistem melakukan pencarian data pada ArrayList menggunakan ID yang sesuai, kemudian menampilkan informasi kostum yang ditemukan.
Fitur ini menunjukkan penerapan proses search data pada sistem, sehingga pengguna dapat menemukan data kostum tertentu tanpa harus melihat seluruh daftar kostum.

### - Proses Update Data Kostum

<img width="365" height="191" alt="image" src="https://github.com/user-attachments/assets/65bb48d4-218c-4263-a63b-3f92b5c2612f" />

Output tersebut menunjukkan proses perubahan data kostum pada menu Kelola Kostum. Pengguna memasukkan ID kostum yang ingin diperbarui, kemudian mengubah informasi kostum seperti nama, kategori, ukuran, dan harga sewa. Setelah data berhasil diperbarui melalui proses validasi sistem, program menampilkan pesan "Data berhasil diupdate" yang menandakan bahwa perubahan data telah berhasil disimpan. Fitur ini menunjukkan penerapan proses update pada CRUD.

### - Proses Hapus Data Kostum

<img width="150" height="136" alt="image" src="https://github.com/user-attachments/assets/bf8e3ad9-6041-4961-b92f-d48ac40949ac" />

Output tersebut menunjukkan proses penghapusan data kostum pada menu Kelola Kostum. Pengguna memasukkan ID kostum yang ingin dihapus, kemudian sistem melakukan pencarian data dan menghapus data kostum yang sesuai dari penyimpanan ArrayList. Setelah proses berhasil dilakukan, sistem menampilkan pesan "Data berhasil dihapus" yang menunjukkan bahwa data kostum telah berhasil dihapus dari sistem. Fitur ini menunjukkan penerapan proses delete pada CRUD.

### - Proses Tambah Data Pelanggan

<img width="217" height="177" alt="image" src="https://github.com/user-attachments/assets/9a98d75d-3b57-41fe-9325-97e8ecd617e2" />

Output tersebut menunjukkan proses penambahan data pelanggan pada menu Kelola Pelanggan. Pengguna memasukkan informasi pelanggan berupa ID pelanggan, nama, nomor telepon, dan alamat. Setelah data melewati proses validasi, sistem menyimpan data pelanggan ke dalam ArrayList dan menampilkan pesan "Data pelanggan berhasil ditambahkan" sebagai tanda bahwa proses penambahan data berhasil dilakukan. Fitur ini menunjukkan penerapan proses create pada CRUD.

### - Tampilan Data Pelanggan

<img width="175" height="235" alt="image" src="https://github.com/user-attachments/assets/50f10b4c-88d0-4d33-af38-34cc542e1ab8" />

Output tersebut menunjukkan proses menampilkan data pelanggan pada menu Kelola Pelanggan. Sistem mengambil data pelanggan yang tersimpan dalam ArrayList kemudian menampilkan informasi setiap pelanggan berupa ID pelanggan, nama pelanggan, nomor telepon, dan alamat. Fitur ini menunjukkan penerapan proses read (tampil data) pada CRUD, sehingga pengguna dapat melihat seluruh data pelanggan yang telah tersimpan dalam sistem.

### - Proses Pencarian Data Pelanggan

<img width="173" height="176" alt="image" src="https://github.com/user-attachments/assets/8fd73492-74f1-4965-ac52-4eaaea717dbc" />

Output tersebut menunjukkan proses pencarian data pelanggan pada menu Kelola Pelanggan. Pengguna memasukkan ID pelanggan yang ingin dicari, kemudian sistem melakukan pencarian data pada ArrayList berdasarkan ID yang sesuai.
Setelah data ditemukan, sistem menampilkan informasi pelanggan berupa ID pelanggan, nama pelanggan, nomor telepon, dan alamat. Fitur ini menunjukkan penerapan proses search data untuk mempermudah pengguna menemukan data pelanggan tertentu tanpa harus melihat seluruh daftar pelanggan.

### - Proses Update Data Pelanggan

<img width="200" height="163" alt="image" src="https://github.com/user-attachments/assets/3cc73e1e-4ada-4150-9b19-70b1c5e360ab" />

Output tersebut menunjukkan proses perubahan data pelanggan pada menu Kelola Pelanggan. Pengguna memasukkan ID pelanggan yang ingin diperbarui, kemudian mengubah informasi pelanggan seperti nomor telepon dan alamat. Setelah data berhasil melewati proses validasi dan diperbarui oleh sistem, program menampilkan pesan "Data berhasil diupdate" yang menunjukkan bahwa perubahan data pelanggan telah berhasil disimpan. Fitur ini menunjukkan penerapan proses update pada CRUD.

### - Proses Hapus Data Pelanggan

<img width="165" height="140" alt="image" src="https://github.com/user-attachments/assets/14afed7e-36f5-42a0-84d9-472b8f20d396" />

Output tersebut menunjukkan proses penghapusan data pelanggan pada menu Kelola Pelanggan. Pengguna memasukkan ID pelanggan yang ingin dihapus, kemudian sistem melakukan pencarian data dan menghapus data pelanggan yang sesuai dari penyimpanan ArrayList. Setelah proses berhasil dilakukan, sistem menampilkan pesan "Data berhasil dihapus" yang menunjukkan bahwa data pelanggan telah berhasil dihapus dari sistem. Fitur ini menunjukkan penerapan proses delete pada CRUD.

### - Proses Tambah Data Peminjaman

<img width="207" height="175" alt="image" src="https://github.com/user-attachments/assets/bc129175-2b14-4b2a-b86c-4df23cc6b5c9" />

Output tersebut menunjukkan proses penambahan transaksi peminjaman kostum pada menu Kelola Peminjaman. Pengguna memasukkan data transaksi berupa ID peminjaman, ID pelanggan, ID kostum, tanggal peminjaman, dan tanggal pengembalian. Sistem melakukan validasi terlebih dahulu untuk memastikan data pelanggan dan kostum tersedia serta kostum tidak sedang dipinjam. Setelah proses berhasil, data peminjaman disimpan dan sistem menampilkan pesan "Peminjaman berhasil" sebagai tanda bahwa transaksi berhasil dibuat dengan status awal Dipinjam. Fitur ini menunjukkan penerapan proses create pada CRUD dan validasi relasi antar objek.

### - Tampilan Data Peminjaman

<img width="210" height="275" alt="image" src="https://github.com/user-attachments/assets/777e5ebb-28e4-4dce-9773-f8797494cb86" />

Output tersebut menunjukkan proses menampilkan data transaksi peminjaman pada menu Kelola Peminjaman. Sistem mengambil data peminjaman yang tersimpan dalam ArrayList kemudian menampilkan informasi transaksi berupa ID peminjaman, nama pelanggan, nama kostum, tanggal peminjaman, tanggal pengembalian, dan status peminjaman. Fitur ini menunjukkan penerapan proses read (tampil data) pada CRUD serta penerapan relasi antar objek, di mana data peminjaman menampilkan informasi pelanggan dan kostum yang terkait, bukan hanya menampilkan ID

### - Proses Pengembalian Kostum

<img width="186" height="124" alt="image" src="https://github.com/user-attachments/assets/cd33b686-e04d-4812-8b29-005c9ef330bd" />

Output tersebut menunjukkan proses pengembalian kostum pada menu Kelola Peminjaman. Pengguna memasukkan ID peminjaman yang akan diproses, kemudian sistem mencari data transaksi dan mengubah status peminjaman secara otomatis. Setelah proses berhasil dilakukan, sistem menampilkan pesan "Kostum berhasil dikembalikan" yang menunjukkan bahwa status peminjaman telah berubah dari "Dipinjam" menjadi "Dikembalikan". Fitur ini menunjukkan penerapan pengelolaan status transaksi dan validasi proses pengembalian pada sistem.

### - Proses Hapus Data Peminjaman

<img width="167" height="122" alt="image" src="https://github.com/user-attachments/assets/7a345ab2-3873-4b31-b7ad-988f15f289eb" />

Output tersebut menunjukkan proses penghapusan data transaksi peminjaman pada menu Kelola Peminjaman. Pengguna memasukkan ID peminjaman yang ingin dihapus, kemudian sistem melakukan pencarian data dan menghapus transaksi peminjaman yang sesuai dari penyimpanan ArrayList. Setelah proses berhasil dilakukan, sistem menampilkan pesan "Data berhasil dihapus" yang menunjukkan bahwa data peminjaman telah berhasil dihapus dari sistem. Fitur ini menunjukkan penerapan proses delete pada CRUD.

### - Proses Keluar Program

<img width="191" height="127" alt="image" src="https://github.com/user-attachments/assets/9b0e2052-205e-4f66-b5c0-f5ae902260ce" />

Output tersebut menunjukkan proses keluar dari program melalui menu utama. Pengguna memilih pilihan 0. Keluar, kemudian sistem menghentikan perulangan menu dan menampilkan pesan "Program selesai". Fitur ini menunjukkan bahwa program memiliki mekanisme penghentian sistem sesuai pilihan pengguna dan memastikan program tidak berjalan terus ketika pengguna sudah selesai menggunakan aplikasi.

--- 

## Penerapan Encapsulation 

### - Implementasi Encapsulation pada Class Kostum

<img width="163" height="59" alt="image" src="https://github.com/user-attachments/assets/fc80c61b-2712-4bf9-8677-bc3b3fdaaad1" />

Gambar tersebut menunjukkan penerapan encapsulation pada class Kostum dengan menggunakan access modifier private pada setiap atribut. Atribut seperti ID kostum, kategori, ukuran, dan harga sewa tidak dapat diakses secara langsung dari luar class, sehingga perubahan data harus dilakukan melalui method getter dan setter yang telah disediakan. Penerapan ini bertujuan untuk menjaga keamanan data serta mengontrol proses perubahan nilai atribut pada objek Kostum.

### - Validasi Setter pada Encapsulation Class Kostum

<img width="218" height="140" alt="Screenshot 2026-10-08 204403" src="https://github.com/user-attachments/assets/3a744e75-829e-4ef4-a7e3-cce080290874" />

Gambar tersebut menunjukkan penerapan encapsulation melalui method setter pada class Kostum. Method setHargaSewa() digunakan untuk mengubah nilai atribut hargaSewa dengan melewati proses validasi terlebih dahulu. Sistem melakukan pengecekan agar harga sewa tidak bernilai 0 atau negatif. Jika nilai tidak sesuai aturan, program akan memberikan error menggunakan IllegalArgumentException. Penerapan ini menjaga keamanan data karena setiap perubahan atribut harus melalui aturan yang telah ditentukan oleh class.

### - Implementasi Getter dan Setter pada Encapsulation Class Kostum

<img width="267" height="170" alt="Screenshot 2026-10-08 204626" src="https://github.com/user-attachments/assets/9f13233b-8972-42bc-a93b-c686846ef9db" />

Gambar tersebut menunjukkan penerapan encapsulation menggunakan method getter dan setter pada class Kostum. Method getKategori() digunakan untuk mengambil nilai atribut kategori, sedangkan method setKategori() digunakan untuk mengubah nilai atribut tersebut. Pada setter, terdapat proses validasi untuk memastikan data kategori tidak kosong sebelum disimpan ke dalam atribut. Jika input tidak sesuai, sistem akan memberikan pesan error menggunakan IllegalArgumentException. Penerapan getter dan setter ini membuat akses terhadap atribut tetap terkontrol serta menjaga keamanan dan konsistensi data pada objek Kostum.

## Penerapan Inheritance

### - Implementasi Superclass pada Inheritance Class Data

<img width="140" height="105" alt="image" src="https://github.com/user-attachments/assets/1027b649-6004-4c29-a92e-48fa80d64c10" />

Gambar tersebut menunjukkan penerapan inheritance melalui abstract class Data yang berperan sebagai superclass dalam program. Class Data menyimpan atribut umum berupa nama yang dapat digunakan oleh class turunannya. Atribut nama menggunakan access modifier protected agar dapat diakses oleh subclass seperti Kostum dan Pelanggan. Selain itu, constructor pada class Data digunakan untuk menginisialisasi nilai nama melalui method setter. Penerapan ini memungkinkan class turunan menggunakan kembali atribut dan method yang bersifat umum tanpa perlu menuliskan ulang kode yang sama.

### - Implementasi Subclass pada Inheritance Class Kostum

<img width="160" height="62" alt="image" src="https://github.com/user-attachments/assets/9530b9a7-7956-4668-a5b5-a4ec35c87c0f" />

Gambar tersebut menunjukkan penerapan inheritance pada class Kostum yang menjadi subclass dari class Data. Hal ini ditunjukkan dengan penggunaan keyword extends Data, yang membuat class Kostum dapat mewarisi atribut dan method yang dimiliki oleh superclass Data. Class Kostum memiliki atribut khusus seperti idKostum, kategori, ukuran, dan hargaSewa, sedangkan atribut umum seperti nama diperoleh dari class Data. Dengan penerapan inheritance ini, kode menjadi lebih efisien karena atribut dan method yang bersifat umum tidak perlu dibuat ulang pada setiap class, sehingga struktur program lebih terorganisir.

### - Implementasi Subclass pada Inheritance Class Pelanggan

<img width="175" height="48" alt="image" src="https://github.com/user-attachments/assets/f9f92f41-eca6-4f9c-8d4b-2860404879e3" />

Gambar tersebut menunjukkan penerapan inheritance pada class Pelanggan yang menjadi subclass dari class Data. Hal ini ditunjukkan dengan penggunaan keyword extends Data, sehingga class Pelanggan dapat mewarisi atribut dan method yang dimiliki oleh superclass Data. Class Pelanggan memiliki atribut khusus berupa idPelanggan, nomorTelepon, dan alamat, sedangkan atribut umum seperti nama diperoleh dari class Data. Penerapan inheritance ini membuat struktur program lebih terorganisir karena atribut dan method yang bersifat umum cukup dibuat pada superclass, kemudian dapat digunakan kembali oleh class turunannya seperti Pelanggan.

## Penerapan Polymorphism

### - Implementasi Abstract Method pada Class Data

<img width="172" height="18" alt="image" src="https://github.com/user-attachments/assets/d4d6177f-b718-4da1-9325-a5de24d3e3cf" />

Gambar tersebut menunjukkan penerapan abstract method pada class Data. Method tampilData() dibuat tanpa implementasi menggunakan keyword abstract, sehingga wajib dioverride oleh class turunannya seperti Kostum, Pelanggan, dan Peminjaman. Penerapan ini digunakan untuk menerapkan konsep abstraction, di mana setiap subclass memiliki cara tersendiri dalam menampilkan data sesuai karakteristik objeknya.

### - Implementasi Method Overriding pada Class Kostum

<img width="259" height="116" alt="image" src="https://github.com/user-attachments/assets/55bc35fa-605c-4061-953d-8357a5b966de" />

Gambar tersebut menunjukkan penerapan method overriding pada class Kostum. Method tampilData() yang berasal dari abstract method pada class Data diimplementasikan kembali dengan menyesuaikan kebutuhan objek kostum. Pada implementasi ini, class Kostum menampilkan informasi khusus seperti ID kostum, nama kostum, kategori, ukuran, dan harga sewa. Hal ini menunjukkan bahwa setiap subclass dapat memiliki cara tersendiri dalam menjalankan method yang sama.

### - Implementasi Method Overloading pada Class Data

<img width="178" height="140" alt="image" src="https://github.com/user-attachments/assets/733699ba-22cf-4dcb-942f-89d9884596c1" />

Gambar tersebut menunjukkan penerapan method overloading pada class Data. Method tampilData() dibuat dalam dua bentuk dengan nama yang sama tetapi memiliki parameter berbeda. Method pertama digunakan sebagai abstract method yang wajib diimplementasikan oleh subclass, sedangkan method kedua menerima parameter judul untuk menampilkan data dengan tambahan judul sebelum memanggil method tampilData().

## Penerapan Abstraction

### - Implementasi Abstract Class pada Class Data

<img width="143" height="30" alt="image" src="https://github.com/user-attachments/assets/c1e220c2-5759-478f-9387-95a188c30da2" />

Gambar tersebut menunjukkan penerapan abstract class pada class Data. Class ini digunakan sebagai superclass yang menjadi dasar bagi class turunannya, yaitu Kostum dan Pelanggan. Class Data memiliki atribut umum berupa nama dengan access modifier protected, sehingga atribut tersebut dapat digunakan oleh subclass. Penerapan abstract class ini digunakan untuk membuat struktur program lebih terorganisir dan mendukung konsep abstraction serta inheritance.

### - Implementasi Abstract Method tampilData()

<img width="164" height="15" alt="Screenshot 2026-10-08 210402" src="https://github.com/user-attachments/assets/065ba857-8501-457b-89ad-efdbb15129b2" />

Gambar tersebut menunjukkan penerapan abstract method pada class Data. Method tampilData() tidak memiliki implementasi pada abstract class dan wajib dibuat ulang (override) oleh class turunannya seperti Kostum, Pelanggan, dan Peminjaman. Penerapan ini mendukung konsep abstraction, karena class induk hanya menentukan aturan method tanpa mengatur detail prosesnya.

## Implementasi Interface

<img width="172" height="120" alt="image" src="https://github.com/user-attachments/assets/1ff5d88a-5a8c-42dd-96f8-a79771762675" />

Gambar tersebut menunjukkan penerapan interface CRUDInterface<T> yang berisi aturan method CRUD (Create, Read, Update, Delete) yang harus diimplementasikan oleh class Controller. Interface ini mendefinisikan method tambah(), tampil(), update(), dan hapus() sebagai standar pengelolaan data yang digunakan oleh KostumController, PelangganController, dan PeminjamanController. Penerapan interface membuat struktur program lebih terorganisir dan konsisten.

<img width="303" height="14" alt="image" src="https://github.com/user-attachments/assets/7a059185-fd8d-4f01-8c5b-c2a8cde1e13e" />

Gambar tersebut menunjukkan penerapan interface CRUDInterface<Kostum> pada class KostumController. Dengan menggunakan keyword implements, class KostumController wajib menyediakan implementasi method CRUD yang telah didefinisikan pada interface, seperti tambah, tampil, update, dan hapus data. Penerapan ini menjadi bukti bahwa interface CRUDInterface digunakan sebagai standar pengelolaan data pada bagian Controller, sehingga struktur program menjadi lebih konsisten dan terorganisir.

---

## penerapan JDBC

### - Implementasi Koneksi JDBC pada DatabaseConnection

<img width="323" height="114" alt="image" src="https://github.com/user-attachments/assets/f4be44ae-ef06-4b18-bd87-03a188f00b8e" />

Gambar tersebut menunjukkan koneksi program Java ke database MySQL menggunakan JDBC melalui DriverManager.getConnection() dengan URL database, username, dan password.

### - Implementasi PreparedStatement pada KostumDAO

<img width="296" height="172" alt="image" src="https://github.com/user-attachments/assets/d3ea1895-ca0c-484c-87ec-7e1706a6bf56" />

Gambar tersebut menunjukkan penggunaan PreparedStatement pada proses penambahan data kostum. Parameter query diisi menggunakan tanda ? sehingga input data diproses melalui JDBC secara terstruktur

### - Pengambilan Data Database Menggunakan JDBC

<img width="268" height="197" alt="image" src="https://github.com/user-attachments/assets/aac1c1be-1f05-4293-9688-e069b594a782" />

Gambar tersebut menunjukkan proses pembacaan data dari tabel kostum menggunakan PreparedStatement, executeQuery(), dan ResultSet, kemudian data database dikonversi menjadi objek Kostum.

### - Pembuatan Struktur Database MySQL

<img width="361" height="408" alt="Screenshot 2026-10-15 195334" src="https://github.com/user-attachments/assets/5be4af8a-88cc-41f8-8194-fb031916a0b3" />

Proses pembuatan database dilakukan dengan membuat tiga tabel utama, yaitu kostum, pelanggan, dan peminjaman. Setiap tabel memiliki primary key, sedangkan tabel peminjaman menggunakan foreign key untuk menghubungkan data pelanggan dan kostum sehingga relasi antar tabel dapat terjaga.

<img width="685" height="225" alt="Screenshot 2026-10-15 195347" src="https://github.com/user-attachments/assets/25fc0603-cb4d-43c0-9063-5377d693b016" />

Dummy data awal dimasukkan langsung ke dalam database menggunakan perintah INSERT INTO pada tabel kostum, pelanggan, dan peminjaman. Data awal ini digunakan agar fitur read dapat langsung menampilkan data tanpa harus melakukan input terlebih dahulu melalui program Java.

### - Hasil Pembacaan Data Kostum dari Database

<img width="164" height="263" alt="image" src="https://github.com/user-attachments/assets/4d528fc6-59c2-4790-823b-eb7f587213e4" />

Data kostum berhasil ditampilkan melalui menu Lihat Kostum pada program Java. Informasi yang muncul berasal dari tabel kostum di database MySQL melalui proses JDBC dan DAO, sehingga data dummy awal dapat langsung terbaca tanpa harus diinput kembali melalui program.

### - Proses Penambahan Data Kostum melalui Program

<img width="329" height="197" alt="image" src="https://github.com/user-attachments/assets/b290173e-32bc-4f1c-9dae-151f37abe4c1" />

### - Hasil Penyimpanan Data Kostum pada Database

<img width="365" height="122" alt="image" src="https://github.com/user-attachments/assets/a626ef0f-a603-4081-8caf-23b7b8ce49b7" />

Data kostum yang sebelumnya ditambahkan melalui program berhasil tersimpan pada tabel kostum di database MySQL. Keberadaan data K004 membuktikan bahwa proses integrasi antara program Java dan database melalui JDBC telah berjalan dengan baik.
