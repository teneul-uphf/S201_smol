import model.Jeu;
import players.Joueur;
import players.JoueurHumain;
import players.JoueurIA;
import view.AffichageCLI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        System.out.println("smol miner\n");

        Joueur joueur = new JoueurIA();
        Jeu jeu=new Jeu(5,5, joueur);

        while (jeu.getLeRobot().getNoLigne() !=jeu.getLaMine().getNoLigne() || jeu.getLeRobot().getNoColonne() !=jeu.getLaMine().getNoColonne()) {
            jeu.tourDeJeu();
        }

        AffichageCLI.afficher(jeu);
        System.out.println("Bravo, vous avez épuisé les ressource de ce monde.");

    }
}