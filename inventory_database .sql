-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 05, 2024 at 02:44 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory_database`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetEquipmentByCategory` (IN `categoryName` VARCHAR(255))   BEGIN
    SELECT DISTINCT c.cat_name, se.equip_id, se.equip_name, se.equip_description
    FROM school_equipment se
    JOIN category c ON se.category_id = c.category_id
    WHERE c.cat_name = categoryName;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetEquipmentByEmployee` (IN `employeeId` INT)   BEGIN
    SELECT DISTINCT se.equip_id, se.equip_name, se.equip_description
    FROM school_equipment se
    JOIN equipment_inventory_status eis ON se.equip_id = eis.equip_id
    WHERE eis.emp_in_charge = employeeId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetEquipmentByRoom` (IN `roomNameParam` VARCHAR(255))   BEGIN
    SELECT DISTINCT se.equip_id, se.equip_name, se.equip_description
    FROM school_equipment se
    JOIN equipment_inventory_status eis ON se.equip_id = eis.equip_id
    JOIN room r ON eis.room_id = r.room_id
    WHERE r.room_name = roomNameParam;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetEquipmentDetails` (IN `equipIdParam` INT)   BEGIN
    SELECT DISTINCT se.equip_id, se.equip_name, se.equip_description, se.equip_used, se.property_num, se.PIR_num, se.amount, se.equip_user, eis.equip_status,
        CONCAT(e.emp_fname, ' ', e.emp_lname) AS emp_in_charge_name, r.room_name,  c.cat_name,  MIN(eis.physical_date) AS first_date, MAX(eis.physical_date) AS latest_date
    FROM school_equipment se
    JOIN category c ON se.category_id = c.category_id
    JOIN ( SELECT equip_id, MAX(physical_date) AS latest_date FROM equipment_inventory_status GROUP BY equip_id ) latest_status ON se.equip_id = latest_status.equip_id
    JOIN equipment_inventory_status eis ON se.equip_id = latest_status.equip_id AND eis.physical_date = latest_status.latest_date
    JOIN room r ON eis.room_id = r.room_id
    JOIN employee e ON eis.emp_in_charge = e.emp_id
    WHERE se.equip_id = equipIdParam;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetLatestEmpEquipment` (IN `empIdParam` VARCHAR(225))   BEGIN
    SELECT DISTINCT se.equip_id, se.equip_name, se.equip_description FROM school_equipment se 
    JOIN equipment_inventory_status eis ON se.equip_id = eis.equip_id 
    LEFT JOIN employee em ON em.emp_id = eis.emp_in_charge 
    JOIN (SELECT equip_id, MAX(physical_date) AS latest_date FROM equipment_inventory_status GROUP BY equip_id) 
    latest_status ON eis.equip_id = latest_status.equip_id AND eis.physical_date = latest_status.latest_date 
    WHERE emp_id = empIdParam 
    GROUP BY se.equip_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetLatestEquipmentStatus` (IN `equipNameParam` VARCHAR(225))   BEGIN
    SELECT DISTINCT se.equip_id, se.equip_name, se.equip_description, eis.equip_status
    FROM school_equipment se
    JOIN equipment_inventory_status eis ON se.equip_id = eis.equip_id
    JOIN (
        SELECT equip_id, MAX(physical_date) AS latest_date
        FROM equipment_inventory_status
        GROUP BY equip_id
    ) latest_status ON eis.equip_id = latest_status.equip_id AND eis.physical_date = latest_status.latest_date
    WHERE se.equip_name = equipNameParam
    GROUP BY se.equip_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetRoomCat` ()   BEGIN 
     SELECT r.room_id, c.cat_id FROM room, category;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `cat_name` varchar(255) NOT NULL,
  `cat_description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `cat_name`, `cat_description`) VALUES
(1, 'ICS', 'Inventory Costugian Slip'),
(2, 'PAR', 'Property Acknowledge Receipt'),
(3, 'LGU', 'Local Government Unit'),
(4, 'Others', 'Equipment that are already in school');

-- --------------------------------------------------------

--
-- Stand-in structure for view `category_equip_count`
-- (See below for the actual view)
--
CREATE TABLE `category_equip_count` (
`cat_name` varchar(255)
,`equip_number` bigint(21)
);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL,
  `emp_fname` varchar(225) NOT NULL,
  `emp_mname` varchar(225) NOT NULL,
  `emp_lname` varchar(225) NOT NULL,
  `emp_suffix` varchar(255) NOT NULL,
  `emp_age` int(11) NOT NULL,
  `emp_gender` varchar(225) NOT NULL,
  `emp_type` varchar(225) NOT NULL,
  `emp_status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `emp_fname`, `emp_mname`, `emp_lname`, `emp_suffix`, `emp_age`, `emp_gender`, `emp_type`, `emp_status`) VALUES
(404, '', '', 'Empty', '', 0, '', '', 1),
(2021011, 'Leo', 'Niel', 'Agner', ' ', 21, 'Female', 'Watchmen', 1),
(2021012, 'Sam', '', 'Robert', 'Jr.', 31, 'Male', 'Watchmen', 1),
(2021013, 'Ramen', '', 'Simoun', 'Sr.', 37, 'Male', 'Watchmen', 1),
(2021014, 'Jhonny', '', 'Yespapa', ' ', 31, 'Male', 'Faculty', 1),
(2021015, 'Dano', '', 'Marlon', 'Jr.', 27, 'Male', 'Faculty', 1),
(2021016, 'Rex', '', 'Ponce', ' ', 12, 'Male', 'Watchmen', 0),
(2021017, 'Jamie', '', 'Fox', ' ', 31, 'Female', 'Admin Staff', 1),
(2021018, 'Jamie', 'Robert', 'Fox', ' ', 21, 'Female', 'Watchmen', 1),
(2021019, 'Jamie', 'Sam', 'Fox', ' ', 21, 'Female', 'Admin Staff', 1),
(2021020, 'dawawd', '', 'dawdad', 'Jr.', 31, 'Male', 'Utility', 1),
(2021021, 'FAWEFAW', 'FAWEFW', 'FAWEF', 'Jr.', 21, 'Male', 'AFWEF', 1);

--
-- Triggers `employee`
--
DELIMITER $$
CREATE TRIGGER `update_equipment_on_status_change` AFTER UPDATE ON `employee` FOR EACH ROW BEGIN
    IF NEW.emp_status = 0 AND OLD.emp_status <> NEW.emp_status THEN
      
        INSERT INTO equipment_inventory_status (equip_id, room_id, equip_status, emp_in_charge, physical_date, user_id)
        SELECT eis.equip_id, eis.room_id, eis.equip_status, NEW.emp_id, NOW(), eis.user_id
        FROM equipment_inventory_status eis
        WHERE eis.emp_in_charge = NEW.emp_id
        GROUP BY equip_id 
        ORDER BY eis.physical_date DESC;

        UPDATE equipment_inventory_status
        SET emp_in_charge = 404
        WHERE emp_in_charge = NEW.emp_id
          AND (emp_in_charge, physical_date) = (
            SELECT emp_in_charge, MAX(physical_date) 
            FROM equipment_inventory_status 
            WHERE emp_in_charge = NEW.emp_id
          );
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `employee_details`
-- (See below for the actual view)
--
CREATE TABLE `employee_details` (
`emp_id` int(11)
,`emp_name` text
,`emp_age` int(11)
,`emp_gender` varchar(225)
,`emp_type` varchar(225)
,`emp_guard` bigint(21)
,`emp_status` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `employee_equip_count`
-- (See below for the actual view)
--
CREATE TABLE `employee_equip_count` (
`emp_id` int(11)
,`emp_name` text
,`equip_number` bigint(21)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `equipment_count`
-- (See below for the actual view)
--
CREATE TABLE `equipment_count` (
`equip_name` varchar(225)
,`equip_number` bigint(21)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `equipment_details`
-- (See below for the actual view)
--
CREATE TABLE `equipment_details` (
`equip_id` int(11)
,`equip_name` varchar(225)
,`equip_description` varchar(255)
,`equip_used` varchar(225)
,`property_num` varchar(255)
,`PIR_num` varchar(225)
,`amount` int(11)
,`equip_user` varchar(225)
,`equip_status` int(11)
,`physical_date` timestamp
,`emp_in_charge_name` text
,`room_name` varchar(255)
,`cat_name` varchar(255)
);

-- --------------------------------------------------------

--
-- Table structure for table `equipment_inventory_status`
--

CREATE TABLE `equipment_inventory_status` (
  `status_id` int(11) NOT NULL,
  `equip_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `equip_status` int(11) NOT NULL,
  `emp_in_charge` int(11) NOT NULL,
  `physical_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `equipment_inventory_status`
--

INSERT INTO `equipment_inventory_status` (`status_id`, `equip_id`, `room_id`, `equip_status`, `emp_in_charge`, `physical_date`, `user_id`) VALUES
(5, 2021101, 4, 1, 2021012, '2023-11-12 14:59:50', 2021001),
(6, 2021103, 4, 1, 2021012, '2023-11-12 14:59:50', 2021001),
(7, 2021102, 3, 1, 2021011, '2023-11-07 18:35:45', 2021001),
(8, 2021104, 3, 1, 2021011, '2023-11-07 18:40:39', 2021001),
(24, 2021105, 1, 1, 2021013, '2023-11-15 15:14:02', 2021001),
(32, 2021106, 1, 1, 2021014, '2023-11-20 12:25:33', 2021001),
(33, 2021107, 1, 1, 2021014, '2023-11-20 12:46:15', 2021001),
(34, 2021108, 4, 1, 2021012, '2023-11-21 12:20:40', 2021001),
(35, 2021109, 3, 1, 2021011, '2023-11-22 14:25:36', 2021001),
(36, 2021110, 3, 1, 2021012, '2023-11-23 09:46:52', 2021001),
(41, 2021111, 3, 1, 2021011, '2023-12-07 08:05:56', 2021001),
(42, 2021112, 3, 1, 2021011, '2023-12-07 08:14:40', 2021001),
(43, 2021113, 2, 1, 2021015, '2023-12-07 08:21:22', 2021001),
(48, 2021114, 2, 1, 2021014, '2023-12-09 09:20:23', 2021001),
(73, 2021113, 3, 6, 2021015, '2023-12-30 06:06:44', 2021001),
(75, 2021105, 1, 5, 2021018, '2023-12-30 12:18:11', 2021001),
(76, 2021115, 2, 1, 404, '2023-12-31 11:48:49', 2021001),
(77, 2021115, 404, 3, 404, '2023-12-31 11:48:58', 2021001),
(78, 2021116, 3, 1, 2021020, '2024-01-01 08:25:44', 2021001);

-- --------------------------------------------------------

--
-- Stand-in structure for view `equipment_status_history`
-- (See below for the actual view)
--
CREATE TABLE `equipment_status_history` (
`status_id` int(11)
,`equip_id` int(11)
,`property_num` varchar(255)
,`PIR_num` varchar(225)
,`room_name` varchar(255)
,`equip_name` varchar(225)
,`equip_description` varchar(255)
,`emp_in_charge_name` text
,`equip_status` int(11)
,`physical_date` timestamp
,`user_name` varchar(451)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `equip_inventory_date`
-- (See below for the actual view)
--
CREATE TABLE `equip_inventory_date` (
`equip_id` int(11)
,`equip_name` varchar(225)
,`equip_description` varchar(255)
,`first_date` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `equip_status_count`
-- (See below for the actual view)
--
CREATE TABLE `equip_status_count` (
`equip_name` varchar(225)
,`available` bigint(21)
,`unavailable` bigint(21)
,`missing` bigint(21)
,`return_to_main` bigint(21)
,`defective` bigint(21)
);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `room_id` int(11) NOT NULL,
  `room_name` varchar(255) NOT NULL,
  `room_type` varchar(255) NOT NULL,
  `room_status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`room_id`, `room_name`, `room_type`, `room_status`) VALUES
(1, 'R3-1', 'Classroom', 1),
(2, 'R3-2', 'Classroom', 1),
(3, 'CL-1', 'Classroom', 1),
(4, 'CL-2', 'Classroom', 1),
(5, 'Locker', 'Storage', 1),
(404, 'Empty', '', 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `room_details`
-- (See below for the actual view)
--
CREATE TABLE `room_details` (
`room_id` int(11)
,`room_name` varchar(255)
,`room_type` varchar(255)
,`room_guard` bigint(21)
,`room_status` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `room_equip_count`
-- (See below for the actual view)
--
CREATE TABLE `room_equip_count` (
`room_name` varchar(255)
,`equip_number` bigint(21)
);

-- --------------------------------------------------------

--
-- Table structure for table `school_equipment`
--

CREATE TABLE `school_equipment` (
  `equip_id` int(11) NOT NULL,
  `property_num` varchar(255) NOT NULL,
  `PIR_num` varchar(225) NOT NULL,
  `equip_name` varchar(225) NOT NULL,
  `equip_description` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  `equip_used` varchar(225) NOT NULL,
  `equip_user` varchar(225) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `school_equipment`
--

INSERT INTO `school_equipment` (`equip_id`, `property_num`, `PIR_num`, `equip_name`, `equip_description`, `amount`, `equip_used`, `equip_user`, `category_id`) VALUES
(2021101, '2023-04-1138-255', 'ICS#-13-41-101', 'Monitor', 'ASUS VP01', 9000, 'Practice Programming', 'Student', 1),
(2021102, '2023-04-1139-255', 'ICS#-33-51-101', 'Desktop Keyboard', 'RGBKA150', 360, 'Practice Programming', 'Student', 3),
(2021103, '2023-04-1140-255', 'ICS#-21-61-101', 'Desktop Mouse', 'DeluxUI17', 300, 'Practice Programming', 'Student', 1),
(2021104, '2023-04-1141-255', 'ICS#-22-11-101', 'Desktop CPU', 'Xtreme 22', 13000, 'Practice Programming', 'Student', 1),
(2021105, '2023-04-1134-255', 'ICS#-23-71-101', 'Ballpen', 'HB101', 10, 'Writting', 'Student', 4),
(2021106, '2023-04-1135-255', 'ICS#-23-81-101', 'Basketball', 'Goodyear VB', 270, 'Sports', 'Atlethes', 3),
(2021107, '2023-04-1136-255', 'ICS#-24-71-101', 'Basketball', 'Goodyear VB', 270, 'Sports', 'Atlethes', 3),
(2021108, '2023-04-1136-255', 'ICS#-13-69-101', 'Desktop Mouse', 'DeluxUI17', 300, 'Practice Programming', 'Student', 1),
(2021109, '2023-04-1137-255', 'ICS#-28-71-101', 'SSD', 'Xtreme -240GB', 5000, 'Educational', 'Student', 1),
(2021110, '2023-04-1161-255', 'ICS#-21-75-101', 'Monitor', 'DellXP', 8500, 'Educational', 'Student', 1),
(2021111, '2023-04-1154-255', 'ICS#-23-74-101', 'SSD', 'Xtreme -240GB', 5000, 'Educational', 'Student', 1),
(2021112, '2023-04-1238-255', 'ICS#-24-78-101', 'SSD', 'Xtreme -240GB', 5000, 'Educational', 'Student', 1),
(2021113, '2023-04-1261-255', 'ICS#-27-71-101', 'Ballpen', 'HB101', 10, 'Writting', 'Student', 4),
(2021114, '2023-04-1105-255', 'ICS#-14-23-101', 'Volleyball', 'Beach101', 330, 'Atlethes', 'Sports', 2),
(2021115, 'fawefawf', 'fawefaweffa', 'faweffsaefa', 'faefasgrfaw', 31241, 'fawefaw', 'fawefaw', 3),
(2021116, 'faqefawfwf', 'fawefawdawdf', 'faweffsaefa', 'faefasgrfaw', 1323, 'dawdafaef', 'fewaawfea', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_ID` int(11) NOT NULL,
  `user_fname` varchar(225) NOT NULL,
  `suer_mname` varchar(225) NOT NULL,
  `user_lname` varchar(225) NOT NULL,
  `user_type` varchar(225) NOT NULL,
  `user_status` int(11) NOT NULL,
  `user_password` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_ID`, `user_fname`, `suer_mname`, `user_lname`, `user_type`, `user_status`, `user_password`) VALUES
(2021001, 'James', '', 'Boncales', 'Student', 1, '1234');

-- --------------------------------------------------------

--
-- Structure for view `category_equip_count`
--
DROP TABLE IF EXISTS `category_equip_count`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `category_equip_count`  AS SELECT `c`.`cat_name` AS `cat_name`, count(distinct `se`.`equip_id`) AS `equip_number` FROM (`category` `c` left join `school_equipment` `se` on(`c`.`category_id` = `se`.`category_id`)) GROUP BY `c`.`category_id` ORDER BY `c`.`category_id` ASC  ;

-- --------------------------------------------------------

--
-- Structure for view `employee_details`
--
DROP TABLE IF EXISTS `employee_details`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_details`  AS SELECT `em`.`emp_id` AS `emp_id`, concat(`em`.`emp_lname`,', ',`em`.`emp_fname`,' ',`em`.`emp_mname`,' ',`em`.`emp_suffix`) AS `emp_name`, `em`.`emp_age` AS `emp_age`, `em`.`emp_gender` AS `emp_gender`, `em`.`emp_type` AS `emp_type`, count(distinct case when `eis`.`physical_date` = `latest_status`.`latest_date` then `se`.`equip_id` end) AS `emp_guard`, `em`.`emp_status` AS `emp_status` FROM (((`employee` `em` left join `equipment_inventory_status` `eis` on(`em`.`emp_id` = `eis`.`emp_in_charge`)) left join `school_equipment` `se` on(`eis`.`equip_id` = `se`.`equip_id`)) left join (select `equipment_inventory_status`.`equip_id` AS `equip_id`,max(`equipment_inventory_status`.`physical_date`) AS `latest_date` from `equipment_inventory_status` group by `equipment_inventory_status`.`equip_id`) `latest_status` on(`eis`.`equip_id` = `latest_status`.`equip_id`)) GROUP BY `em`.`emp_id` HAVING `em`.`emp_id` <> 404 ORDER BY `em`.`emp_id` ASC  ;

-- --------------------------------------------------------

--
-- Structure for view `employee_equip_count`
--
DROP TABLE IF EXISTS `employee_equip_count`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_equip_count`  AS SELECT `em`.`emp_id` AS `emp_id`, concat(`em`.`emp_lname`,', ',`em`.`emp_fname`,' ',`em`.`emp_mname`,' ',`em`.`emp_suffix`) AS `emp_name`, count(distinct `eis`.`equip_id`) AS `equip_number` FROM (`employee` `em` left join `equipment_inventory_status` `eis` on(`em`.`emp_id` = `eis`.`emp_in_charge`)) GROUP BY `em`.`emp_id` ORDER BY `em`.`emp_id` ASC  ;

-- --------------------------------------------------------

--
-- Structure for view `equipment_count`
--
DROP TABLE IF EXISTS `equipment_count`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `equipment_count`  AS SELECT `se`.`equip_name` AS `equip_name`, count(distinct case when `eis`.`physical_date` = `latest_status`.`latest_date` and `eis`.`equip_status` <> 3 then `se`.`equip_id` end) AS `equip_number` FROM ((`school_equipment` `se` join `equipment_inventory_status` `eis` on(`se`.`equip_id` = `eis`.`equip_id`)) left join (select `equipment_inventory_status`.`equip_id` AS `equip_id`,max(`equipment_inventory_status`.`physical_date`) AS `latest_date` from `equipment_inventory_status` group by `equipment_inventory_status`.`equip_id`) `latest_status` on(`eis`.`equip_id` = `latest_status`.`equip_id`)) GROUP BY `se`.`equip_name` ORDER BY `se`.`equip_name` ASC  ;

-- --------------------------------------------------------

--
-- Structure for view `equipment_details`
--
DROP TABLE IF EXISTS `equipment_details`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `equipment_details`  AS SELECT `se`.`equip_id` AS `equip_id`, `se`.`equip_name` AS `equip_name`, `se`.`equip_description` AS `equip_description`, `se`.`equip_used` AS `equip_used`, `se`.`property_num` AS `property_num`, `se`.`PIR_num` AS `PIR_num`, `se`.`amount` AS `amount`, `se`.`equip_user` AS `equip_user`, `eis`.`equip_status` AS `equip_status`, `eis`.`physical_date` AS `physical_date`, concat(`e`.`emp_fname`,' ',ucase(substr(`e`.`emp_mname`,1,1)),if(`e`.`emp_mname` <> '','. ',' '),`e`.`emp_lname`,' ',`e`.`emp_suffix`) AS `emp_in_charge_name`, `r`.`room_name` AS `room_name`, `c`.`cat_name` AS `cat_name` FROM (((((`school_equipment` `se` join (select `equipment_inventory_status`.`equip_id` AS `equip_id`,max(`equipment_inventory_status`.`physical_date`) AS `latest_date` from `equipment_inventory_status` group by `equipment_inventory_status`.`equip_id`) `latest_status` on(`se`.`equip_id` = `latest_status`.`equip_id`)) join `equipment_inventory_status` `eis` on(`se`.`equip_id` = `eis`.`equip_id` and `eis`.`physical_date` = `latest_status`.`latest_date`)) join `employee` `e` on(`eis`.`emp_in_charge` = `e`.`emp_id`)) join `room` `r` on(`eis`.`room_id` = `r`.`room_id`)) join `category` `c` on(`se`.`category_id` = `c`.`category_id`)) ORDER BY `eis`.`physical_date` DESC ;

-- --------------------------------------------------------

--
-- Structure for view `equipment_status_history`
--
DROP TABLE IF EXISTS `equipment_status_history`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `equipment_status_history`  AS SELECT `eis`.`status_id` AS `status_id`, `eis`.`equip_id` AS `equip_id`, `se`.`property_num` AS `property_num`, `se`.`PIR_num` AS `PIR_num`, `r`.`room_name` AS `room_name`, `se`.`equip_name` AS `equip_name`, `se`.`equip_description` AS `equip_description`, concat(`e`.`emp_fname`,' ',ucase(substr(`e`.`emp_mname`,1,1)),if(`e`.`emp_mname` <> '','. ',' '),`e`.`emp_lname`,' ',`e`.`emp_suffix`) AS `emp_in_charge_name`, `eis`.`equip_status` AS `equip_status`, `eis`.`physical_date` AS `physical_date`, concat(`u`.`user_fname`,' ',`u`.`user_lname`) AS `user_name` FROM ((((`equipment_inventory_status` `eis` join `school_equipment` `se` on(`eis`.`equip_id` = `se`.`equip_id`)) join `room` `r` on(`eis`.`room_id` = `r`.`room_id`)) join `employee` `e` on(`eis`.`emp_in_charge` = `e`.`emp_id`)) join `user` `u` on(`eis`.`user_id` = `u`.`user_ID`)) ORDER BY `eis`.`status_id` ASC  ;

-- --------------------------------------------------------

--
-- Structure for view `equip_inventory_date`
--
DROP TABLE IF EXISTS `equip_inventory_date`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `equip_inventory_date`  AS SELECT `se`.`equip_id` AS `equip_id`, `se`.`equip_name` AS `equip_name`, `se`.`equip_description` AS `equip_description`, min(`eis`.`physical_date`) AS `first_date` FROM (`school_equipment` `se` join `equipment_inventory_status` `eis` on(`se`.`equip_id` = `eis`.`equip_id`)) GROUP BY `se`.`equip_id`, `se`.`equip_name`, `se`.`equip_description` ORDER BY `se`.`equip_name` ASC  ;

-- --------------------------------------------------------

--
-- Structure for view `equip_status_count`
--
DROP TABLE IF EXISTS `equip_status_count`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `equip_status_count`  AS SELECT `se`.`equip_name` AS `equip_name`, count(case when `eis`.`equip_status` = 1 then 1 else NULL end) AS `available`, count(case when `eis`.`equip_status` = 0 then 1 else NULL end) AS `unavailable`, count(case when `eis`.`equip_status` = 2 then 1 else NULL end) AS `missing`, count(case when `eis`.`equip_status` = 3 then 1 else NULL end) AS `return_to_main`, count(case when `eis`.`equip_status` = 4 then 1 else NULL end) AS `defective` FROM ((`equipment_inventory_status` `eis` join (select `equipment_inventory_status`.`equip_id` AS `equip_id`,max(`equipment_inventory_status`.`physical_date`) AS `latest_date` from `equipment_inventory_status` group by `equipment_inventory_status`.`equip_id`) `latest_status` on(`eis`.`equip_id` = `latest_status`.`equip_id` and `eis`.`physical_date` = `latest_status`.`latest_date`)) join `school_equipment` `se` on(`eis`.`equip_id` = `se`.`equip_id`)) GROUP BY `se`.`equip_name`  ;

-- --------------------------------------------------------

--
-- Structure for view `room_details`
--
DROP TABLE IF EXISTS `room_details`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `room_details`  AS SELECT `r`.`room_id` AS `room_id`, `r`.`room_name` AS `room_name`, `r`.`room_type` AS `room_type`, count(distinct case when `eis`.`physical_date` = `latest_status`.`latest_date` then `se`.`equip_id` end) AS `room_guard`, `r`.`room_status` AS `room_status` FROM (((`room` `r` left join `equipment_inventory_status` `eis` on(`r`.`room_id` = `eis`.`room_id`)) left join `school_equipment` `se` on(`eis`.`equip_id` = `se`.`equip_id`)) left join (select `equipment_inventory_status`.`equip_id` AS `equip_id`,max(`equipment_inventory_status`.`physical_date`) AS `latest_date` from `equipment_inventory_status` group by `equipment_inventory_status`.`equip_id`) `latest_status` on(`eis`.`equip_id` = `latest_status`.`equip_id`)) GROUP BY `r`.`room_id` HAVING `r`.`room_id` <> 404 ORDER BY `r`.`room_id` ASC  ;

-- --------------------------------------------------------

--
-- Structure for view `room_equip_count`
--
DROP TABLE IF EXISTS `room_equip_count`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `room_equip_count`  AS SELECT `r`.`room_name` AS `room_name`, count(distinct `eis`.`equip_id`) AS `equip_number` FROM (`room` `r` left join `equipment_inventory_status` `eis` on(`r`.`room_id` = `eis`.`room_id`)) GROUP BY `eis`.`room_id` ORDER BY `eis`.`room_id` ASC  ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `equipment_inventory_status`
--
ALTER TABLE `equipment_inventory_status`
  ADD PRIMARY KEY (`status_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `equip_id` (`equip_id`),
  ADD KEY `room_id` (`room_id`),
  ADD KEY `emp_in_charge` (`emp_in_charge`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`room_id`);

--
-- Indexes for table `school_equipment`
--
ALTER TABLE `school_equipment`
  ADD PRIMARY KEY (`equip_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2021113;

--
-- AUTO_INCREMENT for table `equipment_inventory_status`
--
ALTER TABLE `equipment_inventory_status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `room_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=405;

--
-- AUTO_INCREMENT for table `school_equipment`
--
ALTER TABLE `school_equipment`
  MODIFY `equip_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2021117;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2021002;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `equipment_inventory_status`
--
ALTER TABLE `equipment_inventory_status`
  ADD CONSTRAINT `equipment_inventory_status_ibfk_1` FOREIGN KEY (`equip_id`) REFERENCES `school_equipment` (`equip_id`),
  ADD CONSTRAINT `equipment_inventory_status_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  ADD CONSTRAINT `equipment_inventory_status_ibfk_3` FOREIGN KEY (`emp_in_charge`) REFERENCES `employee` (`emp_id`),
  ADD CONSTRAINT `equipment_inventory_status_ibfk_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_ID`);

--
-- Constraints for table `school_equipment`
--
ALTER TABLE `school_equipment`
  ADD CONSTRAINT `school_equipment_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
