import java.util.*;
class Queue{
    Stack<Integer> stk1 = new Stack<Integer>();
    Stack<Integer> stk2 = new Stack<Integer>();

    boolean isEmpty(){
        return stk1.isEmpty();
    }

    void enQueue(int x){

        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        stk1.push(x);

        while(!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }
        
    }

    int deQueue(){

        while(stk1.isEmpty()){
            System.out.println("The Queue is Empty");
            return -1;
        }

        int x = stk1.peek();
        stk1.pop();
        return x;
    }

    int peek(){

        if(isEmpty()){
            System.out.println("The Queue is Empty");
            return -1;
        }

        return stk1.peek();
    }

}

class StackQueue{
    public static void main(String args[]){
        Queue q = new Queue();

        q.enQueue(21);
        q.enQueue(90);
        q.enQueue(55);
        System.out.println("Peeked Element: " + q.peek());
        System.out.print("Popped Element: ");
        while(!q.isEmpty()){
            System.out.print(q.deQueue() + " ");
        }
        
    }
}