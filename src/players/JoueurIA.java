package players;

import model.*;
import java.util.*;

import static model.Direction.*;


public class JoueurIA implements Joueur{

    private Robot robot;
    private Noeud noeudCible = null;
    private Deque<Noeud> itineraire = null;

    @Override
    public Action getAction(Jeu jeu) {

        // Définit quel robot et quel objectif
        if (this.robot == null)
            this.robot = jeu.getLeRobot();

        if (this.noeudCible == null)
            this.noeudCible = new Noeud(jeu.getLaMine().getNoLigne(), jeu.getLaMine().getNoColonne());

        // Vérifie s'il n'est pas déjà arrivé
        if (robot.getNoLigne() == this.noeudCible.noLigne() && robot.getNoColonne() == this.noeudCible.noColonne())
            return Action.PASSER;

        else return Action.BOUGER;
    }

    @Override
    public Direction getDirection(Jeu jeu) {

        // Crée l'itinéraire s'il n'existe pas
        if (itineraire==null) itineraire = dijkstra(jeu);

        System.out.println("Itinéraire "+itineraire);

        Direction directionSuivante = noeudADirection(itineraire.removeFirst());
        System.out.println(directionSuivante);
        System.out.println(directionSuivante);
        return directionSuivante;
    }

    private Direction noeudADirection(Noeud noeud){

        // Gauche ou droite
        if (noeud.noLigne() == this.robot.getNoLigne()){
            if (noeud.noColonne()>this.robot.getNoColonne()) return RIGHT;
            else return LEFT;
        }
        // Haut ou bas
        else{
            if (noeud.noLigne()>this.robot.getNoLigne()) return DOWN;
            else return UP;
        }
    }

    private Deque<Noeud> dijkstra(Jeu jeu){

        HashMap<Noeud, Integer> distances = new HashMap<>();
        HashMap<Noeud, Noeud> precedents = new HashMap<>();
        Deque<Noeud> aExplorer = new ArrayDeque<>();

        // définition du nœud source et ajout aux distances et à la queue à explorer
        Noeud source = new Noeud(this.robot.getNoLigne(), this.robot.getNoColonne()); //
        distances.put(source, 0);
        aExplorer.add(source); // ajout de source à la queue

        boolean arrive = false;

        // explorer chaque nœud de la queue à explorer

        while (!arrive && !aExplorer.isEmpty()){

            // dépiler aExplorer
            Noeud noeud = aExplorer.pollLast();
            System.out.println("Noeud exploré : "+noeud);

            // Ajouter les voisins non-visités à la pile à explorer

            Deque<Noeud> noeudsVoisins = createNoeudsVoisins(noeud.noLigne(), noeud.noColonne(), jeu);

            System.out.println("noeudsVoisins  "+ noeudsVoisins);

            while ((!arrive) && (!noeudsVoisins.isEmpty())){

                Noeud noeudVoisin = noeudsVoisins.pollLast();
                System.out.println("-" + noeudVoisin);

                if (distances.get(noeudVoisin)==null){

                    System.out.println("C'est null");

                    distances.put(noeudVoisin, distances.get(noeud)+1); // ajout au dico des distances
                    precedents.put(noeudVoisin, noeud); // ajout au dico des précédents
                    aExplorer.addFirst(noeudVoisin); // ajout du voisin dans la queue à explorer

                    assert noeudVoisin != null;
                    if (noeudVoisin.noLigne() == this.noeudCible.noLigne() && noeudVoisin.noColonne() == this.noeudCible.noColonne()){
                        System.out.println("Trouvé !");
                        System.out.println("precedents : "+precedents);
                        arrive=true;
                    }

                }
            }
        }

        // Création de la pile du chemin

        Deque<Noeud> itineraire = new ArrayDeque<>();

        Noeud n = noeudCible;
        itineraire.addFirst(n);

        while (precedents.get(n) != null){
            itineraire.addFirst(precedents.get(n));
            n = precedents.get(n);
        }

        itineraire.removeFirst(); // enlève la case de départ du robot

        return itineraire;
    }

    private Noeud createNoeudVoisin(int noLigne, int noColonne, Jeu jeu){ // OK

        Noeud noeudVoisin = null;

        if (jeu.isNotHorsJeu(noLigne, noColonne)){

            if (jeu.getLaGrille()[noLigne][noColonne].isFranchissable()){ // "if" dans un autre et non &&, car il est risqué (hors-range)
                noeudVoisin = new Noeud(noLigne, noColonne);
            }
        }
        System.out.println("+"+ noeudVoisin);
        return noeudVoisin;
    }

    private Deque<Noeud> createNoeudsVoisins(int noLigne, int noColonne, Jeu jeu) { //OK
        Deque<Noeud> noeudsVoisins = new ArrayDeque<>();

        int noLigneHaut = noLigne - 1;
        int noLigneBas = noLigne + 1;
        int noColonneGauche = noColonne - 1;
        int noColonneDroite = noColonne + 1;

        // haut

        System.out.println("voisin haut");
        if(createNoeudVoisin(noLigneHaut, noColonne, jeu)!=null)
            noeudsVoisins.addFirst(createNoeudVoisin(noLigneHaut, noColonne, jeu));

        // bas

        System.out.println("voisin bas");
        if(createNoeudVoisin(noLigneBas, noColonne, jeu)!=null)
            noeudsVoisins.addFirst(createNoeudVoisin(noLigneBas, noColonne, jeu));

        // gauche

        System.out.println("voisin gauche");
        if(createNoeudVoisin(noLigne, noColonneGauche, jeu)!=null)
            noeudsVoisins.addFirst(createNoeudVoisin(noLigne, noColonneGauche, jeu));

        // droite
        System.out.println("voisin droite");
        if(createNoeudVoisin(noLigne, noColonneDroite, jeu)!=null)
            noeudsVoisins.addFirst(createNoeudVoisin(noLigne, noColonneDroite, jeu));

        return noeudsVoisins;
    }
}
