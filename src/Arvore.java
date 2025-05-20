public class Arvore {
    No raiz;

    //Contando os nós da árvore
    public int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerdo) + contarNos(no.direito);
    }
}
