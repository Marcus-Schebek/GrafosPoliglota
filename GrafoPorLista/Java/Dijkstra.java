import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {
    private Grafo grafo;
    private Vertice origem;
    private Vertice destino;
    private Map<String, DijkstraInfo> info_vertices;

    public Dijkstra(Grafo grafo, Vertice origem, Vertice destino) {
        this.grafo = grafo;
        this.origem = origem;
        this.destino = destino;
        this.info_vertices = new HashMap<>();

        for (Vertice v : grafo.getVertices()) {
            this.info_vertices.put(v.getName(), new DijkstraInfo(v));
        }
    }

    public void calcular_menor_caminho() {
        info_vertices.get(origem.getName()).setDistancia(0);
        List<DijkstraInfo> vertices_a_explorar = new ArrayList<>(info_vertices.values());

        while (!vertices_a_explorar.isEmpty()) {
            DijkstraInfo menorDistanciaVertice = encontrarMenorDistancia(vertices_a_explorar);
            vertices_a_explorar.remove(menorDistanciaVertice);

            for (Aresta aresta : menorDistanciaVertice.getVertice().getArestas()) {
                DijkstraInfo infoDestino = info_vertices.get(aresta.getDestino().getName());
                double novaDistancia = menorDistanciaVertice.getDistancia() + aresta.getPeso();

                if (novaDistancia < infoDestino.getDistancia()) {
                    infoDestino.setDistancia(novaDistancia);
                    infoDestino.setAntecessor(menorDistanciaVertice.getVertice());
                }
            }
        }
    }

    private DijkstraInfo encontrarMenorDistancia(List<DijkstraInfo> vertices) {
        DijkstraInfo menorDistanciaVertice = vertices.get(0);

        for (DijkstraInfo vertice : vertices) {
            if (vertice.getDistancia() < menorDistanciaVertice.getDistancia()) {
                menorDistanciaVertice = vertice;
            }
        }

        return menorDistanciaVertice;
    }

    public List<String> obterCaminho() {
        List<String> caminho = new ArrayList<>();
        Vertice verticeAtual = destino;

        while (verticeAtual != origem) {
            caminho.add(0, verticeAtual.getName());
            verticeAtual = info_vertices.get(verticeAtual.getName()).getAntecessor();
        }

        caminho.add(0, origem.getName());
        return caminho;
    }
}
