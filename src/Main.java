import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/musica";
        String user = "root";
        String password = "***";

        try {
            Connection mydb = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM Battuta;";
            PreparedStatement mycursor = mydb.prepareStatement(sql);

            ResultSet myresult = mycursor.executeQuery();

            while (myresult.next()) {
                int num = myresult.getInt("Numero");
                int brano = myresult.getInt("Brano");
                int btm = myresult.getInt("BTM");
                String commento = myresult.getString("Commento");
                int utente = myresult.getInt("Utente");

                System.out.println("Numero di battuta: " + num + ", Brano: " + brano + ", BTM: " + btm + ", Commento: " + commento + ", Utente: " + utente);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}