import java.util.Stack;

public class BinaryTree {
  TreeNode root;

  public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // constructor
    public TreeNode(int data) {
      this.data = data;
    }
  }

  public void createBinaryTree() {
    TreeNode first = new TreeNode(4);
    TreeNode second = new TreeNode(5);
    TreeNode third = new TreeNode(7);
    TreeNode fourth = new TreeNode(8);
    TreeNode fifth = new TreeNode(9);

    root = first;
    first.left = second;
    first.right = third;
    second.left = fourth;
    second.right = fifth;
  }

  public void preOrderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }

  public void preOrderTraversalUsingIteration() {
    if (root == null) {
      return;
    }
    // create stack to hold data while traversing
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode temp = stack.pop();
      System.out.print(temp.data + " ");
      if (temp.right != null) {
        stack.push(temp.right);
      }
      if (temp.left != null) {
        stack.push(temp.left);
      }
    }
  }

  public void inOrderTraversal() {

  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.createBinaryTree();
    // bt.preOrderTraversal(bt.root);
    bt.preOrderTraversalUsingIteration();
  }

}
