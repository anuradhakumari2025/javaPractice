public class ArrayDemo {

  public void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);// print all elements of array
    }
  }

  public void arrayElements() {
    // int arr[] = { 1, 2, 3, 4, 5 };
    // int[] arr = { 1, 2, 3, 4, 5 }; //other method of representing array
    /*
     * other method of declaring and initializing array
     * int[] arr = new int[5];
     * // arr[0] = 1;
     * // arr[1] = 2;
     * // arr[2] = 3;
     * // arr[3] = 4;
     * // arr[5] = 6;
     * // System.out.println(arr[0]);
     */

    int[] arr = { 1, 2, 3, 4, 5 };
    int[] Arr = { 1, 0, 2, 0, 3, 4, 5 };
    int[] newArr = { 1, 3, 4, 6, 8, 2, 7 };
    // arr[4] = 7;// updating elements of array
    // arr[5] = 9; //output will Exception in thread "main"
    // java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

    // printArray(arr);
    // int[] result = removeEven(arr); // calls removeEven(arr) to create a new
    // array result containing only the odd
    // numbers.
    // System.out.println("Array after removing even numbers from array :-");
    // printArray(result);

    // System.out.println("Array after reversing:- ");
    // printArray(reverseArray(arr, 0, arr.length - 1));

    // System.out.println("Minimum value of array:- ");
    // System.out.println((minValueArray(arr)));
    // System.out.println("Second max value of array:- ");
    // System.out.println((secondMaxValueArray(arr)));

    // int[] movedZeroArray = moveZerosOfArray(Arr);
    // printArray(movedZeroArray);

    // int[] resizedArray = resizeArray(arr, 9);
    // printArray(resizedArray);

    // System.out.println(findMissingNoOfArray(newArr));

    System.out.println(checkPalindrome("madam"));

  }

  public int[] removeEven(int[] arr) {
    int oddCount = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 != 0) {
        oddCount++;
      }
    }
    int[] result = new int[oddCount];
    int idx = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 != 0) {
        result[idx] = arr[i];
        idx++;
      }
    }
    return result;
  }

  public int[] reverseArray(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
    return arr;
  }

  public int minValueArray(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Invalid input");
    }
    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
      }
    }
    return min;
  }

  public int secondMaxValueArray(int[] arr) {
    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        secondMax = max;
        max = arr[i];
      } else if (arr[i] > secondMax && arr[i] != max) {
        secondMax = arr[i];
      }
    }
    return secondMax;
  }

  public int[] moveZerosOfArray(int[] arr) {
    int j = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0 && arr[j] == 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
      if (arr[j] != 0) {
        j++;
      }
    }
    return arr;
  }

  public int[] resizeArray(int[] arr, int capacity) {
    int[] temp = new int[capacity];
    for (int i = 0; i < arr.length; i++) {
      temp[i] = arr[i];
    }
    return temp;
  }

  public int findMissingNoOfArray(int[] arr) {
    int n = arr.length + 1;
    int sum = (n * (n + 1)) / 2;
    for (int num : arr) {
      sum = sum - num;
    }
    return sum;
  }

  public boolean checkPalindrome(String word) {
    char[] charArray = word.toCharArray();
    int start = 0;
    int end = word.length() - 1;
    while (start < end) {
      if (charArray[start] != charArray[end]) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  public static void main(String[] args) {

    ArrayDemo arrPractice = new ArrayDemo(); // An instance of ArrayDemo is created.
    // arrPractice.printArray(new int[] = {2,4,5}); //output will error due to In
    // Java, you can pass an anonymous array to a method by directly creating it
    // using new int[]{...} without the assignment operator (=).
    // arrPractice.printArray(new int[] { 2, 4, 5 }); //print elements of array

    arrPractice.arrayElements();/*
                                 * The arrayElements method is called on this instance to execute the sequence
                                 * of operations defined within it.
                                 */
  }

}
