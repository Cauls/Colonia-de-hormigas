import java.util.HashMap;
import java.util.Random;

public class SimuladorColoniaHormigas {
    private static final int NUMERO_OBRERAS = 4,INTERVALO_ACTUALIZACION = 1;
    private static final int[][] DIRECCIONES = {
    {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private Mapa mapa;
    private HashMap<String, Hormiga> hormigas;
    private volatile boolean simulacionActiva;
    private final Random random = new Random();

    public SimuladorColoniaHormigas( Mapa mapa, HashMap<String, Hormiga> hormigas) {
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
        for(Hormiga h : hormigas.values()){
            h.detener();
        }
        simulacionActiva = false;
    }

    private void actualizarVisualizacion(){

    }

    private synchronized void moverTodasLasHormigas(){
        for (Hormiga h : hormigas.values()){
            moverHormigaAleatoriamente(h);
        }
    }

    private synchronized void moverHormigaAleatoriamente(Hormiga hormiga){
        int movimiento = random.nextInt(3);
        hormiga.posicion.mover(DIRECCIONES[movimiento][0], DIRECCIONES[movimiento][1]);
    }

    private void limpiarConsola(){
        System.out.println("Limpiando consola");
        for (this.mapa.) {}
    }

    private void mostrarEstadisticas(){
        System.out.println("Estadisticas");
        System.out.println("Hormigas activas: " + hormigas.size());
        System.out.println("Posicion del hormiguero:" + this.mapa.getHormiguero());

    }
}