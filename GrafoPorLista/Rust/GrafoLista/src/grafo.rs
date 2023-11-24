use std::collections::hash_map::DefaultHasher;
use std::hash::{Hash, Hasher};
use std::collections::HashMap;

#[derive(Clone, Eq, PartialEq)]
pub struct Vertice {
    nome: String,
    vizinhos: HashMap<String, i32>,
}

impl Hash for Vertice { // A Recomendação dos Docs do Rust é aplicar uma implementação propria de Hash nesse caso
    fn hash<H: Hasher>(&self, state: &mut H) {
        self.nome.hash(state);
        // Adiciona a hash dos vizinhos para garantir unicidade
        for (vizinho, peso) in &self.vizinhos {
            vizinho.hash(state);
            peso.hash(state);
        }
    }
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
    pub fn get_name(&self) -> &String{
        &self.nome
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

pub struct DijkstraInfo<Vertice>{
    vertice: Vertice,
    antecessor: Option<String>,
    distancia: i32
}

impl DijkstraInfo<Vertice>{
    pub fn new(vertice: Vertice) -> Self{
        DijkstraInfo{
            vertice,
            antecessor: None,
            distancia: i32::MAX,
        }
    }

    pub fn get_vertice(&self) -> &Vertice {
        &self.vertice
    }
    pub fn get_antecessor(&self) -> &Option<String>{
        &self.antecessor
    }
    pub fn get_distancia(&self) -> &i32{
        &self.distancia
    }

    pub fn set_vertice(&mut self, vertice: Vertice){
        self.vertice = vertice;
    }
    pub fn set_antecessor(&mut self, antecessor: String){
        self.antecessor = Some(antecessor);
    }
    pub fn set_distancia(&mut self, distancia:i32){
        self.distancia = distancia;
    }
}

pub struct Dijkstra<Vertice, Grafo, DijkstraInfo>{
    grafo: Grafo,
    origem: Vertice,
    destino: Vertice,
    info_vertices: HashMap<Vertice, DijkstraInfo>
}

impl Dijkstra<Vertice, Grafo, DijkstraInfo<Vertice>>{
    pub fn new(grafo: Grafo, origem: Vertice, destino: Vertice) -> Self{
        Dijkstra{
            grafo,
            origem,
            destino,
            info_vertices: HashMap::new(),
        }
    }
    pub fn calcular_menor_caminho(&mut self){
        let origem_nome = self.origem.get_name().clone();  
        self.info_vertices.get_mut(&self.origem).expect("REASON").set_distancia(0);
    }
}