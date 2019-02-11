import java.util.Arrays;

public class Queue {

    private Object[] queue;
    private int head;
    private int tail;

    Queue(int size){
        this.queue = new Object[size];
    }

    public boolean isEmpty(){
        return this.head == this.tail;
    }

    public void enqueue(Object key){

        this.queue[this.tail] = key;
        this.tail = (this.tail + 1) % (this.queue.length);

    }

    public Object dequeue(){
        Object key = this.queue[this.head];
        this.head = (this.head + 1) % (this.queue.length);

        return key;
    }

    public void printQueue(){
        System.out.println(Arrays.toString(this.queue));
    }
}
