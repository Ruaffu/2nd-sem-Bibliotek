package FunctionLayer;

public class Laan {
    private int TransaktionsId;
    private int IdBog;
    private int IdKunde;
    private String kundeNavn;
    private String title;

    public Laan(int transaktionsId, int idBog, int idKunde) {
        TransaktionsId = transaktionsId;
        IdBog = idBog;
        IdKunde = idKunde;
    }

    public Laan(int idBog, int idKunde) {
        IdBog = idBog;
        IdKunde = idKunde;
    }

    public Laan(int transaktionsId, int idBog, int idKunde, String kundeNavn, String title) {
        TransaktionsId = transaktionsId;
        IdBog = idBog;
        IdKunde = idKunde;
        this.kundeNavn = kundeNavn;
        this.title = title;
    }


    public String getKundeNavn() {
        return kundeNavn;
    }

    public void setKundeNavn(String kundeNavn) {
        this.kundeNavn = kundeNavn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTransaktionsId() {
        return TransaktionsId;
    }

    public void setTransaktionsId(int transaktionsId) {
        TransaktionsId = transaktionsId;
    }

    public int getIdBog() {
        return IdBog;
    }

    public void setIdBog(int idBog) {
        IdBog = idBog;
    }

    public int getIdKunde() {
        return IdKunde;
    }

    public void setIdKunde(int idKunde) {
        IdKunde = idKunde;
    }
}
