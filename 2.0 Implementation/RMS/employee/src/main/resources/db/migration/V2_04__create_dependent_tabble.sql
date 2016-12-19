CREATE TABLE IF NOT EXISTS `RMSolution`.`dependent` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `active_ind` TINYINT(1) NOT NULL,
  `last_mod_date` DATETIME NULL,
  `last_mod_user` VARCHAR(45) NULL,
  `employee_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dependent_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_dependent_employee1`
  FOREIGN KEY (`employee_id`)
  REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)