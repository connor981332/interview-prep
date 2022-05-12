public class Main {

    private class Node {
        public char value;
        public Node next;
    }

    public void insertList(char[] chars, Node head) {
        Node current = head;
        for (int i = 0; i < chars.length; i++) {
            current.value = chars[i];
            if (i != chars.length - 1) current.next = new Node();
            current = current.next;
        }
    }

    public void printList(Node list) {
        Node current = list;
        System.out.print("List contents: ");
        while (current != null) {
            System.out.print(current.value);
            current = current.next;
            if (current != null) System.out.print(", ");
        }
        System.out.println();
    } 

    public void runTest() {
        Node head = new Node();
        char[] list = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        insertList(list, head);
        printList(head);
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.runTest();

    }
}