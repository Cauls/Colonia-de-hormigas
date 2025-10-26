import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Hormiga> hormigas = new HashMap<>();
        Mapa mapa = new Mapa(hormigas);
        SimuladorColoniaHormigas simulacion = new SimuladorColoniaHormigas(mapa, hormigas);
        simulacion.ejecutar();
    }
}