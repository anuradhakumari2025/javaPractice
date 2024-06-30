import java.util.List;

public class SinglyLinkedList {
  ListNode head;

  class ListNode {
    /*
     * ListNode class defines structure of a node in the
     * linked list, with an integer data and a reference next to the next node.
     */
    int data;
    ListNode next;

    ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // public SinglyLinkedList() {
  // // Create nodes
  // head = new ListNode(10);
  // ListNode second = new ListNode(20);
  // ListNode third = new ListNode(30);
  // ListNode fourth = new ListNode(40);
  // ListNode fifth = new ListNode(50);

  // // Link nodes
  // head.next = second;
  // second.next = third;
  // third.next = fourth;
  // fourth.next = fifth;
  // }

  public int findLength() {
    if (head == null) {
      return 0;
    }
    int count = 0;
    ListNode current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    System.out.println();
    System.out.println("Length of listNode is " + count);
    return count;
  }

  public void insertNodeAtBegin(int value) {
    ListNode newNode = new ListNode(value);
    newNode.next = head;
    head = newNode;
  }

  public void insertNodeAtEnd(int value) {
    ListNode newNode = new ListNode(value);
    if (head == null) {
      head = newNode;
      return;
    }
    ListNode current = head;
    while (null != current.next) { // if it is written current.next != null then it will show error
      current = current.next;
    }
    current.next = newNode;
  }

  public void insertNodeAtposition(int position, int value) {
    ListNode newNode = new ListNode(value);
    if (position == 1) {
      newNode.next = head;
      head = newNode;
    } else {
      ListNode previous = head;
      int count = 1;
      while (count < position - 1) {
        previous = previous.next;
        count++;
      }
      ListNode current = previous.next;
      newNode.next = current;
      previous.next = newNode;
    }
  }

  public ListNode deleteFirstNode() { // return value is null or listnode so in declaration ListNode is used
    if (head == null) {
      return null;
    }
    ListNode temp = head;
    head = temp.next;
    temp.next = null;
    return temp;
  }

  public ListNode deleteLastNode() {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode temp = head;
    ListNode previous = null;
    while (temp.next != null) {
      previous = temp;
      temp = temp.next;
    }
    previous.next = null;
    return temp;

  }

  public ListNode deleteNodeAtPosition(int position) {
    if (position == 1) {
      return null;
    }
    ListNode current = head;
    ListNode previous = null;
    int count = 1;
    while (count < position - 1) {
      previous = current;
      current = current.next;
      count++;
    }
    previous = previous.next;
    current.next = current.next.next;
    return previous;
  }

  public boolean searchNodeData(int searchKey) {
    ListNode current = head;
    if (head == null) {
      return false;
    }
    while (current != null) {
      if (current.data == searchKey) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  public ListNode reverseList() {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode previous = head;
    ListNode current = head.next;
    while (current != null) {
      ListNode next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    head.next = null;
    head = previous;
    return head;
  }

  public ListNode findNthNodeFromEnd(int n) {
    ListNode mainPtr = head;
    ListNode refPtr = head;
    int count = 0;
    while (count < n) {
      if (refPtr == null) {
        throw new IllegalArgumentException(n + "is greater than no. of nodes");
      }
      refPtr = refPtr.next;
      count++;
    }
    while (refPtr != null) {
      refPtr = refPtr.next;
      mainPtr = mainPtr.next;
    }
    System.out.println(mainPtr.data + " is the " + n + "th node from the end");
    return mainPtr;
  }

  public void removeDuplicate() {
    ListNode current = head;
    while (current != null && current.next != null) {
      if (current.data == current.next.data) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
  }

  public ListNode insertNodeinSortedSinglyList(int value) {
    ListNode newNode = new ListNode(value);
    ListNode temp = head;
    ListNode current = head;
    // If the list is empty or the new node should be inserted before the head
    if (head == null || head.data >= newNode.data) {
      newNode.next = head;
      head = newNode;
      return head;
    }
    while (current != null && current.data < newNode.data) {
      temp = current;
      current = current.next;
    }
    newNode.next = current;
    temp.next = newNode;
    return head;
  }

  public boolean detectLoopInNode() {
    ListNode fastPtr = head;
    ListNode slowPtr = head;
    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
      if (slowPtr == fastPtr) {
        return true;
      }
    }
    return false;
  }

  public void createLoopNode() {
    // Create nodes
    ListNode first = new ListNode(10);
    ListNode second = new ListNode(20);
    ListNode third = new ListNode(30);
    ListNode fourth = new ListNode(40);
    ListNode fifth = new ListNode(50);
    ListNode sixth = new ListNode(60);

    // Link nodes
    head = first;
    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = sixth;
    sixth.next = third;
  }

  public ListNode getStartingNode(ListNode slowPtr) {
    // if (slowPtr == null) {
    // return null;
    // }
    ListNode temp = head;
    while (temp != slowPtr) {
      temp = temp.next;
      slowPtr = slowPtr.next;
    }
    return temp;// starting node of loop
  }

  public ListNode startOfLoopNode() {
    ListNode fastPtr = head;
    ListNode slowPtr = head;
    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
      if (slowPtr == fastPtr) {
        return getStartingNode(slowPtr);
      }
    }
    return null;
  }

  public void removeLoop() {
    ListNode fastPtr = head;
    ListNode slowPtr = head;
    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
      if (slowPtr == fastPtr) {
        removeLoop(slowPtr);
        return;
      }
    }
  }

  private void removeLoop(ListNode slowPtr) {
    ListNode temp = head;
    while (temp.next != slowPtr.next) {
      temp = temp.next;
      slowPtr = slowPtr.next;
    }
    slowPtr.next = null;
  }

  public static ListNode merge(ListNode a, ListNode b) {
    ListNode dummy = new SinglyLinkedList().new ListNode(4);// only ListNode dummy = new ListNode(4) will throw error
                                                            // because instance of SinglyLinkedList class is not created
    ListNode tail = dummy;
    while (a != null && b != null) {
      if (a.data <= b.data) {
        tail.next = a;
        a = a.next;
      } else {
        tail.next = b;
        b = b.next;
      }
      tail = tail.next;
    }
    if (a == null) {
      tail.next = b;
    } else if (b == null) {
      tail.next = a;
    }
    return dummy.next;
  }

  public void printList() {
    ListNode current = head;
    System.out.print("The node in the list are ");
    while (current != null) {
      System.out.print(current.data + " -> ");
      current = current.next;
    }
    System.out.print("null");
  }

  public static void main(String[] args) {
    // SinglyLinkedList list = new SinglyLinkedList();
    // list.findLength();
    // list.insertNodeAtBegin(45);
    // list.insertNodeAtEnd(78);
    // list.insertNodeAtposition(3, 39);
    // list.deleteFirstNode();
    // list.deleteLastNode();
    // list.deleteNodeAtPosition(3);
    // if (list.searchNodeData(8)) {
    // System.out.println("Search key found");
    // } else {
    // System.out.println("Search key not found");
    // }

    // list.printList();
    // System.out.println();
    // list.reverseList();
    // System.out.println("The node in list after reverse :- ");
    // list.findNthNodeFromEnd(3);
    // list.removeDuplicate();

    // list.printList();
    // list.insertNodeinSortedSinglyList(45);

    // list.createLoopNode();
    // System.out.println(list.detectLoopInNode());
    // System.out.println("The start of the loop is at node with data: " +
    // list.startOfLoopNode().data);

    // list.removeLoop();
    // System.out.println(list.detectLoopInNode());
    // list.printList();

    /*
     * calling merge method
     * SinglyLinkedList list1 = new SinglyLinkedList();
     * list1.insertNodeAtEnd(1);
     * list1.insertNodeAtEnd(3);
     * list1.insertNodeAtEnd(8);
     * SinglyLinkedList list2 = new SinglyLinkedList();
     * list2.insertNodeAtEnd(4);
     * list2.insertNodeAtEnd(6);
     * list2.insertNodeAtEnd(9);
     * list2.insertNodeAtEnd(11);
     * list1.printList();
     * System.out.println();
     * list2.printList();
     * SinglyLinkedList result = new SinglyLinkedList();
     * System.out.println();
     * System.out.println("The node in the list after merging two sorted list:-");
     * result.head = merge(list1.head, list2.head);
     * result.printList();
     */

    // list.printList();// after calling createLoopNode method dont print it
    // otherwise it will go in
    // infinite loop

  }
}
