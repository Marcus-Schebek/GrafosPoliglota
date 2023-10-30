use std::collections::HashMap;

pub struct Grafo {
    vertices: Vec<u32>,
    arestas: HashMap<(u32, u32), u32>,
    max_vertices: usize,
}

impl Grafo {
    pub fn new(max_vertices: usize) -> Grafo {
        Grafo {
            vertices: Vec::new(),
            arestas: HashMap::new(),
            max_vertices,
        }
    }

    pub fn adicionar_vertice(&mut self, vertice: u32) {
        if vertice >= 0 && self.vertices.len() < self.max_vertices {
            self.vertices.push(vertice);
        } else {
            println!("Vértice inválido ou limite máximo atingido");
        }
    }

    pub fn adicionar_aresta(&mut self, vertice_origem: u32, vertice_destino: u32, peso: u32) {
        if self.vertices.contains(&vertice_origem) && self.vertices.contains(&vertice_destino) {
            self.arestas.insert((vertice_origem, vertice_destino), peso);
            self.arestas.insert((vertice_destino, vertice_origem), peso);
        } else {
            println!("Vértice de origem ou destino inválido");
        }
    }

    pub fn visualizar_grafo(&self) {
        println!("Matriz de Adjacência:");
        for &origem in &self.vertices {
            for &destino in &self.vertices {
                if let Some(&peso) = self.arestas.get(&(origem, destino)) {
                    print!("{:<2} ", peso);
                } else {
                    print!("0  ");
                }
            }
            println!();
        }
    }
}