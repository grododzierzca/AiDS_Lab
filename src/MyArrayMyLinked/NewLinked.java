package MyArrayMyLinked;

import java.util.Collection;
import java.util.Iterator;

public class NewLinked<T> implements Iterable{

    private Node first;
    private Node last;
    private int size;
    private NewLinkedIt it = new NewLinkedIt();

    public NewLinked(){
        size = 0;
    }

    private class Node{
        private Node next;
        private Node prev;
        private T contains;

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
    public void bind(Node n1, Node n2){
        n1.setNext(n2);
        n2.setPrev(n1);
    }


    public void addFirst(T t){
        Node newNode = new Node(null, t, null);
        if(first != null){
            bind(newNode, first);
            first = newNode;
            size++;
        }else{
            first = newNode;
            last = newNode;
            size++;
        }
    }

    public void addLast(T t){
        Node newNode = new Node(null, t, null);
        if(last != null){
            bind(last, newNode);
            last = newNode;
            size++;
        }else{
            first = newNode;
            last = newNode;
            size++;
        }
    }

    public void removeFirst(){
        if(size>1){
            Node newFirst = first.nextNode();
            first.setNext(null);  //?
            newFirst.setPrev(null);
            first = newFirst;
            size--;
        }else if(size == 1){
            clear();
        }
    }

    public void removeLast(){
        if(size>1){
            Node newLast = last.prevNode();
            last.setPrev(null);
            newLast.setNext(null);
            last = newLast;
            size--;
        }else if(size==1){
            clear();
        }
    }

    public int size(){
        return size;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i<size; i++){
            s+=get(i).toString()+"\n";
        }
        return s;
    }

    public T get(int index) throws IndexOutOfBoundsException{
        Node temp = new Node(null, null, first);
        for(int i = 0; i<=index; i++){
            temp = temp.nextNode();
        }
        return temp.getElement();
    }

    public void addAllF(Collection c){
        for(Object o: c){
            addFirst((T) o);
        }
    }
    public void addAllL(Collection c){
        for(Object o: c){
            addLast((T) o);
        }
    }

    public void clear(){
        first = null;
        last = null;
        size = 0;
        System.gc();
    }





    private class NewLinkedIt<T> implements Iterator<T>{

        private int currentEl;

        public NewLinkedIt(){
            currentEl = 0;
        }

        @Override
        public boolean hasNext() {
            if(currentEl<size){
                return true;
            }else{
                return false;
            }
        }

        @Override
        public T next() {
            Node n;
            if (hasNext()) {
                n = first.nextNode();
                currentEl++;
                return (T) n.getElement();
            }else{
                return null;
            }

        }
    }

    @Override
    public Iterator iterator() {
        return it;
    }
}
