public class DoublyLinkedList<T> {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    private DoublyLinkedList(Node head, Node tail, int length){
        this.head = head;
        this.tail = tail;
        this.length = length;
    }

    public Node append(T data){
        Node toAppend = new Node<>(data);
        if(length == 0){
            this.head = toAppend;
            length++;
        }else if(length == 1){
            this.tail = toAppend;
            this.head.next = toAppend;
            this.tail.prev = this.head;
            length++;
        }else{
            this.tail.next = toAppend;
            toAppend.prev = this.tail;
            this.tail = toAppend;
            length++;
        }
        return toAppend;
    }

    public Node insert(int index, T data){
        if (index > length || index < 0) {
            throw new IllegalArgumentException("Index Out of Bounds!");
        }

        Node toInsert = new Node<>(data);

        if (index == 0) {
            toInsert.next = head;
            if (head != null) {
                head.prev = toInsert;
            }
            head = toInsert;
            if (length == 0) {
                tail = toInsert;
            }
        } else if (index == length) {
            return append(data);
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            toInsert.next = curr.next;
            toInsert.prev = curr;
            if (curr.next != null) {
                curr.next.prev = toInsert;
            }
            curr.next = toInsert;
        }
        length++;
        return toInsert;
    }

    public Node delete(int index){
        Node curr = this.head;

        if (index < 0 || index >= this.length) {
            throw new IllegalArgumentException("Index is out of bounds!");
        }else {
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        }

        if(curr.equals(head)){
            head = head.next;
            if(head != null){
                head.prev = null;
            }else{
                tail = null;
            }
        }else if(curr.equals(tail)){
            tail = tail.prev;
            tail.next = null;
        }else{
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        length--;
        return curr;
    }

    public int getIndex(T data){
        Node curr = head;
        for(int i = 0; curr != null; i++){
            if(curr.data.equals(data)) {
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }

    public Node shuffle(){
        if(head == null||tail==null){
            return head;
        }
        Node newHead = head.next;
        Node previous = null;
        Node curr = head;

        while (curr != null && curr.next != null) {
            Node nextNode = curr.next.next;
            Node second = curr.next;
            second.next = curr;
            curr.next = nextNode;
            if (previous != null) {
                previous.next = second;
            }
            previous = curr;
            curr = nextNode;
        }
        return newHead;
    }

    public DoublyLinkedList Partition(T data){
        Node curr = head;
        DoublyLinkedList returnList;
        for(int i = 0; i<length;i++){
            if(curr.data.equals(data)){
                returnList = new DoublyLinkedList(curr,tail,length-i);
                returnList.head.prev = null;
                return returnList;
            }
        }
        throw new IllegalArgumentException("Data does not exist in this list!");
    }

    @Override
    public String toString(){
        Node curr = this.head;
        StringBuilder returnString = new StringBuilder();
        for(int i = 0; i < this.length; i++){
            returnString.append(curr.toString() + " --> ");
            curr = curr.next;
        }
        returnString.append("NULL");
        return returnString.toString();
    }
}
