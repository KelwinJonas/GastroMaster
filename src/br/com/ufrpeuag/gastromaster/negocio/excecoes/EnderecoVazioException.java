package br.com.ufrpeuag.gastromaster.negocio.excecoes;

public class EnderecoVazioException extends Exception{
	
	public EnderecoVazioException() {
		super("O formul�rio de endere�o deve ser preenchido primeiro.");
	}
}
