public class NoRubro {
    NoRubro esquerdo, direito;
    int chave;
    Cor cor;

    enum Cor { RED, BLACK };

    public NoRubro(int chave){
        this.chave = chave;
        this.cor = Cor.BLACK;
        this.esquerdo = null;
        this.direito = null;
    }
}
