public class Angajat {
    private int id;
    private long  salariu;
    private String nume;
    private int zileConcediu;

    public Angajat(int id, long salariu, String nume, int zileConcediu) {
        this.id = id;
        this.salariu = salariu;
        this.nume = nume;
        this.zileConcediu = zileConcediu;
    }

    public int getId() {
        return id;
    }

    public long getSalariu() {
        return salariu;
    }

    public String getNume() {
        return nume;
    }

    public double zileFolositeDinConcediu(){
        return 10 - zileConcediu;
    }

    public int getZileConcediu() {
        return zileConcediu;
    }
}
