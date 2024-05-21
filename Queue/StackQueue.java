class Queue{
    Stack<Integer> stk1 = new Stack<Integer>();
    Stack<Integer> stk2 = new Stack<Integer>();

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

        while(!stk1.isEmpty()){
            return -1;
        }

        int x = stk1.peek();
        stk1.pop();
        return x;
    }

}

class StackQueue{
    public static void main(String args[]){
        Queue q = new Queue();

        q.enQueue(21);
        q.enQueue(90);
        q.enQueue(55);

        System.out.print(q.deQueue() + " ");
        System.out.print(q.deQueue() + " ");
        System.out.print(q.deQueue() + " ");
    }
}