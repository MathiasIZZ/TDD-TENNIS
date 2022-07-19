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











}
