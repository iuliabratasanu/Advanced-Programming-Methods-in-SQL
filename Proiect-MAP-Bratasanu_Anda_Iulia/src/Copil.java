public class Copil extends Client {
    int varsta;
    double discount;

    public Copil(int id, int nrPantof, String nume, int varsta, double discount) {
        super(id, nrPantof, nume);
        this.varsta = varsta;
        this.discount = discount;
    }



    public int getVarsta() {
        return varsta;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public double platesteIntrare() {
        return 20 * discount / 100;
    }
}
