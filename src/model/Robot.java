package model;

public class Robot {

    private int capacité;
    private int stock;

    public void miner(Mine mine){
        mine.extraire();
        this.stock++;
    }

    public void vider(Entrepot entrepot){
        entrepot.deposer();
        this.stock--;
    }
}
