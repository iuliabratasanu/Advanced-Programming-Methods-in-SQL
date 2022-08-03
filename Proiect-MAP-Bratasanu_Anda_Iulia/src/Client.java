public class Client {
    private int id;
    private int nrPantof;
    private String nume;

    public Client(int id, int nrPantof, String nume) {
        this.id = id;
        this.nrPantof = nrPantof;
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public int getNrPantof() {
        return nrPantof;
    }

    public String getNume() {
        return nume;
    }

    public double platesteIntrare(){
        return 20;
    }
}
