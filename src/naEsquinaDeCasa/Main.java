package naEsquinaDeCasa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		ArvoreAVL arvore = new ArvoreAVL();

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
			arvore.inserir(cliente);
			listaClientes.add(cliente);

			System.out
					.println("Deseja cadastrar outro cliente? (S para cadastrar, P para pesquisar, ou N para sair): ");
			String resposta = scanner.nextLine();

			if (resposta.equalsIgnoreCase("n")) {
				continuar = false;
			} else if (resposta.equalsIgnoreCase("p")) {
				realizarPesquisa(listaClientes, scanner, arvore);

				System.out.println("Deseja continuar cadastrando ou cancelar? (S para continuar, N para cancelar): ");
				String respostaPesquisa = scanner.nextLine();
				if (respostaPesquisa.equalsIgnoreCase("n")) {
					continuar = false;
				}
			}
		}

		scanner.close();

		List<Cliente> clientesOrdenados = ordenarRegistrosPorNome(listaClientes);

		for (Cliente cliente : clientesOrdenados) {
			System.out.println(cliente.getNomeCompleto());
		}
	}

	public static void entrada() {

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

	public static Cliente buscarPorCpfAVL(No raiz, String cpf) {
		if (raiz == null) {
			return null;
		}

		if (raiz.cliente.getCpf().startsWith(cpf)) {
			return raiz.cliente;
		} else if (cpf.compareTo(raiz.cliente.getCpf()) < 0) {
			return buscarPorCpfAVL(raiz.esquerda, cpf);
		} else {
			return buscarPorCpfAVL(raiz.direita, cpf);
		}
	}

	public static List<String> gerarListaCPFsEmOrdem(No raiz) {
		List<String> listaCPFs = new ArrayList<>();
		gerarListaCPFsEmOrdemAux(raiz, listaCPFs);
		return listaCPFs;
	}

	private static void gerarListaCPFsEmOrdemAux(No no, List<String> listaCPFs) {
		if (no != null) {
			gerarListaCPFsEmOrdemAux(no.esquerda, listaCPFs);
			listaCPFs.add(no.cliente.getCpf());
			gerarListaCPFsEmOrdemAux(no.direita, listaCPFs);
		}
	}

	public static List<Cliente> ordenarRegistrosPorNome(List<Cliente> clientes) {
		List<Cliente> listaOrdenada = new ArrayList<>(clientes);

		int n = listaOrdenada.size();

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (listaOrdenada.get(j).getNomeCompleto()
						.compareTo(listaOrdenada.get(minIndex).getNomeCompleto()) < 0) {
					minIndex = j;
				}
			}

			Cliente temp = listaOrdenada.get(minIndex);
			listaOrdenada.set(minIndex, listaOrdenada.get(i));
			listaOrdenada.set(i, temp);
		}

		return listaOrdenada;
	}

	public static void realizarPesquisa(ArrayList<Cliente> listaClientes, Scanner scanner, ArvoreAVL arvore) {
		System.out.println("Escolha a opção de pesquisa: ");
		System.out.println("1. Pesquisar por CPF");
		System.out.println("2. Pesquisar por nome");
		System.out.println("3. Listar CPFs em ordem numérica crescente");
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
		case 3:
			System.out.println("Digite o CPF para pesquisa: ");
			String cpfAvl = scanner.nextLine();
			Cliente clienteEncontradoAvl = buscarPorCpfAVL(arvore.raiz, cpfAvl);

			if (clienteEncontradoAvl != null) {
				System.out.println("Cliente encontrado: " + clienteEncontradoAvl.getNomeCompleto());
				List<String> listaCPFsEmOrdem = gerarListaCPFsEmOrdem(arvore.raiz);
				System.out.println("Número de comparações: " + listaCPFsEmOrdem.size());

				for (String cpfOrdenado : listaCPFsEmOrdem) {
					System.out.println("CPF: " + cpfOrdenado);
				}
			} else {
				System.out.println("Cliente não encontrado.");
			}
			break;
		default:
			System.out.println("Opção inválida.");
		}
	}
}
