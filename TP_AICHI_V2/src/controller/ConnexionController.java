package controller;
import model.User;
import model.UserDAO;
import view.FConnexionView;
import viewsAccueil.FAccueilView;
import viewsAccueil.AccueilController;
import java.sql.SQLException;
public class ConnexionController {

    private final FConnexionView view;
    private final UserDAO userDAO;
    private boolean listenersAdded = false;

    public ConnexionController(FConnexionView view, UserDAO userDAO) {
        this.view = view;
        this.userDAO = userDAO;
    }

    public void addListeners() {
        if (!listenersAdded) {
            view.addValiderListener(e -> handleValider());
            view.addQuitterListener(e -> handleQuitter());
            listenersAdded = true;
        }
    }

    private void handleValider() {
        String login = view.getLogin();
        String motDePasse = view.getMotDePasse();
        // Ajoutez ici la logique de validation
        if (login.isEmpty() || motDePasse.isEmpty()) {
            view.showMessage("Veuillez remplir tous les champs.");
            return;
        }

        User user = new User(login, motDePasse);

        try {
            userDAO.ajoutUser(user);
            view.showMessage("Connexion réussie !");
            FAccueilView accueilView = new FAccueilView();
            accueilView.setVisible(true);
            AccueilController accueilController = new AccueilController(accueilView);
            accueilController.initController();


        } catch (SQLException ex) {
            // Log the exception (if a logging framework is available)
            // Logger.getLogger(ValiderListener.class.getName()).log(Level.SEVERE, null, ex);
            view.showMessage("Erreur de connexion : identifiants incorrects ou problème de base de données.");
        }
    }

    private void handleQuitter() {
        view.fermerFenetre();
    }

}