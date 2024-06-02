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
        int BranoID = 1;
        int UtenteID = 4;

        try {
            Connection mydb = DriverManager.getConnection(url, user, password);

            String sql = "SELECT Battuta.Numero, Battuta.BTM, Battuta.Commento FROM Battuta WHERE Battuta.Brano = " + BranoID + " AND Battuta.Utente = " + UtenteID + ";";
            PreparedStatement mycursor = mydb.prepareStatement(sql);

            ResultSet myresult = mycursor.executeQuery();

            while (myresult.next()) {
                int num = myresult.getInt("Numero");
                String btm = myresult.getString("BTM");
                String commento = myresult.getString("Commento");
                String data_lancio = myresult.getString("data_lancio");

                System.out.println("Numero di battuta: " + num + ", BTM: " + btm + ", Commento: " + commento );
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}