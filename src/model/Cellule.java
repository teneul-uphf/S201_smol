package model;

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

    // Constructeur avec robot

    public Cellule(Robot leRobot) {
        this.leType = SOL;
        this.leRobot = leRobot;
        this.leLieu = null;
    }

    // Constructeur avec lieu

    public Cellule(Lieu leLieu) {
        this.leType = SOL;
        this.leRobot = null;
        this.leLieu = leLieu;
    }

    // Constructeur avec robot et lieu

    public Cellule(Robot leRobot, Lieu leLieu) {
        this.leType = SOL;
        this.leRobot = leRobot;
        this.leLieu = leLieu;
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
}
