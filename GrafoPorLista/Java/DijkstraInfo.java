import java.util.HashMap;
import java.util.Map;

public class DijkstraInfo{
    private Vertice vertice;
    private double distancia;
    private Vertice antecessor;

  
    public DijkstraInfo(Vertice vertice) {
        this.vertice = vertice;
        this.distancia = Double.POSITIVE_INFINITY;
        this.antecessor = null;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Vertice getAntecessor() {
        return antecessor;
    }

    public void setAntecessor(Vertice antecessor) {
        this.antecessor = antecessor;
    }
}