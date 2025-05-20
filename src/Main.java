public class Main {
    public static void main(String[] args) {
        // Executando a Arvore
        Arvore arvore = new Arvore();
        arvore.raiz = new No(10);
        arvore.raiz.esquerdo = new No(5);
        arvore.raiz.direito = new No(15);
    }
}