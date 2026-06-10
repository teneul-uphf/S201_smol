package players;

import exceptions.WtfException;

public record  Node(int x, int y) implements Comparable<Node>{
    @Override


    public int compareTo(Node autre) {
        if (autre == null) throw new NullPointerException("Cannot compare with null");
        if (autre.x == this.x && autre.y == this.y) return 0;
        else return autre.x-this.x + autre.y-this.y -1000; // l'essentiel est que ça ne fasse pas zéro
    }
}
