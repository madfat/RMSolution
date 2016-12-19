CREATE TABLE IF NOT EXISTS `RMSolution`.`location` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `branch_office` VARCHAR(45) NULL,
  `relocation_startdate` DATE NULL,
  `relocation_enddate` DATE NULL,
  `employee_id` BIGINT NOT NULL,
  `last_mod_date` DATETIME NULL,
  `last_mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_location_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_location_employee1`
  FOREIGN KEY (`employee_id`)
  REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)