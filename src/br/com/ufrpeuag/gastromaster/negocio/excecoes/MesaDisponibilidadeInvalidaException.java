package br.com.ufrpeuag.gastromaster.negocio.excecoes;

public class MesaDisponibilidadeInvalidaException extends Exception{
	
	public MesaDisponibilidadeInvalidaException() {
		super("Disponibilidade inv�lida para a mesa.");
	}
}
