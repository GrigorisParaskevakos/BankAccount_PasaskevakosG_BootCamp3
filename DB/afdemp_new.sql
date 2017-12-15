CREATE USER 'afdemp'@'localhost' IDENTIFIED BY '12345';
GRANT ALL PRIVILEGES ON `afdemp_java_1`.* TO 'afdemp'@'localhost' IDENTIFIED BY '12345';
FLUSH PRIVILEGES;


CREATE DATABASE  IF NOT EXISTS `afdemp_java_1`;
USE `afdemp_java_1`;

CREATE TABLE `users` (
  `id` int(100) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `accounts` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `user_id` int(100) unsigned NOT NULL,
  `transaction_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `accounts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `deposit_log` (
  `deposit_id` int(11) NOT NULL AUTO_INCREMENT,
  `active_user_id` int(100) unsigned NOT NULL,
  `passive_user_id` int(100) unsigned NOT NULL,
  `amount` double DEFAULT NULL,
  `transaction_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`deposit_id`),
  KEY `active_user_id` (`active_user_id`),
  CONSTRAINT `deposit_log_ibfk_1` FOREIGN KEY (`active_user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `deposit_log_ibfk_2` FOREIGN KEY (`passive_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `withdraw_log` (
  `withdraw_id` int(11) NOT NULL AUTO_INCREMENT,
  `active_user_id` int(100) unsigned NOT NULL,
  `passive_user_id` int(100) unsigned NOT NULL,
  `amount` double DEFAULT NULL,
  `transaction_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`withdraw_id`),
  KEY `active_user_id` (`active_user_id`),
  CONSTRAINT `withdraw_log_ibfk_1` FOREIGN KEY (`active_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `users` VALUES (1,'admin','gdevNfgJOqxpQOt5sS/lVw=='),(2,'user1','xntTpoEy19Zq4CytuSz4wQ=='),(3,'user2','L01skslfO36/gRvE1Ux1Bw==');
INSERT INTO `accounts` VALUES (1,1,'2017-12-13 22:19:42',100000),(2,2,'2017-12-13 22:19:42',1000),(3,3,'2017-12-13 20:32:12',1000);
INSERT INTO `withdraw_log` VALUES (1,1,2,10,'2017-12-14 23:03:02'),(2,1,3,10,'2017-12-14 23:03:08'),(3,1,1,0,'2017-12-14 23:03:11'),(4,1,2,100,'2017-12-14 23:29:40'),(5,1,3,100,'2017-12-14 23:29:44'),(6,1,1,0,'2017-12-14 23:29:47'),(7,1,3,600,'2017-12-15 01:05:14'),(8,1,1,0,'2017-12-15 01:05:16'),(9,1,3,3400,'2017-12-15 01:13:39'),(10,1,3,100,'2017-12-15 01:14:13'),(11,1,1,0,'2017-12-15 01:14:21'),(12,1,2,40000,'2017-12-15 01:36:05'),(13,1,3,9000,'2017-12-15 01:36:17'),(14,1,2,2000,'2017-12-15 01:36:27'),(15,1,1,0,'2017-12-15 01:36:42'),(16,1,3,1000,'2017-12-15 01:41:12'),(17,1,2,100,'2017-12-15 01:41:21'),(18,1,1,0,'2017-12-15 01:41:24'),(19,1,1,0,'2017-12-15 01:51:44'),(20,1,2,100,'2017-12-15 02:15:16'),(21,1,3,100,'2017-12-15 02:15:22'),(22,1,1,0,'2017-12-15 02:15:27'),(23,1,2,500,'2017-12-15 02:16:41'),(24,1,2,100,'2017-12-15 02:16:48'),(25,1,3,200,'2017-12-15 02:16:57'),(26,1,1,0,'2017-12-15 02:17:16'),(27,1,1,0,'2017-12-15 02:20:14'),(28,1,1,0,'2017-12-15 02:22:58'),(29,1,1,0,'2017-12-15 02:24:29'),(30,1,1,0,'2017-12-15 02:25:43'),(31,1,1,0,'2017-12-15 02:26:54'),(32,1,1,0,'2017-12-15 02:27:15'),(33,1,1,0,'2017-12-15 02:28:32'),(34,1,1,0,'2017-12-15 02:29:18'),(35,1,1,0,'2017-12-15 02:35:02'),(36,1,1,0,'2017-12-15 02:36:44'),(37,1,1,0,'2017-12-15 02:37:36'),(38,1,1,0,'2017-12-15 02:39:05'),(39,1,1,0,'2017-12-15 02:39:51'),(40,1,1,0,'2017-12-15 02:40:31'),(41,1,1,0,'2017-12-15 02:41:46'),(42,1,1,0,'2017-12-15 02:44:18'),(43,2,1,0,'2017-12-15 02:48:07'),(44,1,1,0,'2017-12-15 02:58:31'),(45,1,1,0,'2017-12-15 03:03:54'),(46,1,3,10,'2017-12-15 03:04:39'),(47,1,1,0,'2017-12-15 03:04:41'),(48,1,1,0,'2017-12-15 03:08:26'),(49,1,1,0,'2017-12-15 03:10:15'),(50,1,1,0,'2017-12-15 03:11:53'),(51,1,1,0,'2017-12-15 03:13:23'),(52,1,1,0,'2017-12-15 03:14:01'),(53,1,1,0,'2017-12-15 03:20:58'),(54,1,1,0,'2017-12-15 03:34:23'),(55,1,1,0,'2017-12-15 03:35:24'),(56,1,1,0,'2017-12-15 03:59:08'),(57,1,2,144.5,'2017-12-15 04:00:19'),(58,1,1,0,'2017-12-15 04:00:30'),(59,1,2,100,'2017-12-15 04:02:25'),(60,1,1,0,'2017-12-15 04:02:28'),(61,1,1,0,'2017-12-15 04:02:50'),(62,1,1,0,'2017-12-15 04:03:52'),(63,1,1,0,'2017-12-15 04:04:44'),(64,1,1,0,'2017-12-15 04:05:20'),(65,1,2,1000.4,'2017-12-15 04:17:01'),(66,1,3,1300.6,'2017-12-15 04:39:30'),(67,1,2,100.34,'2017-12-15 04:40:48'),(68,1,1,0,'2017-12-15 04:40:52'),(69,1,1,0,'2017-12-15 05:22:59'),(70,1,1,0,'2017-12-15 05:27:39');
INSERT INTO `deposit_log` VALUES (1,1,2,100,'2017-12-13 23:07:23'),(2,2,3,10,'2017-12-13 23:07:42'),(3,2,3,25,'2017-12-13 23:08:34');

