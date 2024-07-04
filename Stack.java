import java.util.NoSuchElementException;

public class Stack {

  ListNode top;
  int length;

  class ListNode {
    int data;
    ListNode next;

    // Consructor
    ListNode(int data) {
      this.data = data;
    }
  }

  public Stack() {
    top = null;
    length = 0;
  }

  public int length() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public void push(int data) {
    ListNode temp = new ListNode(data);
    temp.next = top;
    top = temp;
    length++;
  }

  public int pop() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    int result = top.data;
    top = top.next;
    length--;
    return result;
  }

  public int peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return top.data;
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(8);
    stack.push(5);
    stack.push(15);
    stack.push(50);

    stack.pop();
    stack.pop();
    stack.pop();
    System.out.println(" Top of the stack is " + stack.peek());

  }
}
