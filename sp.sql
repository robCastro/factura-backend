DELIMITER //

CREATE PROCEDURE `facturas`.`sp_update_product_price`(IN new_price double, IN product_id bigint)
BEGIN
	UPDATE producto set precio = new_price where id = product_id;
END;

DELIMITER ;