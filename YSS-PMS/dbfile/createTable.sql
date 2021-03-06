CREATE TABLE `attendacne_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYE_ID` varchar(45) DEFAULT NULL,
  `EMPLOYE_NAME` varchar(45) DEFAULT NULL,
  `EMPLOYE_QUALF` varchar(45) DEFAULT NULL,
  `PROGRAM_NAME` varchar(200) DEFAULT NULL,
  `ATTENDACNE_DYS` varchar(45) DEFAULT '0',
  `ATTENDACNE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8$$;

delimiter $$

CREATE TABLE `constants` (
  `CONS_ECD` varchar(2) DEFAULT NULL,
  `CONS_NAME` varchar(45) DEFAULT NULL,
  `CONS_CATE` varchar(45) DEFAULT NULL,
  `CONS_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`CONS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `employe` (
  `EMP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CARD` varchar(45) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `QUALIFICATION` varchar(45) DEFAULT NULL,
  `STATUS` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`EMP_ID`),
  UNIQUE KEY `EMP_ID_UNIQUE` (`EMP_ID`),
  UNIQUE KEY `ID_CARD_UNIQUE` (`ID_CARD`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8$$

