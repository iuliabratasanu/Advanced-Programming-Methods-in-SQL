import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class ReadCSV {
    private static ReadCSV instanta = null;

    public ReadCSV() {
    }

    public static ReadCSV getInstanta() {
        if (instanta == null)
            instanta = new ReadCSV();
        return instanta;
    }

    public void citesteClienti(Patinoar p, String numeFisier){
        try {
            String date;
            String[] line;

            Scanner s = new Scanner(new File(numeFisier));

            while (s.hasNextLine()) {
                date = s.nextLine();
                line = date.split(",");

                p.adaugaClient(new Client(parseInt(line[0]), parseInt(line[1]), line[2]));
            }
            s.close();
        } catch (FileNotFoundException e){
            System.out.println("Eroare la citirea din fisier");
            e.printStackTrace();
        }
    }

    public void citesteAngajati(Patinoar p, String numeFisier){
        try {
            String date;
            String[] line;

            Scanner s = new Scanner(new File(numeFisier));

            while (s.hasNextLine()) {
                date = s.nextLine();
                line = date.split(",");

                p.adaugaAngajat(new Angajat(parseInt(line[0]), parseLong(line[1]), line[2], parseInt(line[3])));
            }
            s.close();
        } catch (FileNotFoundException e){
            System.out.println("Eroare la citirea din fisier");
            e.printStackTrace();
        }
    }

    public void citesteCursuri(Patinoar p, String numeFisier){
        try {
            String date;
            String[] line;

            Scanner s = new Scanner(new File(numeFisier));

            while (s.hasNextLine()) {
                date = s.nextLine();
                line = date.split(",");

                p.adaugaCurs(new Curs(parseInt(line[0]), line[1], parseInt(line[2]), line[3]));
            }
            s.close();
        } catch (FileNotFoundException e){
            System.out.println("Eroare la citirea din fisier");
            e.printStackTrace();
        }
    }

}
