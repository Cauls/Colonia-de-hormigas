import java.util.HashMap;

public class Mapa {
    public static final int ANCHO = 15;
    public static final int ALTO = 15;
    private final Posicion hormiguero;
    private final char[][] mapa;
    public static final char VACIO = '.';
    public static final char HORMIGUERO = 'H';
    private HashMap<String, Hormiga> hormigas;

    /**
     * Constructor de la clase mapa, inicializa el mapa, posiciona el hormiguero, y pide un hashmap de hormigas
     * @param hormigas
     */
    public Mapa(HashMap<String, Hormiga> hormigas) {
        this.mapa = new char[this.ANCHO][this.ALTO];
        this.hormiguero = new Posicion(this.ANCHO/2, this.ALTO/2);
        this.hormigas = hormigas;

        for(int i = 0; i < this.ANCHO; i++){
            for(int j = 0; j< this.ALTO; j++){
                this.mapa[i][j] = this.VACIO;
            }
        }

        mapa[this.hormiguero.getX()][this.hormiguero.getY()] = this.HORMIGUERO;
    }

    /**
     * Devuelve la posicion del hormiguero
     * @return
     */
    public Posicion getHormiguero() {
        return hormiguero;
    }

    /**
     * Comprueba que la posicion otorgada esté dentro de los limites
     * @param posicion
     * @return
     */
    public boolean dentroLimites(Posicion posicion){
        return posicion.dentroLimites(ANCHO, ALTO) && posicion != this.hormiguero;

    }

    /**
     * Comprueba que la posicion otorgada sea vacio
     * @param posicion
     * @return
     */
    public boolean esVacio(Posicion posicion){
        return mapa[posicion.getX()][posicion.getY()] == VACIO;
    }

    /**
     * Escrive el mapa por consola
     */
    public synchronized void mostrarMapa(){
        for(int i = 0; i < this.ANCHO; i++){
            for(int j = 0; j< this.ALTO; j++){
                System.out.print(this.mapa[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Prepara el mapa
     */
    public void prepararMapa(){
        for(int i = 0; i < this.ANCHO; i++){
            for(int j = 0; j< this.ALTO; j++){
                this.mapa[i][j] = this.VACIO;
            }
        }
        mapa[hormiguero.getX()][hormiguero.getY()] = this.HORMIGUERO;
        for (Hormiga h : this.hormigas.values()){
            mapa[h.getPosicion().getX()][h.getPosicion().getY()] = h.getTipo().getSimbolo();
        }

    }

}
