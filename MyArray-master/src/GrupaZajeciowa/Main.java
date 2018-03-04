package GrupaZajeciowa;

public class Main {
    public static void main(String[] args){
        GrupaZajeciowa g = new GrupaZajeciowa(5, 10);
        g.load();
        System.out.print(g.toString());
        System.out.println("Srednia ocen grupy to: "+g.policzSrednia());
    }
}
