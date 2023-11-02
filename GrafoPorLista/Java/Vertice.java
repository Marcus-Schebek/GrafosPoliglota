import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String name;
    private ArrayList<Aresta> arestas;

    public Vertice(String name) {
        this.name = name;
        this.arestas = new ArrayList<>();
    }

    public void AdicionarAresta(Vertice origem, Vertice destino, int peso) {
        Aresta aresta = new Aresta(origem, destino, peso);
        arestas.add(aresta);
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public String getName(){
        return this.name;
    }
}
