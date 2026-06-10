package players;

import model.Action;
import model.Direction;
import model.Jeu;

import java.util.Scanner;

import static model.Action.*;
import static model.Direction.*;

public class JoueurHumain implements Joueur{

    public Action getAction(Jeu jeu){

        Action action = null;

        while (action == null){

            System.out.println("Choix de l'action");
            System.out.println("b : bouger\td : déposer\tm : miner\tp : passer");
            System.out.print("Votre choix : ");

            Scanner scannerAction = new Scanner(System.in);
            String entreeAction = scannerAction.next();

            switch (entreeAction){
                case "b"    -> action = BOUGER;
                case "d"    -> action = DEPOSER;
                case "m"    -> action = MINER;
                case "p"    -> action = PASSER;
                default     -> System.out.println("Entrée invalide !");
            }
        }

        return action;
    }

    public Direction getDirection(Jeu jeu){
        Direction direction = null;

        while (direction == null){

            System.out.println("Choix de la direction");
            System.out.println("z,q,s,d -> haut, gauche, bas, droite");
            System.out.print("Votre choix : ");

            Scanner scannerDirection = new Scanner(System.in);
            String entreeDirection = scannerDirection.next();

            switch (entreeDirection){
                case "z"    -> direction = UP;
                case "s"    -> direction = DOWN;
                case "q"    -> direction = LEFT;
                case "d"    -> direction = RIGHT;
                default     -> System.out.println("Entrée invalide !");
            }
        }

        return direction;
    }
}
