package naEsquinaDeCasa;

public class ArvoreAVL {
	public No raiz;

	public void inserir(Cliente cliente) {
		raiz = inserirNo(raiz, cliente);
	}

	public No inserirNo(No no, Cliente cliente) {
		if (no == null) {
			no = new No();

			no.cliente = cliente;
			no.esquerda = null;
			no.direita = null;
		}

        int comparacao = cliente.getCpf().compareTo(no.cliente.getCpf());

        if (comparacao < 0) {
            no.esquerda = inserirNo(no.esquerda, cliente);
        } else if (comparacao > 0) {
            no.direita = inserirNo(no.direita, cliente);
        }

		return no;
	}
}
