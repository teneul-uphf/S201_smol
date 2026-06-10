package model;

public class Jeu {

    private Cellule[][] laGrille;

    public Jeu(int longueur, int hauteur){
        this.laGrille = new Cellule[hauteur][longueur];

        // Remplir la grille

        int nbRobots = 1;
        int nbMines = 1;
        int nbEntrepots = 1;
        int nbEau = 6;

        for (int noLigne=0; noLigne<hauteur; noLigne++){

            for (int noColonne=0; noColonne<hauteur; noColonne++){

                this.laGrille[noLigne][noColonne] = new Cellule();

            }


        }


    }



    public Cellule[][] getLaGrille() {
        return laGrille;
    }
}
