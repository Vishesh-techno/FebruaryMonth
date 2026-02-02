import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
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

    public static Node removeNthFromEnd(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy, slow = dummy;
        for (int i = 0; i <= k; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

public class TwoFebruary {

    public static List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int n1 = arr1.size(), n2 = arr2.size(), n3 = arr3.size();
        while (i < n1 && j < n2 && k < n3) {
            int a = arr1.get(i);
            int b = arr2.get(j);
            int c = arr3.get(k);

            if (a == b && b == c) {
                res.add(a);
                int val = a;
                while (i < n1 && val == arr1.get(i)) i++;
                while (j < n2 && val == arr2.get(j)) j++;
                while (k < n3 && val == arr3.get(k)) k++;
            } else if (a < b) {
                i++;
            } else if (b < c) {
                j++;
            } else {
                k++;
            }
        }
        return res;
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
        Node.head = Node.removeNthFromEnd(Node.head, 3);
        Node.print();
        List<Integer> a = Arrays.asList(1, 5, 10, 20, 40, 80);
        List<Integer> b = Arrays.asList(6, 7, 20, 80, 100);
        List<Integer> c = Arrays.asList(3, 4, 15, 20, 30, 70, 80, 120);

        System.out.println(commonElements(a, b, c));
    }
}
