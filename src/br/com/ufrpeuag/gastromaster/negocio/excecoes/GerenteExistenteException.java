package br.com.ufrpeuag.gastromaster.negocio.excecoes;

public class GerenteExistenteException extends Exception{
	
	public GerenteExistenteException() {
		super("Gerente j� pertence ao sistema.");
	}
}
