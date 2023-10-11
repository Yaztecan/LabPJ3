package EX1;

public class Parabola {
    private int a,b,c;
    public Parabola( int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {return a;}
    public int getB() {return b;}
    public int getC() {return c;}


    public String toString(){
        return "f(x) = " + getA() +"x^2" + " + " +  getB() + "x" + "+" + getC() + ".";
    }
    public String varf(){

        int x, y;

        x = -(getB()/2*getA());
        y =  (-getB() + 4*getA()*getB())/4*getA();

        return "{" + x + ", " + y + "}";
    }
    public int varfx(){
        int x;
        x = -(getB()/2*getA());

        return x;
    }

    public int varfy(){
        int y;
        y =  (-getB() + 4*getA()*getB())/4*getA();

        return y;
    }

    public static String mijloc(Parabola p1, Parabola p2) {

        int x = (p1.varfx() + p2.varfx()) / 2;
        int y = (p1.varfy() + p2.varfy()) / 2;

        return "{" + x + ", " + y + "}";
    }

    public double lungime(Parabola p ){

        double l = Math.hypot(p.varfx() - varfx(),p.varfy() - varfy());

        return l;
    }

    public static double lungime2(Parabola p1, Parabola p2){

        double l = Math.hypot(p2.varfx() - p1.varfx(), p2.varfy() - p1.varfy());

        return l;

    }
}
