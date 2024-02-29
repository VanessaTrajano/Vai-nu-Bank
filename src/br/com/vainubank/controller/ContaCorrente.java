package br.com.vainubank.controller;

import java.util.List;
import java.util.Scanner;

import br.com.vainubank.model.MetodosBancarios;

public class ContaCorrente extends Conta implements MetodosBancarios{

	static Scanner sc = new Scanner(System.in);
	
	private double limiteDeCredito;
	
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(String nome, String cpf, String numConta, String agencia, double saldo, double limiteDeCredito) {
		super(nome, cpf, numConta, agencia, saldo);
		this.limiteDeCredito = limiteDeCredito;
	}

	
	public double getLimiteDeCredito() {
		return limiteDeCredito;
	}
	public void setLimiteDeCredito(double limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}


	@Override
	public void saque(double valor) {
		if(valor <= getSaldo()) {
			double novoSaldo = getSaldo() - valor;
			setSaldo(novoSaldo);
			System.out.println("Seu novo saldo é de: " + getSaldo());
		} else if(valor > getSaldo() && valor - getSaldo() < getLimiteDeCredito()) {
			double saldoNegativo = getSaldo() - valor;
			setSaldo(saldoNegativo);
			setLimiteDeCredito(getLimiteDeCredito() - (valor - getSaldo()));
			System.out.println("Você usará " + (valor - getSaldo()) + " do seu limite de crédito e ficará com o saldo negativo");
		} else {
			System.out.println("Você não tem saldo ou limite o bastante o bastante!");
		}
		
	}

	@Override
	public void deposito(double valor) {
		setSaldo(getSaldo() + valor);
		System.out.println("Seu novo saldo é " + getSaldo());
	}

	@Override
	public void transferencia(double valor, String numConta, List<Conta> listaDeContas) {
		Conta destinoDaTransferencia = null;
		for(Conta elemento : listaDeContas) {
			if(elemento.getNumConta().equals(numConta)) {
				destinoDaTransferencia = elemento;
			}
		}
		if(valor <= getSaldo()) {
			setSaldo(getSaldo() - valor);
			destinoDaTransferencia.setSaldo(destinoDaTransferencia.getSaldo() + valor);
			System.out.println("Você acabou de transferir " + valor  + " para a conta de número " + numConta + " e seu saldo atual é de " + getSaldo());
		} else {
			System.out.println("Você não tem saldo o bastante para fazer essa transferência");
		}
	}

	@Override
	public String toString() {
		return "ContaCorrente [nome = " + getNome() + ", cpf = " + getCpf() + ", numConta = " + getNumConta() + ", agencia = " + getAgencia() + ", saldo = " + getSaldo() + ", limite de crédito = " + limiteDeCredito + "]";
	}

}
