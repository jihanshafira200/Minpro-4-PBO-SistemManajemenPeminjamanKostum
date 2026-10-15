-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 15, 2026 at 12:51 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_peminjaman_kostum`
--

-- --------------------------------------------------------

--
-- Table structure for table `kostum`
--

CREATE TABLE `kostum` (
  `id_kostum` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `kategori` varchar(50) NOT NULL,
  `ukuran` int NOT NULL,
  `harga_sewa` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kostum`
--

INSERT INTO `kostum` (`id_kostum`, `nama`, `kategori`, `ukuran`, `harga_sewa`) VALUES
('K001', 'Iron Man', 'Superhero', 40, '150000.00'),
('K002', 'Dokter', 'Profesi', 39, '100000.00'),
('K003', 'Batman', 'Superhero', 41, '130000.00'),
('K004', 'Polisi', 'Profesi', 40, '100000.00');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `nomor_telepon` varchar(20) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `nomor_telepon`, `alamat`) VALUES
('P001', 'Andi', '08123456789', 'Jakarta'),
('P002', 'Budi', '08129876543', 'Bandung');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` varchar(10) NOT NULL,
  `id_pelanggan` varchar(10) NOT NULL,
  `id_kostum` varchar(10) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_pengembalian` date NOT NULL,
  `status_peminjaman` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `id_pelanggan`, `id_kostum`, `tanggal_pinjam`, `tanggal_pengembalian`, `status_peminjaman`) VALUES
('PM001', 'P001', 'K001', '2026-09-20', '2026-09-22', 'Dipinjam');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kostum`
--
ALTER TABLE `kostum`
  ADD PRIMARY KEY (`id_kostum`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `fk_peminjaman_pelanggan` (`id_pelanggan`),
  ADD KEY `fk_peminjaman_kostum` (`id_kostum`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `fk_peminjaman_kostum` FOREIGN KEY (`id_kostum`) REFERENCES `kostum` (`id_kostum`),
  ADD CONSTRAINT `fk_peminjaman_pelanggan` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
