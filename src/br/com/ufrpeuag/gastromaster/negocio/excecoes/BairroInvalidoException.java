package br.com.ufrpeuag.gastromaster.negocio.excecoes;

public class BairroInvalidoException extends Exception{
	public BairroInvalidoException() {
		super("Bairro n�o poder ser vazio.");
	}
}
