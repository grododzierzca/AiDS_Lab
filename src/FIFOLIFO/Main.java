package FIFOLIFO;

import MyArrayMyLinked.NewLinked;

public class Main {

     public static void main(String [] args){

         NewLinked<Integer> nl = new NewLinked<>();
         nl.addFirst(1);
         nl.addFirst(2);
         nl.addLast(3);

         System.out.println(nl);

         nl.removeFirst();
         System.out.println(nl);
         nl.removeLast();
         System.out.println(nl);




     }
}
