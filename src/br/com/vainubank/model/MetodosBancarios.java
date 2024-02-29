package br.com.vainubank.model;

import java.util.List;

import br.com.vainubank.controller.Conta;

public interface MetodosBancarios {

	public void saque(double valor);
	
	public void deposito(double valor);
	
	public void transferencia(double valor, String numConta, List<Conta> listaDeContas);
}
