package naEsquinaDeCasa;

public class Cliente {
	private String nomeCompleto;
	private String dataNascimento;
	private String contatoTelefonico;
	private String email;
	private String endereco;
	private String cpf;

	public Cliente(String nomeCompleto, String dataNascimento, String contatoTelefonico, String email, String endereco,
			String cpf) {
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.contatoTelefonico = contatoTelefonico;
		this.email = email;
		this.endereco = endereco;
		this.cpf = cpf;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setContatoTelefonico(String contatoTelefonico) {
		this.contatoTelefonico = contatoTelefonico;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public String getContatoTelefonico() {
		return contatoTelefonico;
	}

}
