package br.com.sistemaswebbrasil.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.sistemaswebbrasil.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

}
