import java.util.Random;

public abstract class Hormiga extends Thread{
    protected final String id;
    protected final TipoHormiga tipo;
    protected volatile Posicion posicion;
    protected volatile boolean activa;
    protected final Random random = new Random();
    protected static final int[][] DIRECCIONES ={
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    /**
     * Constructor de la clase hormiga
     * @param id
     * @param tipo
     * @param posicionInicial
     */
    public Hormiga(String id, TipoHormiga tipo, Posicion posicionInicial){
        this.id = id;
        this.tipo = tipo;
        this.posicion = posicionInicial;
        activa = true;
    }

    /**
     * Metodo run de la clase Hormiga
     */
    public void run(){
    }

    /**
     * Getter de IdHormiga
     * @return
     */
    public String getIdHormiga() {
        return id;
    }

    /**
     * Getter del tipo de la hormiga
     * @return
     */
    public TipoHormiga getTipo() {
        return tipo;
    }

    /**
     * Getter de la posicion de la hormiga
     * @return
     */
    public Posicion getPosicion() {
        return posicion;
    }

    /**
     * Devuelve true si la hormiga es activa
     * @return
     */
    public boolean isActiva(){
        return activa;
    }

    /**
     * Detiene la hormiga convirtiendo activa en falso
     */
    public void detener(){
        activa = false;
    }
}
