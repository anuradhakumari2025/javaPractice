import java.util.NoSuchElementException;

public class DoublyLinkedList {

  ListNode head;
  ListNode tail;
  int length;

  class ListNode {
    int data;
    ListNode next;
    ListNode previous;

    ListNode(int data) {
      this.data = data;
    }
  }

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public boolean isEmpty() {
    return length == 0; // head == null
  }

  public int length() {
    return length;
  }

  public void insertNodeAtBegin(int value) {
    ListNode newNode = new ListNode(value);
    if (isEmpty()) {
      tail = newNode;
    } else {
      head.previous = newNode;
    }
    newNode.next = head;
    head = newNode;
    length++;

    // return head;
  }

  public void insertNodeAtEnd(int value) {
    ListNode newNode = new ListNode(value);
    if (isEmpty()) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    newNode.previous = tail;
    tail = newNode;
    length++;

    // return tail;
  }

  public ListNode deleteFirstNode() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    ListNode temp = head;
    if (tail == head) {
      head = null;
    } else {
      head.next.previous = null;
    }
    head = temp.next;
    temp.next = null;
    // head.previous = null;
    length--;
    return temp;
  }

  public ListNode deleteLastNode() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    ListNode temp = tail;
    if (tail == head) {
      head = null;
    } else {
      tail.previous.next = null;
    }
    tail = temp.previous;
    // tail.next = null;
    temp.previous = null;
    length--;
    return temp;
  }

  public void forwardDisplay() {
    if (head == null) {
      System.out.println(head);
      // return null;
    }
    ListNode current = head;
    while (current != null) {
      System.out.print(current.data + " -> ");
      current = current.next;
    }
    System.out.println("null");
    // return current;
  }

  public void backwardDisplay() {
    if (tail == null) {
      System.out.println(tail);
      // return null;
    }
    ListNode current = tail;
    while (current != null) {
      System.out.print(current.data + " -> ");
      current = current.previous;
    }
    System.out.println("null");
    // return current;
  }

  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
    list.insertNodeAtBegin(5);
    list.insertNodeAtBegin(7);
    list.insertNodeAtEnd(8);
    list.forwardDisplay();
    // list.backwardDisplay();

    // list.deleteFirstNode();
    // list.forwardDisplay();

    // list.deleteFirstNode();
    // list.forwardDisplay();
    // list.deleteFirstNode();
    // list.forwardDisplay();

    list.deleteLastNode();
    list.forwardDisplay();

    list.deleteLastNode();
    list.forwardDisplay();
    list.deleteLastNode();
    list.forwardDisplay();
  }
}
