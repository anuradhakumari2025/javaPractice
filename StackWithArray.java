import java.util.NoSuchElementException;

public class StackWithArray {
  int top;
  int[] arr;

  public StackWithArray(int capacity) {
    top = -1;
    arr = new int[capacity];
  }

  public StackWithArray() {
    this(10);
  }

  public boolean isFull() {
    return arr.length == size();
  }

  public boolean isEmpty() {
    return top < 0;
  }

  public int size() {
    return top + 1;
  }

  public void push(int data) {
    if (isFull()) {
      throw new NoSuchElementException("Stack is full..");
    }
    top++;
    arr[top] = data;
  }

  public int pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    int result = arr[top];
    top--;
    return result;
  }

  public int peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is Empty");
    }
    return arr[top];
  }

  public static void main(String[] args) {
    StackWithArray stack = new StackWithArray();
    stack.push(10);
    stack.push(11);
    stack.push(12);
    System.out.println(stack.peek());

    // stack.pop();
    // stack.pop();
    // stack.pop();
    System.out.println(stack.peek());

  }
}
