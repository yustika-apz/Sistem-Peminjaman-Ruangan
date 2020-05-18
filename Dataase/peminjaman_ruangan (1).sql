-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2020 at 10:08 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `peminjaman_ruangan`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(5) NOT NULL,
  `nama_admin` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `password`) VALUES
(451, 'Anulika', 'mustard12');

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `nip_dosen` int(15) NOT NULL,
  `nama_dosen` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`nip_dosen`, `nama_dosen`, `password`) VALUES
(123456789, 'Ayudia', 'kurang1');

-- --------------------------------------------------------

--
-- Table structure for table `gedung`
--

CREATE TABLE `gedung` (
  `id_gedung` varchar(3) NOT NULL,
  `nama_gedung` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gedung`
--

INSERT INTO `gedung` (`id_gedung`, `nama_gedung`) VALUES
('G4', 'gedung d'),
('G1', 'gedung e'),
('G2', 'gedung f'),
('G3', 'gku');

-- --------------------------------------------------------

--
-- Table structure for table `kegiatan`
--

CREATE TABLE `kegiatan` (
  `id_kegiatan` varchar(3) NOT NULL,
  `nama_kegiatan` varchar(30) NOT NULL,
  `tgl_kegiatan` varchar(30) NOT NULL,
  `jam_mulai` varchar(10) NOT NULL,
  `jam_selesai` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kegiatan`
--

INSERT INTO `kegiatan` (`id_kegiatan`, `nama_kegiatan`, `tgl_kegiatan`, `jam_mulai`, `jam_selesai`) VALUES
('K3', 'jam pengganti ', '2020-05-23', '07.00', '10.00'),
('K2', 'kelas pengganti', '2020-05-18', '09.00', '11.30'),
('K1', 'rapat organisasi', '2020-05-20', '17.00', '20.00');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nim_mhs` int(15) NOT NULL,
  `nama_mhs` varchar(15) NOT NULL,
  `prodi` varchar(30) NOT NULL,
  `no_hp` int(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim_mhs`, `nama_mhs`, `prodi`, `no_hp`) VALUES
(14116044, 'Laurentia', 'Informatika', 815467890),
(14117040, 'Yustika', 'Informatika', 813883853);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` varchar(20) NOT NULL,
  `nim_mhs` int(15) NOT NULL,
  `id_ruang` varchar(3) NOT NULL,
  `id_gedung` varchar(3) NOT NULL,
  `id_kegiatan` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `nim_mhs`, `id_ruang`, `id_gedung`, `id_kegiatan`) VALUES
('P01', 14117040, 'R1', 'G1', 'K1'),
('P02', 14116044, 'R2', 'G2', 'K2'),
('P03', 14117040, 'R3', 'G1', 'K1');

-- --------------------------------------------------------

--
-- Table structure for table `pinjam_ruang`
--

CREATE TABLE `pinjam_ruang` (
  `ID_pinjam_ruang` int(3) NOT NULL,
  `nama_ruang` varchar(15) NOT NULL,
  `nama_gedung` varchar(15) NOT NULL,
  `tgl_kegiatan` varchar(30) NOT NULL,
  `jam_mulai` varchar(10) NOT NULL,
  `jam_selesai` varchar(10) NOT NULL,
  `nama_kegiatan` varchar(30) NOT NULL,
  `nama_mhs` varchar(15) NOT NULL,
  `nim_mhs` int(9) NOT NULL,
  `prodi` varchar(30) NOT NULL,
  `no_hp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pinjam_ruang`
--

INSERT INTO `pinjam_ruang` (`ID_pinjam_ruang`, `nama_ruang`, `nama_gedung`, `tgl_kegiatan`, `jam_mulai`, `jam_selesai`, `nama_kegiatan`, `nama_mhs`, `nim_mhs`, `prodi`, `no_hp`) VALUES
(7, 'GKU1124', 'GKU', '16 Mei 2020', '13.00', '15.00', 'rapat organisasi', 'Handoyo', 11111111, 'Teknik', '098764353332'),
(11, 'LabKom', 'Labtek', '18 Mei 2020', '11.00', '13.00', 'kelas biasa', 'Ezra', 11814035, 'Informatika', '09278467652'),
(13, 'Aula GKU', 'Aula', '20 Mei 2020', '09.00', '11.30', 'Seminar Prodi', 'Prima', 26117123, 'Teknik Kelautan', '09485637646');

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE `ruangan` (
  `id_ruang` varchar(3) NOT NULL,
  `nama_ruang` varchar(15) NOT NULL,
  `lantai` int(2) NOT NULL,
  `nama_gedung` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`id_ruang`, `nama_ruang`, `lantai`, `nama_gedung`) VALUES
('R1', 'E114', 1, 'gedung e'),
('R2', 'F002', 0, 'gedung f'),
('R3', 'E104', 1, 'gedung e');

-- --------------------------------------------------------

--
-- Table structure for table `tambah_pinjam`
--

CREATE TABLE `tambah_pinjam` (
  `id_tambah_pinjam` int(5) NOT NULL,
  `id_validasi` int(4) NOT NULL,
  `id_admin` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tambah_pinjam`
--

INSERT INTO `tambah_pinjam` (`id_tambah_pinjam`, `id_validasi`, `id_admin`) VALUES
(11111, 1, 451),
(11112, 2, 451);

-- --------------------------------------------------------

--
-- Table structure for table `validasi`
--

CREATE TABLE `validasi` (
  `id_validasi` int(4) NOT NULL,
  `id_peminjaman` varchar(3) NOT NULL,
  `nip_dosen` int(15) NOT NULL,
  `status_validasi` varchar(10) NOT NULL,
  `tgl_validasi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `validasi`
--

INSERT INTO `validasi` (`id_validasi`, `id_peminjaman`, `nip_dosen`, `status_validasi`, `tgl_validasi`) VALUES
(1, 'P01', 123456789, 'setuju', '2020-05-15'),
(2, 'P02', 123456789, 'setuju', '2020-05-16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`nip_dosen`);

--
-- Indexes for table `gedung`
--
ALTER TABLE `gedung`
  ADD PRIMARY KEY (`id_gedung`),
  ADD KEY `nama_gedung` (`nama_gedung`),
  ADD KEY `nama_gedung_2` (`nama_gedung`);

--
-- Indexes for table `kegiatan`
--
ALTER TABLE `kegiatan`
  ADD PRIMARY KEY (`id_kegiatan`),
  ADD KEY `nama_kegiatan` (`nama_kegiatan`,`tgl_kegiatan`,`jam_mulai`,`jam_selesai`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim_mhs`),
  ADD KEY `nama_mhs` (`nama_mhs`,`prodi`,`no_hp`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `nim_mhs` (`nim_mhs`),
  ADD KEY `id_ruang` (`id_ruang`,`id_gedung`,`id_kegiatan`),
  ADD KEY `id_kegiatan` (`id_kegiatan`),
  ADD KEY `id_gedung` (`id_gedung`);

--
-- Indexes for table `pinjam_ruang`
--
ALTER TABLE `pinjam_ruang`
  ADD PRIMARY KEY (`ID_pinjam_ruang`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`id_ruang`),
  ADD KEY `nama_gedung` (`nama_gedung`),
  ADD KEY `nama_ruang` (`nama_ruang`);

--
-- Indexes for table `tambah_pinjam`
--
ALTER TABLE `tambah_pinjam`
  ADD PRIMARY KEY (`id_tambah_pinjam`),
  ADD UNIQUE KEY `id_validasi` (`id_validasi`,`id_admin`),
  ADD KEY `id_admin` (`id_admin`);

--
-- Indexes for table `validasi`
--
ALTER TABLE `validasi`
  ADD PRIMARY KEY (`id_validasi`),
  ADD KEY `id_peminjaman` (`id_peminjaman`,`nip_dosen`),
  ADD KEY `nip_dosen` (`nip_dosen`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=452;

--
-- AUTO_INCREMENT for table `dosen`
--
ALTER TABLE `dosen`
  MODIFY `nip_dosen` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123456790;

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `nim_mhs` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14117041;

--
-- AUTO_INCREMENT for table `pinjam_ruang`
--
ALTER TABLE `pinjam_ruang`
  MODIFY `ID_pinjam_ruang` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `tambah_pinjam`
--
ALTER TABLE `tambah_pinjam`
  MODIFY `id_tambah_pinjam` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11113;

--
-- AUTO_INCREMENT for table `validasi`
--
ALTER TABLE `validasi`
  MODIFY `id_validasi` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`nim_mhs`) REFERENCES `mahasiswa` (`nim_mhs`),
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`id_ruang`) REFERENCES `ruangan` (`id_ruang`),
  ADD CONSTRAINT `peminjaman_ibfk_3` FOREIGN KEY (`id_kegiatan`) REFERENCES `kegiatan` (`id_kegiatan`),
  ADD CONSTRAINT `peminjaman_ibfk_4` FOREIGN KEY (`id_gedung`) REFERENCES `gedung` (`id_gedung`);

--
-- Constraints for table `ruangan`
--
ALTER TABLE `ruangan`
  ADD CONSTRAINT `ruangan_ibfk_1` FOREIGN KEY (`nama_gedung`) REFERENCES `gedung` (`nama_gedung`);

--
-- Constraints for table `tambah_pinjam`
--
ALTER TABLE `tambah_pinjam`
  ADD CONSTRAINT `tambah_pinjam_ibfk_1` FOREIGN KEY (`id_validasi`) REFERENCES `validasi` (`id_validasi`),
  ADD CONSTRAINT `tambah_pinjam_ibfk_2` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`);

--
-- Constraints for table `validasi`
--
ALTER TABLE `validasi`
  ADD CONSTRAINT `validasi_ibfk_1` FOREIGN KEY (`nip_dosen`) REFERENCES `dosen` (`nip_dosen`),
  ADD CONSTRAINT `validasi_ibfk_2` FOREIGN KEY (`id_peminjaman`) REFERENCES `peminjaman` (`id_peminjaman`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
