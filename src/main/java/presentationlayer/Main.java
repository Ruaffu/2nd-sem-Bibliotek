package presentationlayer;

import DBAccess.KundeMapper;
import FunctionLayer.Kunde;

import java.util.List;

public class Main {


    public static void main(String[] args)  {





        //nyKunde("lone","nøjsomhedsvej 12", "2800");

       // udskrivKunder();

        System.out.println(fjernKunde("lone"));



        opdatere(401, "Jørgen", "Vedkæret 23, ", "2820");

        udskrivKunder();

    }


    public static String fjernKunde(String navn) {


        return KundeMapper.deleteKunde( navn );


    }

    // todo lav en fjernkunde som tager et kunde id som input. Det kunne jo være der var flere kunder med samme navn.


    public static String opdatere(int idKunde, String navn, String adresse, String postNr) {

       return KundeMapper.updateKunde(idKunde,navn,adresse, postNr);

    }

    // todo lav en udskriv kunde metode. Moden skal tage et kunde id som imput, og udskrive stamoplysningerne

    public static void udskrivKunder() {

        for (Kunde k : hentKunder() ) {

            System.out.println( k.getIdKunde() + " " +  k.getKundeNavn());

        }
    }

    public static List<Kunde> hentKunder () {

        return KundeMapper.HentKunder();


    }

    public static void nyKunde(String navn, String adresse, String postnr )  {

        Kunde kunde = new Kunde(navn,adresse,postnr);

        KundeMapper.OpretKunde(kunde);

    }



}
