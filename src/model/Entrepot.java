package model;

public class Entrepot implements Lieu {

    private final int capacite;
    private int stock;

    public Entrepot(int capacite) {
        this.capacite = capacite;
        this.stock=0;
    }

    // Getters

    public int getCapacite() {
        return capacite;
    }

    public int getStock() {
        return stock;
    }

    public void deposer() {
        this.stock++;
    }
}
