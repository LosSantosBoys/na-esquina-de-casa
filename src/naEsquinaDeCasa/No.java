package naEsquinaDeCasa;

public class No {
	public Cliente cliente;
	public No direita;
	public No esquerda;
	public int altura;

	public No() {
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}
	
	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public No getDireita() {
		return direita;
	}

	public No getEsquerda() {
		return esquerda;
	}
	
	public int getAltura() {
		return altura;
	}
}
