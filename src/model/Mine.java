package model;

public class Mine implements Lieu {

    private int stock;
    private int noLigne;
    private int noColonne;

    public Mine(int stock) {
        this.stock = stock;
        this.noLigne = -1;
        this.noColonne = -1;
    }

    // Getters

    public int getStock() {
        return stock;
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

    // Méthodes publiques

    public void extraire() {
        this.stock--;
    }

}
