CREATE DATABASE  IF NOT EXISTS `afdemp_java_1`; 
USE `afdemp_java_1`;

CREATE TABLE `users` (
  `id` int(100) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES (1,'admin','gdevNfgJOqxpQOt5sS/lVw=='),(2,'user1','xntTpoEy19Zq4CytuSz4wQ=='),(3,'user2','L01skslfO36/gRvE1Ux1Bw==');

UNLOCK TABLES;


CREATE TABLE `accounts` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `user_id` int(100) unsigned NOT NULL,
  `transaction_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `accounts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;




LOCK TABLES `accounts` WRITE;

INSERT INTO `accounts` VALUES (1,1,'2017-12-13 22:19:42',100000),(2,2,'2017-12-13 22:19:42',1000),(3,3,'2017-12-13 20:32:12',1000);

UNLOCK TABLES;


CREATE TABLE `deposit_log` (
  `deposit_id` int(11) NOT NULL AUTO_INCREMENT,
  `active_user_id` int(100) unsigned NOT NULL,
  `passive_us_id` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `transaction_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`deposit_id`),
  KEY `active_user_id` (`active_user_id`),
  CONSTRAINT `deposit_log_ibfk_1` FOREIGN KEY (`active_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




LOCK TABLES `deposit_log` WRITE;
INSERT INTO `deposit_log` VALUES (1,1,2,100,'2017-12-13 23:07:23'),(2,2,3,10,'2017-12-13 23:07:42'),(3,2,3,25,'2017-12-13 23:08:34');
UNLOCK TABLES;


CREATE TABLE `withdraw_log` (
  `withdraw_id` int(11) NOT NULL AUTO_INCREMENT,
  `active_user_id` int(100) unsigned NOT NULL,
  `passive_us_id` int(100) unsigned NOT NULL,
  `amount` double DEFAULT NULL,
  `transaction_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`withdraw_id`),
  KEY `active_user_id` (`active_user_id`),
  CONSTRAINT `withdraw_log_ibfk_1` FOREIGN KEY (`active_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




LOCK TABLES `withdraw_log` WRITE;

UNLOCK TABLES;



