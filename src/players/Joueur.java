package players;

import model.Action;
import model.Direction;
import model.Jeu;

public interface Joueur {

    Action getAction(Jeu jeu);
    Direction getDirection();
}
