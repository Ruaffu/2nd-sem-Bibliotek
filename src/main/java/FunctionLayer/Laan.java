package FunctionLayer;

public class Laan {
    private int TransaktionsId;
    private int IdBog;
    private int IdKunde;

    public Laan(int transaktionsId, int idBog, int idKunde) {
        TransaktionsId = transaktionsId;
        IdBog = idBog;
        IdKunde = idKunde;
    }

    public Laan(int idBog, int idKunde) {
        IdBog = idBog;
        IdKunde = idKunde;
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
