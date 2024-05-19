
class LinkedList{

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    void insertAtBeg(int data){
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
            return;
        }

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = newNode;
    }

    void insertAtMid(int data, int key){
        if(key == 0){
            insertAtBeg(data);
            return;
        }

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        int i = 0;
        Node curr = head;

        while(i <= key - 2){
            curr = curr.next;
            i++;
        }

        newNode.next = curr.next;
        curr.next = newNode;
    }

    int size(){
        Node curr = head;
        int s = 0;

        while(curr != null){
            curr = curr.next;
            s++;
        }

        return s;
    }

    void removeFromBeg(){
        if(head == null){
            System.out.println("The LinkedList is Empty");
            return;
        }

        head = head.next;
    }

    void removeFromEnd(){
        if(head == null){
            System.out.println("The LinkedList is Empty");
            return;
        }

        if(head.next == null){
            head = null;
            System.out.println("The LinkedList is now Empty");
            return;
        }

        Node curr = head;
        Node prev = null;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
    }

    void removeFrommid(int key){
        if(head == null){
            System.out.println("The LinkedList is Empty");
            return;
        }

        if(key == 0){
            removeFromBeg();
            return;
        }

        Node curr = head;
        Node prev =  null;
        int i = 0;
        while(i <= key - 1){
            prev = curr;
            curr = curr.next;
            i++;
        }
        prev.next = curr.next;
    }

    void print(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

class ScratchLL{
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.insertAtBeg(87);
        ll.insertAtEnd(22);
        ll.insertAtMid(34, 1);
        ll.removeFrommid(1);
        ll.print();
    }
}