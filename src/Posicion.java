public class Posicion {
    private final int x;
    private final int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean dentroLimites(int maxX, int maxY){
        return this.x <= maxX && this.y <= maxY && this.x >= 0 && this.y >= 0;
    }

    public Posicion mover(int deltaX, int deltaY){
        return new Posicion(this.x + deltaX, this.y + deltaY);
    }
}
