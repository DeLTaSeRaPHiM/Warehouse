CREATE DATABASE  IF NOT EXISTS `warehouse_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `warehouse_db`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: warehouse_db
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `warehouse_main`
--

DROP TABLE IF EXISTS `warehouse_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehouse_main` (
  `id_warehouse` int NOT NULL AUTO_INCREMENT,
  `Наименование` text NOT NULL,
  `Категория_товара` text NOT NULL,
  `Тип_товара` text NOT NULL,
  `Производитель` text NOT NULL,
  `Количество` int NOT NULL,
  `Цена_розницы` double DEFAULT NULL,
  `Цена_закупки` double NOT NULL,
  `Цена_продаж` double NOT NULL,
  `Дата_изменения` varchar(10) DEFAULT NULL,
  `Описание` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id_warehouse`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse_main`
--

LOCK TABLES `warehouse_main` WRITE;
/*!40000 ALTER TABLE `warehouse_main` DISABLE KEYS */;
INSERT INTO `warehouse_main` VALUES (1,'Видеорегистратор DVR-104P-G','Видеонаблюдение','Видеорегистратор','',1,7100,7100,0,'2022-04-27','Описания не будет, его украли пингвины'),(2,'Видеорегистратор DVR-108-G/N','Видеонаблюдение','Видеорегистратор','',1,10150,10150,0,NULL,NULL),(3,'Видеокамера HDC-T020-P','Видеонаблюдение','Видеокамера','',4,3050,12200,0,NULL,NULL),(4,'Видеокамера HDC-B020 ','Видеонаблюдение','Видеокамера','',8,3050,24400,0,NULL,NULL),(5,'Видеокамера DS-T200L','Видеонаблюдение','Видеокамера','',2,4800,9600,0,NULL,NULL),(6,'Видеокамера DS-T200(B)','Видеонаблюдение','Видеокамера','',2,4050,8100,0,NULL,NULL),(7,'Видеокамера DS-T123','Видеонаблюдение','Видеокамера','',2,3000,6000,0,NULL,NULL),(8,'Видеокамера DS-T133','Видеонаблюдение','Видеокамера','',2,2300,4600,0,NULL,NULL),(9,'Видеокамера DS-T233','Видеонаблюдение','Видеокамера','',2,3700,7400,0,NULL,NULL),(10,'Видеокамера PT-MHD1080P-MC-IR','Видеонаблюдение','Видеокамера','',1,2300,2300,0,NULL,NULL),(11,'Видеокамера IPC-T020','Видеонаблюдение','Видеокамера','',2,7100,14200,0,NULL,NULL),(12,'Видеокамера IPC-B020(B)','Видеонаблюдение','Видеокамера','',2,7100,14200,0,NULL,NULL),(13,'Видеорегистратор DS-H204QA','Видеонаблюдение','Видеорегистратор','',1,10500,10500,0,NULL,NULL),(14,'Видеокамера DS-T200A','Видеонаблюдение','Видеокамера','',2,9800,19600,0,NULL,NULL),(15,'Видеокамера DS-T203(A)','Видеонаблюдение','Видеокамера','',2,4900,9800,0,NULL,NULL),(16,'Видеокамера DVC-S492V','Видеонаблюдение','Видеокамера','',1,4000,4000,0,NULL,NULL),(17,'Видеорегистратор BestDVR-800Light-AM','Видеонаблюдение','Видеорегистратор','',1,7300,7300,0,NULL,NULL),(18,'Видеорегистратор BestDVR-400Pro-AM','Видеонаблюдение','Видеорегистратор','',2,7590,15180,0,NULL,NULL),(19,'Видеорегистратор SVR-4115P','Видеонаблюдение','Видеорегистратор','',1,8600,8600,0,NULL,NULL),(20,'Видеорегистратор SVR-9115N','Видеонаблюдение','Видеорегистратор','',1,17750,17750,0,NULL,NULL),(21,'Видеорегистратор SVR-8812AM PRO','Видеонаблюдение','Видеорегистратор','',1,13000,13000,0,NULL,NULL),(22,'Видеокамера SVI-D343V','Видеонаблюдение','Видеокамера','',2,11000,22000,0,NULL,NULL),(23,'Видеокамера SVC-D892 v3.0','Видеонаблюдение','Видеокамера','',1,4000,4000,0,NULL,NULL),(24,'Видеокамера SVC-D892 SL','Видеонаблюдение','Видеокамера','',3,5700,17100,0,NULL,NULL),(25,'Видеокамера SVC-D89','Видеонаблюдение','Видеокамера','',1,1400,1400,0,NULL,NULL),(26,'Видеокамера SVC-D392V v3.0','Видеонаблюдение','Видеокамера','',1,7800,7800,0,NULL,NULL),(27,'Видеокамера SVC-D393V','Видеонаблюдение','Видеокамера','',2,4200,8400,0,NULL,NULL),(28,'Видеокамера SVC-D692V SL','Видеонаблюдение','Видеокамера','',2,3700,7400,0,NULL,NULL),(29,'Видеокамера SVC-D295','Видеонаблюдение','Видеокамера','',1,7700,7700,0,NULL,NULL),(30,'Видеокамера SVC-D694V','Видеонаблюдение','Видеокамера','',1,3400,3400,0,NULL,NULL),(31,'Видеокамера SVC-S195 V2.0 Новый вариант','Видеонаблюдение','Видеокамера','',1,9200,9200,0,NULL,NULL),(32,'Видеокамера SVC-S192SL Новый вариант','Видеонаблюдение','Видеокамера','',2,7500,15000,0,NULL,NULL),(33,'Видеокамера DVC-S192P 2.8mm','Видеонаблюдение','Видеокамера','',5,3750,18750,0,NULL,NULL),(34,'Видеокамера DVC-S192P 3.6mm','Видеонаблюдение','Видеокамера','',1,1900,1900,0,NULL,NULL),(35,'Видеокамера SVC-S195 V3.0','Видеонаблюдение','Видеокамера','',1,9230,9230,0,NULL,NULL),(36,'Видеокамера SVC-S175','Видеонаблюдение','Видеокамера','',1,8700,8700,0,NULL,NULL),(37,'Видеокамера VC-2203','Видеонаблюдение','Видеокамера','',2,1100,2200,0,NULL,NULL),(38,'Видеокамера VC-4261','Видеонаблюдение','Видеокамера','',1,1100,1100,0,NULL,NULL),(39,'Видеокамера MBK-M720Strong','Видеонаблюдение','Видеокамера','',1,4553,4553,0,NULL,NULL),(40,'Видеокамера MBK-M1080Ball','Видеонаблюдение','Видеокамера','',4,4553,18212,0,NULL,NULL),(41,'Видеокамера MBK-M720Ball','Видеонаблюдение','Видеокамера','',4,3538,14152,0,NULL,NULL),(42,'Видеокамера MBK-MV720Ball','Видеонаблюдение','Видеокамера','',1,3300,3300,0,NULL,NULL),(43,'Видеорегистратор SVN-4625-PRO','Видеонаблюдение','Видеорегистратор','',1,5400,5400,0,NULL,NULL),(44,'Видеокамера DS-I250','Видеонаблюдение','Видеокамера','',1,7250,7250,0,NULL,NULL),(45,'Видеокамера DS-I203 ©','Видеонаблюдение','Видеокамера','',1,8090,8090,0,NULL,NULL),(46,'Видеокамера Т-107','Видеонаблюдение','Видеокамера','',1,4000,4000,0,NULL,NULL),(47,'Видеокамера SVC-S195 V2.0 Старый вариант','Видеонаблюдение','Видеокамера','',1,9000,9000,0,NULL,NULL),(48,'Видеокамера SVC-S192SL Старый вариант','Видеонаблюдение','Видеокамера','',1,7300,7300,0,NULL,NULL),(49,'Cчитыватель антивандальный iButton','СКУД','Считыватель','',1,350,350,0,NULL,NULL),(50,'Блок сопряжения MC-VZ','СКУД','Блоки','',2,945,1890,0,NULL,NULL),(51,'Доводчик гидравлический TS-DC045','СКУД','Доводчик','',3,2500,7500,0,NULL,NULL),(52,'Доводчик гидравлический TS-DC065','СКУД','Доводчик','',2,3250,6500,0,NULL,NULL),(53,'Доводчик дверной OUBAO E-604','СКУД','Доводчик','',1,3200,3200,0,NULL,NULL),(54,'Замок электромагнитный M1-300','СКУД','Замки','',1,1850,1850,0,NULL,NULL),(55,'Замок электромагнитный ML-180K (с уголком)','СКУД','Замки','',1,3430,3430,0,NULL,NULL),(56,'Замок электромагнитный TS-ML180','СКУД','Замки','',1,3000,3000,0,NULL,NULL),(57,'Замок электромагнитный VIZIT-ML300M-40','СКУД','Замки','',2,2700,5400,0,NULL,NULL),(58,'Замок электромеханичексий EL-01','СКУД','Замки','',1,2025,2025,0,NULL,NULL),(59,'Замок электромеханический TS-EL2369','СКУД','Замки','',1,4950,4950,0,NULL,NULL),(60,'Замок электромеханический TS-EL2369SS','СКУД','Замки','',1,4470,4470,0,NULL,NULL),(61,'Замок электромеханический TS-EL2369ST','СКУД','Замки','',1,3135,3135,0,NULL,NULL),(62,'Замок электромеханический ПОЛИС-11','СКУД','Замки','',2,3070,6140,0,NULL,NULL),(63,'Кнопка JSB-Kn-21 ','СКУД','Кнопки','',2,505,1010,0,NULL,NULL),(64,'Кнопка JSB-Kn-22 ','СКУД','Кнопки','',1,505,505,0,NULL,NULL),(65,'Кнопка HO-02','СКУД','Кнопки','',10,125,1250,0,NULL,NULL),(66,'Кнопка TS-CLICK','СКУД','Кнопки','',4,825,3300,0,NULL,NULL),(67,'Контактор ЦИКЛОП ТМ','СКУД','Считыватель','',2,380,760,0,NULL,NULL),(68,'Контроллер Z-5R','СКУД','Контроллер','',2,1010,2020,0,NULL,NULL),(69,'Контроллер Z-5R (мод. Relay Wiegand)','СКУД','Контроллер','',1,1550,1550,0,NULL,NULL),(70,'Модуль сопряжения MCK','СКУД','Модули','',1,1975,1975,0,NULL,NULL),(71,'Считыватель JSB-KTMn Z touch memory','СКУД','Считыватель','',1,70,70,0,NULL,NULL),(72,'Защелка электромеханическая ПОЛИС-15-02','СКУД','Защелка','',1,2000,2000,0,NULL,NULL),(73,'Коммутатор POE Switch ST-S45POE','Сетевое оборудование','Коммутатор','',1,5000,5000,0,NULL,NULL),(74,'Источник питания Optimus 1250','Источники питания','Источник питания','',1,2100,2100,0,NULL,NULL),(75,'Источник питания SVP-122 ','Источники питания','Источник питания','',1,850,850,0,NULL,NULL),(76,'Источник питания SVP-123','Источники питания','Источник питания','',2,1000,2000,0,NULL,NULL),(77,'Источник питания SVP-125','Источники питания','Источник питания','',2,1200,2400,0,NULL,NULL),(78,'Источник питания SR-12/5A','Источники питания','Источник питания','',2,0,0,0,NULL,NULL),(79,'Источник питания TS-08-Slim','Источники питания','Источник питания','',1,1300,1300,0,NULL,NULL),(80,'Источник питания БП-3А-У','Источники питания','Источник питания','',1,3411,3411,0,NULL,NULL),(81,'Аудиодомофон DP-203HA','Домофоны','Аудиодомофон','',1,3900,3900,0,NULL,NULL),(82,'Аудиодомофон TS-203 Kit','Домофоны','Аудиодомофон','',1,5500,5500,0,NULL,NULL),(83,'Аудиотрубка Vizit УКП-7','Домофоны','Аудиотрубка','',3,836,2508,0,NULL,NULL),(84,'Аудиотрубка Метаком ТКП-12М','Домофоны','Аудиотрубка','',4,908,3632,0,NULL,NULL),(85,'Блок сопряжения MC-VZ','Домофоны','Блоки','',2,945,1890,0,NULL,NULL),(86,'Видеодомофон SM-07MN','Домофоны','Видеодомофон','',2,13500,27000,0,NULL,NULL),(87,'Видеодомофон SQ-04','Домофоны','Видеодомофон','',2,7110,14220,0,NULL,NULL),(88,'Вызывная панель AVC-105','Домофоны','Вызывная панель','',1,1700,1700,0,NULL,NULL),(89,'Вызывная панель Kocom','Домофоны','Вызывная панель','',1,500,500,0,NULL,NULL),(90,'Вызывная панель Tantos ipannel 2','Домофоны','Вызывная панель','',1,9087,9087,0,NULL,NULL),(91,'Вызывная панель Tantos WALLE+','Домофоны','Вызывная панель','',1,5300,5300,0,NULL,NULL),(92,'Вызывная панель МВК-327','Домофоны','Вызывная панель','',4,3700,14800,0,NULL,NULL),(93,'Вызывная панель МВК-327ц Эпика','Домофоны','Вызывная панель','',1,2500,2500,0,NULL,NULL),(94,'Аудиотрубка TS-203HA','Домофоны','Аудиотрубка','',1,2700,2700,0,NULL,NULL),(95,'Видеомонитор Tantos Amelie','Домофоны','Видеомонитор','',1,12400,12400,12400,NULL,NULL),(96,'Видеомонитор Tantos Amelie SD','Домофоны','Видеомонитор','',1,16400,16400,0,NULL,NULL),(97,'Видеомонитор Tantos Lea','Домофоны','Видеомонитор','',1,5760,5760,0,NULL,NULL),(98,'Видеомонитор Tantos Lilu','Домофоны','Видеомонитор','',1,9700,9700,0,NULL,NULL),(99,'Видеомонитор Tantos lilu lim.edit','Домофоны','Видеомонитор','',2,9750,19500,0,NULL,NULL),(100,'Видеомонитор Tantos Lilu lux','Домофоны','Видеомонитор','',1,9750,9750,0,NULL,NULL),(101,'Видеомонитор Tantos LOKI','Домофоны','Видеомонитор','',1,15775,15775,0,NULL,NULL),(102,'Видеомонитор Tantos MIA','Домофоны','Видеомонитор','',1,12400,12400,0,NULL,NULL),(103,'Переговорное устройство VTA 2F','Домофоны','Переговорное устройство','',1,3375,3375,0,NULL,NULL),(104,'Аудиотрубка COMMAX INTERCOM HF-8CM','Домофоны','Аудиотрубка','',1,8700,8700,0,NULL,NULL),(121,'123','123','123','123',123,123,123,123,NULL,NULL),(122,'321','123','1231','321',323,213,321,123,'2022-04-27',NULL),(123,'123123','13123','123123','123123',123213,NULL,123123,123123,'2022-04-27',NULL);
/*!40000 ALTER TABLE `warehouse_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'warehouse_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-27 13:03:29