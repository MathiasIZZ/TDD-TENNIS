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

    public void GagnePoint(Joueur joueurGagnant) {
        if (joueurGagnant.getScore().equals("0")) {
            joueurGagnant.setScore("15");
        }
        else if (joueurGagnant.getScore().equals("15")) {
            joueurGagnant.setScore("30");
        }
        else if (joueurGagnant.getScore().equals("30")) {
            joueurGagnant.setScore("40");
        }
        else {
            Joueur joueurPerdant;
            if(joueurGagnant.equals(joueurA))
            {
                joueurPerdant = joueurB;
            }
            else
            {
                joueurPerdant = joueurA;
            }
            if(joueurGagnant.isAvantage() == false && joueurPerdant.isAvantage() == false) {
                joueurGagnant.setAvantage(true);
            }
        }
    }
}
