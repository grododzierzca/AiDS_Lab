package FIFOLIFO;

import MyArrayMyLinked.MyLinked;
import MyArrayMyLinked.NewLinked;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class LIFO<T> implements Queue<T>{

    private NewLinked<T> list;

    public LIFO(){
        list = new NewLinked<>();
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
    public boolean contains(Object o) { /////optional
        for(Object t: list){
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
    public Object[] toArray() { /////optional
        Object[] tab = new Object[list.size()];
        for(int i = 0; i<tab.length; i++){
            tab[i] = list.get(i);
        }
        return tab;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) { /////optional
        @SuppressWarnings("unchecked")
        Object[] tab = new Object[list.size()];
        for(int i = 0; i<tab.length; i++){
            tab[i] = (T1) list.get(i);
        }
        return (T1[])tab;
    }

    @Override
    public boolean add(T t) {
        try{
            list.addFirst(t);
            return true;
        }catch(IllegalStateException e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean remove(Object o) { /////optional
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) { /////optional
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) { /////optional
        list.addAllF(c);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) { /////optional
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) { /////optional
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
        list.removeFirst();
        return t;
    }

    @Override
    public T poll() {
        if(list.size()==0){
            return null;
        }else{
            return remove();
        }
    }

    @Override
    public T element() {
        return list.get(0);
    }

    @Override
    public T peek() {
        if(list.size()==0){
            return null;
        }else{
            return element();
        }
    }
}
