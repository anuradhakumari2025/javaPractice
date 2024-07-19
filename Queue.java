// import java.util.List;

import java.util.NoSuchElementException;

public class Queue {

  ListNode front;
  ListNode rear;
  int length;

  // Constructor
  public Queue() {
    this.front = null;
    this.rear = null;
    this.length = 0;
  }

  class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public int length() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public void enQueue(int data) {
    ListNode temp = new ListNode(data);
    if (isEmpty()) {
      front = temp;
    } else {
      rear.next = temp;
    }
    rear = temp;
    length++;
  }

  public int deQueue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    int result = front.data;
    front = front.next;
    if (front == null) {
      rear = front;
    }
    length--;
    return result;
  }

  public int first() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    // ListNode current = front;
    return front.data;
  }

  public int last() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    // ListNode current = front;
    return rear.data;
  }

  public void display() {
    ListNode temp;
    temp = front;
    if (isEmpty()) {
      return;
      // System.out.println("Queue is empty");
    }
    System.out.print("The elements in queue are: ");
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.enQueue(5);
    queue.enQueue(51);
    queue.enQueue(50);
    queue.enQueue(55);

    // queue.display();

    // queue.deQueue();
    // queue.deQueue();
    // queue.deQueue();
    // queue.deQueue();

    queue.display();

    System.out.println("The first element in queue is: " + queue.first());
    System.out.println("The last element in queue is: " + queue.last());

  }
}
