package EX2;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {


    public static void main(String[] args) throws IOException {

        List<Produs> produse = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("\nMENIU");
        System.out.println("""
                a) afișarea tuturor produselor din colecția List
                b) afișarea produselor expirate
                c) vânzarea unui produs, care se poate realiza doar dacă există suficientă cantitate pe stoc.
                Daca produsul ajunge la cantitate zero, se elimina din listă. În clasa Produs se va declara
                o variabilă statica încasări care se va actualiza la fiecare vânzare a unui produs, luând în
                considerare prețul produsului vândut şi cantitatea vândută .
                d) afișarea produselor cu prețul minim (pot fi mai multe cu același preț)
                e) salvarea produselor care au o cantitate mai mică decât o valoare citită de la tastatură
                într-un fișier de ieșire.
                $) total incasari.\s
                EXIT) EXIT!
                """);

        String filePath = "C:\\Users\\Christian\\IdeaProjects\\LabPJ3\\src\\EX2\\produse.csv";
        BufferedReader scanFile = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

        float total = 0;

        String line;

        while(( line = scanFile.readLine())!= null) {

            String[] value = line.split(",");

            String den = value[0].trim();
            float pret = Float.parseFloat(value[1].trim());
            int cantitate = Integer.parseInt(value[2].trim());
            LocalDate data = LocalDate.parse(value[3].trim());

            Produs p = new Produs(den,pret,cantitate,data);
            produse.add(p);
        }


        do {System.out.print("\nAlegeti o optiune(a-e): ");
            String opt = scan.nextLine();

            switch (opt){
                case "a":
                    afisare(produse);
                    break;
                case "b":
                    afisareExpirate(produse);
                    break;
                case "c":
                    System.out.println("Ce produs doriti sa cumparati?");
                    String search = scan.nextLine();
                    for(Produs p:produse) {
                        if(search.equals(p.getDen().trim())){
                            System.out.print("Cantitate dorita: ");
                            String q = scan.nextLine();
                            int z = Integer.parseInt(q);
                            if(vanzare(produse,p,z)) {
                                System.out.println("SOLD");
                                float money = z * p.getPret();
                                System.out.println("\n+" + Produs.incasari + " $");
                                total += money;
                            }
                        }
                    }
                    break;
                case "d":
                    break;
                case "e":
                    break;
                case "$":
                    System.out.println( "Total: " + total + " $");
                    break;
                case "EXIT":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiune invalida!");
                    break;
            }

        }while(true);
    }
    public static void afisare(List<Produs> produse) {
        for(Produs produs: produse) {
            System.out.println(produs.toString());
        }
    }
    public static void afisareExpirate(List<Produs> produse) {
        for(Produs produs: produse) {
            if(produs.getDate().isBefore(LocalDate.now())) {
                System.out.println(produs.toString());
            }
        }
    }
    public static boolean vanzare(List<Produs> produse, Produs p, int cantitateDorita) {
        if(p.getCantitate()>0){
            if(p.getCantitate()<cantitateDorita){
                System.out.println("Mai sunt doar " + p.getCantitate() + " buicati in stoc");
                return false;
            }else {
                Produs.incasari += cantitateDorita* p.getPret();
                int cantitateRamasa = p.getCantitate() - cantitateDorita;
                p.setCantitate( cantitateRamasa);
                return true;
            }
        }else{
            System.out.println("Sold out...");
            produse.remove(p);
            return false;
        }
    }
}
