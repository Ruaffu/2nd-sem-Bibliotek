package DBAccess;

import FunctionLayer.Bog;
import FunctionLayer.Kunde;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BogMapper {

    public static void opretBog(Bog bog){

        String sql = "INSERT INTO bogtabel (forfatter, title, forlag, Udgivelsesdato ) VALUES (?, ?, ?, ?)";


        // se lige try-with-resources f.eks. her  https://www.baeldung.com/java-try-with-resources
        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            // her klargøres mit prepared statement ved at min parametre indsættes.
            ps.setString(1, bog.getForfatter());
            ps.setString(2, bog.getTitle());
            ps.setString(3, bog.getForlag());
            ps.setDate(4, bog.getUdgivelsesdato());


            ps.executeUpdate();    //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            bog.setIdBogTabel(id);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static List<Bog> hentBoger() {

        List<Bog> bogList = new ArrayList<>();

        String sql = "select * from bogtabel ";

        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {           // https://en.wikipedia.org/wiki/Prepared_statement


            ResultSet resultSet = ps.executeQuery();   //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            while (resultSet.next()) {
                int id = resultSet.getInt("idBogTabel");
                String forfatter = resultSet.getString("forfatter");
                String title = resultSet.getString("title");
                String forlag = resultSet.getString("forlag");
                Date Udgivelsesdato = resultSet.getDate("Udgivelsesdato");

                Bog bog = new Bog(id, forfatter, title, forlag, Udgivelsesdato);
                bogList.add(bog);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bogList;
    }


    public static String deleteBog(String title) {

        String sql = "delete from bogtabel where title = ?";

        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, title);


            int res = ps.executeUpdate();       //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            if (res > 0) {

                return "Bogen med titlen " + "\""  + title + "\""  + " er nu blevet slettet";
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return "en bog med titlen " + "\"" + title + "\"" + " fandtes ikke i listen";


    }






    public static String updateBog(int idBogTabel, String forfatter , String title, String forlag, Date Udgivelsesdato) {

        String sql = "update  bogtabel set forfatter = ? , title = ? , forlag = ? , Udgivelsesdato = ? , where idBogTabel = ?";



        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, forfatter);
            ps.setString(2, title);
            ps.setString(3, forlag);
            ps.setDate(4, Udgivelsesdato);

            // det er det her jeg søger på.
            ps.setInt(5, idBogTabel);


            int res = ps.executeUpdate();    //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            if (res > 0) {

                return "Bogen med titlen " + "\""  + title + "\""  + " er nu blevet opdateret";
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return "en bog med titlen " + "\"" + title + "\"" + " fandtes ikke i listen";


    }
}
