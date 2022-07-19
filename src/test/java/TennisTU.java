import entities.Joueur;
import entities.Partie;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TennisTU {

    Joueur JoueurA = new Joueur("Mathias");
    Joueur joueurB = new Joueur("Karan");
    Partie laPartie = new Partie(JoueurA, joueurB);


    @Test
    @DisplayName("Un utilisateur peut créer une nouvelle partie.")
    public void CreatePartie() {
        assertInstanceOf(Partie.class, this.laPartie);
    }

    @Test
    @DisplayName("Un utilisateur peut choisir les 2 joueurs qui jouerons la partie.")
    public void createPartieWithPlayers() {
        this.laPartie.setJoueurA(new Joueur("Mathias"));
        this.laPartie.setJoueurB(new Joueur("Karan"));

        assertInstanceOf(Partie.class, this.laPartie);
    }

    @Test
    @DisplayName("Au début de la partie les deux joueurs ont 0 points.")
    public void initializePartie() {

//        this.laPartie.getJoueurA().setScore("0");
//        this.laPartie.getJoueurB().setScore("0");

        assertEquals("0", this.laPartie.getJoueurA().getScore());
        assertEquals("0", this.laPartie.getJoueurB().getScore());
    }

    @Test
    @DisplayName("Quand un joueur gagne un point, il passe de 0 à 15.")
    public void partie15Points() {

//        this.laPartie.getJoueurA().setScore("0");
//        this.laPartie.getJoueurB().setScore("15");
//
//        assertEquals("15", this.laPartie.getJoueurB().getScore());

        this.laPartie.getJoueurA().setScore("0");
        this.laPartie.GagnePoint(this.laPartie.getJoueurA());

        assertEquals("15", this.laPartie.getJoueurA().getScore());
    }

    @Test
    @DisplayName("Quand un joueur gagne un point, il passe de 15 à 30.")
    public void partie30Points() {

//        this.laPartie.getJoueurA().setScore("15");
//        this.laPartie.getJoueurB().setScore("15");
//        this.laPartie.getJoueurB().setScore("30");
//
//        assertEquals("30", this.laPartie.getJoueurB().getScore());

        this.laPartie.getJoueurA().setScore("15");
        this.laPartie.GagnePoint(this.laPartie.getJoueurA());

        assertEquals("30", this.laPartie.getJoueurA().getScore());
    }

    @Test
    @DisplayName("Quand un joueur gagne un point, il passe de 30 à 40.")
    public void partie40Points() {

//        this.laPartie.getJoueurA().setScore("30");
//        this.laPartie.getJoueurB().setScore("30");
//        this.laPartie.getJoueurB().setScore("40");
//
//        assertEquals("40", this.laPartie.getJoueurB().getScore());

        this.laPartie.getJoueurA().setScore("30");
        this.laPartie.GagnePoint(this.laPartie.getJoueurA());

        assertEquals("40", this.laPartie.getJoueurA().getScore());
    }


    @Test
    @DisplayName("Si les deux joueurs sont a egalité a 40 points, si aucun joueur a un avantage, le joueur qui gagne le point gagne un avantage.")
    public void avantageAfterEquality() {

//        this.laPartie.getJoueurA().setScore("40");
//        this.laPartie.getJoueurB().setScore("40");
//
//        this.laPartie.getJoueurB().setScore("ADV");
//
//        assertEquals("ADV", this.laPartie.getJoueurB().getScore());
        this.laPartie.getJoueurA().setScore("40");
        this.laPartie.getJoueurB().setScore("40");

        this.laPartie.GagnePoint(this.laPartie.getJoueurA());

        assertEquals(true, this.laPartie.getJoueurA().isAvantage());
    }

    @Test
    @DisplayName("Si les deux joueurs sont a egalité a 40 points, si le perdant a un avantage, alors il le perd.")
    public void lostAvantageAfterEquality() {

//        this.laPartie.getJoueurA().setScore("40");
//
//        this.laPartie.getJoueurB().setScore("40");
//        this.laPartie.getJoueurB().setScore("ADV");
//        this.laPartie.getJoueurB().setScore("40");
//
//        assertEquals("40", this.laPartie.getJoueurB().getScore());
        this.laPartie.getJoueurA().setScore("40");
        this.laPartie.getJoueurB().setScore("40");
        this.laPartie.getJoueurB().setAvantage(true);

        this.laPartie.GagnePoint(this.laPartie.getJoueurA());

        assertEquals(false, this.laPartie.getJoueurB().isAvantage());
    }

    @Test
    @DisplayName("Si les deux joueurs sont a egalité a 40 points, si le gagnant a un avantage, alors il gagne le jeu.")
    public void getPointAfterADV() {

//        this.laPartie.getJoueurA().setScore("40");
//
//        this.laPartie.getJoueurB().setScore("ADV");
//        this.laPartie.getJoueurB().setScore("1");
//
//        assertEquals("1", this.laPartie.getJoueurB().getScore());
        this.laPartie.getJoueurA().setScore("40");
        this.laPartie.getJoueurB().setScore("40");
        this.laPartie.getJoueurA().setAvantage(true);

        this.laPartie.GagnePoint(this.laPartie.getJoueurA());

        assertEquals(1, this.laPartie.getJoueurA().getNombreSet());
    }

    @Test
    @DisplayName("Quand un jeu est gagné, alors les deux joueurs retournent à 0 point.")
    public void reinitJeuAfterGetPoint() {

        this.laPartie.getJoueurB().setScore("1");

        this.laPartie.getJoueurA().setScore("0");
        this.laPartie.getJoueurB().setScore("0");

        assertEquals("0", this.laPartie.getJoueurB().getScore());
    }













}
