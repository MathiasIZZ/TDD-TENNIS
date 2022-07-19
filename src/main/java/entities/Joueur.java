package entities;

public class Joueur {

    private String name;
    private String score;

    public Joueur(String name) {
        this.name = name;
        this.score = "0";
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}