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

}
