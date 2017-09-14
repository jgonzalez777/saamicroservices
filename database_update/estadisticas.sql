ALTER TABLE estadistica DROP FOREIGN KEY FK6A338326CCCCDEFF;
ALTER TABLE `estadistica` DROP `estacion_id`;
ALTER TABLE `estadistica` CHANGE `temperatura` `temperatura_ambiente` INT(11) NOT NULL;
ALTER TABLE `estadistica` CHANGE `humedad` `humedad_ambiente` INT(11) NOT NULL;
ALTER TABLE `estadistica` ADD `temperatura_suelo` INT NOT NULL AFTER `temperatura_ambiente`;
ALTER TABLE `estadistica` ADD `humedad_suelo` INT NOT NULL AFTER `humedad_ambiente`;


