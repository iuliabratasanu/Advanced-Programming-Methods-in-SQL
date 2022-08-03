import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Main {
    public static void main(String[] args) throws Exception {
        Patinoar p = new Patinoar(20, 15, 100 ,4, 0 );

        ReadCSV r = ReadCSV.getInstanta();
        Scanner s = new Scanner(System.in);


        r.citesteClienti(p, "clienti.csv");
        r.citesteAngajati(p, "angajati.csv");
        r.citesteCursuri(p, "cursuri.csv");

        String logMessage = "Test12333";
        BufferedWriter bw = new BufferedWriter(new FileWriter("log.csv"));
        System.out.println(new Timestamp(System.currentTimeMillis()));


        try {
            while (true) {
                curataEcran();
                System.out.println("Bine ati venit la pationar! Lista optiuni: ");
                System.out.println("1. Adauga client");
                System.out.println("2. Afiseaza clienti");
                System.out.println("3. Sterge client");
                System.out.println("4. Adauga angajat");
                System.out.println("5. Afiseaza angajati");
                System.out.println("6. Afiseaza cursuri");
                System.out.println("7. Insciere curs");
                System.out.println("8. Stergere angajat");
                System.out.println("9. Stergere curs");
                System.out.println("0. Iesire meniu");
                int alegere = s.nextInt();
                switch (alegere) {
                    case 1:
                        System.out.println("Introduceti datele clientului: ");
                        Client c = citesteClient();
                        p.adaugaClient(c);
                        bw.write("Adaugare client," + new Timestamp(System.currentTimeMillis()));
                        bw.newLine();
                        break;
                    case 2:
                        p.afiseazaClienti();
                        bw.write("Afisare clienti," + new Timestamp(System.currentTimeMillis()));
                        bw.newLine();
                        s.nextLine();
                        s.nextLine();
                        break;
                    case 3:
                        System.out.println("Scrieti numele clientului: ");
                        String nume = s.nextLine();
                        nume = s.nextLine();
                        p.stergeClient(nume);
                        bw.write("Sterge client," + new Timestamp(System.currentTimeMillis()));
                        bw.newLine();
                        s.nextLine();
                        break;
                    case 4:
                        System.out.println("Introduceti datele angajatului: ");
                        Angajat a = citesteAngajat();
                        p.adaugaAngajat(a);
                        bw.write("Adaugare angajat," + new Timestamp(System.currentTimeMillis()));
                        bw.newLine();
                        break;
                    case 5:
                        p.afiseazaAngajati();
                        s.nextLine();
                        s.nextLine();
                        bw.write("Afiseaza angajati," + new Timestamp(System.currentTimeMillis()));
                        bw.newLine();
                        break;
                    case 6:
                        p.afiseazaCursuri();
                        s.nextLine();
                        s.nextLine();
                        bw.write("Afiseaza cursuri," + new Timestamp(System.currentTimeMillis()));
                        bw.newLine();
                        break;
                    case 7:
                        System.out.println("Introduceti datele cursului: ");
                        Curs curs = citesteCurs();
                        p.adaugaCurs(curs);
                        bw.write("Adaugare curs," + new Timestamp(System.currentTimeMillis()));
                        bw.newLine();
                        break;
                    case 8:
                        System.out.println("Scrieti numele angajatului: ");
                        String numeAng = s.nextLine();
                        numeAng = s.nextLine();
                        p.stergeAngajat(numeAng);
                        bw.write("Sterge angajat," + new Timestamp(System.currentTimeMillis()));
                        bw.newLine();
                        s.nextLine();
                        break;
                    case 9:
                        System.out.println("Scrieti numele cursului: ");
                        String numeCurs = s.nextLine();
                        numeCurs = s.nextLine();
                        p.stergeCurs(numeCurs);
                        bw.write("Sterge curs," + new Timestamp(System.currentTimeMillis()));
                        bw.newLine();
                        s.nextLine();
                        break;
                    case 0:
                        System.out.println("Salvam datele si iesim din program. O zi faina!");
                        salveazaDate(p);
                        bw.newLine();
                        bw.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Incearca din nou");
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Eroare la citire");
        }
    }

    public static void curataEcran() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void salveazaDate(Patinoar p) throws IOException {
        ArrayList<Client> clienti = p.getClienti();
        ArrayList<Angajat> angajati = p.getAngajati();
        ArrayList<Curs> cursuri = p.getCursuri();

        BufferedWriter bw = new BufferedWriter(new FileWriter("clienti.csv"));
        for (Client c : clienti) {
            bw.write(c.getId() + "," + c.getNrPantof() + "," + c.getNume());
            bw.newLine();
        }
        bw.close();

        bw = new BufferedWriter(new FileWriter("angajati.csv"));
        for (Angajat a : angajati) {
            bw.write(a.getId() + "," + a.getSalariu() + "," + a.getNume() + "," + a.getZileConcediu());
            bw.newLine();
        }
        bw.close();

        bw = new BufferedWriter(new FileWriter("cursuri.csv"));
        for (Curs c : cursuri) {
            bw.write(c.getId() + "," + c.getNume() + "," + c.getIdAntrenor() + "," + c.getNivel());
            bw.newLine();
        }
        bw.close();
    }

    public static Client citesteClient(){
        Scanner s = new Scanner(System.in);
        System.out.println("id: ");
        int id = parseInt(s.next());
        System.out.println("numar pantof: ");
        int nrPantof = parseInt(s.next());
        System.out.println("nume: ");
        String nume = s.next();
        return new Client(id, nrPantof, nume);
    }

    public static Angajat citesteAngajat(){
        Scanner s = new Scanner(System.in);
        System.out.println("id: ");
        int id = parseInt(s.next());
        System.out.println("salariu: ");
        long salariu = parseLong(s.next());
        System.out.println("nume: ");
        String nume = s.next();
        System.out.println("zile concediu: ");
        int zileConcediu = parseInt(s.next());
        return new Angajat(id, salariu, nume, zileConcediu);
    }

    public static Curs citesteCurs(){
        Scanner s = new Scanner(System.in);
        System.out.println("id: ");
        int id = parseInt(s.next());
        System.out.println("nume: ");
        String nume = s.next();
        System.out.println("id antrenor: ");
        int idAntrenor = parseInt(s.next());
        System.out.println("nivel (incepator/avansat/profesionist: ");
        String nivel = s.next();
        return new Curs(id, nume, idAntrenor, nivel);
    }
}
