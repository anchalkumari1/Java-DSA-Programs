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
}

class BST{
    public static void main(String args[]){
        int values[] = {5, 1, 3, 4, 2, 7};

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
    }
}