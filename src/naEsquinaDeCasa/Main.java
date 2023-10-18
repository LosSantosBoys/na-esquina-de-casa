package naEsquinaDeCasa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		while (continuar) {
			System.out.print("Digite o nome completo do cliente: ");
			String nomeCompleto = scanner.nextLine();

			System.out.print("Digite a data de nascimento do cliente: ");
			String dataNascimento = scanner.nextLine();

			System.out.print("Digite o contato telefônico do cliente: ");
			String contatoTelefonico = scanner.nextLine();

			System.out.print("Digite o e-mail do cliente: ");
			String email = scanner.nextLine();

			System.out.print("Digite o endereço do cliente: ");
			String endereco = scanner.nextLine();

			System.out.print("Digite o CPF do cliente: ");
			String cpf = scanner.nextLine();

			Cliente cliente = new Cliente(nomeCompleto, dataNascimento, contatoTelefonico, email, endereco, cpf);
			listaClientes.add(cliente);

			System.out
					.println("Deseja cadastrar outro cliente? (S para cadastrar, P para pesquisar, ou N para sair): ");
			String resposta = scanner.nextLine();

			if (resposta.equalsIgnoreCase("n")) {
				continuar = false;
			} else if (resposta.equalsIgnoreCase("p")) {
				realizarPesquisa(listaClientes, scanner);
			}
		}

		scanner.close();
	}

	public static Cliente buscarPorCpf(ArrayList<Cliente> listaClientes, String cpf) {
		for (Cliente cliente : listaClientes) {
			if (cliente.getCpf().startsWith(cpf)) {
				return cliente;
			}
		}

		return null;
	}

	public static ArrayList<Cliente> buscarPorNome(ArrayList<Cliente> listaClientes, String nome) {
		ArrayList<Cliente> clientesEncontrados = new ArrayList<>();
		for (Cliente cliente : listaClientes) {
			if (cliente.getNomeCompleto().startsWith(nome.toLowerCase())) {
				clientesEncontrados.add(cliente);
			}
		}
		return clientesEncontrados;
	}

	public static void realizarPesquisa(ArrayList<Cliente> listaClientes, Scanner scanner) {
		System.out.println("Escolha a opção de pesquisa: ");
		System.out.println("1. Pesquisar por CPF");
		System.out.println("2. Pesquisar por nome");
		int opcao = scanner.nextInt();
		scanner.nextLine();

		switch (opcao) {
		case 1:
			System.out.println("Digite o CPF para pesquisa: ");
			String cpf = scanner.nextLine();
			Cliente clienteEncontrado = buscarPorCpf(listaClientes, cpf);
			if (clienteEncontrado != null) {
				System.out.println("Cliente encontrado: " + clienteEncontrado.getNomeCompleto());
			} else {
				System.out.println("Cliente não encontrado.");
			}
			break;
		case 2:
			System.out.print("Digite o nome para pesquisa: ");
			String nome = scanner.nextLine();
			ArrayList<Cliente> clientesEncontrados = buscarPorNome(listaClientes, nome);
			if (!clientesEncontrados.isEmpty()) {
				System.out.println("Clientes encontrados por nome:");
				for (Cliente cliente : clientesEncontrados) {
					System.out.println(cliente.getNomeCompleto());
				}
			} else {
				System.out.println("Nenhum cliente encontrado por nome.");
			}
			break;
		default:
			System.out.println("Opção inválida.");
		}
	}
}
