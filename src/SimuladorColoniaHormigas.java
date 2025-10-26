import java.util.HashMap;
import java.util.Random;

public class SimuladorColoniaHormigas extends Thread{
    private static final int NUMERO_OBRERAS = 4,INTERVALO_ACTUALIZACION = 1;
    private static final int[][] DIRECCIONES = {
    {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private Mapa mapa;
    private HashMap<String, Hormiga> hormigas;
    private volatile boolean simulacionActiva;
    private final Random random = new Random();

    /**
     * Constructor de la clase SimuladorColoniaHormigas
     * @param mapa
     * @param hormigas
     */
    public SimuladorColoniaHormigas( Mapa mapa, HashMap<String, Hormiga> hormigas) {
        this.mapa = mapa;
        this.hormigas = hormigas;
        this.simulacionActiva = false;
    }

    /**
     * Metodo que genera hormigas obreras y las añade al HashMap de hormigas
     */
    public void generarHormigaObrera(){
        for (int i = 0; i < NUMERO_OBRERAS; i++) {
            Posicion pos = new Posicion(random.nextInt(15), random.nextInt(15));
            while(!mapa.dentroLimites(pos)){
                pos = new Posicion(random.nextInt(15), random.nextInt(15));
            }
            hormigas.put(Integer.toString(i),new HormigaObrera(Integer.toString(i), pos));
        }
    }

    /**
     * Metodo que inicia la simulacion
     */
    public void ejecutar(){
        generarHormigaObrera();
        simulacionActiva = true;
        actualizarVisualizacion();
    }

    /**
     * Detiene las hormigas una a una y luego detiene la simulacion
     */
    public void detenerSimulacion(){
        for(Hormiga h : hormigas.values()){
            h.detener();
        }
        simulacionActiva = false;
    }

    /**
     * Contiene el bucle que se encarga de hacer que la simulacion funcione
     */
    private void actualizarVisualizacion(){
        while(simulacionActiva){
            limpiarConsola();
            moverTodasLasHormigas();
            mapa.mostrarMapa();
            try {
                //noinspection BusyWait
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            mostrarEstadisticas();
        }
    }

    /**
     * Recorre el hashmap moviendo cada hormiga
     */
    private synchronized void moverTodasLasHormigas(){
        for (Hormiga h : hormigas.values()){
            moverHormigaAleatoriamente(h);
            mapa.prepararMapa();
        }
    }

    /**
     * Mueve una hormiga en una direccion, asegurandose de que en esa posicion no haya una hormiga o el hormiguero en si
     * @param hormiga
     */
    private synchronized void moverHormigaAleatoriamente(Hormiga hormiga){
        int movimiento = 0;
        do {
            movimiento = random.nextInt(4);
        }while(!mapa.dentroLimites(hormiga.posicion.mover(DIRECCIONES[movimiento][0], DIRECCIONES[movimiento][1])) || !mapa.esVacio(hormiga.posicion.mover(DIRECCIONES[movimiento][0], DIRECCIONES[movimiento][1])));
        hormiga.posicion = hormiga.posicion.mover(DIRECCIONES[movimiento][0], DIRECCIONES[movimiento][1]);
    }

    /**
     * Intento de limpiar la consola
     */
    private void limpiarConsola(){
        System.out.print("\033[H\033[2J");
    }

    /**
     * Muestra cuantas hormigas estan activas y donde esta el hormiguero
     */
    private void mostrarEstadisticas(){
        System.out.println("Estadisticas");
        System.out.println("Hormigas activas: " + hormigas.size());
        System.out.println("Posicion del hormiguero:" + this.mapa.getHormiguero().getX() + " " + this.mapa.getHormiguero().getY());
    }
}