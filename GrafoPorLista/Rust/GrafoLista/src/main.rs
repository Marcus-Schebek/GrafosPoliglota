mod grafo;
use grafo::Grafo;

fn main() {
    let mut grafo = Grafo::new(20);
    grafo.adicionar_vertice("A".to_string());
    grafo.adicionar_vertice("B".to_string());
    grafo.adicionar_vertice("C".to_string());

    grafo.adicionar_aresta("A".to_string(), "B".to_string(), 5);
    grafo.adicionar_aresta("B".to_string(), "C".to_string(), 7);



    grafo.imprimir_grafo();
}