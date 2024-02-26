package br.com.vainaweb.backend.desafios.vainubank;

public abstract class Conta {
	private String nome;
	private String cpf;
	private String numConta;
	private String agencia;
	private double saldo;
	
	public Conta(){}
	
	public Conta(String nome, String cpf, String numConta, String agencia, double saldo) {
		this.nome = nome;
		this.cpf = cpf;
		this.numConta = numConta;
		this.agencia = agencia;
		this.saldo = saldo;
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
	
	public String getNumConta() {
		return numConta;
	}
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}	
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	public abstract String toString();
	public abstract void deletarConta();
}
