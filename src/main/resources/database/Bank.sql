-- Database: `banking`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE IF NOT EXISTS `Bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Accountnumber` int(20) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Firstname` varchar(255) DEFAULT NULL,
  `Lastname` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Address1` varchar(255) DEFAULT NULL,
  `Address2` varchar(255) DEFAULT NULL,
  `Amountbalance` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`id`,`Accountnumber`,`Email`, `Firstname`, `Lastname`, `Phone`, `Address1`, `Address2` , `Amountbalance`) VALUES
(1,1238719871, 'abc@gmail.com','Bharath', 'Alluri', '9642589', 'Hyderabad', 'Telangana', 1000000),
(2,1238719872, 'sandy@gmail.com','Sandeep', 'DAS', '9090821', 'cuttak', 'orissa', 235000),
(3,1238719873, 'myneni@yahoo.com','Naveen', 'Myneni', '8608606', 'rjy', 'AP', 431200);

