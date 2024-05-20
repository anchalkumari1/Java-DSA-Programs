class Queue{

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node front, rear;

    public Queue(){
        front = null;
        rear = null;
    }

    boolean isEmpty(){
        return front == null;
    }

    void enQueue(int data){
        Node newNode = new Node(data);
        
        if(isEmpty()){
            rear = newNode;
            front = rear;
            return;
        }

        rear.next = newNode;
        rear = newNode;
        
    }

    int deQueue(){

        if(isEmpty()){
            System.out.println("The Queue is Empty");
            return Integer.MIN_VALUE;
        }

        int deQueued = front.data;
        front = front.next;
        return deQueued;

    }

    int peek(){
        return rear.data;
    }

    int size(){
        Node curr = front;
        int s = 1;

        while(curr != rear){
            s++;
            curr = curr.next;
        }
        return s;
    }

    void print(){
        
        if(isEmpty()){
            System.out.println("The Queue is Empty");
        }

        Node curr = front;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    
}

class LinkedListQueue{
    public static void main(String args[]){
        Queue que = new Queue();
        que.enQueue(46);
        que.enQueue(11);
        que.enQueue(76);
        que.deQueue();
        que.deQueue();
        System.out.println("Size of Queue: " + que.size());
        System.out.print("Elements in Queue: ");
        que.print();
    }
}