package model;

public class Robot {

    private final int capacite;
    private int stock;
    private int noLigne;
    private int noColonne;

    public Robot(int capacite) {
        this.capacite = capacite;
        this.noLigne = -1;
        this.noColonne = -1;
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

    public int getNoLigne() {
        return noLigne;
    }

    public int getNoColonne() {
        return noColonne;
    }

    // Setters

    public void setCoordonnees(int noLigne, int noColonne){
        this.noLigne = noLigne;
        this.noColonne = noColonne;
    }
}
