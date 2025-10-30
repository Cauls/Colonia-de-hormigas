public class HormigaObrera extends Hormiga{

    /**
     * Constructor de la clase HormigaObrera
     * @param id
     * @param posicionIncial
     */
    public HormigaObrera(String id, Posicion posicionIncial, SimuladorColoniaHormigas simulador) {
        super(id, TipoHormiga.OBRERA, posicionIncial, simulador);
    }

    /**
     * El metodo run de la clase hormiga, arranca la hormiga y hace que ella solita se mueva periodicamente
     */
    @Override
    public void run(){
        activa = true;
        while (activa) {
            simulador.moverHormigaAleatoriamente(this);
            try {
                Thread.sleep(random.nextInt(10, 5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
