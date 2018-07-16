CREATE DATABASE ppm
 
use ppm

CREATE TABLE `ppm`.`user` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `fullname` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `sex` VARCHAR(45) NOT NULL,
  `dateofbirth` DATE NOT NULL,
  `placeofbirth` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userid`));

CREATE TABLE `ppm`.`role` (
  `roleid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`roleid`));


CREATE TABLE `ppm`.`patient` (
  `patientid` INT NOT NULL AUTO_INCREMENT,
  `fullname` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `sex` VARCHAR(45) NOT NULL,
  `dateofbirth` DATE NOT NULL,
  `placeofbirth` VARCHAR(45) NOT NULL,
  `treatmentid` INT NOT NULL,
  `allergic` VARCHAR(45) NULL,
  PRIMARY KEY (`patientid`));


CREATE TABLE `ppm`.`treatment` (
  `treatmentid` INT NOT NULL AUTO_INCREMENT,
  `historyofdiseases` VARCHAR(45) NOT NULL,
  `prescription` VARCHAR(45) NOT NULL,
  `medicineused` VARCHAR(45) NOT NULL,
  `medicaltestresult` VARCHAR(45) NOT NULL,
  `patientid` INT NOT NULL,
  `doctorid` INT NOT NULL,medicineid
  `medicineid` INT NOT NULL,
  PRIMARY KEY (`treatmentid`));

CREATE TABLE `ppm`.`medicine` (
  `medicineid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`medicineid`));