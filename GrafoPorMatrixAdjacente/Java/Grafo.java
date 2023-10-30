import java.util.ArrayList;
import java.util.List;

public class Grafo{
    private List<Integer> vertices;
    private int[][] matrizAdjacencia;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.matrizAdjacencia = new int[20][20];
    }

    public void adicionarVertice(int vertice) {
        if (vertice >= 0 && vertices.size() < 20) {
            vertices.add(vertice);
        } else {
            System.out.println("Vértice inválido ou limite máximo atingido");
        }
    }

    public void adicionarAresta(int verticeOrigem, int verticeDestino, int peso) {
        if (vertices.contains(verticeOrigem) && vertices.contains(verticeDestino)) {
            int indiceOrigem = vertices.indexOf(verticeOrigem);
            int indiceDestino = vertices.indexOf(verticeDestino);
            matrizAdjacencia[indiceOrigem][indiceDestino] = peso;
            matrizAdjacencia[indiceDestino][indiceOrigem] = peso;
        } else {
            System.out.println("Vértice de origem ou destino inválido");
        }
    }

    public void visualizarGrafo() {
        System.out.println("Matriz de Adjacência:");
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

}