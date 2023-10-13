package EX2;

import java.sql.Struct;
import java.time.LocalDate;

public class Produs {
    private String den;
    private float pret;
    private int cantitate;
    private LocalDate date;

    public static float incasari;


    public String getDen() { return den; }
    public float getPret() {
        return pret;
    }
    public int getCantitate() {
        return cantitate;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public Produs(String den, float pret, int cantitate, LocalDate date) {
        this.den = den;
        this.pret = pret;
        this.cantitate = cantitate;
        this.date = date;

    }
    public String toString(){
        return "\nDenumire: " + getDen()
                + "\nPret: " + getPret()
                + "\nCantitate: " + getCantitate()
                + "\nData de valabilitate: " + getDate();
    }




}
