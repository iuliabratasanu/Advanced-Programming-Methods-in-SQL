import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Patinoar extends Locatie implements Aprovizionare {
    public int latime;
    int lungime;
    protected int numarPatineDisp = 100;
    private final int nrAntrenori;
    private final ArrayList<Client> clienti;
    private final ArrayList <Angajat> angajati;
    private final ArrayList<Curs> cursuri;
    private final Map dimPatine;
    private final Map programAngajati;
    private final int profit;


    public Patinoar(int latime, int lungime, int numarPatineDisp, int nrAntrenori, int profit) {
        this.latime = latime;
        this.lungime = lungime;
        this.numarPatineDisp = numarPatineDisp;
        this.nrAntrenori = nrAntrenori;
        this.profit = profit;
        clienti = new ArrayList<Client>(50);
        angajati = new ArrayList<Angajat>(20);
        cursuri = new ArrayList<Curs>(20);
        dimPatine = new HashMap<Integer, Integer>() {{
            put(39, 25);
            put(40, 25);
            put(41, 25);
            put(42, 25);
        }};

        programAngajati = new HashMap <String, String>() {{
            //program pentru part-time si voluntariate:
            put ("Part-time/Voluntariat Dimineata1", "Luni, Duminica, Sambata: 08:00-12:00");
            put ("Part-time/Voluntariat Dupa-Amiaza1", "Luni, Duminica, Sambata: 12:00-16:00");
            put ("Part-time/Volunariat Seara1", "Luni, Duminica, Sambata: 16:00-20:00");

            put ("Part-time/Voluntariat Dimineata2", "Marti Miercuri Joi Vineri: 08:00-12:00");
            put ("Part-time/Voluntariat Dupa-Amiaza2", "Marti Miercuri Joi Vineri: 12:00-16:00");
            put ("Part-time/Volunariat Seara2", "Marti Miercuri Joi Vineri: 16:00-20:00");

            // program pentru angajatii full-time:
            put ("Full-time1", "Marti Miercuri Joi Vineri: 16:00-23:00");

            put ("Full-time2", "Luni, Duminica, Sambata: 16:00-23:00");
        }};
    }

    public int getLatime() {
        return latime;
    }

    public int getLungime() {
        return lungime;
    }

    public ArrayList<Client> getClienti() {
        return clienti;
    }

    public ArrayList<Angajat> getAngajati() {
        return angajati;
    }

    public ArrayList<Curs> getCursuri() {
        return cursuri;
    }

    public int getNumarPatineDisp() {
        return numarPatineDisp;
    }

    public int getNrAntrenori() {
        return nrAntrenori;
    }

    public Map getDimPatine() {
        return dimPatine;
    }

    public Map getProgramAngajati() {
        return programAngajati;
    }

    public int getProfit() {
        return profit;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public void adaugaPatine(int numarPatine){
        this.numarPatineDisp += numarPatine;
    }

    public void adaugaClient(Client c){
        clienti.add(c);
    }

    public void afiseazaAngajati() {
        System.out.println("Lista angajati: ");
        for (Angajat a : angajati) {
            System.out.println(" - " + a.getId() + ": " + a.getNume() + "; salariu:" + a.getSalariu());
        }
    }

    public void adaugaAngajat(Angajat a){
        angajati.add(a);
    }

    public void afiseazaClienti() {
        System.out.println("Lista clienti: ");
        for (Client c : clienti) {
            System.out.println(" - " + c.getId() + ": " + c.getNume());
        }
    }

    public void afiseazaCursuri() {
        System.out.println("Lista cursuri: ");
        for (Curs c : cursuri) {
            System.out.println(" - " + c.getId() + ": " + c.getNume() + " - " + c.getNivel());
        }
    }

    public void adaugaCurs(Curs c){
        cursuri.add(c);
    }
    public void stergeClient(String nume) {
        int index = 0;
        for (Client c : clienti) {
            if (c.getNume().equals(nume)) {
                System.out.println("Am sters " + nume);
                clienti.remove(index);
                break;
            }
            index++;
        }
        this.afiseazaClienti();
    }

    public void stergeAngajat(String nume) {
        int index = 0;
        for (Angajat a : angajati) {
            if (a.getNume().equals(nume)) {
                System.out.println("Am sters " + nume);
                angajati.remove(index);
                break;
            }
            index++;
        }
        this.afiseazaAngajati();

    }
    public void stergeCurs(String nume) {
        int index = 0;
        for (Curs c: cursuri) {
            if (c.getNume().equals(nume)) {
                System.out.println("Am sters " + nume);
                cursuri.remove(index);
                break;
            }
            index++;
        }
        this.afiseazaCursuri();
    }
}
