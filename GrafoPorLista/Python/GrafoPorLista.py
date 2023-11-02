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

    def adicionar_aresta(self, nome_origem, nome_destino, peso=0):
        if nome_origem in self.vertices and nome_destino in self.vertices:
            vertice_origem = self.vertices[nome_origem]
            vertice_destino = self.vertices[nome_destino]

            aresta = Aresta(vertice_origem, vertice_destino, peso)
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


# Exemplo de uso:
grafo = Grafo()
grafo.adicionar_vertice("Camaquã")
grafo.adicionar_vertice("Bagé")
grafo.adicionar_vertice("Pelotas")

grafo.adicionar_aresta("Camaquã", "Bagé", 5)
grafo.adicionar_aresta("Bagé", "Pelotas", 3)
grafo.adicionar_aresta("Pelotas", "Camaquã", 2)

grafo.imprimir_grafo()
