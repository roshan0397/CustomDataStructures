package trees;

public class BTClient {

	public static void main(String[] args) {

		// 10 true 20 true 40 false false true 50 false false true 30 false true 60
		// false false

		BinaryTree bt = new BinaryTree();
		bt.display();

		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(20));
		System.out.println(bt.ht());

		bt.preOrder();

		int[] pre = { 10, 20, 70, 30, 40, 50, 60 };
		int[] in = { 20, 70, 10, 40, 50, 30, 60 };
		int[] post = { 70, 20, 50, 40, 60, 30, 10 };
	}
}