package naEsquinaDeCasa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DataManager dataManager = new DataManager();

		Dados dados = new Dados(dataManager);
		// Formulario form = new Formulario(dataManager);
		
		/*
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

			System.out.println("Deseja cadastrar outro cliente? (S/n): ");
			String resposta = scanner.nextLine();

			if (resposta.equalsIgnoreCase("n")) {
				continuar = false;
			}
		}
		
		

		scanner.close();
		*/
		
		
		
	}

	public static Cliente buscarPorCpf(ArrayList<Cliente> listaClientes, String cpf) {
		for (Cliente cliente : listaClientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}

		return null;
	}

	public static ArrayList<Cliente> buscarPorNome(ArrayList<Cliente> listaClientes, String nome) {
		ArrayList<Cliente> clientesEncontrados = new ArrayList<>();
		for (Cliente cliente : listaClientes) {
			if (cliente.getNomeCompleto().equalsIgnoreCase(nome)) {
				clientesEncontrados.add(cliente);
			}
		}
		return clientesEncontrados;
	}
}
