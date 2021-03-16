package DBAccess;

import FunctionLayer.Kunde;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Kunde;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 The purpose of UserMapper is to...
 @author kasper
 */
public class UserMapper {


    // nu virker denne her.
    public static void OpretKunde(Kunde kunde) throws LoginSampleException {

        // her laver vi vores sql statement
        String sql = "INSERT INTO KundeTabel (KundeNavn, Adresse, PostNr ) VALUES (?, ?, ?)";


        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection


             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // NB: Statement.RETURN_GENERATED_KEYS
        )  {

            // her klargøres mit prepared statement ved at min parametre indsættes.
            ps.setString(1, kunde.getKundeNavn());
            ps.setString(2, kunde.getAdresse());
            ps.setString(3, kunde.getPostNr());
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            kunde.setIdKunde(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


//
//    public static List<Kunde> opretKunde() {
//
//        List<Kunde> kundeList = new ArrayList<>();
//
//        String sql = "INSERT INTO Kunde (Kundenavn ) VALUES (?)";
//
//        try (Connection con = ConnectionConfiguration.getConnection();
////             PreparedStatement ps = con.prepareStatement(sql)
//             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//        )  {
//
//            ps.setString(1, kunde.getKundeNavn());
//
//            ps.executeUpdate();
//
//            ResultSet ids = ps.getGeneratedKeys();
//            ids.next();
//            int id = ids.getInt(1);
//            kunde.setKundeId(id);
//
//
////            ResultSet resultSet = ps.executeQuery();
////            while (resultSet.next()){
////                int id = resultSet.getInt("idKunde");
////                String navn = resultSet.getString("Kundenavn");
////
////                Kunde kunde = new Kunde(id, navn);
////                kundeList.add(kunde);
//
//
//        } catch (SQLException e) {
//            System.out.println("Fejl i connection til database");
//            e.printStackTrace();
//        }
//        return kundeList;
//    }
//
//
//
//
//    public static List<Kunde> getKunder() {
//
//        List<Kunde> kundeList = new ArrayList<>();
//
//        String sql = "select * from Kunde ";
//
//        try (Connection con = ConnectionConfiguration.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql))  {
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()){
//                int id = resultSet.getInt("idKunde");
//                String navn = resultSet.getString("Kundenavn");
//
//                Kunde kunde = new Kunde(id, navn);
//                kundeList.add(kunde);
//            }
//        } catch (SQLException e) {
//            System.out.println("Fejl i connection til database");
//            e.printStackTrace();
//        }
//        return kundeList;
//    }
//
//
//    public static String deleteKunde(String kundeNavn) {
//
//
//        try {
////            Connection con = Connector.connection();
//            Connection con = ConnectionConfiguration.getConnection();
//            String SQL = "delete from Kunde where Kundenavn = ?";
//            PreparedStatement ps = con.prepareStatement(SQL);
//            ps.setString(1, kundeNavn);
//
//            int rew = ps.executeUpdate();
//
//            if (rew > 0 ) {
//
//                return kundeNavn + " " + " er nu blevet slettet";
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//        return kundeNavn + " " + "fandtes ikke i listen";
//
//
//
//    }
}
