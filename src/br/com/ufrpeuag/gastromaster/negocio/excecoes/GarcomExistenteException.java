package br.com.ufrpeuag.gastromaster.negocio.excecoes;

public class GarcomExistenteException extends Exception{
	
	public GarcomExistenteException() {
		super("Gar�om j� pertence ao sistema.");
	}
}
