import java.util.ArrayList;

public class Aresta{
    private Vertice destino;
    private Vertice origem;
    private int peso;

    public Aresta(Vertice origem, Vertice destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getDestino(){
        return this.destino;
    }
    public int getPeso(){
        return this.peso;
    }
}