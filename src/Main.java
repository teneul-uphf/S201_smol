import model.Jeu;
import view.AffichageCLI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("smol miner\n");

        Jeu jeu=new Jeu(5,5);
        AffichageCLI.afficher(jeu);
    }
}