public class List {

    private ListItem head;
    private ListItem tail;
    private boolean inverted;

    List(){
        this.inverted = false;
    }

    List(boolean inverted){
        this.inverted = inverted;
    }

    private void invert(){
        this.inverted = !this.inverted;
    }

    public ListItem insert(Object x){
        ListItem listItem = new ListItem(x);

        if (inverted){
            listItem.setPrev(this.tail);
            listItem.setNext(null);

            if (this.tail != null) this.tail.setNext(listItem);
            if (this.head == null) this.head = listItem;
            this.tail = listItem;
        } else {
            listItem.setNext(this.head);
            listItem.setPrev(null);

            if (this.head != null) this.head.setPrev(listItem);
            if (this.tail == null) this.tail = listItem;
            this.head = listItem;
        }

        return listItem;
    }

    public void delete(ListItem x){
        ListItem prev = x.getPrev();
        ListItem next = x.getNext();

        if (prev != null) {
            prev.setNext(next);
        } else {
            this.head = next;
        }

        if (next != null) next.setPrev(prev);
    }

    public void delete(Object x){
        this.delete(this.search(x));
    }

    public ListItem search(Object x){
        ListItem current = this.head;

        while(current != null && current.getKey().equals(x)){
            current = current.getNext();
        }

        return current;
    }


    public void printList(){
        ListItem current = this.head;

        while (current != null){
            System.out.printf("%s%s", current.getKey().toString(), current.getNext() == null ? "" : ", ");
            current = current.getNext();
        }
    }
}