DELIMITER $$
CREATE PROCEDURE reembolsarPedido(IN idPedido bigint(20), OUT reembolsado BOOL)
proc_reembolso:
BEGIN
	DECLARE dataAtual DATE DEFAULT CURDATE();
    DECLARE dataPagamento DATE;
    DECLARE diasDif INT DEFAULT 0;
    DECLARE statusOrder BIGINT;
    
	SELECT datediff(release_date, dataAtual) INTO diasDif FROM tborder WHERE id = idPedido;
    
    IF diasDif > 10 THEN 
		SET reembolsado = FALSE;
        LEAVE proc_reembolso;
    ELSE 
		SET reembolsado = TRUE;
    END IF;
    
    SELECT order_status INTO statusOrder FROM tborder WHERE id = idPedido;
    
    IF reembolsado THEN
		IF statusOrder != 1 THEN
			SET reembolsado = FALSE;
	    ELSE
			UPDATE payment SET status = 3;
            UPDATE tborder SET order_status = 4;
        END IF;
    END IF;
END $$
DELIMITER ;