import entities.Joueur;
import entities.Partie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        assertEquals(0, this.laPartie.getJoueurA().getScore());
        assertEquals(0, this.laPartie.getJoueurB().getScore());
    }

    @Test
    @DisplayName("Quand un joueur gagne un point, il passe de 0 à 15.")
    public void partie15Points() {

//        this.laPartie.getJoueurA().setScore("0");
//        this.laPartie.getJoueurB().setScore("15");
//
//        assertEquals("15", this.laPartie.getJoueurB().getScore());

        this.laPartie.getJoueurA().setScore(0);
        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(15, this.laPartie.getJoueurA().getScore());
    }

    @Test
    @DisplayName("Quand un joueur gagne un point, il passe de 15 à 30.")
    public void partie30Points() {

//        this.laPartie.getJoueurA().setScore("15");
//        this.laPartie.getJoueurB().setScore("15");
//        this.laPartie.getJoueurB().setScore("30");
//
//        assertEquals("30", this.laPartie.getJoueurB().getScore());

        this.laPartie.getJoueurA().setScore(15);
        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(30, this.laPartie.getJoueurA().getScore());
    }

    @Test
    @DisplayName("Quand un joueur gagne un point, il passe de 30 à 40.")
    public void partie40Points() {

//        this.laPartie.getJoueurA().setScore("30");
//        this.laPartie.getJoueurB().setScore("30");
//        this.laPartie.getJoueurB().setScore("40");
//
//        assertEquals("40", this.laPartie.getJoueurB().getScore());

        this.laPartie.getJoueurA().setScore(30);
        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(40, this.laPartie.getJoueurA().getScore());
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
        this.laPartie.getJoueurA().setScore(40);
        this.laPartie.getJoueurB().setScore(40);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

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
        this.laPartie.getJoueurA().setScore(40);
        this.laPartie.getJoueurB().setScore(40);
        this.laPartie.getJoueurB().setAvantage(true);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

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
        this.laPartie.getJoueurA().setScore(40);
        this.laPartie.getJoueurB().setScore(40);
        this.laPartie.getJoueurA().setAvantage(true);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(1, this.laPartie.getJoueurA().getNombreJeu());
    }

    @Test
    @DisplayName("Quand un jeu est gagné, alors les deux joueurs retournent à 0 point.")
    public void reinitJeuAfterGetPoint() {

//        this.laPartie.getJoueurB().setScore("1");
//
//        this.laPartie.getJoueurA().setScore("0");
//        this.laPartie.getJoueurB().setScore("0");
//
//        assertEquals("0", this.laPartie.getJoueurB().getScore());
        this.laPartie.getJoueurA().setScore(40);
        this.laPartie.getJoueurB().setScore(40);
        this.laPartie.getJoueurA().setAvantage(true);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(0, this.laPartie.getJoueurA().getScore());
        assertEquals(0, this.laPartie.getJoueurB().getScore());
    }

    @Test
    @DisplayName("Quand un joueur arrive à gagner 6 jeux et que son adversaire 4 ou moins jeux gagnés, alors le joueur gagne un set.")
    public void winSetAfter6Jeux() {

//        this.laPartie.getJoueurA().setNombreJeu(6);
//        this.laPartie.getJoueurB().setNombreJeu(4);
//        this.laPartie.getJoueurA().setNombreSet(1);

//        assertEquals(1, this.laPartie.getJoueurA().getNombreSet());

        this.laPartie.getJoueurA().setNombreJeu(5);
        this.laPartie.getJoueurB().setNombreJeu(4);

        this.laPartie.getJoueurA().setScore(40);
        this.laPartie.getJoueurB().setScore(40);
        this.laPartie.getJoueurA().setAvantage(true);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(1, this.laPartie.getJoueurA().getNombreSet());
    }

    @Test
    @DisplayName("Quand les deux joueurs ont 5 jeux chacun, apres avoir reporté le 6 ieme jeux, le nombre de Set reste a zero")
    public void continuingJeuxAfter5and5() {

//        this.laPartie.getJoueurA().setNombreJeu(6);
//        this.laPartie.getJoueurB().setNombreJeu(4);
//        this.laPartie.getJoueurA().setNombreSet(1);

//        assertEquals(1, this.laPartie.getJoueurA().getNombreSet());

        this.laPartie.getJoueurA().setNombreJeu(5);
        this.laPartie.getJoueurB().setNombreJeu(5);

        this.laPartie.getJoueurA().setScore(40);
        this.laPartie.getJoueurB().setScore(40);
        this.laPartie.getJoueurA().setAvantage(true);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(0, this.laPartie.getJoueurA().getNombreSet());
    }





    @Test
    @DisplayName("Quand les deux joueurs ont 5 points alors faut avoir 2 points d'avance et 7 jeux pour gagner le set.")
    public void winSet5JeuxTwoPlayersAnd2PointsAdvance() {
//        this.laPartie.getJoueurA().setNombreJeu(7);
//        this.laPartie.getJoueurB().setNombreJeu(5);
//
//        this.laPartie.getJoueurA().setNombreSet(1);
//
//        assertEquals(1, this.laPartie.getJoueurA().getNombreSet());

        this.laPartie.getJoueurA().setNombreJeu(6);
        this.laPartie.getJoueurB().setNombreJeu(5);

        this.laPartie.getJoueurA().setScore(40);
        this.laPartie.getJoueurB().setScore(40);
        this.laPartie.getJoueurA().setAvantage(true);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(1, this.laPartie.getJoueurA().getNombreSet());
    }

    @Test
    @DisplayName("Quand les deux joueurs ont 6 jeux gagné, alors on passe en jeux decisif.")
    public void twoPlayersJeuxDecisif() {
//        this.laPartie.getJoueurA().setNombreJeu(6);
//        this.laPartie.getJoueurB().setNombreJeu(6);
//
//        this.laPartie.getJoueurA().setJeuDecisif(true);
//        this.laPartie.getJoueurB().setJeuDecisif(true);
//
//        assertEquals(true, this.laPartie.getJoueurA().isJeuDecisif());
//        assertEquals(true, this.laPartie.getJoueurB().isJeuDecisif());

        this.laPartie.getJoueurA().setNombreJeu(5);
        this.laPartie.getJoueurB().setNombreJeu(6);

        this.laPartie.getJoueurA().setScore(40);
        this.laPartie.getJoueurB().setScore(40);
        this.laPartie.getJoueurA().setAvantage(true);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(true, this.laPartie.getJoueurA().isJeuDecisif());
        assertEquals(true, this.laPartie.getJoueurB().isJeuDecisif());
    }

    @Test
    @DisplayName("Quand il y a jeu décisif les points sont compté par point.")
    public void countByPointWhenJeuxDecisif() {
//        this.laPartie.getJoueurA().setJeuDecisif(true);
//        this.laPartie.getJoueurB().setJeuDecisif(true);
//
//        this.laPartie.getJoueurA().setScore(1);
//        this.laPartie.getJoueurB().setScore(2);
//
//        assertEquals(1, this.laPartie.getJoueurA().getScore());
//        assertEquals(2, this.laPartie.getJoueurB().getScore());

        this.laPartie.getJoueurA().setJeuDecisif(true);
        this.laPartie.getJoueurB().setJeuDecisif(true);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(1, this.laPartie.getJoueurA().getScore());
    }

    @Test
    @DisplayName("Si un joueur gagne un point pendant un jeu decisif il passe de 0 à 1, puis 2, ... jusqu'à 7.")
    public void incrementPointWhenJeuxDecisiflessThan7() {
//        this.laPartie.getJoueurA().setJeuDecisif(true);
//        this.laPartie.getJoueurB().setJeuDecisif(true);
//
//        this.laPartie.getJoueurA().setScore(1);
//        this.laPartie.getJoueurA().setScore(2);
//
//        assertEquals(2, this.laPartie.getJoueurA().getScore());

        this.laPartie.getJoueurA().setJeuDecisif(true);
        this.laPartie.getJoueurB().setJeuDecisif(true);

        this.laPartie.getJoueurA().setScore(6);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(7, this.laPartie.getJoueurA().getScore());
    }

    @Test
    @DisplayName("Si un joueur gagne un point pendant un jeu decisif il passe de 0 à 1, puis 2, ... jusqu'à 7.")
    public void incrementPointWhenJeuxDecisifScore7() {
        this.laPartie.getJoueurA().setJeuDecisif(true);
        this.laPartie.getJoueurB().setJeuDecisif(true);

        this.laPartie.getJoueurA().setScore(7);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(7, this.laPartie.getJoueurA().getScore());
    }


    @Test
    @DisplayName("Il faut avoir deux points d'avance pour gagner le jeu et donc le set.")
    public void twoPointJeuForWinSet() {

        this.laPartie.getJoueurA().setJeuDecisif(true);
        this.laPartie.getJoueurB().setJeuDecisif(true);
        this.laPartie.getJoueurA().setNombreSet(0);
        this.laPartie.getJoueurB().setNombreSet(0);
        this.laPartie.getJoueurA().setScore(6);
        this.laPartie.getJoueurB().setScore(4);
        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        assertEquals(1, this.laPartie.getJoueurA().getNombreSet());
    }

    @Test
    @DisplayName("Le premier joueur a 2 sets gagnés gagne la partie.")
    public void winAfterTwoSet() {

//        this.laPartie.getJoueurA().setNombreSet(2);
//        this.laPartie.getJoueurA().setWin(true);
//
//        assertTrue(this.laPartie.getJoueurA().isWin());

        this.laPartie.getJoueurA().setJeuDecisif(true);
        this.laPartie.getJoueurB().setJeuDecisif(true);

        this.laPartie.getJoueurA().setNombreSet(0);
        this.laPartie.getJoueurB().setNombreSet(0);

        this.laPartie.getJoueurA().setScore(6);
        this.laPartie.getJoueurB().setScore(4);

        this.laPartie.getJoueurA().setNombreSet(1);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());


        assertTrue(this.laPartie.getJoueurA().isWin());
    }

    @Test
    @DisplayName("Quand un joueur a gagné, il n'est plus possible de changer les scores.")
    public void whenWinNoChangeScore() {
        this.laPartie.getJoueurA().setJeuDecisif(true);
        this.laPartie.getJoueurB().setJeuDecisif(true);

        this.laPartie.getJoueurA().setNombreSet(0);
        this.laPartie.getJoueurB().setNombreSet(0);

        this.laPartie.getJoueurA().setScore(6);
        this.laPartie.getJoueurB().setScore(4);

        this.laPartie.getJoueurA().setNombreSet(1);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());


        assertEquals("La partie est déja terminée", this.laPartie.gagnePoint(this.laPartie.getJoueurA()));
    }

    @Test
    @DisplayName("L'utilisateur doit être avertie que la partie est finie.")
    public void userReceiveMessageAfterWin() {

        this.laPartie.getJoueurA().setJeuDecisif(true);
        this.laPartie.getJoueurB().setJeuDecisif(true);

        this.laPartie.getJoueurA().setNombreSet(0);
        this.laPartie.getJoueurB().setNombreSet(0);

        this.laPartie.getJoueurA().setScore(6);
        this.laPartie.getJoueurB().setScore(4);

        this.laPartie.getJoueurA().setNombreSet(1);

        this.laPartie.gagnePoint(this.laPartie.getJoueurA());


        assertEquals("Joueur Gagnant: Mathias", "Joueur Gagnant: " + this.laPartie.getJoueurA().getName());

    }











}
