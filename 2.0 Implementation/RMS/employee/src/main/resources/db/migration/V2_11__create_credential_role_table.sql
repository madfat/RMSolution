CREATE TABLE IF NOT EXISTS `RMSolution`.`credential_role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `credential_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
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
    ON UPDATE NO ACTION
)