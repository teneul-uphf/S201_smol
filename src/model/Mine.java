package model;

public class Mine implements Lieu {

    private int stock;

    public Mine(int stock) {
        this.stock = stock;
    }

    public void extraire() {
        this.stock--;
    }
}
