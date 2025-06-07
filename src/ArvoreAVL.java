public class ArvoreAVL {
    NoAVL no;

    int alturaAVL(NoAVL no){
        if(no == null) {
            return 0;
        } else {
            return no.altura;
        }
    }

    int fatorBalanceamento(NoAVL no){
        if(no == null) return 0;
        return alturaAVL(no.esquerda) - alturaAVL(no.direita);
    }


}
