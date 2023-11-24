public class Main {
    public static void main(String[] args){
       Grafo grafo = new Grafo();
        grafo.AdicionarVertice("Pelotas");
        grafo.AdicionarVertice("Rio Grande");
        grafo.AdicionarVertice("Bagé");
        grafo.AdicionarVertice("Camaquã");
       
        grafo.AdicionarAresta("Pelotas", "Rio Grande", 5);
        grafo.AdicionarAresta("Pelotas", "Bagé", 3);
        grafo.AdicionarAresta("Rio Grande", "Bagé", 2);
        grafo.AdicionarAresta("Camaquã", "Bagé", 9);
        grafo.AdicionarAresta("Camaquã", "Pelotas", 2);
        grafo.AdicionarAresta("Camaquã", "Rio Grande", 5);

        grafo.ImprimirGrafo();
          
    
    }
}