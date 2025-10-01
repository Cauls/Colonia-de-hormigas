import java.util.HashMap;

public class Mapa {
    public static final int ANCHO;
    public static final int ALTO;
    private final Posicion hormiguero;
    private final char[][] mapa;
    public static final char VACIO;
    public static final char HORMIGUERO;

    public Mapa(char[][] mapa, Posicion hormiguero) {
        this.mapa = mapa;
        this.hormiguero = hormiguero;
    }

    public Posicion getHormiguero() {
        return hormiguero;
    }

    public boolean dentroLimites(Posicion posicion){
    }

    public synchronized void mostrarMapa(){

    }

    public void prepararMapa(HashMap<String, Hormiga> hormigas){

    }
}
