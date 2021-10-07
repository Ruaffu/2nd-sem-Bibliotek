package FunctionLayer;

import java.sql.Date;

public class Bog {
    private int idBogTabel;
    private String forfatter;
    private String title;
    private String forlag;
    private Date Udgivelsesdato;

    public Bog(String forfatter, String title, String forlag, Date udgivelsesdato) {
        this.forfatter = forfatter;
        this.title = title;
        this.forlag = forlag;
        Udgivelsesdato = udgivelsesdato;
    }

    public Bog(int idBogTabel, String forfatter, String title, String forlag, Date udgivelsesdato) {
        this.idBogTabel = idBogTabel;
        this.forfatter = forfatter;
        this.title = title;
        this.forlag = forlag;
        Udgivelsesdato = udgivelsesdato;
    }

    public int getIdBogTabel() {
        return idBogTabel;
    }

    public void setIdBogTabel(int idBogTabel) {
        this.idBogTabel = idBogTabel;
    }

    public String getForfatter() {
        return forfatter;
    }

    public void setForfatter(String forfatter) {
        this.forfatter = forfatter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForlag() {
        return forlag;
    }

    public void setForlag(String forlag) {
        this.forlag = forlag;
    }

    public Date getUdgivelsesdato() {
        return Udgivelsesdato;
    }

    public void setUdgivelsesdato(Date udgivelsesdato) {
        Udgivelsesdato = udgivelsesdato;
    }
}
