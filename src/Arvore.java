public class Arvore {
    // Implementando a Arvore
    No raiz;

    public Arvore() {
        this.raiz = null;
    }

    /*Implementando contador int*/
    private int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerdo) + contarNos(no.direito);
    }

    /* Percorrendo os nós da Árvore em Pré-Ordem */
    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerdo);
            preOrdem(no.direito);
        }
    }
    /* Percorrendo os nós da Árvore Em-Ordem */
    public void emOrdem(No no){
        if(no != null){
            emOrdem(no.esquerdo);
            System.out.println(no.valor + " ");
            emOrdem(no.direito);
        }
    }

}
