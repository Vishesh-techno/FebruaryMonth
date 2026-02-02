public class TwoFebruary {
    static class Node {
        int data;
        Node next;

        Node() {

        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        static Node head;
        static int size = 0;

        public static void addNode(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public static void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "==>>");
                temp = temp.next;
                size++;
            }
            System.out.println("null");
        }

        public static int getKthFromLast(Node head, int k) {
            if (k > size) return -1;
            int sz = 0;
            Node temp = head;
            while (temp != null) {
                if (sz == size - k) {
                    return temp.data;
                }
                temp = temp.next;
                sz++;
            }
            return -1;
        }

        public static int getKthFromLastII(Node head, int k) {
            if (head == null) return -1;
            Node fast = head;
            Node slow = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow.data;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            Node.addNode(i);
        }
        Node.addNode(9);
        Node.addNode(7);
        Node.addNode(8);
        Node.print();
        int res = Node.getKthFromLastII(Node.head, 3);
        System.out.println(res);
    }
}
