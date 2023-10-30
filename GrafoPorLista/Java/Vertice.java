import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String name;
    private ArrayList<Aresta> arestas;

    public Vertice(String name) {
        this.name = name;
        this.arestas = new ArrayList<>();
    }

    public void CriarAresta(String name) {
        Aresta aresta = new Aresta(name);
        arestas.add(aresta);
    }

    public void AdicionarAresta(Vertice destino, int peso) {
        Aresta aresta = new Aresta(destino, peso);
        arestas.add(aresta);
    }
}
