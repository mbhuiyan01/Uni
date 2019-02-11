import java.util.Arrays;

public class Stack {
    private Object[] stack;
    private int top;

    Stack(int size){
        this.top = 0;
        this.stack = new Object[size];
    }

    public boolean isEmpty(){
        return this.top == 0;
    }

    public void push(Object x){
        this.stack[this.top++] = x;
    }

    public Object pop(){
        return this.stack[--this.top];
    }

    public Object top(){
        return this.stack[this.top];
    }

    public void printStack(){
        System.out.println(Arrays.toString(this.stack));
    }
}
