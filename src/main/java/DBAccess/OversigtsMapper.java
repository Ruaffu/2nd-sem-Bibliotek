package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import FunctionLayer.Bog;
import FunctionLayer.Kunde;
import FunctionLayer.Laan;

public class OversigtsMapper {

    public static void opretLaan(Laan laan){
        String sql = "INSERT INTO lånetabel (IdBog, IdKunde) VALUES (?, ?)";


        // se lige try-with-resources f.eks. her  https://www.baeldung.com/java-try-with-resources
        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            // her klargøres mit prepared statement ved at min parametre indsættes.
            ps.setInt(1, laan.getIdBog());
            ps.setInt(2, laan.getIdKunde());


            ps.executeUpdate();    //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            laan.setTransaktionsId(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
