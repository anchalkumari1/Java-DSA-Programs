class Stack{
    int arr[];
    int top;

    public Stack(){
      arr = new int[50];
      top = -1;
    }

    boolean isEmpty(){
      return (top == -1);
    }

    boolean isFull(){
      return (top == arr.length - 1);
    }

    void push(int data){
      if(isFull()){
        System.out.println("The Stack is Full");
        return;
      }else{
        top++;
        arr[top] = data;
      } 
    }

    int pop(){
      if(isEmpty()){
        System.out.println("The Stack is Empty");
        return -1;
      }else{
        int temp = arr[top];
        top--;
        return temp;
      }
    }

    int peek(){
      return arr[top];
    }

    int size(){
      return top + 1;
    }

  }

class ArrayStack{
    public static void main(String args[]){
    Stack s = new Stack();
    System.out.println(s.isEmpty());
    s.push(90);
    s.push(89);
    s.push(70);
    s.push(45);
    s.push(33);
    s.push(22);
    System.out.println("Popped Element : " + s.pop());
    System.out.println("Peeked Element : " + s.peek());
    System.out.println("Size of Stack : " + s.size());
    }
}