

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinked<T> implements Iterable<T>{

    private Node first = null;
    private Node last = null;
    private int size = 0;
    private Node current = null;

    public MyLinked(){
        this.size = 0;
    }

    private class Node{

        private T contains;
        private Node next;
        private Node prev;

        public Node(Node prev, T contains, Node next){
            this.next = next;
            this.contains = contains;
            this.prev = prev;
        }

        public Node nextNode(){
            return next;
        }
        public void setNext(Node n){
            next = n;
        }

        public void setPrev(Node n){
            prev = n;
        }

        public Node prevNode(){
            return prev;
        }

        public T getElement(){
            return contains;
        }

        public void setElement(T t){
            contains = t;
        }
    }

    public void setCurrent(Node n){
        current = n;
    }

    public Node getCurrent(){
        return current;
    }

    public int size(){
        return size;
    }

    public int indexOf(T t){
        for(int i =0; i<size; i++){
            if(getCurrent().getElement().equals(t)){
                return i;
            }else{
                setCurrent(getCurrent().nextNode());
            }
        }
        return -1;
    }

    public void set(int index, T t){
        Node temp = first;
        for(int i = 0; i<index-1; i++){
            temp = temp.nextNode(); /// temp do jednego przed, a potem nextNode i setElement :P
        }
        temp.nextNode().setElement(t);
    }

    public void add(T t){
        if(first == null){
            Node new_first = new Node(null, t, null);
            first = new_first;
            last = new_first;
            current = new_first;
        }else{
            Node new_last = new Node(last, t, null);
            last.setNext(new_last);
            last = new_last;
        }
    }

    public void add(int index, T t){
        Node temp = first;
        for(int i = 0; i<index-1; i++){
            temp = temp.nextNode();
        }
        Node new_node = new Node(temp, t, temp.nextNode());
        temp.setNext(new_node);
        temp.nextNode().setPrev(new_node);
    }

    public void remove(int index) throws IndexOutOfBoundsException{
        Node temp = first;
        for(int i = 0; i<index-1; i++){
            temp = temp.nextNode();
        }
        temp.setNext(temp.nextNode().nextNode());
        temp.nextNode().nextNode().setPrev(temp.nextNode());
        System.gc();
    }

    public void clear(){
        first = null;
        last = null;
        current = null;
        System.gc();
    }

    public void addAll(Collection c){
        for (Object o: c){
            add((T)o);
            }
    }

    public void addAll(int index, Collection c){
        for(Object o: c){
            add(index, (T)o);
        }
    }

    public T get(int index){
        Node temp = first;
        for(int i = 0; i<index; i++){
            temp = temp.nextNode();
        }
        return temp.getElement();
    }



    @Override
    public Iterator<T> iterator() {
        return new MyLinkedIt();
    }

    private class MyLinkedIt<T> implements Iterator<T> {
        private int current;

        public MyLinkedIt() {
            current = 0;
        }


        @Override
        public boolean hasNext() {
            if (current < size) return true;
            else return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                current++;
                return (T) getCurrent().nextNode().getElement();
            } else {
                throw new NoSuchElementException();
            }
        }


    }
}
