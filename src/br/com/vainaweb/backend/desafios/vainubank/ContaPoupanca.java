package br.com.vainaweb.backend.desafios.vainubank;

import java.util.List;
import java.util.Scanner;

public class ContaPoupanca extends Conta implements MetodosBancarios {

	private Data aniversario;
	
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(String nome, String cpf, String numConta, String agencia, double saldo, Data aniversario) {
		super(nome, cpf, numConta, agencia, saldo);
		this.aniversario = aniversario;
	}
	
	public Data getAniversario() {
		return aniversario;
	}
	public void setAniversario(Data aniversario) {
		this.aniversario = aniversario;
	}
	
	
	public void verificaAniversario(Data hoje) {
		if(hoje == aniversario) {
			setSaldo(getSaldo() + (getSaldo() * 5/100));
			System.out.println("Parabéns! Hoje é aniversário de sua conta. Você acaba de ganhar um juros de 5%");
		} else {
			System.out.println("Hoje não é o aniversário de sua conta. Volte outro dia para conferir seus juros.");
		}
	}
	
	@Override
	public void saque(double valor) {
		if(getSaldo() >= valor) {
			double novoSaldo = getSaldo() - valor + (2/100*valor);
			setSaldo(novoSaldo);
			System.out.println("Seu novo saldo é " + getSaldo());
		} else {
			System.out.println("Você não tem saldo o suficiente na conta para sacar esse valor.");
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
		return "ContaPoupanca [nome = " + getNome() + ", cpf = " + getCpf() + ", numConta = " + getNumConta() + ", agencia = " + getAgencia() + ", aniversario = " + aniversario.getDataCompleta() + "]";
	}
	
	@Override
	public void deletarConta() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Tem certeza que deseja deletar do sistema a conta de número " + this.getNumConta() + "? Digite 1 para sim e 2 para não.");
		int decisao = sc.nextInt();
		
		switch(decisao) {
		case 1:
			this.aniversario = null;
			this.setAgencia(null);
			this.setCpf(null);
			this.setNome(null);
			this.setNumConta(null);
			this.setSaldo(0);
			System.out.println("Sua conta acaba de ser deletada com sucesso!");
			break;
		case 2:
			System.out.println("Ação cancelada!");
			break;
		default:
			System.err.println("Código inválido!");
		}
		
		sc.close();
	}
}
