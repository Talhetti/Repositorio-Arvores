public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.raiz = new No(10);
        arvore.raiz.esquerdo = new No(5);
        arvore.raiz.direito = new No(15);
        arvore.raiz.esquerdo.esquerdo = new No(2);
        arvore.raiz.esquerdo.direito = new No(7);
        arvore.raiz.direito.esquerdo = new No(12);
        arvore.raiz.direito.direito = new No(17);

        System.out.println("Contador recursivo: " + arvore.contador(arvore.raiz) );
        System.out.println("Contador Iterativo: " + arvore.contadorIterativo(arvore.raiz) );
        System.out.println("Folha recursivo: " + arvore.contadorDeFolhas(arvore.raiz) );
        System.out.println("Folha iterativo: " + arvore.contadorDeFolhasIterativo(arvore.raiz) );

        System.out.print("Pré-ordem recursivo: ");
        arvore.preOrdem(arvore.raiz);
        System.out.println();

        /*System.out.print("Pré-ordem iterativo: ");
        arvore.preOrdemIterativa(arvore.raiz);
        System.out.println();*/

        System.out.print("Em ordem recursivo: ");
        arvore.emOrdem(arvore.raiz);
        System.out.println();

        /*System.out.print("Em ordem iterativo: ");
        arvore.emOrdemIterativo(arvore.raiz);
        System.out.println();*/

        System.out.print("Pós-ordem recursivo: ");
        arvore.posOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Pós-ordem iterativo: ");
        arvore.posOrdemIterativo(arvore.raiz);
        System.out.println();

        /*System.out.print("Busca em nível: ");
        arvore.BuscaEmNivel(arvore.raiz);
        System.out.println();*/
    }
}
