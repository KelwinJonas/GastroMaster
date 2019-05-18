package br.com.ufrpeuag.gastromaster.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ufrpeuag.gastromaster.dados.interfaces.ProdutoDao;
import br.com.ufrpeuag.gastromaster.negocio.modelo.classes.Produto;

public class RepositorioProduto implements ProdutoDao {

	@Override
	public void inserir(Produto produto) {
		PreparedStatement pstmt = null;
		try {
			Connection conn = ConfiguracoesBanco.getSingleton().getConnection();
			String inserirSql = "INSERT INTO Produto(nome, quantidade) VALUES(?,?)";
			pstmt = conn.prepareStatement(inserirSql);

			pstmt.setString(1, produto.getNome());
			pstmt.setInt(2, produto.getQuantidade());

			pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {

			try {
				pstmt.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	@Override
	public Produto recuperar(Integer codigo) {
		PreparedStatement pstmt = null;
		ResultSet result = null;

		try {
			Connection conn = ConfiguracoesBanco.getSingleton().getConnection();

			pstmt = conn.prepareStatement("SELECT * from Produto where id_produto = ?");
			pstmt.setInt(1, codigo);

			result = pstmt.executeQuery();

			Produto p = null;

			if (result.next()) {

				p = new Produto();
				p.setId_produto(result.getInt("id_produto"));
				p.setNome(result.getString("nome"));
				p.setQuantidade(result.getInt("quantidade"));
				return p;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {

			try {
				result.close();
				pstmt.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}
		return null;
	}

	@Override
	public void alterar(Produto produto) {
		String alterarSql = "UPDATE Produto SET " + "nome = ? , " + "quantidade = ?" + " WHERE id_produto = ?";
		PreparedStatement pstmt = null;
		try {
			Connection conn = ConfiguracoesBanco.getSingleton().getConnection();

			pstmt = conn.prepareStatement(alterarSql);

			pstmt.setString(1, produto.getNome());
			pstmt.setInt(2, produto.getQuantidade());
			pstmt.setInt(3, produto.getId_produto());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				pstmt.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}
	}

	@Override
	public void deletar(Produto produto) {
		String deletarSql = "DELETE FROM Produto WHERE id_produto = ?";
		PreparedStatement pstmt = null;
		try {
			Connection conn = ConfiguracoesBanco.getSingleton().getConnection();

			pstmt = conn.prepareStatement(deletarSql);

			pstmt.setInt(1, produto.getId_produto());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				pstmt.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}
	}

	@Override
	public List<Produto> listarTodos() {
		List<Produto> lista = new ArrayList<>();
		String listarTodosSql = "Select * FROM Produto";
		ResultSet result = null;
		Statement stmt = null;
		try {
			Connection conn = ConfiguracoesBanco.getSingleton().getConnection();
			stmt = conn.createStatement();
			result = stmt.executeQuery(listarTodosSql);
			Produto p = null;

			while (result.next()) {

				p = new Produto();

				p.setId_produto(result.getInt("id_produto"));
				p.setNome(result.getString("nome"));
				p.setQuantidade(result.getInt("quantidade"));
				lista.add(p);

			}
			return lista;

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {

			try {
				result.close();
				stmt.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

		return null;
	}

	@Override
	public void removerQuantProduto(Produto produto,Integer quantidade) {
		String alterarSql = "UPDATE Produto SET quantidade = ? WHERE id_produto = ?";
		PreparedStatement pstmt = null;
		try {
			Connection conn = ConfiguracoesBanco.getSingleton().getConnection();

			pstmt = conn.prepareStatement(alterarSql);

		
			pstmt.setInt(1, produto.getQuantidade() - quantidade);
			pstmt.setInt(2, produto.getId_produto());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				pstmt.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}
	


	}

	@Override
	public int retonarQuantidadeProduto(Produto produto) {
		
		int quant=0;
		String sql = "SELECT quantidade FROM Produto WHERE id_produto= ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;

		try {
			Connection conn = ConfiguracoesBanco.getSingleton().getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, produto.getId_produto());

			result = pstmt.executeQuery();
			
			if (result != null) {
				if (result.next()) {
					quant = result.getInt("quantidade");
					return quant;
				}
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {

			try {
				result.close();
				pstmt.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}
		return 0;

	}
}
