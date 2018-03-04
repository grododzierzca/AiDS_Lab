package GrupaZajeciowa;

public class Student {

    private String imie, nazwisko;
    private int indeks, semestr, rok;
    private double ocena;
    private Zadania zad;

    public Student(String imie, String nazwisko, int indeks, int semestr, int rok, int liczba_zadan, double max_punktow){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.indeks = indeks;
        this.semestr = semestr;
        this.rok = rok;
        zad = new Zadania(liczba_zadan, max_punktow);
        update();
    }



    public void update(){
        korekta();
        obliczOcene();
    }

    private void korekta(){
        for(int i = 0; i<zad.getLiczba_zadan(); i++){
            if(zad.getZadania()[i]>zad.getMax_punktow()){
                zad.getZadania()[i]= (int) zad.getMax_punktow();
            }
        }
    }


    private void obliczOcene(){
        double temp = zad.getUzyskaneP()/zad.getSumaMax();
        if(Double.compare(temp, 0.5)<=0){
            ocena = 2;
        }else if(Double.compare(temp, 0.6)<=0){
            ocena = 3;
        }else if(Double.compare(temp, 0.7)<=0){
            ocena = 3.5;
        }else if(Double.compare(temp, 0.8)<=0){
            ocena = 4;
        }else if(Double.compare(temp, 0.9)<=0){
            ocena = 4.5;
        }else{
            ocena = 5;
        }
    }

    public String getImie() {
        return imie;
    }
    public Zadania getZadania(){
        return zad;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public int getSemestr() {
        return semestr;
    }

    public void setSemestr(int semestr) {
        this.semestr = semestr;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public double getOcena() {
        return ocena;
    }
    public String toString(){
        return imie+" "+nazwisko+", "+indeks+" "+"sem. "+semestr+" rok "+rok+", ocena: "+getOcena()+"\n";
    }
}
