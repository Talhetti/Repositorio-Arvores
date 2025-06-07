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

    NoAVL RotacaoDireita(NoAVL y){
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(alturaAVL(y), alturaAVL(x)) + 1;
        x.altura = Math.max(alturaAVL(y), alturaAVL(x)) + 1;

        return x;
    }

    NoAVL RotacaoEsquerda(NoAVL x){
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(alturaAVL(y), alturaAVL(x)) + 1;
        y.altura = Math.max(alturaAVL(y), alturaAVL(x)) + 1;

        return y;
    }
}
