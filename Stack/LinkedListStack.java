class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Stack{
    Node top;

    public Stack(){
        top = null;
    }

    boolean isEmpty(){
        return top == null;
    }

    void push(int data){
        Node newNode = new Node(data);

        if(isEmpty()){
            top = newNode;
            return;
        }

        newNode.next = top;
        top = newNode;
    }

    int pop(){
        if(isEmpty()){
            System.out.println("The Stack is Empty");
            return -1;
        }
        int temp = top.data;
        top = top.next;
        return temp;
    }

    int peek(){
        if(isEmpty()){
            System.out.println("The Stack is Empty");
            return -1;
        }
        return top.data;
    }

    int size(){
        int sizeS = 0;
        Node curr = top;
        while(curr != null){
            sizeS++;
            curr = curr.next;
        }

        return sizeS;
    }

}

class LinkedListStack{
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(34);
        s.push(30);
        s.push(54);
        s.push(67);
        System.out.println("Popped Element : " + s.pop());
        System.out.println("Peeked Element : " + s.peek());
        System.out.println("Size of Stack : " + s.size());
    }
}