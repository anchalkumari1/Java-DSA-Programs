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

class BinaryTree{
    
    int idx = -1;

    Node buildTree(int nodes[]){
        idx++;

        if(nodes[idx] == -1){
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
        
    }
    
    void preOrder(Node root){

        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }
    
    void inOrder(Node root){

        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    void postOrder(Node root){

        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }
}

class BTTraversals{
    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.print("Preorder Traversal of Tree : ");
        tree.preOrder(root);
        System.out.println();

        System.out.print("Inorder Traversal of Tree : ");
        tree.inOrder(root);
        System.out.println();

        System.out.print("Postorder Traversal of Tree : ");
        tree.postOrder(root);
        System.out.println();

    }
}