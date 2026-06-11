package players;

public record Noeud(int noLigne, int noColonne) implements Comparable<Noeud>{
    @Override


    public int compareTo(Noeud autre) {
        if (autre == null) throw new NullPointerException("Cannot compare with null");
        if (autre.noLigne == this.noLigne && autre.noColonne == this.noColonne) return 0;
        else return autre.noLigne -this.noLigne + autre.noColonne -this.noColonne -1000; // l'essentiel est que ça ne fasse pas zéro
    }
}
