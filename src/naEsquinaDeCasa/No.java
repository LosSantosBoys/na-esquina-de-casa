package naEsquinaDeCasa;

public class No {
	public int dado;
	public No direita;
	public No esquerda;

	public No() {
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}

	public int getDado() {
		return dado;
	}

	public No getDireita() {
		return direita;
	}

	public No getEsquerda() {
		return esquerda;
	}
}
