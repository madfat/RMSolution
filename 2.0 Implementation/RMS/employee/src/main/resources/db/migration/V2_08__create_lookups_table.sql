CREATE TABLE IF NOT EXISTS `RMSolution`.`lookups` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data_type` VARCHAR(45) NULL,
  `data_code` VARCHAR(45) NULL,
  `data_desc` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_lookups_lookup_master1_idx` (`data_type` ASC),
  CONSTRAINT `fk_lookups_lookup_master1`
  FOREIGN KEY (`data_type`)
  REFERENCES `RMSolution`.`lookup_master` (`type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)