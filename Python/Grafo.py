class Grafo:
    def __init__(self):
        self.vertices = []
        self.matriz_adjacencia = []

    def adicionar_vertice(self, vertice):
        if vertice >= 0 and len(self.vertices) < 20:
            self.vertices.append(vertice)
            for linha in self.matriz_adjacencia:
                linha.append(0)
            nova_linha = [0] * len(self.vertices)
            self.matriz_adjacencia.append(nova_linha)

    def adicionar_aresta(self, vertice_origem, vertice_destino, peso):
        if vertice_origem in self.vertices and vertice_destino in self.vertices:
            indice_origem = self.vertices.index(vertice_origem)
            indice_destino = self.vertices.index(vertice_destino)
            self.matriz_adjacencia[indice_origem][indice_destino] = peso
            self.matriz_adjacencia[indice_destino][indice_origem] = peso

    def visualizar_grafo(self):
        print("Matriz de Adjacência:")
        for linha in self.matriz_adjacencia:
            print(linha)

# Exemplo de uso:
grafo = Grafo()
grafo.adicionar_vertice(1)
grafo.adicionar_vertice(2)
grafo.adicionar_vertice(3)
grafo.adicionar_aresta(1, 2, 5)
grafo.adicionar_aresta(2, 3, 8)
grafo.visualizar_grafo()
