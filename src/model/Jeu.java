package model;

import exceptions.WtfException;
import players.Joueur;
import view.AffichageCLI;

import java.util.Random;

import static model.Action.BOUGER;
import static model.TypeCellule.EAU;

public class Jeu {

    private final int largeur;
    private final int hauteur;
    private final Cellule[][] laGrille;
    private final Random random = new Random();

    private final Robot leRobot;
    private final Mine laMine;
    private final Entrepot lEntrepot;

    private final Joueur joueur;

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
                robot.setCoordonnees(noLigne, noColonne);
                ajoute = true;
            }
        }
    }

    public Jeu(int largeur, int hauteur, Joueur joueur){

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

        this.joueur = joueur;
    }

    // Getters

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

    // Méthodes privées

    private boolean isNotHorsJeu(int noLigne, int noColonne){
        // Renvoie true si les coordonnées sont hors terrain

        return (noLigne >= 0 && noLigne <= this.hauteur - 1 && noColonne >= 0 && noColonne <= this.largeur - 1);
    }

    // Méthodes publiques

    public void deplacer(Robot robot, Direction direction) throws WtfException {

        int noLigneDestination = robot.getNoLigne();
        int noColonneDestination = robot.getNoColonne();

        switch (direction){
            case UP -> noLigneDestination--;
            case DOWN -> noLigneDestination++;
            case LEFT -> noColonneDestination--;
            case RIGHT -> noColonneDestination++;
            default -> throw new WtfException("wtf");
        }

        System.out.print(isNotHorsJeu(noLigneDestination, noColonneDestination));

        if (isNotHorsJeu(noLigneDestination, noColonneDestination)){
            if(this.laGrille[noLigneDestination][noColonneDestination].isFranchissable()){
                this.laGrille[noLigneDestination][noColonneDestination].setLeRobot(robot);
                this.laGrille[robot.getNoLigne()][robot.getNoColonne()].setLeRobot(null);
                robot.setCoordonnees(noLigneDestination, noColonneDestination);
            }
        }

        else System.out.println("Déplacement impossible !");
    }

    public void tourDeJeu(){

        while (this.lEntrepot.getCapacite() > this.lEntrepot.getStock()){

            AffichageCLI.afficher(this);

            Action actionJoueur = this.joueur.getAction(this);

            if (actionJoueur == BOUGER){
                Direction directionJoueur = this.joueur.getDirection();
                deplacer(this.leRobot, directionJoueur);
            }
        }
    }
}
