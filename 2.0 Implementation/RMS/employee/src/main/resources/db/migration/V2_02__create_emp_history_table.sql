CREATE TABLE IF NOT EXISTS `RMSolution`.`emp_history` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `employer` VARCHAR(45) NULL,
  `job_desc` VARCHAR(45) NULL,
  `active_ind` TINYINT(1) NOT NULL,
  `last_mod_date` DATETIME NULL,
  `last_mod_user` VARCHAR(45) NULL,
  `employee_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_emp_history_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_emp_history_employee1`
  FOREIGN KEY (`employee_id`)
  REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)