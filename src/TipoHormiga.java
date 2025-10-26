public enum TipoHormiga {
    OBRERA('O', "Hormiga Obrera"),
    GUERRERA('G', "Hormiga Guerrera"),
    REINA('R', "Hormiga Reina");

    private final char simbolo;
    private final String nombre;

    /**
     * Constructor de la clase TipoHormiga
     * @param simbolo
     * @param nombre
     */
    TipoHormiga(char simbolo, String nombre) {
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    /**
     * Getter de simbolo
     * @return
     */
    public char getSimbolo() {
        return simbolo;
    }

    /**
     * Getter de nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }
}
