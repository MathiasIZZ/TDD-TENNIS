package entities;

public class Joueur {

    private String name;
    private int score;

    private boolean avantage;

    private int nombreSet;

    public Joueur(String name) {
        this.name = name;
        this.score = 0;
        this.avantage = false;
        this.nombreSet = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvantage() {
        return avantage;
    }

    public void setAvantage(boolean avantage) {
        this.avantage = avantage;
    }

    public int getNombreSet() {
        return nombreSet;
    }

    public void setNombreSet(int nombreSet) {
        this.nombreSet = nombreSet;
    }
}