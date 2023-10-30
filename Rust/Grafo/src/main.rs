mod grado;
use grafo::Grafo;

fn main() {
    let mut grafo = Grafo::new(20);
    grafo.adicionar_vertice(1);
    grafo.adicionar_vertice(2);
    grafo.adicionar_vertice(3);
    grafo.adicionar_aresta(1, 2, 5);
    grafo.adicionar_aresta(2, 3, 8);
    grafo.visualizar_grafo();
}