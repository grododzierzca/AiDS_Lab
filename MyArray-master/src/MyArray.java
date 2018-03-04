import java.util.*;

public class MyArray<T> implements Iterable<T>{

    private Object[] tab;
    private int size, last = 0;

    public MyArray(){
        tab = new Object[10];
        size = 10;
    }
    public MyArray(int size){
        tab = new Object[size];
        this.size = size;
    }

    public MyArray(Collection c){
        tab = new Object[c.size()];
        this.size = c.size();
        last = c.size();
        for(int i = 0; i<size; i++){
            tab[i] = c.iterator().next();
        }
    }

    public void add(T t){
        checkSize();
        tab[last] = t;
        last++;
    }

    public void add(int index, T t) throws IndexOutOfBoundsException{
        moveFwd(index);
        tab[index] = t;
        last++;
    }

    public void addAll(Collection c){
        for(int i = last; i<last+c.size(); i++){
            checkSize();
            tab[i] = c.iterator().next();
            last++;
        }
    }
    public void addAll(int index, Collection c) throws IndexOutOfBoundsException{
        for(int i = index; i<index+c.size(); i++){
            checkSize();
            moveFwd(i);
            tab[i] = c.iterator().next();
            last++;
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException{ //???????????????????????????????????????????????
        moveBkw(index);
        last--;
    }

    public void clear(){
        tab = new Object[10];
        System.gc();
        last = 0;
    }

    public Object get(int index) throws IndexOutOfBoundsException{
        return tab[index];
    }

    public void set(int index, T t){
        if(index<=last) {
            tab[index] = t;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public int indexOf(T t){
        for(int i = 0; i<last; i++){
            if(tab[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    public int size(){
        return last;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i<last; i++){
            s+=tab[i].toString()+" ";
        }
        return s;
    }


    private void moveBkw(int from){
        checkSize();
        for(int i = from; i<last; i++){
            tab[i] = tab[i+1];
        }
    }


    private void moveFwd(int from){
        checkSize();
        for(int i = last; i>from; i--) {
            tab[i] = tab[i - 1];
        }
    }



    private void checkSize(){
        if(size == last){
            size = tab.length*2;
            tab = Arrays.copyOf(tab, size);
        }
        else if(last*3 == size*2){
            size = tab.length*2/3 +1;
            tab = Arrays.copyOf(tab, size);
        }
    }



    @Override
    public Iterator iterator() {

        return new MyArrayIt();
    }

    private class MyArrayIt<T> implements Iterator<T>{

        private int current;

        public MyArrayIt(){
            current = 0;
        }

        @Override
        public boolean hasNext() {
            if(current<last){
                return true;
            }else{
                return false;
            }

        }

        @Override
        public T next() {
            if(hasNext()){
                T temp = (T) tab[current+1];
                current++;
                return temp;
            }else{
                throw new NoSuchElementException();
            }
        }
    }
}
