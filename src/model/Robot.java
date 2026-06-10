package model;

public class Robot {

    private int capacite;
    private int stock;

    public Robot(int capacité) {
        this.capacite = capacité;
        this.stock = 0;
    }

    // Getters

    public int getCapacite() {
        return capacite;
    }

    public int getStock() {
        return stock;
    }

    public void miner(Mine mine){
        mine.extraire();
        this.stock++;
    }

    public void vider(Entrepot entrepot){
        entrepot.deposer();
        this.stock--;
    }
}
