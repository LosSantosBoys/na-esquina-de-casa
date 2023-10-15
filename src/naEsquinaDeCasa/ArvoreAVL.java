package naEsquinaDeCasa;

public class ArvoreAVL {
	public No inserir(No node, int dado) {
		if (node == null) {
			node = new No();

			node.dado = dado;
			node.esquerda = null;
			node.direita = null;
		} else if (dado < node.dado) {
			node.esquerda = inserir(node.esquerda, dado);
		} else {
			node.direita = inserir(node.direita, dado);
		}

		return node;
	}

	public int retiraEmOrdem(No root, int i, int vetor[]) {
		if (root != null) {
			i = retiraEmOrdem(root.esquerda, i, vetor);
			vetor[i] = root.dado;
			i++;
			i = retiraEmOrdem(root.direita, i, vetor);
		}
		
		return i;
	}
}
