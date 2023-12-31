import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    private Map<String, Vertice> vertices;

    public Grafo() {
        this.vertices = new HashMap<>();
    }

    public void AdicionarVertice(Vertice vertice) {
        if (vertices.size() < 20) {
            vertices.put(vertice.getName(), vertice);
        } else {
            System.out.println("Vértice inválido ou limite máximo atingido");
        }
    }


    public List<Vertice> getVertices() {
        return new ArrayList<>(vertices.values());
    }

    public void AdicionarAresta(String origem, String destino, int peso) {
        if (vertices.containsKey(origem) && vertices.containsKey(destino)) {
            vertices.get(origem).AdicionarAresta(vertices.get(origem), vertices.get(destino), peso);
            vertices.get(destino).AdicionarAresta(vertices.get(destino), vertices.get(origem), peso);
        }
    }

    public List<Aresta> ObterArestas(String nomeVertice) {
        if (vertices.containsKey(nomeVertice)) {
            return vertices.get(nomeVertice).getArestas();
        }
        return null;
    }

    public void ImprimirGrafo() {
        for (String nomeVertice : vertices.keySet()) {
            System.out.print("Vértice " + nomeVertice + " -> ");
            List<Aresta> arestas = ObterArestas(nomeVertice);
            if (arestas != null) {
                for (Aresta aresta : arestas) {
                    System.out.print("(" + aresta.getDestino().getName() + ", " + aresta.getPeso() + ") ");
                }
            }
            System.out.println();
        }
    }
}
