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

    public SimuladorColoniaHormigas( Mapa mapa, HashMap<String, Hormiga> hormigas) {
        this.mapa = mapa;
        this.hormigas = hormigas;
        this.simulacionActiva = false;
    }

    public void generarHormigaObrera(){
        for (int i = 0; i < NUMERO_OBRERAS; i++) {
            Posicion pos = new Posicion(random.nextInt(15), random.nextInt(15));
            while(!mapa.dentroLimites(pos)){
                pos = new Posicion(random.nextInt(15), random.nextInt(15));
            }
            hormigas.put(Integer.toString(i),new HormigaObrera(Integer.toString(i), pos));
        }
    }

    public void ejecutar(){
        generarHormigaObrera();
        simulacionActiva = true;
        actualizarVisualizacion();
    }

    public void detenerSimulacion(){
        for(Hormiga h : hormigas.values()){
            h.detener();
        }
        simulacionActiva = false;
    }

    private void actualizarVisualizacion(){
        while(simulacionActiva){
            limpiarConsola();
            moverTodasLasHormigas();
            mapa.mostrarMapa();
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            mostrarEstadisticas();
        }
    }

    private synchronized void moverTodasLasHormigas(){
        for (Hormiga h : hormigas.values()){
            moverHormigaAleatoriamente(h);
            mapa.prepararMapa();
        }
    }

    private synchronized void moverHormigaAleatoriamente(Hormiga hormiga){
        int movimiento = 0;
        do {
            movimiento = random.nextInt(4);
        }while(!mapa.dentroLimites(hormiga.posicion.mover(DIRECCIONES[movimiento][0], DIRECCIONES[movimiento][1])) || !mapa.esVacio(hormiga.posicion.mover(DIRECCIONES[movimiento][0], DIRECCIONES[movimiento][1])));
        hormiga.posicion = hormiga.posicion.mover(DIRECCIONES[movimiento][0], DIRECCIONES[movimiento][1]);
    }

    private void limpiarConsola(){
        System.out.print("\033[H\033[2J");
    }

    private void mostrarEstadisticas(){
        System.out.println("Estadisticas");
        System.out.println("Hormigas activas: " + hormigas.size());
        System.out.println("Posicion del hormiguero:" + this.mapa.getHormiguero().getX() + " " + this.mapa.getHormiguero().getY());
    }
}