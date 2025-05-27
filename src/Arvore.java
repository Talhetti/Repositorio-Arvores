import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arvore {
    // Implementando a Arvore
    No raiz;

    public Arvore() {
        this.raiz = null;
    }

    /*Implementando contador int*/
    public int contador(No no) {
        if (no == null) { return 0; }
        return 1 + contador(no.esquerdo) + contador(no.direito);
    }

    /* Implementando o contador iterativo */
    public int contadorIterativo(No raiz){
        if(raiz == null){ return 0; }

        //Criando o contador.
        int contador = 0;
        // Criando a pilha para armazenar os nós
        Stack<No> pilha = new Stack<>();
        pilha.add(raiz);

        while(!pilha.isEmpty()){
            // pop -> remove e retorna
            No atual = pilha.pop();
            contador++;
            if(atual.esquerdo != null) pilha.push(atual.esquerdo);
            if(atual.direito != null) pilha.push(atual.direito);
        }
        return contador;
    }

    /* Método para contar os nós folhas */
    public int contadorDeFolhas(No raiz) {
        if (raiz == null) return 0;
        if (raiz.esquerdo == null && raiz.direito == null) return 1;
        return contadorDeFolhas(raiz.esquerdo) + contadorDeFolhas(raiz.direito);
    }

    public int contadorDeFolhasIterativo(No raiz) {
        if (raiz == null) return 0;

        int contador = 0;
        Stack<No> pilha = new Stack<>();
        pilha.add(raiz);

        while(!pilha.isEmpty()){
            No atual = pilha.pop();
            if(atual.esquerdo == null && atual.direito == null) contador++;
            if(atual.esquerdo != null) pilha.push(atual.esquerdo);
            if(atual.direito != null) pilha.push(atual.direito);
        }
        return contador;
    }

    /* Percorrendo os nós da Árvore em Pré-Ordem */
    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerdo);
            preOrdem(no.direito);
        }
    }

    /*Implementando a preOrdem*/
    public void preOrdemIterativa(No raiz){
        if(raiz == null){ return; }

        Stack<No> pilha = new Stack<>();
        pilha.add(raiz);

        while(!pilha.isEmpty()){
            No atual = pilha.pop();
            System.out.println(raiz.valor + " ");

            if(atual.esquerdo != null){
                pilha.push(atual.esquerdo);
            }
            if(atual.direito != null){
                pilha.push(atual.direito);
            }

        }
    }

    /* Percorrendo os nós da Árvore Em-Ordem */
    public void emOrdem(No no){
        if(no != null){
            emOrdem(no.esquerdo);
            System.out.print(no.valor + " ");
            emOrdem(no.direito);
        }
    }

    /* Implementando em Ordem Iterativo */
    public void emOrdemIterativo(No raiz){
        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while(atual != null || !pilha.isEmpty()){
            while(atual != null){
                pilha.push(atual);
                atual = atual.esquerdo;
            }
        }
        atual = pilha.pop();
        System.out.println(atual.valor + " ");
        atual = atual.direito;
    }

    /* Percorrendo os nós da Árvore em Pós-ordem */
    public void posOrdem(No no){
        if(no != null){
            posOrdem(no.esquerdo);
            posOrdem(no.direito);
            System.out.print(no.valor + " ");
        }
    }

    /* Implementando a Pos Ordem Iterativa*/
    public void posOrdemIterativo(No raiz){
        if (raiz == null) return;

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();
        pilha1.push(raiz);

        while(!pilha1.isEmpty()){
            No atual = pilha1.pop();
            pilha2.push(atual);

            if(atual.esquerdo != null){
                pilha1.push(atual.esquerdo);
            }
            if(atual.direito != null){
                pilha1.push(atual.direito);
            }
        }
        while(!pilha2.isEmpty()){
            System.out.println(pilha2.pop().valor + " ");
        }

    }


    /* Percorrendo os nós da Árvore em Nível (Busca em Largura) */
    public void BuscaEmNivel(No raiz){
        if (raiz == null) return; // Não faz mais nada quando cai aqui
        //Criando fila para armazenar os nós
        Queue<No> fila = new LinkedList<>();
        // Adicionando o primeiro a ser adicionado
        fila.add(raiz);
        // Enquanto a fila não estiver vazia, percurso continua
        while (!fila.isEmpty()){
            // Removendo o primeiro valor e armazenamos no 'atual'
            No atual = fila.poll();
            //Imprimindo o valor do nó
            System.out.println(raiz.valor + " ");
            if(atual.esquerdo != null) fila.add(atual.esquerdo);
            if(atual.direito != null) fila.add(atual.direito);

        }
    }
}
