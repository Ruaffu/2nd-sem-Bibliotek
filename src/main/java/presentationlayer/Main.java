package presentationlayer;

import DBAccess.KundeMapper;
import DBAccess.OversigtsMapper;
import FunctionLayer.Kunde;
import DBAccess.BogMapper;
import FunctionLayer.Bog;
import FunctionLayer.Laan;

import java.sql.Date;
import java.util.List;

public class Main {


    public static void main(String[] args)  {





//        //nyKunde("lone","nøjsomhedsvej 12", "2800");
//
//       // udskrivKunder();
//
//        System.out.println(fjernKunde("lone"));
//
//
//
//        opdatere(401, "Jørgen", "Vedkæret 23, ", "2820");
//
//        udskrivKunder();


        //nyKunde("Alexander","Mathildeparken 23", "3400");

//        udskrivKunder();

//       fjernKunde("jørgen");

//        udskrivKunder();
        udskrivboger();
//        nyBog("Alexandre Dumas","The three musketeers","Penguin books ltd",null);
//        opdaterBog(6,"Alexandre Dumas", "The Count of Monte Cristo", "Penguin books ltd", null);
//        System.out.println(fjernBog("The three musketeers"));
        nytLaan(2, 1);
        System.out.println();
        udskrivboger();


    }


    public static String fjernKunde(String navn) {


        return KundeMapper.deleteKunde( navn );


    }

    // todo lav en fjernkunde som tager et kunde id som input. Det kunne jo være der var flere kunder med samme navn.


    public static String opdatere(int idKunde, String navn, String adresse, String postNr) {

       return KundeMapper.updateKunde(idKunde,navn,adresse, postNr);

    }

    // todo lav en udskriv kunde metode. Metoden skal tage et kunde id som imput, og udskrive stamoplysningerne

    public static void udskrivKunder() {

        List<Kunde> kundeList = hentKunder();

        for (Kunde k : kundeList ) {

            System.out.println( k.getIdKunde() + " " +  k.getKundeNavn());

        }
    }

    public static List<Kunde> hentKunder () {

        return KundeMapper.HentKunder();


    }

    public static void nytLaan(int bogId, int kundeId){

        Laan laan = new Laan(bogId, kundeId);

        OversigtsMapper.opretLaan(laan);

    }

    public static void nyKunde(String navn, String adresse, String postnr )  {

        Kunde kunde = new Kunde(navn,adresse,postnr);

        KundeMapper.opretKunde(kunde);

    }

    public static void nyBog(String forfatter, String title, String forlag, Date Udgivelsesdato)  {

        Bog bog = new Bog(forfatter,title,forlag,Udgivelsesdato);

        BogMapper.opretBog(bog);

    }

    public static List<Bog> hentBoger () {

        return BogMapper.hentBoger();


    }

    public static void udskrivboger() {

        List<Bog> bogList = hentBoger();

        for (Bog b : bogList ) {

            System.out.println( b.getIdBogTabel() + " " +  b.getTitle());

        }
    }

    public static String fjernBog(String title) {


        return BogMapper.deleteBog(title);

    }

    public static String opdaterBog(int idBogTabel, String forfatter, String title, String forlag, Date udgivelsesdato) {

        return BogMapper.updateBog(idBogTabel,forfatter,title,forlag,udgivelsesdato);

    }



}
