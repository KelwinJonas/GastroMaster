package br.com.ufrpeuag.gastromaster.negocio.excecoes;

public class RuaInvalidaException extends Exception{
	public RuaInvalidaException() {
		super("Rua n�o pode ser vazia");
	}
}
