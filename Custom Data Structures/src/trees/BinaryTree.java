package trees;

import java.util.Scanner;

public class BinaryTree {

	Scanner sc = new Scanner(System.in);

	private class Node {

		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		root = construct(null, false);
	}

	// ilc : true --> left
	// ilc : false --> right
	private Node construct(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter data for root node.");
		} else {
			if (ilc) {
				System.out.println("Enter data for left child of " + parent.data + " .");
			} else {
				System.out.println("Enter data for right child of " + parent.data + " .");
			}
		}

		int item = sc.nextInt();

		Node nn = new Node();

		nn.data = item;

		System.out.println(nn.data + " has left ?");
		boolean hlc = sc.nextBoolean();
		if (hlc) {
			nn.left = construct(nn, true);
		}

		System.out.println(nn.data + " has right ?");
		boolean hrc = sc.nextBoolean();
		if (hrc) {
			nn.right = construct(nn, false);
		}

		return nn;
	}

	public BinaryTree(int[] pre, int[] in) {

		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi || ilo > ihi) {
			return null;
		}

		Node nn = new Node();

		nn.data = pre[plo];

		int si = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (pre[plo] == in[i]) {
				si = i;
				break;
			}
		}

		int nel = si - ilo;

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);

		return nn;
	}

	public void display() {
		System.out.println("-----------------------");
		display(root);
		System.out.println("-----------------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}

		str += " ->" + node.data + "<- ";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null)
			return 0;

		int sl = size(node.left);
		int sr = size(node.right);

		return sl + sr + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int ml = max(node.left);
		int mr = max(node.right);

		return Math.max(node.data, Math.max(ml, mr));
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean fl = find(node.left, item);
		if (fl) {
			return true;
		}
		boolean fr = find(node.right, item);
		if (fr) {
			return true;
		}

		return false;
	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;
	}

	// Pre Order --> NLR
	// Post Order --> LRN
	// In Order --> LNR

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {

		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {

		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {

		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}
}