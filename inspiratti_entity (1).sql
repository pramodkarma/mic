-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2017 at 01:35 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inspiratti_entity`
--

-- --------------------------------------------------------

--
-- Table structure for table `gender`
--

CREATE TABLE `gender` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gender`
--

INSERT INTO `gender` (`id`, `name`) VALUES
(1, 'male');

-- --------------------------------------------------------

--
-- Table structure for table `permissionrecord`
--

CREATE TABLE `permissionrecord` (
  `id` int(11) NOT NULL,
  `category` varchar(500) DEFAULT NULL,
  `name` varchar(500) DEFAULT NULL,
  `systemname` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `permissionrecordrolemapping`
--

CREATE TABLE `permissionrecordrolemapping` (
  `permissionrecordid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `enablepasswordlifetime` tinyint(1) DEFAULT NULL,
  `systemname` varchar(255) DEFAULT NULL,
  `isactive` tinyint(1) DEFAULT NULL,
  `issystemrole` tinyint(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `enablepasswordlifetime`, `systemname`, `isactive`, `issystemrole`, `name`) VALUES
(1, 0, 'admin', 1, 1, 'sani verma');

-- --------------------------------------------------------

--
-- Table structure for table `userpassword`
--

CREATE TABLE `userpassword` (
  `id` int(11) NOT NULL,
  `createdonutc` datetime DEFAULT NULL,
  `password` varchar(225) NOT NULL,
  `passwordformatid` int(11) DEFAULT NULL,
  `passwordsalt` varchar(225) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userpassword`
--

INSERT INTO `userpassword` (`id`, `createdonutc`, `password`, `passwordformatid`, `passwordsalt`, `userid`) VALUES
(1, '2017-12-22 00:00:00', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 1, 'ddd', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `admincomment` varchar(500) DEFAULT NULL,
  `cannotloginuntildateutc` datetime NOT NULL,
  `createdonutc` datetime NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `emailtorevalidate` varchar(500) DEFAULT NULL,
  `email_verified` tinyint(1) NOT NULL,
  `failedloginattempts` int(11) DEFAULT NULL,
  `genderid` int(11) NOT NULL,
  `isactive` tinyint(1) NOT NULL,
  `issystemaccount` tinyint(1) NOT NULL,
  `lastactivitydateutc` datetime NOT NULL,
  `lastipaddress` varchar(50) NOT NULL,
  `lastlogindateutc` datetime NOT NULL,
  `mobile` varchar(12) NOT NULL,
  `mobileverified` tinyint(1) NOT NULL,
  `requirerelogin` tinyint(1) DEFAULT NULL,
  `systemname` varchar(500) NOT NULL,
  `userguid` text,
  `username` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `admincomment`, `cannotloginuntildateutc`, `createdonutc`, `deleted`, `email`, `emailtorevalidate`, `email_verified`, `failedloginattempts`, `genderid`, `isactive`, `issystemaccount`, `lastactivitydateutc`, `lastipaddress`, `lastlogindateutc`, `mobile`, `mobileverified`, `requirerelogin`, `systemname`, `userguid`, `username`) VALUES
(1, 'no comment', '2017-12-22 00:00:00', '2017-12-22 00:00:00', 0, 'sani@gmail.com', 'no', 0, 0, 1, 0, 0, '2017-12-22 00:00:00', '127.15.175.99.', '2017-12-22 00:00:00', '9415422104', 0, 0, 'admin', 'asdsa sadsad', 'sani');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`userid`, `roleid`) VALUES
(1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gender`
--
ALTER TABLE `gender`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `permissionrecord`
--
ALTER TABLE `permissionrecord`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `permissionrecordrolemapping`
--
ALTER TABLE `permissionrecordrolemapping`
  ADD PRIMARY KEY (`permissionrecordid`,`roleid`),
  ADD KEY `FKew1kct72sewyru7t41tefoxhj` (`roleid`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userpassword`
--
ALTER TABLE `userpassword`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK10kbu13fdilxsta8p9likwn22` (`userid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlrj9s7ph40sff84m0v4hbonnl` (`genderid`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`userid`,`roleid`),
  ADD KEY `FKbo5ik0bthje7hum554xb17ry6` (`roleid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gender`
--
ALTER TABLE `gender`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `permissionrecord`
--
ALTER TABLE `permissionrecord`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `userpassword`
--
ALTER TABLE `userpassword`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `permissionrecordrolemapping`
--
ALTER TABLE `permissionrecordrolemapping`
  ADD CONSTRAINT `FKew1kct72sewyru7t41tefoxhj` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FKg71ymtx1q17sawn4m05bwj70b` FOREIGN KEY (`permissionrecordid`) REFERENCES `permissionrecord` (`id`);

--
-- Constraints for table `userpassword`
--
ALTER TABLE `userpassword`
  ADD CONSTRAINT `FK10kbu13fdilxsta8p9likwn22` FOREIGN KEY (`userid`) REFERENCES `users` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKlrj9s7ph40sff84m0v4hbonnl` FOREIGN KEY (`genderid`) REFERENCES `gender` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FKbo5ik0bthje7hum554xb17ry6` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FKl4qqtaxj0v5ikodha3v2pmfl` FOREIGN KEY (`userid`) REFERENCES `users` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
