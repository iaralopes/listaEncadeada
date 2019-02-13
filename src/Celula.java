public class Celula {
    private Celula proxima;
    private int elemento;

    public Celula(Celula proxima, int elemento) {
        this.proxima = proxima;
        this.elemento = elemento;
    }

    public Celula(int elemento) {
        this.elemento = elemento;
    }

    public void setProxima(Celula proxima) {
        this.proxima = proxima;
    }

    public Celula getProxima() {
        return proxima;
    }

    public int getElemento() {
        return elemento;
    }
}
