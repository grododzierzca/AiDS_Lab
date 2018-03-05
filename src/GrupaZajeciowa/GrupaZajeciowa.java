package GrupaZajeciowa;

import java.io.*;
import java.util.ArrayList;

public class GrupaZajeciowa {
    private ArrayList<Student> lista;
    private int liczba_zadan, max_punktow;

    public GrupaZajeciowa(int liczba_zadan, int max_punktow){
        lista = new ArrayList();
        this.liczba_zadan = liczba_zadan;
        this.max_punktow = max_punktow;
    }

    public ArrayList<Student> getLista(){
        return lista;
    }

    public void addStudent(String imie, String nazwisko, int indeks, int semestr, int rok){
        Student a = new Student(imie, nazwisko, indeks, semestr, rok, liczba_zadan, max_punktow);
        lista.add(a);
    }
    public void delStudent(){
        if(lista.size()>0){
            lista.remove(0);
        }else{
            System.out.println("Lista jest pusta.");
        }
    }
    public void delStudent(int indeks){
        for(int i = 0; i <lista.size(); i++){
            if(lista.get(i).getIndeks() == indeks){
                lista.remove(i);
            }else{
                System.out.println("Brak studenta o takim indeksie.");
            }
        }
    }
    public double policzSrednia(){
        double temp = 0;
        for (Student a : lista){
            temp+=a.getOcena();
        }
        return temp/lista.size();
    }
    public void update(){
        for(Student a: lista){
            a.update();
        }
    }
    public String toString(){
        String str = new String();
        for (Student a: lista){
            str+=a.toString();
        }
        return str;
    }
    public void save(){
        try(PrintWriter out = new PrintWriter(new File("grupa.csv"))){
            StringBuilder stb = new StringBuilder();
            stb.append("imie,nazwisko,indeks,semestr,rok,ocena\n");
            for(Student a: lista){
               stb.append(a.getImie()+",");
               stb.append(a.getNazwisko()+",");
               stb.append(a.getIndeks()+",");
               stb.append(a.getSemestr()+",");
               stb.append(a.getRok()+",");
               stb.append(a.getOcena()+",");
               for(int i = 0; i<liczba_zadan; i++){
                   stb.append(a.getZadania().getZadania()[i]+",");
               }
               stb.append("\n");
           }
           out.write(stb.toString());
        }catch(FileNotFoundException e){
            System.out.println("Nie ma takiego pliku.");
        }
    }
    public void load(){
        try(BufferedReader in = new BufferedReader(new FileReader("grupa.csv"))){
            ArrayList <Student> lista_new = new ArrayList();
            in.readLine();
            String wiersz = new String();
            while((wiersz = in.readLine())!=null){
                String [] temp = wiersz.split(",");
                Student a = new Student(temp[0], temp[1], Integer.valueOf(temp[2]), Integer.valueOf(temp[3]), Integer.valueOf(temp[4]), liczba_zadan, max_punktow);
                for(int i=0; i<liczba_zadan; i++){
                    a.getZadania().setUzyskaneP(i, Integer.valueOf(temp[6+i]));
                }
                lista_new.add(a);
            }
            lista=lista_new;
            update();
        }catch(IOException e){

        }
    }



}
