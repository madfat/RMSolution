CREATE TABLE IF NOT EXISTS `RMSolution`.`credential` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `enable` TINYINT(1) NOT NULL,
  `locked` TINYINT(1) NOT NULL,
  `password` VARCHAR(45) NULL,
  `employee_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`, `employee_id`),
  INDEX `fk_credential_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_credential_employee1`
  FOREIGN KEY (`employee_id`)
  REFERENCES `RMSolution`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)