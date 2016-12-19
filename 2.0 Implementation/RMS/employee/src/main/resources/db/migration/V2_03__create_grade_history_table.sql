CREATE TABLE IF NOT EXISTS `RMSolution`.`grade_history` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `grade` VARCHAR(45) NULL,
  `dev_stage` INT NOT NULL,
  `last_mod_date` DATETIME NULL,
  `last_mod_user` VARCHAR(45) NULL,
  `employee_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_grade_history_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_grade_history_employee1`
  FOREIGN KEY (`employee_id`)
  REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)