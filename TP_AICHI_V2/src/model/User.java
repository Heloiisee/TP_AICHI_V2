package model;

public class User {
    private int id;
    private String login;
    private String userMdp;

    // Constructeur par défaut
    public User() {
    }

    // Constructeur avec paramètres
    public User(String login, String userMdp) {
        this.login = login;
        this.userMdp = userMdp;
    }

    // Getter et setter pour l'identifiant
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter et setter pour le login
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    // Getter et setter pour le mot de passe
    public String getUserMdp() {
        return this.userMdp;
    }

    public void setUserMdp(String userMdp) {
        this.userMdp = userMdp;
    }
}
