ALTER TABLE alertas DROP FOREIGN KEY alertas_ibfk_1;
ALTER TABLE `alertas` DROP `usuario_id`;
ALTER TABLE `alertas` ADD `cultivo_id` BIGINT NOT NULL AFTER `id`;
ALTER TABLE `alertas` ADD INDEX(`cultivo_id`);
ALTER TABLE `alertas` ADD FOREIGN KEY (`cultivo_id`) REFERENCES `cultivo`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `alertas` CHANGE `fecha_creacion` `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE `alertas` CHANGE `fecha_leido` `fecha_leido` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
