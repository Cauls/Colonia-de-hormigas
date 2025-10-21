import java.util.HashMap;
import java.util.Random;

public class SimuladorColoniaHormigas {
    private static final int NUMERO_OBRERAS = 4,INTERVALO_ACTUALIZACION = 1;
    private static final int[][] DIRECCIONES;
    private Mapa mapa;
    private HashMap<String, Hormiga> hormigas;
    private volatile boolean simulacionActiva;
    private final Random random;

    public SimuladorColoniaHormigas(Random random, Mapa mapa, HashMap<String, Hormiga> hormigas) {
        this.random = random;
        this.mapa = mapa;
        this.hormigas = hormigas;
        this.simulacionActiva = false;
    }

    public void generarHormigaObrera(){
        for (int i = 0; i < NUMERO_OBRERAS; i++) {
            hormigas.put(Integer.toString(i), new HormigaObrera(Integer.toString(i), new Posicion(0, i)));
        }

    }

    public void ejecutar(){
        simulacionActiva = true;
    }

    public void detenerSimulacion(){
        simulacionActiva = false;
    }

    private void actualizarVisualizacion(){

    }

    private synchronized void moverTodasLasHormigas(){

    }

    private synchronized void moverHormigaAleatoriamente(Hormiga hormiga){

    }

    private void limpiarConsola(){

    }

    private void mostrarEstadisticas(){

    }
}