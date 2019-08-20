package trees;

public class BSTClient {

	public static void main(String[] args) {

		int[] in = { 10, 20, 30, 100, 110, 120, 150 };
		BinarySearchTree bst = new BinarySearchTree(in);

		System.out.println(bst.size());
		System.out.println(bst.max());
		System.out.println(bst.find(100));
		System.out.println(bst.ht());

		bst.addNode(32);
		bst.display();

		bst.removeNode(32);
		bst.display();
	}
}