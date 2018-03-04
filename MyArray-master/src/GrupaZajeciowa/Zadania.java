package GrupaZajeciowa;


import java.util.Scanner;

public class Zadania {

    private double max_punktow;
    private int liczba_zadan;
    private int[] zadania;



    public Zadania(int liczba_zadan, double max_punktow){
        this.liczba_zadan=liczba_zadan;
        this.max_punktow=max_punktow;
        zadania = new int[liczba_zadan];
        for(int i = 0; i<getLiczba_zadan(); i++){
            zadania[i]=8;  //domyslna liczba zdobytych punktow za zadanie
        }
    }
    public void setUzyskaneP(int zadanie, int punkty){
        zadania[zadanie]=punkty;
    }
    public void setUzyskaneP(){
        Scanner in = new Scanner(System.in);
        for(int i = 0; i<getLiczba_zadan(); i++){
            zadania[i] = in.nextInt();
        }
        in.close();
    }
    public double getUzyskaneP(){
        double temp = 0;
        for(int i = 0; i<getLiczba_zadan(); i++){
            temp+=zadania[i];
        }
        return temp;
    }
    public double getSumaMax(){
        return max_punktow*liczba_zadan;
    }
    public int[] getZadania(){
        return zadania;
    }

    public double getMax_punktow() {
        return max_punktow;
    }

    public void setMax_punktow(int max_punktow) {
        this.max_punktow = max_punktow;
    }

    public int getLiczba_zadan() {
        return liczba_zadan;
    }

    public void setLiczba_zadan(int liczba_zadan) {
        this.liczba_zadan = liczba_zadan;
    }


}
