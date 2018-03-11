package FIFOLIFO;

import MyArrayMyLinked.MyLinked;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class LIFO<T> implements Queue<T>{

    private MyLinked<T> list;

    public LIFO(){
        list = new MyLinked<>();
    }


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        if(list.size() == 0) return true;
        else return false;
    }

    @Override
    public boolean contains(Object o) {
        for(T t: list){
            if(t.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] tab = new Object[list.size()];
        for(int i = 0; i<tab.length; i++){
            tab[i] = list.get(i);
        }
        return tab;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) { /////////////////////////////////
        return null;
    }

    @Override
    public boolean add(T t) {
        list.add(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).equals(o)){
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) { //////////////////////
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        list.add((T) c);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        T t = list.get(0);
        list.remove(0);
        return t;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }
}
