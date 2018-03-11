package FIFOLIFO;

import MyArrayMyLinked.MyLinked;
import MyArrayMyLinked.NewLinked;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class FIFO<T> implements Queue<T>{

    private NewLinked<T> list;

    public FIFO(){
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
    public boolean contains(Object o) {  /////optional
        for(int i =0; i<size(); i++){
            if(o.equals(list.get(i))){
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
            tab[i] = (T) list.get(i);
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
    public boolean addAll(Collection<? extends T> c) {
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
        add(t);
        return true;
    }

    @Override
    public T remove() {
        T t = list.get(size()-1);
        list.removeLast();
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
        return list.get(size()-1);
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
