-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 04, 2024 at 05:42 AM
-- Server version: 8.0.30
-- PHP Version: 8.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbakademik`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nobp` varchar(15) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `kelas` varchar(5) NOT NULL,
  `tglultah` date NOT NULL,
  `nomorhp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nobp`, `nama`, `kelas`, `tglultah`, `nomorhp`) VALUES
('0702222088', 'Arlan Tri Handika', 'SI-3', '2004-06-17', '089613338528');

-- --------------------------------------------------------

--
-- Table structure for table `matakuliah`
--

CREATE TABLE `matakuliah` (
  `kdmtk` varchar(10) NOT NULL,
  `namamtk` varchar(30) NOT NULL,
  `sks` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `matakuliah`
--

INSERT INTO `matakuliah` (`kdmtk`, `namamtk`, `sks`) VALUES
('mk001', 'pbwd', 4),
('mk002', 'apsi', 4);

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE `nilai` (
  `nobp` varchar(15) NOT NULL,
  `kdmtk` varchar(10) NOT NULL,
  `nilaitugas` int NOT NULL,
  `nilaimid` int NOT NULL,
  `nilaisemester` int NOT NULL,
  `nilaiakhir` int NOT NULL,
  `nilaihuruf` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `nilai`
--

INSERT INTO `nilai` (`nobp`, `kdmtk`, `nilaitugas`, `nilaimid`, `nilaisemester`, `nilaiakhir`, `nilaihuruf`) VALUES
('0702222088', 'mk001', 100, 100, 100, 100, 'A');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nobp`);

--
-- Indexes for table `matakuliah`
--
ALTER TABLE `matakuliah`
  ADD PRIMARY KEY (`kdmtk`);

--
-- Indexes for table `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`nobp`,`kdmtk`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
