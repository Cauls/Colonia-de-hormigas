public enum TipoHormiga {
    OBRERA('O', "Hormiga Obrera"),
    GUERRERA('G', "Hormiga Guerrera"),
    REINA('R', "Hormiga Reina");

    private final char simbolo;
    private final String nombre;

    TipoHormiga(char simbolo, String nombre) {
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }
}
