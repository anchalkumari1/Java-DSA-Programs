class Queue{
    int arr[], front, rear;

    public Queue(){
        arr = new int[10];
        front = 0;
        rear = -1;
    }

    boolean isEmpty(){
        return size() == 0;
    }

    boolean isFull(){
        return size() == arr.length;
    }

    void enQueue(int data){

        if(isFull()){
            System.out.println("The Queue is Full");
            return;
        }
        
        rear++;
        arr[rear] = data;
    }

    int deQueue(){

        if(isEmpty()){
            System.out.println("The Queue is Empty");
            return Integer.MIN_VALUE;
        }

        int deQueued = arr[front];
        front++;
        return deQueued;

    }

    int peek(){
        return arr[rear];
    }

    int size(){
        return rear - front + 1;
    }

    void print(){
        for(int i=front;i<=rear;i++){
            System.out.print(arr[i] + " ");
        }
    }
    
}

class ArrayQueue{
    public static void main(String args[]){
        Queue que = new Queue();
        //que.enQueue(89);
        que.enQueue(98);
        que.deQueue();
        que.print();
    }
}