package presentationlayer;

import DBAccess.KundeMapper;
import DBAccess.OversigtsMapper;
import FunctionLayer.Kunde;
import DBAccess.BogMapper;
import FunctionLayer.Bog;
import FunctionLayer.Laan;

import java.sql.Date;
import java.util.List;
import java.util.Random;

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
//        udskrivboger();
//        nyBog("Alexandre Dumas","The three musketeers","Penguin books ltd",null);
//        opdaterBog(6,"Alexandre Dumas", "The Count of Monte Cristo", "Penguin books ltd", null);
//        System.out.println(fjernBog("The three musketeers"));
//        nytLaan(2, 1);
//        randomLaan(5,100);
//        System.out.println();
//        udskrivboger();
        udskrivAlleLaan();
        System.out.println();
        udskrivLånteBoger();
        System.out.println();
        udskrivLåner();


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

    public  static void randomLaan(int bogMax, int kundeMax){
        int min = 1;
        int bogId;
        int kundeId;

        Random r = new Random();
        Random r2 = new Random();
        bogId = r.nextInt(bogMax-min)+min;
        kundeId = r2.nextInt(kundeMax-min)+min;

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

    public static List<Laan> hentLaan(){
        return OversigtsMapper.hentLaan("select * from laaninfo ");
    }

    public static void udskrivAlleLaan() {

        List<Laan> laanList = hentLaan();

        for (Laan l : laanList ) {

            System.out.println( "LånID: "+l.getTransaktionsId() + " KundeID: "+l.getIdKunde()+
                    " Navn: "+l.getKundeNavn()+" BogID: "+l.getIdBog()+" Title:"+l.getTitle());

        }
    }

    public static void udskrivLånteBoger() {
        System.out.println("laante boger:");

        List<Laan> laanList = OversigtsMapper.hentLaan("select * from laaninfo group by IdBog");;

        for (Laan l : laanList ) {

            System.out.println("ID:"+l.getIdBog()+" Title:"+l.getTitle());

        }
    }

    public static void udskrivLåner() {
        System.out.println("Kunder med laante boger:");

        List<Laan> laanList = OversigtsMapper.hentLaan("select * from laaninfo group by IdKunde");

        for (Laan l : laanList ) {

            System.out.println("ID:"+l.getIdKunde()+" Navn:"+l.getKundeNavn());

        }
    }





}
