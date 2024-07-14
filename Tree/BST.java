class Node{

    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BSTree{
    
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(val < root.data){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    boolean search(Node root, int key){
        
        if(root == null){
            return false;
        }

        if(key < root.data){
            return search(root.left, key);
        }else if(key > root.data){
            return search(root.right, key);
        }else{
            return true;
        }
    }

    Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }

            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            Node is = inOrderSuccessor(root.right);
            root.data = is.data;
            root.right = delete(root.right, is.data); 
        }
        return root;
    }

    Node inOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }

        else if(root.data < k1){
            printInRange(root.right, k1, k2);
        }

        else if(root.data > k2){
            printInRange(root.left, k1, k2);
        }
    }

    
}

class BST{
    public static void main(String args[]){
        int values[] = {3, 4, 5, 6, 1, 11, 10, 14, 8};

        BSTree tree = new BSTree();
        Node root = null;

        for(int i=0;i<values.length;i++){
            root = tree.insert(root, values[i]);
        }

        tree.inOrder(root);
        System.out.println();

        if(tree.search(root, 7)){
            System.out.println("Found the key.");
        }else{
            System.out.println("Not found.");
        }

        tree.delete(root, 5);
        tree.inOrder(root);
        System.out.println();

        tree.printInRange(root, 5, 12);
        
    }
}