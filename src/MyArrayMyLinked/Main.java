package MyArrayMyLinked;

import GrupaZajeciowa.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String [] args){

        MyArray<Student> ar = new MyArray<>();
        MyLinked<Student> lk = new MyLinked<>();
        int liczba_zadan = 5;
        int max_punktow = 10;
        ArrayList<Student> lista = new ArrayList();

        try(BufferedReader in = new BufferedReader(new FileReader("grupa.csv"))){
            in.readLine();
            String wiersz = new String();
            while((wiersz = in.readLine())!=null){
                String [] temp = wiersz.split(",");
                Student a = new Student(temp[0], temp[1], Integer.valueOf(temp[2]), Integer.valueOf(temp[3]), Integer.valueOf(temp[4]), liczba_zadan, max_punktow);
                for(int i=0; i<liczba_zadan; i++){
                    a.getZadania().setUzyskaneP(i, Integer.valueOf(temp[6+i]));
                }
                lista.add(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lk.addAll(lista);
        ar.addAll(lista);

        while(ar.iterator().hasNext()){
            System.out.println(ar.iterator().next().toString());
        }
        while(lk.iterator().hasNext()){
            System.out.println(lk.iterator().next().toString());
        }


    }

}
