public class Node<T> {
    //Node after this node
    //Tail should have next as NULL
    public Node next;
    //Node ahead of this node
    //Head should have prev as NULL
    public Node prev;
    public T data;


    /*
    next -> Node -> prev
    */

    public Node(T data){
        this.data = data;
    }
    @Override
    public String toString(){
        return data.toString();
    }
}
