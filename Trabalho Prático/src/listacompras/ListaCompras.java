package listacompras;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ListaCompras {
	
	private ArrayList<String> listaDeContatos = new ArrayList<>();
	private Queue <String> filaDePedidos = new LinkedList<>();
	private Stack <Integer> romaneioDeEntrega = new Stack<>();
	private Stack <Integer> inputEntrega = new Stack<>();
	private Scanner scanner = new Scanner (System.in);
	
	
	public void iniciar() {
		String opcao = mostrarMenu();		
		while (!opcao.equals("8")){
			switch (opcao) {
			case "1":
				System.out.println(listaDeContatos);
				opcao = mostrarMenu();
			
				break;
			case "2":
				System.out.println("Digite o nome do contato para adicionar na lista:");
				String nomeContato = scanner.nextLine();
				listaDeContatos.add(nomeContato);
				System.out.println(listaDeContatos);
				opcao = mostrarMenu();
				break;
			case "3":
				System.out.println("Digite o índice do nome para remover da lista:");
				int indice = Integer.valueOf(scanner.nextLine());
				listaDeContatos.remove(indice -1);
				System.out.println(listaDeContatos);
				opcao = mostrarMenu();
				break;
			case "4":
				System.out.println("Insira o nome do próximo cliente:");
				String nomeCliente = scanner.nextLine();
				filaDePedidos.add(nomeCliente);
				System.out.println(filaDePedidos);
				opcao = mostrarMenu();
				break;
			case "5":
				System.out.println(filaDePedidos);
				System.out.println("Cliente atendido:" + filaDePedidos.remove());	
				opcao = mostrarMenu();
				break;
			case "6":
				System.out.println("Digite a distância da próxima entrega. Digite '-1' para finalizar o romaneio de entrega");
				int comando = Integer.parseInt(scanner.nextLine());
				while (comando != -1) {				
					inputEntrega.add(comando);
					System.out.println(inputEntrega);
					System.out.println("Digite a distância da próxima entrega. Digite '-1' para finalizar o romaneio de entrega");
					int comando2 = Integer.parseInt(scanner.nextLine());
					comando = comando2;					
				}
				organizarStack(inputEntrega, romaneioDeEntrega);
				System.out.println(romaneioDeEntrega);
				opcao = mostrarMenu();
				break;
			case "7":
				System.out.println(romaneioDeEntrega);
				System.out.println("Pedido entregue:" + romaneioDeEntrega.pop());
//				romaneioDeEntrega.remove((romaneioDeEntrega.size()-1));
				System.out.println(romaneioDeEntrega);
				opcao = mostrarMenu();
				break;
		
				
				default: 
				System.out.println("Opção inválida.");
				opcao = mostrarMenu();
				
			}
			
			
		}
		scanner.close();
		System.out.println("Obrigado!");
	}
	
	private String mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("Digite o comando desejado: \n");
		sb.append("1 - Consultar Lista de Contatos \n");
		sb.append("2 - Inserir contato na lista de contatos \n");
		sb.append("3 - Remover contato da lista de contatos \n");
		sb.append("4 - Inserir pedido na Fila \n");
		sb.append("5 - Atender próximo cliente da Fila \n");
		sb.append("6 - Organizar as Entregas \n");
		sb.append("7 - Desempilhar Pedido \n");
		sb.append("8 - Sair \n");
		System.out.println(sb.toString());
		
		return scanner.nextLine();
	}
	
	private Stack<Integer> organizarStack(Stack <Integer> input, Stack <Integer> output) {
		while(!input.isEmpty()) {
			if ((output.isEmpty()) || (input.peek() < output.peek())) {
				output.add(input.pop());				
			}
			else {
			input.add(0, output.pop());
			}
		}
		return output;
	}
}
