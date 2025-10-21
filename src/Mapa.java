import java.util.HashMap;

public class Mapa {
    public static final int ANCHO = 15;
    public static final int ALTO = 15;
    private final Posicion hormiguero;
    private final char[][] mapa;
    public static final char VACIO = '.';
    public static final char HORMIGUERO = 'H';

    public Mapa() {
        this.mapa = new char[this.ANCHO][this.ALTO];
        this.hormiguero = new Posicion(this.ANCHO/2, this.ALTO/2);

        for(int i = 0; i < this.ANCHO; i++){
            for(int j = 0; j< this.ALTO; j++){
                this.mapa[i][j] = this.VACIO;
            }
        }

        mapa[this.hormiguero.getX()][this.hormiguero.getY()] = this.HORMIGUERO;
    }

    public Posicion getHormiguero() {
        return hormiguero;
    }

    public boolean dentroLimites(Posicion posicion){
        return posicion.dentroLimites(ANCHO, ALTO);
    }

    public synchronized void mostrarMapa(){
        for(int i = 0; i < this.ANCHO; i++){
            for(int j = 0; j< this.ALTO; j++){
                System.out.print(this.mapa[i][j] + " ");
            }
        }
    }

    public void prepararMapa(HashMap<String, Hormiga> hormigas){
        for(int i = 0; i < this.ANCHO; i++){
            for(int j = 0; j< this.ALTO; j++){
                this.mapa[i][j] = this.VACIO;
            }
        }
    }
}
