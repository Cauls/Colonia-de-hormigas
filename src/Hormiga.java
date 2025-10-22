import java.util.Random;

public abstract class Hormiga extends Thread{
    protected final String id;
    protected final TipoHormiga tipo;
    protected volatile Posicion posicion;
    protected volatile boolean activa;
    protected final Random random = new Random();
    protected static final int[][] DIRECCIONES ={
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public Hormiga(String id, TipoHormiga tipo, Posicion posicionInicial){
        this.id = id;
        this.tipo = tipo;
        this.posicion = posicionInicial;
        activa = true;
    }

    @Override
    public String getId() {
        return id;
    }

    public TipoHormiga getTipo() {
        return tipo;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean isActiva(){
        return activa;
    }

    public void detener(){
        activa = false;
        Thread.
    }
}
