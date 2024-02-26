package br.com.vainaweb.backend.desafios.vainubank;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ContasTeste {
	
	static List<Conta> contas = new ArrayList<Conta>();
	static List<ContaPoupanca> contasPoupanca = new ArrayList<ContaPoupanca>();
	static List<ContaCorrente> contasCorrente = new ArrayList<ContaCorrente>();
	
	public static void main(String[] args) {
		contas.add(new ContaPoupanca("Vanessa", "000-000-01", "00021", "vai nu bank", 10000.04, new Data(24, 11, 2014)));
		contas.add(new ContaPoupanca("Samuel", "000-000-02", "00022", "vai nu bank", 500000.00, new Data(31, 4, 1999)));
		contas.add(new ContaPoupanca("João", "000-000-03", "00023", "vai nu bank", 893000.00, new Data(4, 8, 2000)));
		contas.add(new ContaPoupanca("Deise", "000-000-04", "00024", "vai nu bank", 30000.00, new Data(8, 2, 2011)));
		contas.add(new ContaPoupanca("Maria", "000-000-05", "00025", "vai nu bank", 50000.00, new Data(17, 5, 2022)));
		contas.add(new ContaCorrente("Leo", "000-000-06", "00031", "vai nu bank", 1000.04, 1000.00));
		contas.add(new ContaCorrente("Luiz", "000-000-07", "00032", "vai nu bank", 5000.00, 2000.00));
		contas.add(new ContaCorrente("Marcos", "000-000-08", "00033", "vai nu bank", 8900.00, 100.00));
		contas.add(new ContaCorrente("Marcia", "000-000-09", "00034", "vai nu bank", 3000.00, 2300.00));
		contas.add(new ContaCorrente("Julia", "000-000-10", "00035", "vai nu bank", 5000.00, 493.00));
		
		contasPoupanca.add(new ContaPoupanca("Vanessa", "000-000-01", "00021", "vai nu bank", 10000.04, new Data(24, 11, 2014)));
		contasPoupanca.add(new ContaPoupanca("Samuel", "000-000-02", "00022", "vai nu bank", 500000.00, new Data(31, 4, 1999)));
		contasPoupanca.add(new ContaPoupanca("João", "000-000-03", "00023", "vai nu bank", 893000.00, new Data(4, 8, 2000)));
		contasPoupanca.add(new ContaPoupanca("Deise", "000-000-04", "00024", "vai nu bank", 30000.00, new Data(8, 2, 2011)));
		
		Scanner sc = new Scanner(System.in);
		int continuar = 0;
		while(continuar != 1) {
			int opcao = menuInicial();
			switch(opcao) {
			case 1:
				menuDeCriarConta();
				break;
			case 2:
				menuDeConsultarConta();
				break;
			case 3:
				menuDeSaque();
				break;
			case 4:
				menuDeTransferencia();
				break;
			case 5:
				menuDeDeposito();
				break;
			case 6:
				menuDeDeletarConta();
				break;
			case 7: 
				continuar = 1;
				break;
			default:
				System.out.println("Esse código não faz referência a nenhuma ação, reveja o menu e faça outra escolha.");
			}
			System.out.println("---------------------");
		}
		System.out.println("Você acaba de sair do sistema Vai nu Bank! ");
		
		sc.close();
		
	}
	
	public static int menuInicial() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Vai nu Bank");
		System.out.println("---------------------");
		System.out.println("1 - Criar Conta");
		System.out.println("2 - Consultar Conta");
		System.out.println("3 - Sacar dinheiro");
		System.out.println("4 - Fazer uma transferência");
		System.out.println("5 - Depositar em minha conta");
		System.out.println("6 - Deletar Conta");
		System.out.println("7 - Sair do sistema");
		System.out.println("---------------------");
		System.out.println("Digite o número da respectiva ação que deseja realizar: ");
		int opcao = sc.nextInt();
		System.out.println("---------------------");
		sc.close();
		return opcao;
	}

	public static void menuDeCriarConta() {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Vamos iniciar o seu cadastro em nosso banco!");

		System.out.println("---------------------");
		System.out.println("Precisamos das seguintes informações básicas para qualquer conta:");
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		System.out.println("---------------------");
		System.out.println("CPF: ");
		String cpf = sc.nextLine();
		String numConta = "000-" +  rand.nextInt((100 - 0) + 1) + 0;
		String agencia = "" + rand.nextInt(1000);

		System.out.println("---------------------");
		System.out.println("Que tipo de conta deseja criar?: ");
		System.out.println("1 - conta corrente");
		System.out.println("2 - conta poupança");
		System.out.println("---------------------");
		System.out.println("Digite o que deseja:");
		int opcao = sc.nextInt();
		System.out.println("---------------------");
		
		switch(opcao) {
		case 1:
			ContaCorrente conta1 = new ContaCorrente(nome, cpf, numConta, agencia, 0, rand.nextInt(10000));
			contasCorrente.add(conta1);
			contas.add(conta1);
			System.out.println("Sua conta corrente foi criada com sucesso! Seu saldo no momento é zerado, se desejar, faça um depósito.");
			System.out.println("---------------------");
			break;
		case 2:
			System.out.println("Precisamos da data atual!");
			System.out.println("Digite o dia: ");
			int dia = sc.nextInt();
			System.out.println("Digite o mês (em número): ");
			int mes = sc.nextInt();
			System.out.println("Digite o ano: ");
			int ano = sc.nextInt();
			Data data = new Data(dia, mes, ano);
			ContaPoupanca conta2 = new ContaPoupanca(nome, cpf, numConta, agencia, 0, data);
			contasPoupanca.add(conta2);
			contas.add(conta2);
			System.out.println("Sua conta poupança foi criada com sucesso! Seu saldo no momento é zerado, se desejar, faça um depósito.");
			System.out.println("---------------------");
			break;
		}	
		sc.close();
	}

	public static void menuDeConsultarConta() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Aqui estão os números das contas cadastradas em nosso sistema: ");
		for(Conta conta : contas) {
			System.out.println(conta.getNumConta());
		}
		System.out.println("---------------------");
		System.out.println("Digite o número da conta que você deseja consultar(exatamente como ele está na lista): ");
		String numeroBuscado = sc.nextLine();
		
		for(Conta elemento : contas) {
			if(elemento.getNumConta().equals(numeroBuscado)) {
				System.out.println("Aqui estão as informações buscadas: ");
				System.out.println(elemento.toString());
			} 
		}
		sc.close();
	}
	
	public static void menuDeSaque() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sua conta é uma conta poupança ou corrente? (Para poupança, digite 1. Para corrente, digite 2.) ");
		int tipoDeConta = sc.nextInt();
		String contaParaSaque;
		double valorSaque;
		switch(tipoDeConta){
		case 1:
			System.out.println("Aqui estão os números das contas poupanças cadastradas em nosso sistema: ");
			for(ContaPoupanca conta : contasPoupanca) {
				System.out.println(conta.getNumConta());
			}
			System.out.println("---------------------");
			System.out.println("Digite o número da conta da qual deseja sacar (exatamente como ele está na lista): ");
			contaParaSaque = sc.nextLine();
			
			System.out.println("Qual valor deseja sacar? ");
			valorSaque = sc.nextDouble();
			for(ContaPoupanca conta : contasPoupanca) {
				if(conta.getNumConta().equals(contaParaSaque)) {
					conta.saque(valorSaque);
				} 
			}
			break;
		case 2:
			System.out.println("Aqui estão os números das contas correntes cadastradas em nosso sistema: ");
			for(ContaCorrente conta : contasCorrente) {
				System.out.println(conta.getNumConta());
			}
			System.out.println("---------------------");
			System.out.println("Digite o número da conta da qual deseja sacar (exatamente como ele está na lista): ");
			contaParaSaque = sc.nextLine();
			System.out.println("Qual valor deseja sacar? ");
			valorSaque = sc.nextDouble();
			for(ContaCorrente conta : contasCorrente) {
				if(conta.getNumConta().equals(contaParaSaque)) {
					conta.saque(valorSaque);
				} 
			}
			break;
		default:
			System.err.println("Código fornecido inválido");
		}
		sc.close();
	}
	
	public static void menuDeTransferencia() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sua conta é uma conta poupança ou corrente? (Para poupança, digite 1. Para corrente, digite 2.) ");
		int tipoDeConta = sc.nextInt();
		
		String contaRemetente, contaDestinatario;
		double valorTransferencia;
		
		switch(tipoDeConta) {
		case 1:
			System.out.println("Aqui estão os números das contas poupanças cadastradas em nosso sistema: ");
			for(ContaPoupanca conta : contasPoupanca) {
				System.out.println(conta.getNumConta());
			}
			System.out.println("---------------------");
			System.out.println("Digite o número da conta da qual deseja transferir o dinheiro (exatamente como ele está na lista): ");
			contaRemetente = sc.nextLine();
			System.out.println("---------------------");
			System.out.println("Você pode fazer essa transferência para as seguintes contas:");
			for(Conta conta : contas) {
				if(!conta.getNumConta().equals(contaRemetente)) {
					System.out.println(conta.getNumConta());
				}
			}
			System.out.println("Digite o número da conta que deve receber a transferência (exatamente como ele está na lista): ");
			contaDestinatario = sc.nextLine();
			System.out.println("---------------------");
			System.out.println("Digite o valor que deseja transferir de " + contaRemetente + " para " + contaDestinatario);
			valorTransferencia = sc.nextDouble();
			
			for(ContaPoupanca conta : contasPoupanca) {
				if(conta.getNumConta().equals(contaRemetente)) {
					conta.transferencia(valorTransferencia, contaDestinatario, contas);
				} 
			}
			break;
		case 2: 
			System.out.println("Aqui estão os números das contas correntes cadastradas em nosso sistema: ");
			for(ContaCorrente conta : contasCorrente) {
				System.out.println(conta.getNumConta());
			}
			System.out.println("---------------------");
			System.out.println("Digite o número da conta da qual deseja transferir o dinheiro (exatamente como ele está na lista): ");
			contaRemetente = sc.nextLine();
			System.out.println("---------------------");
			System.out.println("Você pode fazer essa transferência para as seguintes contas:");
			for(Conta conta : contas) {
				if(!conta.getNumConta().equals(contaRemetente)) {
					System.out.println(conta.getNumConta());
				}
			}
			System.out.println("Digite o número da conta que deve receber a transferência (exatamente como ele está na lista): ");
			contaDestinatario = sc.nextLine();
			System.out.println("---------------------");
			System.out.println("Digite o valor que deseja transferir de " + contaRemetente + " para " + contaDestinatario);
			valorTransferencia = sc.nextDouble();
			
			for(ContaCorrente conta : contasCorrente) {
				if(conta.getNumConta().equals(contaRemetente)) {
					conta.transferencia(valorTransferencia, contaDestinatario, contas);
				} 
			}
			
			break;
		default:
			System.err.println("Código fornecido inválido");
		}
		sc.close();
	}
	
	public static void menuDeDeposito() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sua conta é uma conta poupança ou corrente? (Para poupança, digite 1. Para corrente, digite 2.) ");
		int tipoDeConta = sc.nextInt();
		String contaParaDeposito;
		double valorDeposito;
		
		switch(tipoDeConta){
		case 1:
			System.out.println("Aqui estão os números das contas poupanças cadastradas em nosso sistema: ");
			for(ContaPoupanca conta : contasPoupanca) {
				System.out.println(conta.getNumConta());
			}
			System.out.println("---------------------");
			System.out.println("Digite o número da conta em que deseja depositar (exatamente como ele está na lista): ");
			contaParaDeposito = sc.nextLine();
			System.out.println("Qual valor deseja depositar? ");
			valorDeposito = sc.nextDouble();
			for(ContaPoupanca conta : contasPoupanca) {
				if(conta.getNumConta().equals(contaParaDeposito)) {
					conta.deposito(valorDeposito);
				}
			}
			break;
		case 2:
			System.out.println("Aqui estão os números das contas correntes cadastradas em nosso sistema: ");
			for(ContaCorrente conta : contasCorrente) {
				System.out.println(conta.getNumConta());
			}
			System.out.println("---------------------");
			System.out.println("Digite o número da conta em que deseja depositar (exatamente como ele está na lista): ");
			contaParaDeposito = sc.nextLine();
			System.out.println("Qual valor deseja depositar? ");
			valorDeposito = sc.nextDouble();
			for(ContaCorrente conta : contasCorrente) {
				if(conta.getNumConta().equals(contaParaDeposito)) {
					conta.deposito(valorDeposito);
				}
			}
			break;
		default:
			System.err.println("Código fornecido inválido");
		}
		sc.close();
	}
	
	public static void menuDeDeletarConta() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sua conta é uma conta poupança ou corrente? (Para poupança, digite 1. Para corrente, digite 2.) ");
		int tipoDeConta = sc.nextInt();
		
		String numeroDaConta;
		switch(tipoDeConta){
		case 1:
			System.out.println("Aqui estão os números das contas poupanças cadastradas em nosso sistema: ");
			for(ContaPoupanca conta : contasPoupanca) {
				System.out.println(conta.getNumConta());
			}
			System.out.println("---------------------");
			System.out.println("Digite o número da conta em que deseja deletar do sistema (exatamente como ele está na lista): ");
			numeroDaConta = sc.nextLine();
			for(ContaPoupanca conta : contasPoupanca) {
				if(conta.getNumConta().equals(numeroDaConta)) {
					conta.deletarConta();
				} 
			}
			break;
		case 2:
			System.out.println("Aqui estão os números das contas correntes cadastradas em nosso sistema: ");
			for(ContaCorrente conta : contasCorrente) {
				System.out.println(conta.getNumConta());
			}
			System.out.println("---------------------");
			System.out.println("Digite o número da conta em que deseja deletar do sistema (exatamente como ele está na lista): ");
			numeroDaConta = sc.nextLine();
			for(ContaCorrente conta : contasCorrente) {
				if(conta.getNumConta().equals(numeroDaConta)) {
					conta.deletarConta();
				}
			}
			break;
		default:
			System.err.println("Código fornecido inválido");
		}
		sc.close();
	}
}
