package br.com.ufrpeuag.gastromaster.negocio.validacoes;

import java.sql.SQLException;
import java.util.List;

import br.com.ufrpeuag.gastromaster.dados.RepositorioGerenciamentoContas;
import br.com.ufrpeuag.gastromaster.dados.interfaces.IGerenciamentoContasDao;
import br.com.ufrpeuag.gastromaster.negocio.excecoes.RelatorioVazioException;
import br.com.ufrpeuag.gastromaster.negocio.modelo.classes.GerenciamentoContas;

public class GerenciamentoNegocio {
	
	private IGerenciamentoContasDao repGerenciamento;
	
	public GerenciamentoNegocio() throws SQLException {
		repGerenciamento = new RepositorioGerenciamentoContas();
	}
	
	public void cadastrarGerenciamentoContas(GerenciamentoContas gerenciamento) {
		repGerenciamento.inserir(gerenciamento);
	}
	
	public List<GerenciamentoContas> listarTodosGerenciamentoContas() throws RelatorioVazioException {
		if(repGerenciamento.listarTodos() == null || repGerenciamento.listarTodos().isEmpty()) {
			throw new RelatorioVazioException();
		}
		return repGerenciamento.listarTodos();
	}
}
