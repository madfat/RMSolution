CREATE TABLE IF NOT EXISTS `RMSolution`.`address` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) NULL,
  `active_ind` TINYINT(1) NOT NULL,
  `last_mod_date` DATETIME NULL,
  `last_mod_user` VARCHAR(45) NULL,
  `employee_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_address_employee1`
  FOREIGN KEY (`employee_id`)
  REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)