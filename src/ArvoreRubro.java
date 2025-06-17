public class ArvoreRubro {
    private NoRubro raiz;
    private final NoRubro NIL;

    public ArvoreRubro(){
        NIL = new NoRubro(-1);
        NIL.cor = Cor.BLACK;
        NIL.esquerdo = NIL.direito = NIL.pai = null;
        raiz = NIL;
    }

    private void leftRotate(NoRubro x) {
        NoRubro y = x.direito;
        x.direito = y.esquerdo;
        if(y.esquerdo != NIL) y.esquerdo.pai = x;

        y.pai = x.pai;

        if(x.pai == null) raiz = y;
        else if(x == x.pai.esquerdo) x.pai.esquerdo = y;
        else x.pai.direito =y;

        y.esquerdo = x;
        x.pai = y;
    }

    private void rightRotate(NoRubro y){
        NoRubro x = y.esquerdo;
        y.esquerdo = x.direito;
        if(x.direito != NIL) x.direito.pai = y;

        x.pai = y.pai;

        if(y.pai == null) raiz = x;
        else if(y == y.pai.direito) y.pai.direito = x;
        else y.pai.esquerdo = x;

        x.direito = y;
        y.pai = x;
    }

    private void insert(int key){
        NoRubro no = new NoRubro(key);
        no.esquerdo = no.direito = no.pai = NIL;

        NoRubro y = null;
        NoRubro x = raiz;

        while(x != NIL){
            y = x;
            if(no.chave < x.chave) x = x.esquerdo;
            else x = x.direito;
        }

        no.pai = y;
        if(y == null) raiz = no;
        else if(no.chave < y.chave) y.esquerdo = no;
        else y.direito = no;

        no.esquerdo = NIL;
        no.direito = NIL;
        no.cor = Cor.RED;

        insertFix(no);
    }

    private void insertFix(NoRubro k){
        while(k.pai != null && k.pai.cor == Cor.RED){
            if(k.pai == k.pai.pai.esquerdo){
                NoRubro u = k.pai.pai.direito;
                if(u.cor == Cor.RED){
                    k.pai.cor = Cor.BLACK;
                    u.cor = Cor.BLACK;
                    k.pai.pai.cor = Cor.RED;
                    k = k.pai.pai;
                } else {
                    if(k == k.pai.direito){
                        k = k.pai;
                        leftRotate(k);
                    }
                    k.pai.cor = Cor.BLACK;
                    k.pai.pai.cor = Cor.RED;
                    rightRotate(k.pai.pai);
                }
            } else {
                NoRubro u = k.pai.pai.esquerdo;
                if(u.cor == Cor.RED){
                    k.pai.cor = Cor.BLACK;
                    u.cor = Cor.BLACK;
                    k.pai.pai.cor = Cor.RED;
                    k = k.pai.pai;
                } else {
                    if(k == k.pai.esquerdo){
                        k = k.pai;
                        rightRotate(k);
                    }
                    k.pai.cor = Cor.BLACK;
                    k.pai.pai.cor = Cor.RED;
                    leftRotate(k.pai.pai);
                }
            }
            if(k == raiz) break;
        }
        raiz.cor = Cor.BLACK;
    }

    public void transplant(NoRubro u, NoRubro v) {
        if(u.pai == null) raiz = v;
        else if(u == u.pai.esquerdo) u.pai.esquerdo = v;
        else u.pai.direito = v;
        v.pai = u.pai;
    }

    private NoRubro minimum(NoRubro no){
        while(no.esquerdo != NIL) no = no.esquerdo;
        return no;
    }

    public void delete(int key){
        NoRubro z = searchTree(raiz, key);
        if(z == NIL) return;

        NoRubro y = z;
        Cor yOriginalCor = y.cor;
        NoRubro x;

        if(z.esquerdo == NIL) {
            x = z.direito;
            transplant(z, z.direito);
        }else if(z.direito == NIL){
           x = z.esquerdo;
           transplant(z, z.esquerdo);
        } else {
            y = minimum(z.direito);
            yOriginalCor = y.cor;
            x = y.direito;
            if(y.pai == z) x.pai = y;
            else {
                transplant(y, y.direito);
                y.direito = z.direito;
                y.direito.pai = y;
            }
            transplant(z, y);
            y.esquerdo = z.esquerdo;
            y.esquerdo.pai = y;
            y.cor = z.cor;
        }
        if(yOriginalCor == Cor.BLACK) {
            deleteFix(x);
        }
    }

    private void deleteFix(NoRubro x){
        NoRubro w;
        while(x != raiz && x.cor == Cor.BLACK){
            if(x == x.pai.esquerdo){
                w = x.pai.direito;
                if(w.cor == Cor.RED){
                    w.cor = Cor.BLACK;
                    x.pai.cor = Cor.RED;
                    leftRotate(x.pai);
                    w = x.pai.direito;
                }
                if(w.esquerdo.cor == Cor.BLACK && w.direito.cor == Cor.BLACK){
                    w.cor = Cor.RED;
                    x = x.pai;
                } else {
                    if(w.direito.cor == Cor.BLACK){
                        w.esquerdo.cor = Cor.BLACK;
                        w.cor = Cor.RED;
                        rightRotate(w);
                        w = x.pai.direito;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.BLACK;
                    w.direito.cor = Cor.BLACK;
                    leftRotate(x.pai);
                    x = raiz;
                }
            } else {
                w = x.pai.esquerdo;
                if(w.cor == Cor.RED){
                    w.cor = Cor.BLACK;
                    x.pai.cor = Cor.RED;
                    rightRotate(x.pai);
                    w = x.pai.esquerdo;
                }
                if(w.direito.cor == Cor.BLACK && w.esquerdo.cor == Cor.BLACK){
                    w.cor = Cor.RED;
                    x = x.pai;
                } else {
                    if(w.esquerdo.cor == Cor.BLACK){
                        w.direito.cor = Cor.BLACK;
                        w.cor = Cor.RED;
                        leftRotate(w);
                        w = x.pai.esquerdo;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.BLACK;
                    w.esquerdo.cor = Cor.BLACK;
                    rightRotate(x.pai);
                    x = raiz;
                }
            }
        }
        x.cor = Cor.BLACK;
    }

    private NoRubro searchTree(NoRubro no, int key){
        if(no == NIL  || key == no.chave) return no;
        if(key < no.chave) return searchTree(no.esquerdo, key);
        return searchTree(no.direito, key);
    }

    public void inorder(){
        inorderHelper(raiz);
        System.out.println();
    }

    private void inorderHelper(NoRubro no) {
        if(no != NIL) {
            inorderHelper(no.esquerdo);
            String colorSuffix = (no.cor == Cor.RED) ? "R" : "B";
            System.out.print(no.chave + colorSuffix + " ");
            inorderHelper(no.direito);
        }
    }
}