public class ListItem {
    private Object key;
    private ListItem next;
    private ListItem prev;

    ListItem(Object key){
        this.key = key;
    }

    public Object getKey(){
        return this.key;
    }

    public ListItem getNext() {
        return this.next;
    }

    public ListItem getPrev(){
        return this.prev;
    }

    void setKey(Object key){
        this.key = key;
    }

    void setNext(ListItem next) {
        this.next = next;
    }

    void setPrev(ListItem prev) {
        this.prev = prev;
    }
}
