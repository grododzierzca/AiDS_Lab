public class Main {

    public static void main(String [] args){

        MyArray<Integer> a = new MyArray<>();
        MyArray<String> b = new MyArray<>(10);

        a.add(1);
        a.add(100);
        System.out.println(a.toString());
        for(int i = 0; i<100; i++){
            a.add(i*i);
        }
        System.out.println(a.toString());
        System.out.println(a.size());

        b.add("Czipsy");
        b.add(0, "Kupa");
        System.out.println(b.toString());
        System.out.println(b.size());

        for(int i = 0; i <= a.size(); i++){
            a.remove(i);
        }
        System.out.println("Czip "+a);



    }

}
