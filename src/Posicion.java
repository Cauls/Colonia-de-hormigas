public class Posicion {
    private final int x;
    private final int y;

    /**
     * Constructor de la clase Posicion
     * @param x
     * @param y
     */
    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Devuelve la posicion en el eje x
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Devuelve la posicion en el eje y
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Devuelve true si la posicion esta dentro de los ejes otorgados
     * @param maxX
     * @param maxY
     * @return
     */
    public boolean dentroLimites(int maxX, int maxY){
        return this.x < maxX && this.y < maxY && this.x >= 0 && this.y >= 0;
    }

    /**
     * Modifica la posicion en proporcion a los valores que se le ortorguen
     * @param deltaX
     * @param deltaY
     * @return
     */
    public Posicion mover(int deltaX, int deltaY){
        return new Posicion(this.x + deltaX, this.y + deltaY);
    }
}
