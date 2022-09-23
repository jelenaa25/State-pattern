/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.22 : Database - paf44state
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`paf44state` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `paf44state`;

/*Table structure for table `counter` */

DROP TABLE IF EXISTS `counter`;

CREATE TABLE `counter` (
  `TableName` varchar(100) NOT NULL DEFAULT '',
  `Counter` int DEFAULT '0',
  PRIMARY KEY (`TableName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `counter` */

insert  into `counter`(`TableName`,`Counter`) values 
('DKPorudzbina',47);

/*Table structure for table `dkporudzbina` */

DROP TABLE IF EXISTS `dkporudzbina`;

CREATE TABLE `dkporudzbina` (
  `SifraPorudzbine` int NOT NULL,
  `Palacinka` varchar(55) DEFAULT NULL,
  `Preliv` varchar(55) DEFAULT NULL,
  `Voce` varchar(55) DEFAULT NULL,
  `Stanje` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`SifraPorudzbine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dkporudzbina` */

insert  into `dkporudzbina`(`SifraPorudzbine`,`Palacinka`,`Preliv`,`Voce`,`Stanje`) values 
(34,'KLASICNA','Nutela','visnje','storniran'),
(45,'COKO','Ala Kinder Bueno','visnje','obradjen'),
(46,'RED VELVET','Nutela','sumsko voce','obradjen'),
(47,'KLASICNA','Nutela','sumsko voce','storniran');

/*Table structure for table `dkproizvod` */

DROP TABLE IF EXISTS `dkproizvod`;

CREATE TABLE `dkproizvod` (
  `sifraProizvoda` int NOT NULL,
  `nazivProizvoda` text,
  `opisProizvoda` text,
  `cenaProizvoda` double DEFAULT NULL,
  `urlProizvoda` text,
  PRIMARY KEY (`sifraProizvoda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dkproizvod` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
