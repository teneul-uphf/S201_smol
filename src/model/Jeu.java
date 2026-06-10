package model;

import java.util.Random;

import static model.TypeCellule.EAU;

public class Jeu {

    private final int largeur;
    private final int hauteur;
    private final Cellule[][] laGrille;
    private final Random random = new Random();

    private final Robot leRobot;
    private final Mine laMine;
    private final Entrepot lEntrepot;

    private void creerCasesDeLaGrille(){
        for (int noLigne=0; noLigne<this.hauteur; noLigne++) {

            for (int noColonne = 0; noColonne < this.largeur; noColonne++) {

                if (random.nextInt(7) > 5) // une chance sur 6 d'avoir de l'eau
                    this.laGrille[noLigne][noColonne] = new Cellule(EAU);
                else
                    this.laGrille[noLigne][noColonne] = new Cellule();
            }
        }
    }

    private void ajouterALaGrille(Lieu lieu){

        boolean ajoute = false;

        while (!ajoute){
            int noLigne = random.nextInt(this.hauteur);
            int noColonne = random.nextInt(this.largeur);

            if (this.laGrille[noLigne][noColonne].getLeLieu() == null &&
                    this.laGrille[noLigne][noColonne].getLeType()!=EAU){

                this.laGrille[noLigne][noColonne].setLeLieu(lieu);
                ajoute = true;
            }
        }
    }

    private void ajouterALaGrille(Robot robot){

        boolean ajoute = false;

        while (!ajoute){
            int noLigne = random.nextInt(this.hauteur);
            int noColonne = random.nextInt(this.largeur);

            if (this.laGrille[noLigne][noColonne].getLeRobot() == null &&
                    this.laGrille[noLigne][noColonne].getLeType()!=EAU){

                this.laGrille[noLigne][noColonne].setLeRobot(robot);
                ajoute = true;
            }
        }
    }

    public Jeu(int largeur, int hauteur){

        this.largeur = largeur;
        this.hauteur = hauteur;
        this.laGrille = new Cellule[hauteur][largeur];

        this.leRobot=new Robot(5);
        this.lEntrepot=new Entrepot(10);
        this.laMine=new Mine(10);

        this.creerCasesDeLaGrille();
        this.ajouterALaGrille(laMine);
        this.ajouterALaGrille(lEntrepot);
        this.ajouterALaGrille(leRobot);
    }

    public Robot getLeRobot() {
        return leRobot;
    }

    public Mine getLaMine() {
        return laMine;
    }

    public Entrepot getlEntrepot() {
        return lEntrepot;
    }

    public Cellule[][] getLaGrille() {
        return laGrille;
    }
}
