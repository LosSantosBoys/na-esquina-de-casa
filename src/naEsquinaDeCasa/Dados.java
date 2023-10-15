package naEsquinaDeCasa;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Dados extends JFrame implements ClienteAdicionadoListener {
	JTable tabela;
	JScrollPane barraRolagem;
	DataManager dataManager;
	JTextField pesquisarCliente;

	public Dados(DataManager dataManager) {
		this.dataManager = dataManager;
		dataManager.addClienteAdicionadoListener(this);

		initialize();
	}

	private void initialize() {
		setTitle("Dados de Cliente");
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nome Completo");
		modelo.addColumn("Data de Nascimento");
		modelo.addColumn("Contato Telefônico");
		modelo.addColumn("E-mail");
		modelo.addColumn("Endereço");
		modelo.addColumn("CPF");

		tabela = new JTable(modelo);

		for (Cliente cliente : dataManager.getListaClientes()) {
			modelo.addRow(new Object[] { cliente.getNomeCompleto(), cliente.getDataNascimento(),
					cliente.getContatoTelefonico(), cliente.getEmail(), cliente.getEndereco(), cliente.getCpf(), });
		}

		barraRolagem = new JScrollPane(tabela);
		JButton novoCliente = new JButton("Novo Cliente");
		pesquisarCliente = new JTextField(20);
		JButton pesquisar = new JButton("Pesquisar");

		novoCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Formulario form = new Formulario(dataManager);
				form.setVisible(true);
			}
		});

		add(novoCliente);

		JPanel painelPesquisa = new JPanel();
		painelPesquisa.add(pesquisarCliente);
		painelPesquisa.add(pesquisar);

		pesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});

		add(painelPesquisa);
		add(barraRolagem);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setVisible(true);
	}

	@Override
	public void clienteAdicionado(ClienteAdicionadoEvent event) {
		atualizarTabela();
	}

	private void atualizarTabela() {
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.setRowCount(0); // Clear existing rows in the table

		ArrayList<Cliente> listaClientes = dataManager.getListaClientes();
		System.out.println(listaClientes.size());

		for (Cliente cliente : listaClientes) {
			System.out.println(cliente.getNomeCompleto());

			model.addRow(new Object[] { cliente.getNomeCompleto(), cliente.getDataNascimento(),
					cliente.getContatoTelefonico(), cliente.getEmail(), cliente.getEndereco(), cliente.getCpf() });
		}
	}

	private void pesquisar() {
		String searchText = pesquisarCliente.getText();
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.setRowCount(0);

		for (Cliente cliente : dataManager.getListaClientes()) {
			if (cliente.getNomeCompleto().toLowerCase().contains(searchText.toLowerCase())) {
				model.addRow(new Object[] { cliente.getNomeCompleto(), cliente.getDataNascimento(),
						cliente.getContatoTelefonico(), cliente.getEmail(), cliente.getEndereco(), cliente.getCpf() });
			}
		}
	}

}
