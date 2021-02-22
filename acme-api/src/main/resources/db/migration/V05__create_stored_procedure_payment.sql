DELIMITER $$
CREATE PROCEDURE pagarPedido(IN idPedido bigint(20), IN numberCard VARCHAR(255))
BEGIN
	DECLARE ultimoId BIGINT(20) UNSIGNED;
	
    INSERT INTO payment (number_card, payment_date, status) VALUES (numberCard, curdate(), 1);
    SELECT LAST_INSERT_ID() INTO ultimoId FROM payment;
    
	UPDATE tborder 
		SET release_date = curdate(), 
			order_status = 1,
            id_payment = ultimoId
		WHERE id = idPedido;
END $$
DELIMITER ;