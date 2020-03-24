-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 24, 2020 at 12:18 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_nusa`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(10) NOT NULL,
  `nama_admin` varchar(40) NOT NULL,
  `nik` varchar(20) NOT NULL,
  `username_admin` varchar(12) NOT NULL,
  `password_admin` varchar(12) NOT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `photo` text NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `no_hp` varchar(16) NOT NULL,
  `email` text NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `nik`, `username_admin`, `password_admin`, `tgl_lahir`, `photo`, `jenis_kelamin`, `no_hp`, `email`, `alamat`) VALUES
(1, 'Jamal', '30019920518', 'admin1', '12345678', '1992-05-18', '', 'Male', '08213457899', 'jamal@nusabank.com', 'Kali Deres'),
(2, 'Putri', '30019920518', 'admin2', '12345678', '1992-01-18', '', 'Female', '08213457899', 'putri@nusabank.com', 'Kali Deres'),
(3, 'Supardi', '19900312444', 'admin3', 'admin3', '2020-01-03', '', 'Male', '0825312312', 'supardi@nusabank.com', 'Jl. Bulak Wangi'),
(4, 'Parjo', '19841201992', 'admin4', 'admin4', '1997-01-13', 'res/admin_photos/admin4_NusaBank_1997-01-13.jpg', 'Male', '08123889432', 'parjo@nusabank.com', 'Jl. Kembang No.21'),
(5, 'Andi', '1234abc', 'andiads', 'andi97', '1997-04-06', '', 'Male', '0812345678', 'andi@gmail.com', 'Jl. tabanas ujung'),
(8, 'Mamat', '19900312229', 'admin9', 'admin9', '1990-06-06', '', 'Male', '085699876', 'mamat@', 'Jl. Bulak Wangi'),
(10, 'Nabila Bila', '1997011232', 'nabila', 'nabila', '1997-01-12', '', 'Female', '082134567', 'nabila@nusabank.com', 'Jl.Karyawan'),
(11, 'Jason ', '119202102', 'jasonx', 'jason12', '1995-03-18', '', 'Male', '+62 812234568', 'jason@nusabank.com', 'jalan'),
(13, 'Nanda', '1990121292', 'nanda', 'nanda88', '1997-01-12', '', 'Female', '+62 8572928123', 'nanda@nusabank.com', 'Jalan Buntu'),
(14, 'Mozart', '199923212', 'mozart', 'mozart123', '1992-03-02', '', 'Male', '+62 8561919182', 'mozart@nusabank.com', 'Austria'),
(15, 'John Doe', '1002998217', 'adminjohn', 'johndoe99', '1986-10-20', '', 'Male', '+62 81399125621', 'johndoe@nusabank.com', 'Jl. Empang Sari No.11\nCiputat, Tangerang Selatan');

-- --------------------------------------------------------

--
-- Table structure for table `nasabah`
--

CREATE TABLE `nasabah` (
  `id_nasabah` int(5) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `nik` varchar(32) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` text NOT NULL,
  `photo` text,
  `jenis_kelamin` varchar(10) NOT NULL,
  `pekerjaan` text NOT NULL,
  `alamat_kantor` text NOT NULL,
  `pendapatan` int(12) NOT NULL,
  `email` varchar(320) NOT NULL,
  `no_hp` varchar(50) NOT NULL,
  `status` varchar(10) NOT NULL,
  `nama_ibu` varchar(40) NOT NULL,
  `username_nasabah` varchar(60) NOT NULL,
  `password_nasabah` varchar(60) NOT NULL,
  `tgl_pembuatan` datetime NOT NULL,
  `id_rekening` int(16) NOT NULL,
  `id_admin` int(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nasabah`
--

INSERT INTO `nasabah` (`id_nasabah`, `nama`, `nik`, `tgl_lahir`, `alamat`, `photo`, `jenis_kelamin`, `pekerjaan`, `alamat_kantor`, `pendapatan`, `email`, `no_hp`, `status`, `nama_ibu`, `username_nasabah`, `password_nasabah`, `tgl_pembuatan`, `id_rekening`, `id_admin`) VALUES
(2, 'Deni', '12345678', '1990-01-02', 'Jkt', 'file...', 'Male', 'Programmer', 'Jkt', 1200000, '', '0812345678', 'Single', 'Dummy Mom', 'dummy1', 'dummy1', '2020-03-16 19:02:00', 6, 0),
(4, 'Ruslan', '1231200976', '1992-01-12', 'Jaksel', 'res/nasabah_photos/abcd1_NusaBank_2020-03-17_16-10.jpg', 'Male', 'Admin', 'Depok', 4000000, '', '081231231', 'Maried', 'Bsdkja', 'abcd1', '123456', '2020-03-17 16:10:00', 9, NULL),
(5, 'Andi', '201543502', '1991-01-01', 'Jakarta', 'res/nasabah_photos/andi_NusaBank_2020-03-17_16-23.jpg', 'Male', 'Programmer', 'Bekasi', 999999999, '', '08123456', 'Maried', 'Rumiah', 'andi', '123456', '2020-03-17 16:23:00', 11, NULL),
(6, 'Asep', '12345678', '1992-01-27', 'Bandung', 'res/nasabah_photos/asep1_NusaBank_2020-03-17_16-27.jpg', 'Male', 'Programmer', 'Jakarta', 50000000, '', '0812345', 'Single', 'Booo', 'asep1', '123456', '2020-03-17 16:27:00', 12, NULL),
(7, 'Ujang', '11223344', '1990-01-01', 'Bogor', 'res/nasabah_photos/ujang1_NusaBank_2020-03-17_19-35.jpg', 'Male', 'Manager', 'Depok', 20000000, '', '0857123456', 'Single', 'Ujung', 'ujang1', '123456', '2020-03-17 19:35:00', 13, NULL),
(9, 'Anton', '1288123921', '1990-03-10', 'Jl. Nangka No.12\nPasar Rebo, Jakarta Timur', 'res/nasabah_photos/antonyz_NusaBank_2020-03-23_21-02.png', 'Male', 'Tax Consultant', 'Jakarta Pusat', 250000000, 'anton@gmail.com', '+62 8579910201', 'Single', 'Mak w', 'antonyz', 'antony99', '2020-03-23 21:02:00', 15, NULL),
(10, 'Peter Shawn', '19999832', '1986-09-26', 'Sillicon Valey', 'res/nasabah_photos/petershwn_NusaBank_2020-03-23_21-21.jpg', 'Male', 'Engineer', 'Sillicon Valey', 80000000, 'petershwn@yahoo.com', '+1 999222111', 'Maried', 'Brunkkk', 'petershwn', 'peter12345', '2020-03-23 21:21:00', 17, NULL),
(11, 'Susan', '12312312312', '1992-03-10', 'Jl. Ketapang no.24', 'res/nasabah_photos/susan92_NusaBank_2020-03-24_09-19.jpg', 'Female', 'Sales', 'Jakarta Pusat', 90000000, 'susan@gmail.com', '+62 85822323123', 'Maried', 'emak gue', 'susan92', 'susan92', '2020-03-24 09:19:00', 0, NULL),
(12, 'Jon Bon Jovi', '11098722731', '1962-03-02', 'USA', 'res/nasabah_photos/bonjovi_NusaBank_2020-03-24_16-52-22.jpg', 'Male', 'Musician', 'USA', 12000000, 'jonbovi@gmail.com', '+62 998772621', 'Maried', 'Carol', 'bonjovi', 'boncabe99', '2020-03-24 16:52:22', 0, 13),
(13, 'Jon Bon Jovi', '19862812388', '1962-03-02', 'USA', 'res/nasabah_photos/bonjovi_NusaBank_2020-03-24_16-58-48.jpg', 'Male', 'Musician', 'USA', 90000000, 'jonbovi@mail.com', '+1 987762612211', 'Maried', 'Gatau', 'bonjovi', 'boncabe99', '2020-03-24 16:58:48', 0, 13),
(14, 'Jon Bon Jovi', '129819620302', '1962-03-02', 'USA C.A', 'res/nasabah_photos/bonjovi_NusaBank_2020-03-24_17-42-23.jpg', 'Male', 'Musican/Artist', 'USA Washington DC', 19000000, 'jonbovi@gmail.com', '+1 9928282828', 'Maried', 'Clark', 'bonjovi', 'boncabe1962', '2020-03-24 17:42:23', 0, 13),
(15, 'Jon Bon Jovi', '19992292', '1962-03-02', 'USA dong', 'res/nasabah_photos/jonbon_NusaBank_2020-03-24_17-51-50.jpg', 'Male', 'Musician', 'Mampang', 1000000000, 'jonbonjovi@jovimail.com', '+1 987662661922', 'Maried', 'Clark', 'jonbon', 'bonkredit123', '2020-03-24 17:51:50', 0, 13),
(16, 'Abon Jovi', '19292839212', '1962-03-02', 'New York, USA', 'res/nasabah_photos/bonjovi11_NusaBank_2020-03-24_17-54-44.jpg', 'Male', 'Musician', 'Pejaten Barat', 90000000, 'jonbovi@mail.com', '+1 299838277122', 'Maried', 'Clark', 'bonjovi11', 'boncabe123', '2020-03-24 17:54:44', 20, 13);

-- --------------------------------------------------------

--
-- Table structure for table `rekening`
--

CREATE TABLE `rekening` (
  `id_rekening` int(12) NOT NULL,
  `no_rekening` varchar(24) NOT NULL,
  `saldo` int(32) NOT NULL,
  `jenis_rekening` varchar(24) NOT NULL,
  `no_pin` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rekening`
--

INSERT INTO `rekening` (`id_rekening`, `no_rekening`, `saldo`, `jenis_rekening`, `no_pin`) VALUES
(1, '1234567890', 100000, 'Reguler', 32767),
(4, '058159171881', 100000, 'Gold', 32767),
(5, '673159171881', 1000000, 'Reguler', 32767),
(6, '058159171881', 900000, 'Reguler', 32767),
(7, '058159170576', 500000, 'Gold', 32767),
(8, '058159170576', 6000000, 'Gold', 32767),
(9, '259959170576', 1500000, 'Reguler', 32767),
(10, '045359170576', 5000000, 'Gold', 32767),
(11, '045359170576', 5000000, 'Gold', 32767),
(12, '050159170576', 3347000, 'Reguler', 32767),
(13, '175359170576', 49949000, 'Platinum', 32767),
(14, '787459177653', 9000000, 'Platinum', 32767),
(15, '787459177653', 9000000, 'Platinum', 32767),
(16, '191056789508', 10000000, 'Gold', 123456),
(17, '191056789508', 10000000, 'Gold', 123456),
(18, '258015975366', 50000000, 'VVIP', 123456),
(19, '258015975366', 25000000, 'Platinum', 123456),
(20, '676315975366', 80000000, 'Gold', 123456);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_bank`
--

CREATE TABLE `transaksi_bank` (
  `id_transaksi` bigint(120) NOT NULL,
  `jenis_transaksi` varchar(16) NOT NULL,
  `nominal` int(12) NOT NULL,
  `tgl_transaksi` datetime NOT NULL,
  `kode_bank` int(3) NOT NULL,
  `rek_tujuan` int(32) NOT NULL,
  `biaya_admin` int(12) NOT NULL,
  `ket_transaksi` text NOT NULL,
  `id_rekening` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi_bank`
--

INSERT INTO `transaksi_bank` (`id_transaksi`, `jenis_transaksi`, `nominal`, `tgl_transaksi`, `kode_bank`, `rek_tujuan`, `biaya_admin`, `ket_transaksi`, `id_rekening`) VALUES
(1, 'Transfer', 50000, '2020-03-20 20:28:00', 21, 762512731, 1000, 'Test transfer to my sister', 12);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_ppob`
--

CREATE TABLE `transaksi_ppob` (
  `id_transaksi` bigint(120) NOT NULL,
  `jenis_transaksi` varchar(40) NOT NULL,
  `nominal` int(12) NOT NULL,
  `tgl_transaksi` datetime NOT NULL,
  `no_target` int(32) NOT NULL,
  `ket_transaksi` text NOT NULL,
  `id_rekening` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi_ppob`
--

INSERT INTO `transaksi_ppob` (`id_transaksi`, `jenis_transaksi`, `nominal`, `tgl_transaksi`, `no_target`, `ket_transaksi`, `id_rekening`) VALUES
(1, 'Mobile Recharge', 50000, '2020-03-20 22:20:00', 81234567, 'beli pulsa buat adik', 13),
(2, 'Electricity', 100000, '2020-03-20 22:40:00', 18891812, 'listrik PLN', 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`id_nasabah`);

--
-- Indexes for table `rekening`
--
ALTER TABLE `rekening`
  ADD PRIMARY KEY (`id_rekening`);

--
-- Indexes for table `transaksi_bank`
--
ALTER TABLE `transaksi_bank`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- Indexes for table `transaksi_ppob`
--
ALTER TABLE `transaksi_ppob`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `nasabah`
--
ALTER TABLE `nasabah`
  MODIFY `id_nasabah` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `rekening`
--
ALTER TABLE `rekening`
  MODIFY `id_rekening` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `transaksi_bank`
--
ALTER TABLE `transaksi_bank`
  MODIFY `id_transaksi` bigint(120) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `transaksi_ppob`
--
ALTER TABLE `transaksi_ppob`
  MODIFY `id_transaksi` bigint(120) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
