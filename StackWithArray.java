import java.util.NoSuchElementException;
import java.util.Stack;

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

  public static String reverseString(String str) {
    Stack<Character> stack = new Stack<>();
    char[] chars = str.toCharArray();
    for (char c : chars) {
      stack.push(c);
    }
    for (int i = 0; i < str.length(); i++) {
      chars[i] = stack.pop();
    }
    return new String(chars);
  }

  public int[] nextGreaterElement(int[] arr) {
    int[] result = new int[arr.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = arr.length - 1; i >= 0; i--) {
      if (!stack.isEmpty()) {
        while (!stack.isEmpty() && stack.peek() <= arr[i]) {
          stack.pop();
        }
      }
      if (stack.isEmpty()) {
        result[i] = -1;
      } else {
        result[i] = stack.peek();
      }
      stack.push(arr[i]);
    }
    return result;
  }

  public static boolean isValidParenthesis(String str) {
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        } else {
          char top = stack.peek();
          if ((c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[')) {
            stack.pop();
          } else {
            return false;
          }
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    StackWithArray stack = new StackWithArray();
    stack.push(10);
    stack.push(11);
    // stack.push(12);
    System.out.println("Top of the element is : " + stack.peek());

    // stack.pop();
    // stack.pop();
    // stack.pop();
    // System.out.println("Top of the element is : " + stack.peek());

    // stack.nextGreaterElement([1,3,4,5]);
    int[] arr = { 4, 7, 3, 4, 8, 1 };
    int[] result = stack.nextGreaterElement(arr);

    System.out.print("Next greater elements: ");
    for (int num : result) {
      System.out.print(num + " "); // output is 7 8 4 8 -1 -1
    }

    // System.out.println(result);//output is [I@3a71f4dd

    String str = "abcd";
    System.out.println();
    System.out.println("String to be reversed is : " + str);
    System.out.println("Revesed String is " + reverseString(str));

    String parenthesis = "{}";
    System.out.println(parenthesis + " is valid or not ? :- " + isValidParenthesis(parenthesis));
    System.out.println("}{ is valid or not ? :- " + isValidParenthesis("}{"));

  }
}
