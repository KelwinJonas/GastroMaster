package br.com.ufrpeuag.gastromaster.negocio.excecoes;

public class PratoExistenteException extends Exception{
	
	public PratoExistenteException() {
		super ("Prato j� pertence ao sistema.");
	}
}
