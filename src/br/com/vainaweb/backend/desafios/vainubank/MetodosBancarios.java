package br.com.vainaweb.backend.desafios.vainubank;

import java.util.List;

public interface MetodosBancarios {

	public void saque(double valor);
	
	public void deposito(double valor);
	
	public void transferencia(double valor, String numConta, List<Conta> listaDeContas);
}
