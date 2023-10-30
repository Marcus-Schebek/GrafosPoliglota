public class GrafosMain {
    public static void main(String[] args){
        Grafo grafo = new Grafo();
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarAresta(1, 2, 5);
        grafo.adicionarAresta(2, 3, 8);
        grafo.visualizarGrafo();
    }
}