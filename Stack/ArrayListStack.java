import java.util.*;

class Stack{
    ArrayList<Integer> arr;
    int top;

    public Stack(){
      arr = new ArrayList<>();
      top = -1;
    }

    boolean isEmpty(){
      return (top == -1);
    }

    void push(int data){
      
        top++;
        arr.add(data);

    }

    int pop(){

      if(isEmpty()){
        System.out.println("The Stack is Empty");
        return -1;
      }else{
        int temp = arr.get(top);
        top--;
        return temp;
      }

    }

    int peek(){
      return arr.get(top);
    }

    int size(){
      return top + 1;
    }
  }

class ArrayListStack{
    public static void main(String args[]){
    Stack s = new Stack();
    System.out.println(s.isEmpty());
    s.push(99);
    s.push(87);
    s.push(76);
    s.push(54);
    s.push(66);
    s.push(12);
    System.out.println("Popped Element : " + s.pop());
    System.out.println("Peeked Element : " + s.peek());
    System.out.println("Size of Stack : " + s.size());
  }
}