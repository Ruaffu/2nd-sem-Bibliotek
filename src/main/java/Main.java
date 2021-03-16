import DBAccess.KundeMapper;
import FunctionLayer.Kunde;
import FunctionLayer.LoginSampleException;

import java.util.List;

public class Main {


    public static void main(String[] args) throws LoginSampleException {

        /* opgaver .
        *
        * Jeg har lavet en kunde mapper. I skal lave BogMapper med de tilsvarende
        * fungtioner.
        *
        * I skal lave en metoder der automatisk kan oprette en masse lån, dvs.
        * automatiske fylde data ind i lånetabellen.
        * */




        //nyKunde("lone","nøjsomhedsvej 12", "2800");

       // udskrivKunder();

        System.out.println(fjernKunde("lone"));


        //udskrivKunder();


    }


    public static String fjernKunde(String navn) {


        return KundeMapper.deleteKunde( navn );


    }

    public static void udskrivKunder() {

        for (Kunde k : hentKunder() ) {

            System.out.println( k.getIdKunde() + " " +  k.getKundeNavn());

        }
    }

    public static List<Kunde> hentKunder () {

        return KundeMapper.HentKunder();


    }

    public static void nyKunde(String navn, String adresse, String postnr ) throws LoginSampleException {

        Kunde kunde = new Kunde(navn,adresse,postnr);

        KundeMapper.OpretKunde(kunde);

    }



}
