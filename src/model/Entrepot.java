package model;

public class Entrepot implements Lieu {

    private final int capacite;
    private int stock;
    private int noLigne;
    private int noColonne;

    public Entrepot(int capacite) {
        this.capacite = capacite;
        this.stock=0;
        this.noLigne = -1;
        this.noColonne = -1;
    }

    // Getters

    public int getStock() {
        return stock;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getNoLigne() {
        return noLigne;
    }

    public int getNoColonne() {
        return noColonne;
    }

    // Setters

    @Override
    public void setCoordonnees(int noLigne, int noColonne) {
        this.noLigne = noLigne;
        this.noColonne = noColonne;
    }

    // Méthodes publiques

    public void deposer() {
        this.stock++;
    }

}
