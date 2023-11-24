class Vertice:
    def __init__(self, nome):
        self.nome = nome
        self.vizinhos = {} #Dicionário para usar de Hash map

    def adicionar_vizinho(self, vertice, peso=0):
        self.vizinhos[vertice] = peso


class Aresta:
    def __init__(self, vertice1, vertice2, peso=0):
        self.vertice1 = vertice1
        self.vertice2 = vertice2
        self.peso = peso


class Grafo:
    def __init__(self):
        self.vertices = {}
        self.limite_vertices = 20

    def adicionar_vertice(self, nome):
        if len(self.vertices) < self.limite_vertices:
            novo_vertice = Vertice(nome)
            self.vertices[nome] = novo_vertice
        else:
            print("Limite máximo de vértices atingido")
    def definir_origem_destino(self, origem, destino):
        if origem in self.vertices and destino in self.vertices:
            self.origem = self.vertices[origem]
            self.destino = self.vertices[destino]
    def adicionar_aresta(self, nome_origem, nome_destino, peso=0):
        if nome_origem in self.vertices and nome_destino in self.vertices:
            vertice_origem = self.vertices[nome_origem]
            vertice_destino = self.vertices[nome_destino]
            vertice_origem.adicionar_vizinho(vertice_destino, peso)
            vertice_destino.adicionar_vizinho(vertice_origem, peso)
    def imprimir_grafo(self):
        for nome_vertice, vertice in self.vertices.items():
            vizinhos = vertice.vizinhos
            arestas = []
            for vizinho, peso in vizinhos.items():
                arestas.append(f"({vizinho.nome}, {peso})")
            arestas_str = ", ".join(arestas)
            print(f"Vértice {nome_vertice} -> {arestas_str}")
class DijkstraInfo:
    def __init__(self, vertice):
        self.vertice = vertice
        self.distancia = float('inf')
        self.antecessor = None
class Dikstra:
    def __init__(self, grafo, origem, destino):
        self.grafo = grafo
        self.origem = origem
        self.destino = destino
        self.info_vertices = {v: DijkstraInfo(v) for v in grafo.vertices.values()}
    def calcular_menor_caminho(self):
        self.info_vertices[self.origem].distancia = 0
        vertices_a_explorar = list(self.info_vertices.values())
        while vertices_a_explorar:
            vertices_a_explorar.sort(key = lambda x: x.distancia)
            vertice_atual = vertices_a_explorar.pop(0)
            for vizinho, peso in vertice_atual.vertice.vizinhos.items():
                nova_distancia = vertice_atual.distancia + peso
                if nova_distancia < self.info_vertices[vizinho].distancia:
                    self.info_vertices[vizinho].distancia = nova_distancia
                    self.info_vertices[vizinho].antecessor = vertice_atual.vertice
    def obter_caminho(self):
        caminho = []
        vertice_atual = self.destino
        while vertice_atual != self.origem:
            caminho.insert(0, vertice_atual.nome)
            vertice_atual = self.info_vertices[vertice_atual].antecessor

        caminho.insert(0, self.origem.nome)
        return caminho

# Exemplo de uso:
grafo = Grafo()
grafo.adicionar_vertice("Camaquã")
grafo.adicionar_vertice("Bagé")
grafo.adicionar_vertice("Pelotas")

grafo.definir_origem_destino("Bagé", "Camaquã")
grafo.adicionar_aresta("Camaquã", "Bagé", 5)
grafo.adicionar_aresta("Bagé", "Pelotas", 2)
grafo.adicionar_aresta("Pelotas", "Camaquã", 2)
grafo.imprimir_grafo()

dikstra = Dikstra(grafo, grafo.origem, grafo.destino)
dikstra.calcular_menor_caminho()
caminho = dikstra.obter_caminho()
print(f"Menor Caminho: {caminho}")
