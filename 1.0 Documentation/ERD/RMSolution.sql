-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema RMSolution
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema RMSolution
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `RMSolution` DEFAULT CHARACTER SET utf8 ;
USE `RMSolution` ;

-- -----------------------------------------------------
-- Table `RMSolution`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RMSolution`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `dob` DATE NULL,
  `gender` VARCHAR(45) NULL,
  `marital_status` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `hire_date` DATE NULL,
  `employment_status` VARCHAR(45) NULL,
  `nationality` VARCHAR(45) NULL,
  `business_unit` VARCHAR(45) NULL,
  `division` VARCHAR(45) NULL,
  `job_family` VARCHAR(45) NULL,
  `stream` VARCHAR(45) NULL,
  `job_title` VARCHAR(45) NULL,
  `reporting_manager` INT NULL,
  `retire_date` DATE NULL,
  `suspend_date` DATE NULL,
  `active_ind` TINYINT(1) NULL,
  `last_degree` VARCHAR(45) NULL,
  `recruit_from` VARCHAR(255) NULL,
  `contract_expiry_date` DATE NULL,
  `last_mod_date` DATETIME NULL,
  `last_mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RMSolution`.`emp_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RMSolution`.`emp_history` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `employer` VARCHAR(45) NULL,
  `job_desc` VARCHAR(45) NULL,
  `active_ind` TINYINT(1) NULL,
  `last_mod_date` DATETIME NULL,
  `last_mod_user` VARCHAR(45) NULL,
  `employee_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_emp_history_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_emp_history_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RMSolution`.`grade_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RMSolution`.`grade_history` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `grade` VARCHAR(45) NULL,
  `dev_stage` INT NULL,
  `last_mod_date` DATETIME NULL,
  `last_mod_user` VARCHAR(45) NULL,
  `employee_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_grade_history_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_grade_history_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RMSolution`.`dependent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RMSolution`.`dependent` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `active_ind` TINYINT(1) NULL,
  `last_mod_date` DATETIME NULL,
  `last_mod_user` VARCHAR(45) NULL,
  `employee_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dependent_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_dependent_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RMSolution`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RMSolution`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) NULL,
  `active_ind` TINYINT(1) NULL,
  `last_mod_date` DATETIME NULL,
  `last_mod_user` VARCHAR(45) NULL,
  `employee_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_address_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RMSolution`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RMSolution`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `branch_office` VARCHAR(45) NULL,
  `relocation_startdate` DATE NULL,
  `relocation_enddate` DATE NULL,
  `employee_id` INT NULL,
  `last_mod_date` DATETIME NULL,
  `last_mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_location_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_location_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RMSolution`.`lookup_master`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RMSolution`.`lookup_master` (
  `type` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`type`),
  UNIQUE INDEX `type_UNIQUE` (`type` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RMSolution`.`lookups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RMSolution`.`lookups` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_type` VARCHAR(45) NULL,
  `data_code` VARCHAR(45) NULL,
  `data_desc` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_lookups_lookup_master1_idx` (`data_type` ASC),
  CONSTRAINT `fk_lookups_lookup_master1`
    FOREIGN KEY (`data_type`)
    REFERENCES `RMSolution`.`lookup_master` (`type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RMSolution`.`credential`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RMSolution`.`credential` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `enable` TINYINT(1) NULL,
  `locked` TINYINT(1) NULL,
  `password` VARCHAR(45) NULL,
  `employee_id` INT NOT NULL,
  PRIMARY KEY (`id`, `employee_id`),
  INDEX `fk_credential_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_credential_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RMSolution`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RMSolution`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RMSolution`.`credential_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RMSolution`.`credential_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `credential_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`, `credential_id`, `role_id`),
  INDEX `fk_credential_role_credential1_idx` (`credential_id` ASC),
  INDEX `fk_credential_role_role1_idx` (`role_id` ASC),
  CONSTRAINT `fk_credential_role_credential1`
    FOREIGN KEY (`credential_id`)
    REFERENCES `RMSolution`.`credential` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_credential_role_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `RMSolution`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
