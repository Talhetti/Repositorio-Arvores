enum Cor { RED, BLACK };

public class NoRubro {
    Cor cor;
    int chave;
    NoRubro esquerdo, direito, pai;


    public NoRubro(int chave){
        this.chave = chave;
        this.cor = Cor.BLACK;
        this.esquerdo = null;
        this.direito = null;
        this.pai = null;
    }
}
