package br.com.ufrpeuag.gastromaster.negocio.excecoes;

public class GerenteInexistenteException extends Exception{
	
	public GerenteInexistenteException() {
		super("Gerente n�o encontrado.");
	}
}
