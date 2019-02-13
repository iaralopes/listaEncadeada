public class ListaLigada {
    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    public void adicionaNoComeco(int elemento) {
        Celula nova = new Celula(this.primeira, elemento);
        this.primeira = nova;

        if(this.totalDeElementos == 0) {
            this.ultima = this.primeira;
        }

        this.totalDeElementos++;
    }

    public void adicionaNoFim(int elemento) {
        if (this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    public void adicionaQualquerPosicao(int posicao, int elemento) {
        if(posicao == 0) {
            this.adicionaNoComeco(elemento);
        } else if(posicao == this.totalDeElementos) { //total de elementos, ou seja, colocar na posicao do fim
            this.adicionaNoFim(elemento);
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula nova = new Celula(anterior.getProxima(), elemento);
            anterior.setProxima(nova);
            this.totalDeElementos++;
        }
    }

    public Celula pegaCelula(int posicao) {
        if(!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }

        return atual;
    }

    public boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

    public void removeDoComeco() {
        if(!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        this.primeira = this.primeira.getProxima();
        this.totalDeElementos--;

        if(this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }

    public void removeDoFim() {
        if(!this.posicaoOcupada(this.totalDeElementos - 1)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (this.totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = pegaCelula(this.totalDeElementos - 2);
            penultima.setProxima(null);
            this.ultima = penultima;
            totalDeElementos--;
        }
    }

    public void removeQualquerPosicao(int posicao) {
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }

        if(posicao == 0) {
            removeDoComeco();
        } else if(posicao == this.totalDeElementos - 1) {
            this.removeDoFim();
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();

            anterior.setProxima(proxima);

            this.totalDeElementos--;
        }
    }

    public boolean buscaElemento(int elemento) {
        Celula atual = this.primeira;

        while (atual != null) {
            if (atual.getElemento() == elemento) {
                return true;
            }
            atual = atual.getProxima();
        }

        return false;

    }
}
