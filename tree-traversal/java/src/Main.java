import java.util.*;

public class Main {

    public class Node {
        char value;
        Node left;
        Node right;
        
        public Node() {
            left = null;
            right = null;
        }
    }

    public Node createTree() {
        Node head = new Node();
        head.value = 'A';
        head.left = new Node();
        head.right = new Node();
        head.left.value = 'B';
        head.right.value = 'C';
        head.left.left = new Node();
        head.left.left.value = 'D';
        return head;
    }

    public void BFS(Node tree) {
        LinkedList<Node> queue = new LinkedList<Node>();
        //TreeSet<Node> visited = new TreeSet<Node>();
        queue.add(tree);
        System.out.print("Contents of tree in BFS order: ");
        while (!queue.isEmpty()) {
            Node current = queue.pop();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
            System.out.print(current.value);
            if (!queue.isEmpty()) System.out.print(", ");
        }
        System.out.println();
    }

    private String DFSHelper(Node tree) {
        if (tree == null) return "";
        String treeStr = Character.toString(tree.value) + ", ";
        if (tree.left != null) treeStr += DFSHelper(tree.left);
        if (tree.right != null) treeStr += DFSHelper(tree.right);
        return treeStr;
    }

    public void DFS(Node tree) {
        StringBuffer treeStr = new StringBuffer(DFSHelper(tree));
        treeStr.deleteCharAt(treeStr.length() - 1);
        treeStr.deleteCharAt(treeStr.length() - 1);
        System.out.println("Contents of tree in DFS order: " + treeStr.toString());
    }

    private String DFSWithLevelHelper(Node tree, int parentLevel) {
        if (tree == null) return "";
        String treeStr = Character.toString(tree.value) + " at level " + (parentLevel + 1) + ", ";
        if (tree.left != null) treeStr += DFSWithLevelHelper(tree.left, parentLevel + 1);
        if (tree.right != null) treeStr += DFSWithLevelHelper(tree.right, parentLevel + 1);
        return treeStr;
    }

    public void DFSWithLevel(Node tree) {
        StringBuffer treeStr = new StringBuffer(DFSWithLevelHelper(tree, 0));
        treeStr.deleteCharAt(treeStr.length() - 1);
        treeStr.deleteCharAt(treeStr.length() - 1);
        System.out.println("Contents of tree in DFS order with depth: " + treeStr.toString());
    }

    public void BFSWIthLevel(Node tree) {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(tree);
        Node EOLNode = tree;
        int level = 0;
        System.out.print("Contents of tree in BFS order: ");
        while(!queue.isEmpty()) {
            Node current = queue.pop();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
            System.out.print(current.value + " at level " + level);
            if (!queue.isEmpty()) {
                System.out.print(", ");
                if (current == EOLNode) {
                    level++;
                    EOLNode = queue.getLast();
                }
            }
        }
        System.out.println();
    }

    public void runTest() {
        Node tree = createTree();
        BFS(tree);
        DFS(tree);
        BFSWIthLevel(tree);
        DFSWithLevel(tree);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.runTest();
    }
}