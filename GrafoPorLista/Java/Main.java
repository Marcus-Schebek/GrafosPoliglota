import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Vertice pelotas = new Vertice("Pelotas");
        Vertice rioGrande = new Vertice("Rio Grande");
        Vertice bage = new Vertice("Bagé");
        Vertice camaqua = new Vertice("Camaquã");

        grafo.AdicionarVertice(pelotas);
        grafo.AdicionarVertice(rioGrande);
        grafo.AdicionarVertice(bage);
        grafo.AdicionarVertice(camaqua);

        grafo.AdicionarAresta("Pelotas", "Rio Grande", 5);
        grafo.AdicionarAresta("Pelotas", "Bagé", 3);
        grafo.AdicionarAresta("Rio Grande", "Bagé", 2);
        grafo.AdicionarAresta("Camaquã", "Bagé", 9);
        grafo.AdicionarAresta("Camaquã", "Pelotas", 2);
        grafo.AdicionarAresta("Camaquã", "Rio Grande", 5);

        System.out.println("Grafo Original:");
        grafo.ImprimirGrafo();
        
        Vertice origem = pelotas;
        Vertice destino = bage;

        Dijkstra dijkstra = new Dijkstra(grafo, origem, destino);
        dijkstra.calcular_menor_caminho();

        System.out.println("\nCaminho Mínimo de " + origem.getName() + " para " + destino.getName() + ":");
        List<String> caminho = dijkstra.obterCaminho();
        for (String vertice : caminho) {
            System.out.print(vertice + " ");
        }
    }
}
