package players;

import model.*;

import java.util.PriorityQueue;


public class JoueurIA implements Joueur{

    private Robot robot;
    private Lieu destination = null;

    @Override
    public Action getAction(Jeu jeu) {
        return Action.BOUGER;
    }

    @Override
    public Direction getDirection(Jeu jeu) {


        if (this.destination == null || this.robot == null){
            this.destination = jeu.getLaMine();
            this.robot = jeu.getLeRobot();
        }




    }
}
