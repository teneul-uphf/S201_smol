package players;

import model.*;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;


public class JoueurIA implements Joueur{

    private Robot robot;
    private Lieu destinationCible = null;

    @Override
    public Action getAction(Jeu jeu) {
        return Action.BOUGER;
    }

    @Override
    public Direction getDirection(Jeu jeu) {

        // Définit quel robot et quel objectif

        if (this.destinationCible == null || this.robot == null){
            this.destinationCible = jeu.getLaMine();
            this.robot = jeu.getLeRobot();
        }






    }

    private List<Noeud> dijkstra(Jeu jeu){
        HashMap<Noeud, Integer> distances = new HashMap<>();
        HashMap<Noeud, Integer> precedents = new HashMap<>();
        PriorityQueue<Noeud> aExplorer = new PriorityQueue<>();

        // définition du noeud source et ajout aux distances

        Noeud source = new Noeud(this.robot.getNoLigne(), this.robot.getNoColonne()); //
        distances.put(source, 0);

        // initialisation des nœuds

        for (int noLigne = 0; noLigne < jeu.getHauteur(); noLigne++){

            for (int noColonne = 0; noColonne < jeu.getLargeur(); noColonne++){

                if (noLigne!=this.robot.getNoLigne() && noColonne!=this.robot.getNoColonne() &&
                        jeu.getLaGrille()[noLigne][noColonne].getLeType().isFranchissable()) {

                    Noeud n = new Noeud(noLigne, noColonne);
                    distances.put(n, null); // distance à la source inconnue
                    precedents.put(n, null); // noeud precedent inconnu
                }
            }
        }

        // exploration jusqu'à ce que l'objectif soit atteint

        boolean arrive = false;

        while (!arrive){

            // recherche des noeuds voisins à la source

            for (Noeud noeud : aExplorer)

            createNoeudsVoisins(jeu)

        }



    }

    private Noeud createNoeudVoisin(int noLigne, int noColonne, Jeu jeu){

        Noeud noeudVoisin = null;

        if (jeu.isNotHorsJeu(noLigne, noColonne)){

            if (jeu.getLaGrille()[noLigne][noColonne].isFranchissable()){
                noeudVoisin = new Noeud(noLigne, noColonne);
            }
        }
        return noeudVoisin;
    }

    private PriorityQueue<Noeud> createNoeudsVoisins(int noLigne, int noColonne, Jeu jeu) {
        PriorityQueue<Noeud> noeudsVoisins = new PriorityQueue<>();

        int noLigneHaut = noLigne - 1;
        int noLigneBas = noLigne + 1;
        int noColonneGauche = noColonne - 1;
        int noColonneDroite = noColonne + 1;

        // haut
        if(createNoeudVoisin(noLigneHaut, noColonne, jeu)!=null)
            noeudsVoisins.add(createNoeudVoisin(noLigneHaut, noColonne, jeu));

        // bas
        if(createNoeudVoisin(noLigneBas, noColonne, jeu)!=null)
            noeudsVoisins.add(createNoeudVoisin(noLigneBas, noColonne, jeu));

        // gauche
        if(createNoeudVoisin(noLigne, noColonneGauche, jeu)!=null)
            noeudsVoisins.add(createNoeudVoisin(noLigne, noColonneGauche, jeu));

        // droite
        if(createNoeudVoisin(noLigne, noColonneDroite, jeu)!=null)
            noeudsVoisins.add(createNoeudVoisin(noLigne, noColonneDroite, jeu));

        return noeudsVoisins;
    }
}
