use std::collections::HashMap;

pub struct Vertice {
    nome: String,
    vizinhos: HashMap<String, i32>,
}

impl Vertice {
    pub fn new(nome: String) -> Self {
        Vertice {
            nome,
            vizinhos: HashMap::new(),
        }
    }

    pub fn adicionar_aresta(&mut self, destino: String, peso: i32) {
        self.vizinhos.insert(destino, peso);
    }
}

pub struct Aresta {
    origem: Vertice,
    destino: Vertice,
    peso: i32,
}

impl Aresta {
    pub fn new(origem: Vertice, destino: Vertice, peso: i32) -> Self {
        Aresta { origem, destino, peso }
    }
}

pub struct Grafo {
    vertices: HashMap<String, Vertice>,
    limite_de_vertices: i32,
}

impl Grafo {
    pub fn new(limite_de_vertices: i32) -> Self {
        Grafo {
            vertices: HashMap::new(),
            limite_de_vertices,
        }
    }

    pub fn adicionar_vertice(&mut self, nome: String) {
        if self.vertices.len() < self.limite_de_vertices as usize {
            let vertice = Vertice::new(nome.clone());
            self.vertices.insert(nome.clone(), vertice);
        } else {
            println!("Limite máximo de vértices atingido");
        }
    }

    pub fn adicionar_aresta(&mut self, origem: String, destino: String, peso: i32) {
        if let Some(vertice_origem) = self.vertices.get_mut(&origem) {
            vertice_origem.adicionar_aresta(destino.clone(), peso);
        }
        if let Some(vertice_destino) = self.vertices.get_mut(&destino) {
            vertice_destino.adicionar_aresta(origem.clone(), peso);
        }
    }

    pub fn imprimir_grafo(&self) {
        for (nome, vertice) in &self.vertices {
            print!("Vértice {}: ", nome);
            for (vizinho, peso) in &vertice.vizinhos {
                print!("({} -> {}, peso: {}), ", nome, vizinho, peso);
            }
            println!();
        }
    }
}
