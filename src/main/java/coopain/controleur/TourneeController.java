package coopain.controleur;

import coopain.modele.*;
import coopain.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.hibernate.Session;
import java.util.List;

public class TourneeController {
    @FXML private ComboBox<TypePrestation> comboPrestations;
    @FXML private TextField txtNbActes;
    @FXML private Label lblTotal;
    @FXML private Label lblMessage;
    // Ajout Mission 5
    @FXML private TextArea txtHistorique;

    private GestionTournee gestionTournee;
    private Visite visiteCourante;

    @FXML
    public void initialize() {
        gestionTournee = new GestionTournee(new Tournee());
        visiteCourante = new Visite();
        gestionTournee.ajouterVisite(visiteCourante);

        // Connexion et remplissage ComboBox via Hibernate
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<TypePrestation> liste = session.createQuery("from TypePrestation", TypePrestation.class).list();
            comboPrestations.setItems(FXCollections.observableArrayList(liste));
            if (!liste.isEmpty()) comboPrestations.getSelectionModel().selectFirst();
        } catch (Exception e) {
            lblMessage.setText("Erreur BDD : Vérifiez que MySQL est lancé (" + e.getMessage() + ")");
        }
    }

    @FXML
    public void handleAjouterActe() {
        lblMessage.setText("");
        try {
            int nbActes = Integer.parseInt(txtNbActes.getText());
            TypePrestation typeSelectionne = comboPrestations.getValue();

            if (typeSelectionne != null && nbActes > 0) {
                visiteCourante.ajouterPrestationVisite(typeSelectionne, nbActes);
                lblTotal.setText("CA Total de la tournée : " + gestionTournee.CATournee() + " €");
                
                // Amélioration Mission 5 : Ajout dans l'historique visuel
                txtHistorique.appendText("- " + nbActes + "x " + typeSelectionne.getLibelle() + "\n");
                
            } else {
                lblMessage.setText("Veuillez saisir un nombre d'actes valide (> 0).");
            }
        } catch (NumberFormatException ex) {
            lblMessage.setText("Le nombre d'actes doit être un entier positif.");
        }
    }
}
