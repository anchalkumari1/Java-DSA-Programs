import java.util.*;

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
    void levelOrder(Node root){
        if(root == null){
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr = q.remove();

            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    System.out.println();
                    q.add(null);
                }
            }else{
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

        }
    }

    int height(Node root){

        if(root == null){
            return 0;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);

        return Math.max(leftH , rightH) + 1;
    }

    int count(Node root){
        if(root == null){
            return 0;
        }

        int lCount = count(root.left);
        int rCount = count(root.right);

        return (lCount + rCount + 1);
    }

    int sum(Node root){
        if(root == null){
            return 0;
        }

        int leftS = sum(root.left);
        int rightS = sum(root.right);

        return (leftS + rightS + root.data);
    }

    int diameter(Node root){
        if(root == null){
            return 0;
        }

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2));
    }

    class TreeInfo{
        int height;
        int diam;

        public TreeInfo(int height, int diam){
            this.height = height;
            this.diam = diam;
        }
    }

    TreeInfo optDiameter(Node root){
        if(root == null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left = optDiameter(root.left);
        TreeInfo right = optDiameter(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.height + right.height + 1;

        int myDiam = Math.max(Math.max(diam1, diam2), diam3);

        return new TreeInfo(myHeight, myDiam);
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

        System.out.println("Levelorder Traversal of Tree : ");
        tree.levelOrder(root);
        System.out.println();
        
        System.out.println("Height of the Tree : " + tree.height(root));
        System.out.println("Number of Nodes : " + tree.count(root));
        System.out.println("Sum of Nodes : " + tree.sum(root));
        System.out.println("Diameter of Tree : " + tree.diameter(root));
        System.out.println("Diameter of Tree (through optimal approach) : " + tree.optDiameter(root).diam);
    }
}