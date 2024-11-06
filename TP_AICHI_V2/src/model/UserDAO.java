package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;
    public UserDAO() {
        try {
            // Connection à MySQL
            String url = "jbdc:mysql://mysql-momo.alwaysdata.net/";
            String username = "momo_utlisateur";
            String password = "Je123pas?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,
                    username, password);
        } catch (SQLException e) { e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void ajoutUser(User user) throws SQLException {
        String query = "SELECT login,mdp FROM users WHERE login = ?  AND mdp = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, user.getLogin());
        stmt.setString(2, user.getUserMdp());
        stmt.executeUpdate();
    }


}
