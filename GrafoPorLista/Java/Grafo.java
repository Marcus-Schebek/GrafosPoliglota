import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    private Map<String, Vertice> vertices;

    public Grafo() {
        this.vertices = new HashMap<String, Vertice>();
    }

    public void AdicionarVertice(String name) {
        if (vertices.size() < 20) {
            Vertice vertice = new Vertice(name);
            vertices.put(name, vertice);
        } else {
            System.out.println("Vértice inválido ou limite máximo atingido");
        }
    }

    public void AdicionarAresta(String origem, String destino, int peso) {
        if (vertices.containsKey(origem) && vertices.containsKey(destino)) {
            vertices.get(origem).AdicionarAresta(destino, peso);
        }
    }

    public List<Aresta> ObterArestas(String nomeVertice) {
        if (vertices.containsKey(nomeVertice)) {
            return vertices.get(nomeVertice).ObterArestas();
        }
        return null;
    }
}
