import DBAccess.UserMapper;
import FunctionLayer.Kunde;
import FunctionLayer.LoginSampleException;

public class Main {


    public static void main(String[] args) throws LoginSampleException {

        nyKunde("lone","nøjsomhedsvej 12", "2800");



    }


    public static void nyKunde(String navn, String adresse, String postnr ) throws LoginSampleException {

        Kunde kunde = new Kunde(navn,adresse,postnr);

        UserMapper.OpretKunde(kunde);

    }

}
