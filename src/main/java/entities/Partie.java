package entities;

public class Partie {

    private Joueur joueurA;
    private Joueur joueurB;

    public Partie(Joueur joueurA, Joueur joueurB) {
        this.joueurA = joueurA;
        this.joueurB = joueurB;
    }

    public void setJoueurA(Joueur joueurA) {
        this.joueurA = joueurA;
    }

    public void setJoueurB(Joueur joueurB) {
        this.joueurB = joueurB;
    }

    public Joueur getJoueurA() {
        return this.joueurA;
    }

    public Joueur getJoueurB() {
        return this.joueurB;
    }


}
