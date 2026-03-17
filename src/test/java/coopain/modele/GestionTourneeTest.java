package coopain.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GestionTourneeTest {
    private Visite v1, v2;
    private TypePrestation tp1, tp2;
    private Tournee t1;
    private GestionTournee gt;

    @BeforeEach
    void setUp() {
        tp1 = new TypePrestation("Insémination", 100);
        tp2 = new TypePrestation("Echographie", 10);
        t1 = new Tournee();
        gt = new GestionTournee(t1);

        v1 = new Visite();
        v1.ajouterPrestationVisite(tp1, 3); // 300
        v1.ajouterPrestationVisite(tp2, 1); // 10

        v2 = new Visite();
        v2.ajouterPrestationVisite(tp1, 1); // 100
    }

    // Mission 4 : Test mathématique sur un parcours simple
    @Test
    void testCATournee() {
        assertEquals(0, gt.CATournee(), "Le CA initial doit être nul");

        gt.ajouterVisite(v1); // Doit faire 310
        assertEquals(310.0f, gt.CATournee());

        gt.ajouterVisite(v2); // Doit rajouter 100
        assertEquals(410.0f, gt.CATournee());
    }

    // Mission 5 : Fiabilisation TDD pour valider qu'un ajout de zéro ne change rien.
    @Test
    void testAjoutZeroActe() {
        Visite visiteZero = new Visite();
        visiteZero.ajouterPrestationVisite(tp2, 0); // 0 Echographie
        
        gt.ajouterVisite(visiteZero);
        
        assertEquals(0.0f, gt.CATournee(), "L'ajout de 0 acte ne doit pas augmenter le CA (Fiabilité M5)");
    }
}
