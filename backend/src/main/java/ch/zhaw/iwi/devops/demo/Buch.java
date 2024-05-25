package ch.zhaw.iwi.devops.demo;
public class Buch {
    private int id;
    private String titel;
    private String autor;

    public Buch() {}

    public Buch(int id, String titel, String autor) {
        this.id = id;
        this.titel = titel;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
