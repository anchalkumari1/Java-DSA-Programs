import java.util.*;
class Queue{
    ArrayList<Integer> arr;
    int front, rear;

    public Queue(){
        arr = new ArrayList<>();
        front = 0;
        rear = -1;
    }

    boolean isEmpty(){
        return size() == 0;
    }

    void enQueue(int data){
        rear++;
        arr.add(data);
    }

    int deQueue(){

        if(isEmpty()){
            System.out.println("The Queue is Empty");
            return Integer.MIN_VALUE;
        }

        int deQueued = arr.get(front);
        front++;
        return deQueued;

    }

    int peek(){
        return arr.get(rear);
    }

    int size(){
        return (rear - front + 1);
    }

    void print(){
        for(int i=front;i<=rear;i++){
            System.out.print(arr.get(i) + " ");
        }
    }
    
}

class ArrayListQueue{
    public static void main(String args[]){
        Queue que = new Queue();
        que.enQueue(43);
        que.enQueue(56);
        que.enQueue(77);
        que.enQueue(88);
        que.deQueue();
        System.out.println("Size of Queue: " + que.size());
        System.out.print("Elements in Queue: ");
        que.print();
    }
}