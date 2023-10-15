package naEsquinaDeCasa;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Formulario extends JFrame implements ActionListener {
	DataManager dataManager;
	private Container container;
	private JLabel nome;
	private JTextField tNome;
	private JLabel dataNascimento;
	private JTextField tDataNascimento;
	private JLabel contatoTel;
	private JTextField tContatoTel;
	private JLabel email;
	private JTextField tEmail;
	private JLabel endereco;
	private JTextField tEndereco;
	private JLabel cpf;
	private JTextField tCpf;
	private JButton cadastrar;
	private JButton cancelar;

	public Formulario(DataManager dataManager) {
		this.dataManager = dataManager;

		initialize();
	}

	private void initialize() {
		setTitle("Cadastro de Cliente");
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		container = getContentPane();
		container.setLayout(null);

		nome = new JLabel("Nome");
		nome.setFont(new Font("Arial", Font.PLAIN, 20));
		nome.setSize(100, 20);
		nome.setLocation(31, 36);
		container.add(nome);

		tNome = new JTextField();
		tNome.setFont(new Font("Arial", Font.PLAIN, 20));
		tNome.setSize(190, 20);
		tNome.setLocation(245, 36);
		container.add(tNome);

		dataNascimento = new JLabel("Data de Nascimento");
		dataNascimento.setFont(new Font("Arial", Font.PLAIN, 20));
		dataNascimento.setSize(200, 20);
		dataNascimento.setLocation(31, 65);
		container.add(dataNascimento);

		tDataNascimento = new JTextField();
		tDataNascimento.setFont(new Font("Arial", Font.PLAIN, 20));
		tDataNascimento.setSize(190, 20);
		tDataNascimento.setLocation(245, 65);
		container.add(tDataNascimento);

		contatoTel = new JLabel("Contato tel.");
		contatoTel.setFont(new Font("Arial", Font.PLAIN, 20));
		contatoTel.setSize(175, 20);
		contatoTel.setLocation(31, 96);
		container.add(contatoTel);

		tContatoTel = new JTextField();
		tContatoTel.setFont(new Font("Arial", Font.PLAIN, 20));
		tContatoTel.setSize(190, 20);
		tContatoTel.setLocation(245, 96);
		container.add(tContatoTel);

		email = new JLabel("E-mail");
		email.setFont(new Font("Arial", Font.PLAIN, 20));
		email.setSize(100, 20);
		email.setLocation(31, 127);
		container.add(email);

		tEmail = new JTextField();
		tEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		tEmail.setSize(190, 20);
		tEmail.setLocation(245, 127);
		container.add(tEmail);

		endereco = new JLabel("Endereço");
		endereco.setFont(new Font("Arial", Font.PLAIN, 20));
		endereco.setBounds(31, 158, 100, 20);
		getContentPane().add(endereco);

		tEndereco = new JTextField();
		tEndereco.setFont(new Font("Arial", Font.PLAIN, 20));
		tEndereco.setBounds(245, 158, 190, 20);
		getContentPane().add(tEndereco);

		cpf = new JLabel("CPF");
		cpf.setFont(new Font("Arial", Font.PLAIN, 20));
		cpf.setBounds(31, 189, 100, 20);
		getContentPane().add(cpf);

		tCpf = new JTextField();
		tCpf.setFont(new Font("Arial", Font.PLAIN, 20));
		tCpf.setBounds(245, 189, 190, 20);
		getContentPane().add(tCpf);

		cadastrar = new JButton("Salvar");
		cadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		cadastrar.setSize(100, 20);
		cadastrar.setLocation(150, 450);
		cadastrar.addActionListener(this);
		getContentPane().add(cadastrar);

		cancelar = new JButton("Resetar");
		cancelar.setFont(new Font("Arial", Font.PLAIN, 15));
		cancelar.setSize(100, 20);
		cancelar.setLocation(270, 450);
		cancelar.addActionListener(this);
		getContentPane().add(cancelar);

		setVisible(true);
	}

	private void resetar() {
		tNome.setText("");
		tDataNascimento.setText("");
		tContatoTel.setText("");
		tEndereco.setText("");
		tEmail.setText("");
		tCpf.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrar) {
			if (tNome.getText() != null && tDataNascimento.getText() != null && tContatoTel.getText() != null
					&& tEmail.getText() != null && tEndereco.getText() != null && tCpf.getText() != null) {
				Cliente cliente = new Cliente(tNome.getText(), tDataNascimento.getText(), tContatoTel.getText(),
						tEmail.getText(), tEndereco.getText(), tCpf.getText());
				dataManager.addCliente(cliente);

				resetar();
			}

		} else if (e.getSource() == cancelar) {
			resetar();
		}

	}
}
