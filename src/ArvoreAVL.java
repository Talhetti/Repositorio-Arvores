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

    public void percursoEmOrdem(NoAVL no){
        if(no != null){
            percursoEmOrdem(no.esquerda);
            System.out.print(no.chave + " ");
            percursoEmOrdem(no.direita);
        }
    }

    private NoAVL RotacaoDireita(NoAVL y){
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(alturaAVL(y.esquerda), alturaAVL(y.direita)) + 1;
        x.altura = Math.max(alturaAVL(x.esquerda), alturaAVL(x.direita)) + 1;

        return x;
    }

    private NoAVL RotacaoEsquerda(NoAVL x){
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(alturaAVL(x.esquerda), alturaAVL(x.direita)) + 1;
        y.altura = Math.max(alturaAVL(y.esquerda), alturaAVL(y.direita)) + 1;

        return y;
    }

    public NoAVL inserir(NoAVL no, int valor){
        if(no == null)
            return new NoAVL(valor);

        if(valor < no.chave){
            no.esquerda = inserir(no.esquerda, valor);
        } else if(valor > no.chave) {
            no.direita = inserir(no.direita, valor);
        } else {
            return no;
        }

        no.altura = Math.max(alturaAVL(no.esquerda), alturaAVL(no.direita)) + 1;

        int fatorBalanceamento = fatorBalanceamento(no);

        if(fatorBalanceamento > 1 && valor < no.esquerda.chave){
            return RotacaoDireita(no);
        }
        if(fatorBalanceamento < -1 && valor > no.direita.chave){
            return RotacaoEsquerda(no);
        }
        if(fatorBalanceamento > 1 && valor > no.esquerda.chave){
            no.esquerda = RotacaoEsquerda(no.esquerda);
            return RotacaoDireita(no);
        }

        if(fatorBalanceamento < -1 && valor < no.direita.chave){
            no.direita = RotacaoDireita(no.direita);
            return RotacaoEsquerda(no);
        }

        return no;
    }

    /*public NoAVL remover(NoAVL no, int valor) {
        if (no == null)
            return null;

        if (valor < no.chave) {
            no.esquerda = remover(no.esquerda, valor);
        } else if (valor > no.chave) {
            no.direita = remover(no.direita, valor);
        } else {
            if (no.esquerda == null || no.direita == null) {
                NoAVL temp = (no.esquerda != null) ? no.esquerda : no.direita;
                no = temp;
            } else {
                NoAVL temp = no.direita;
                while (temp.esquerda != null)
                    temp = temp.esquerda;
                no.chave = temp.chave;
                no.direita = remover(no.direita, temp.chave);
            }
        }

        if (no == null)
            return null;

        no.altura = Math.max(alturaAVL(no.esquerda), alturaAVL(no.direita)) + 1;

        int balanceamento = fatorBalanceamento(no);

        if (balanceamento > 1 && fatorBalanceamento(no.esquerda) >= 0)
            return RotacaoDireita(no);

        if (balanceamento > 1 && fatorBalanceamento(no.esquerda) < 0) {
            no.esquerda = RotacaoEsquerda(no.esquerda);
            return RotacaoDireita(no);
        }

        if (balanceamento < -1 && fatorBalanceamento(no.direita) <= 0)
            return RotacaoEsquerda(no);

        if (balanceamento < -1 && fatorBalanceamento(no.direita) > 0) {
            no.direita = RotacaoDireita(no.direita);
            return RotacaoEsquerda(no);
        }

        return no;
    }*/
}
