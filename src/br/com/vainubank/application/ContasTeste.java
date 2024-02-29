package br.com.vainubank.application;

import br.com.vainubank.view.Menus;

public class ContasTeste {
	
	public static void main(String[] args) {
		
		Menus.adicionaContasPadraoDoSistema();
		
		int continuar = 0;
		while(continuar != 1) {
			int opcao = Menus.menuInicial();
			switch(opcao) {
			case 1:
				Menus.menuDeCriarConta();
				break;
			case 2:
				Menus.menuDeConsultarConta();
				break;
			case 3:
				Menus.menuDeSaque();
				break;
			case 4:
				Menus.menuDeTransferencia();
				break;
			case 5:
				Menus.menuDeDeposito();
				break;
			case 6:
				Menus.menuDeDeletarConta();
				break;
			case 7: 
				continuar = 1;
				break;
			default:
				System.out.println("Esse código não faz referência a nenhuma ação, reveja o menu e faça outra escolha.");
			}
		}
		System.out.println("Você acaba de sair do sistema Vai nu Bank! ");
	}
	
	
}
