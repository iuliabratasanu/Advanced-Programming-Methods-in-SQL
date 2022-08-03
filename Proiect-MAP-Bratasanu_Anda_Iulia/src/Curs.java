public class Curs {

    private int id;
    private String nume;
    private int idAntrenor;
    private Nivel nivel;
    public enum Nivel {
        incepator, avansat, profesionist;
    }

    public Curs(int id, String nume, int idAntrenor, String nivel) {
        this.id = id;
        this.nume = nume;
        this.idAntrenor = idAntrenor;
        if (nivel.equals("incepator"))
            this.nivel = Nivel.incepator;
        if (nivel.equals("avansat"))
            this.nivel = Nivel.avansat;
        if (nivel.equals("profesionist"))
            this.nivel = Nivel.profesionist;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public int getIdAntrenor() {
        return idAntrenor;
    }

    public Nivel getNivel() {
        return nivel;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setIdAntrenor(int idAntrenor) {
        this.idAntrenor = idAntrenor;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
