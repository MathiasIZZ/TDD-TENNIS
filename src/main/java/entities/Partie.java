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

    public void gagnePoint(Joueur joueurGagnant) {
        if (joueurGagnant.getScore() == 0 && !joueurGagnant.isJeuDecisif()) {
            joueurGagnant.setScore(15);
        }
        else if (joueurGagnant.getScore() == 15) {
            joueurGagnant.setScore(30);
        }
        else if (joueurGagnant.getScore() == 30) {
            joueurGagnant.setScore(40);
        }
        else {
            Joueur joueurPerdant;
            if (joueurGagnant.equals(joueurA)) {
                joueurPerdant = joueurB;
            } else {
                joueurPerdant = joueurA;
            }
            if (!joueurGagnant.isAvantage() && !joueurPerdant.isAvantage()) {
                joueurGagnant.setAvantage(true);
            } else if (joueurPerdant.isAvantage()) {
                joueurPerdant.setAvantage(false);
            } else if (joueurGagnant.isAvantage()) {
                joueurGagnant.setScore(0);
                joueurPerdant.setScore(0);
                joueurGagnant.setNombreJeu(joueurGagnant.getNombreJeu() + 1);

                if (joueurGagnant.getNombreJeu() == 6 && joueurPerdant.getNombreJeu() <= 4) {
                    joueurGagnant.setNombreSet(joueurGagnant.getNombreSet() + 1);
                }
                else if (joueurGagnant.getNombreJeu() == 7 && joueurPerdant.getNombreJeu() == 5) {
                    joueurGagnant.setNombreSet(joueurGagnant.getNombreSet() + 1);
                }
                else if (joueurGagnant.getNombreJeu() == joueurPerdant.getNombreJeu()) {
                    joueurGagnant.setJeuDecisif(true);
                    joueurPerdant.setJeuDecisif(true);
                }
            }
            if(joueurGagnant.isJeuDecisif() && joueurPerdant.isJeuDecisif()) {
                if (joueurGagnant.getScore() < 7) {
                    joueurGagnant.setScore(joueurGagnant.getScore() + 1);
                }
            }
        }
    }
}
