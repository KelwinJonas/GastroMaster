package br.com.ufrpeuag.gastromaster.negocio.excecoes;

public class IDInexistenteException extends Exception{
	
	public IDInexistenteException(){
		super("�ltimo ID n�o existe.");
	}

}
