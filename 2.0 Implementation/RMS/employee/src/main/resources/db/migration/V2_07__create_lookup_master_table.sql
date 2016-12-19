CREATE TABLE IF NOT EXISTS `RMSolution`.`lookup_master` (
  `type` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`type`),
  UNIQUE INDEX `type_UNIQUE` (`type` ASC)
)