// import DoublyLinkedList.ListNode;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
  ListNode last;
  int length;

  class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
      this.data = data;
    }
  }

  public CircularSinglyLinkedList() {
    last = null;
    length = 0;
  }

  public int length() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public void createCSLL() {
    ListNode first = new ListNode(5);
    ListNode second = new ListNode(6);
    ListNode third = new ListNode(7);
    ListNode fourth = new ListNode(8);

    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = first;

    last = fourth;
  }

  public void insertNodeAtBegin(int data) {
    ListNode newNode = new ListNode(data);
    if (last == null) {
      last = newNode;
    } else {
      newNode.next = last.next;
    }
    last.next = newNode;
    length++;
  }

  public void insertNodeAtEnd(int data) {
    ListNode newNode = new ListNode(data);
    if (last == null) {
      last = newNode;
      last.next = last;
    } else {
      newNode.next = last.next;
      last.next = newNode;
      last = newNode;
    }
    length++;
  }

  public int deleteFirstNode() {
    ListNode temp = last.next;
    int result = temp.data;
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else {
      last.next = temp.next;
    }
    length--;
    return result;
  }

  public void displayCSLL() {
    if (last == null) {
      return;
    }
    ListNode temp = last.next;
    while (temp != last) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println(last.data);
  }

  public static void main(String[] args) {
    CircularSinglyLinkedList list = new CircularSinglyLinkedList();
    list.createCSLL();
    list.displayCSLL();

    list.insertNodeAtBegin(1);
    list.displayCSLL();

    list.insertNodeAtEnd(2);
    list.displayCSLL();

    list.deleteFirstNode();
    list.displayCSLL();
  }
}
