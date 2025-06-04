public class NoAVL {
    NoAVL esquerda;
    NoAVL direita;
    int info;
    int altura;


    int alturaAVL(NoAVL no){
        if(no == null) {
            return -1;
        } else {
            return no.altura;
        }
    }

    int fatorBalanceamento(NoAVL no){
        return alturaAVL(no.esquerda) - alturaAVL(no.direita);
    }


}
