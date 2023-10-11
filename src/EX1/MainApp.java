package EX1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {

        List<Parabola> parabole = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Christian\\IdeaProjects\\LabPJ3\\src\\EX1\\in.txt")));
        String line;

        while ((line = reader.readLine()) != null){
            String[] value = line.split(" ");
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            int c = Integer.parseInt(value[2]);

            Parabola p = new Parabola(a,b,c);
            parabole.add(p);
        }

        for(Parabola p : parabole)
        {
            System.out.println("Functia: " + p.toString());
            System.out.println("   Varf: " + p.varf() + "\n");
        }
        System.out.println("Mijlocul primelor 2 functii: " + Parabola.mijloc(parabole.get(0), parabole.get(0)));
        System.out.println("Lungimea  segmentului care unește vârfurile: " + parabole.get(0).lungime(parabole.get(1)));
        System.out.println("Lungimea  segmentului care unește vârfurile: " + Parabola.lungime2(parabole.get(0), parabole.get(1)));
    }
}
