package br.com.ufrpeuag.gastromaster.negocio.modelo.classes;

public class Funcionario {

	private int id_func;
	private String nome;
	private String cpf;
	private Endereco endereco;
	private String dataNasc;
	private String telefone;
	private String email;
	private double salario;

	public Funcionario(String nome, String cpf, Endereco endereco, String dataNasc, String telefone,
			String email, double salario) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.email = email;
		this.salario = salario;
	}

	public int getId_func() {
		return id_func;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}