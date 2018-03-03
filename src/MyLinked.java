
public class MyLinked<T> {

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

        public Node prevNode(){
            return prev;
        }

        public T getElement(){
            return contains;
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



}
