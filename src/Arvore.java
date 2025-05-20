public class Arvore {
    No raiz;

    public Arvore() {
        this.raiz = null;
    }


    public int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerdo) + contarNos(no.direito);
    }

}
