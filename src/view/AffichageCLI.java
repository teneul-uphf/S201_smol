package view;

import model.*;

import static model.TypeCellule.EAU;

public class AffichageCLI {

    public static void afficher(Jeu jeu){
        Cellule[][] grille = jeu.getLaGrille();

        afficher(grille);
        afficher(jeu.getLeRobot(), jeu.getLaMine(), jeu.getlEntrepot());
    }

    public static void afficher(Robot robot, Mine mine, Entrepot entrepot){
        System.out.println("---");
        System.out.println("Robot    | Stock : "+robot.getStock()+"/"+robot.getCapacite());
        System.out.println("Mine     | Stock : "+mine.getStock());
        System.out.println("Entrepot | Stock : "+entrepot.getStock()+"/"+entrepot.getCapacite());
    }

    public static String toString(Cellule cellule){
        String strCellule = "";

        if (cellule.getLeType()==EAU) return "XX";

        if (cellule.getLeRobot()==null) strCellule+=" ";
        else strCellule+="R";

        if (cellule.getLeLieu()==null) strCellule+=" ";
        else {
            switch (cellule.getLeLieu()){
                case Mine m     -> strCellule+="M";
                case Entrepot e -> strCellule+="E";
                case null       -> strCellule+=" ";
                default         -> strCellule+="?";
            }
        }
        return strCellule;
    }

    public static void afficher(Cellule[][] grille){

        int noLigne=0;
        int noColonne;

        // Entête

        for (noColonne=0; noColonne<grille[0].length;noColonne++){
            System.out.printf("  "+noColonne);
        }
        System.out.printf("\n");



        for (Cellule[] ligne : grille){

            System.out.printf(Integer.toString(noLigne++));
            for (Cellule cellule : ligne){
                System.out.printf("|"+toString(cellule));
            }
            System.out.printf("|\n");
        }

    }
}
