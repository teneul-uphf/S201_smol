package model;

import static model.TypeCellule.EAU;
import static model.TypeCellule.SOL;

public class Cellule {

    private final TypeCellule leType;
    private Robot leRobot;
    private Lieu leLieu;

    // Constructeur case sol vide

    public Cellule() {
        this.leType = SOL;
        this.leRobot = null;
        this.leLieu = null;
    }

    // Constructeur pour l'eau

    public Cellule(TypeCellule type) {
        this.leType = type;
        this.leRobot = null;
        this.leLieu = null;
    }

    // Getters

    public Lieu getLeLieu() {
        return leLieu;
    }

    public Robot getLeRobot() {
        return leRobot;
    }

    public TypeCellule getLeType() {
        return leType;
    }

    // Setters

    public void setLeLieu(Lieu leLieu) {
        this.leLieu = leLieu;
    }

    public void setLeRobot(Robot leRobot) {
        this.leRobot = leRobot;
    }

    // Méthodes publiques

    public boolean isFranchissable(){
        return (!(leType==EAU || leRobot != null));
    }
}
