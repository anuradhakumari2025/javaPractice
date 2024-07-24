public class BinaryTree2 {
  // node class to represent single node of tree
  class Node {
    int data;
    Node left;
    Node right;

    // constructor to hold data of node
    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  int idx = -1;

  // function that take array and return root node
  public Node buildTree(int nodes[]) {
    idx++;
    // Check if the index is out of bounds
    if (idx >= nodes.length || nodes[idx] == -1) {
      return null;
    }
    Node newNode = new Node(nodes[idx]);
    newNode.left = buildTree(nodes);
    newNode.right = buildTree(nodes);
    return newNode;
  }

  public static void main(String[] args) {
    BinaryTree2 bt = new BinaryTree2();
    int nodes[] = { 1, 2, 4, -1, -1, 3, -1, 6, -1, -1 };
    Node root = bt.buildTree(nodes);
    System.out.println(root.data);
  }
}
