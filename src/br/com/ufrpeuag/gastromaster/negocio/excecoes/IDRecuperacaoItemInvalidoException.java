package br.com.ufrpeuag.gastromaster.negocio.excecoes;

public class IDRecuperacaoItemInvalidoException extends Exception{
	
	public IDRecuperacaoItemInvalidoException() {
		super("Imposs�vel recuperar o produto.");
	}
}
