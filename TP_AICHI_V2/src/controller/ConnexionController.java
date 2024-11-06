package controller;



import model.User;
import model.UserDAO;
import view.FConnexionView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ConnexionController {

    private FConnexionView view;
    private UserDAO userDAO;

    public ConnexionController(FConnexionView view, UserDAO userDAO) {
        this.view = view;
        this.userDAO = userDAO;


        this.view.addValiderListener(new ValiderListener());
        this.view.addQuitterListener(new QuitterListener());
    }


    class ValiderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String login = view.getLogin();
            String motDePasse = view.getMotDePasse();

            if (login.isEmpty() || motDePasse.isEmpty()) {
                view.showMessage("Veuillez remplir tous les champs.");
                return;
            }

            User user = new User(login, motDePasse);

            try {

                userDAO.ajoutUser(user);
                view.showMessage("Connexion réussie !");

            } catch (SQLException ex) {
                view.showMessage("Erreur de connexion : identifiants incorrects ou problème de base de données.");
            }
        }
    }


    class QuitterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.fermerFenetre();
        }
    }
}