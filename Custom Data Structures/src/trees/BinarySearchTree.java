package trees;

public class BinarySearchTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinarySearchTree(int[] in) {
		root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		int mid = (lo + hi) / 2;

		Node nn = new Node();

		nn.data = in[mid];

		nn.left = construct(in, lo, mid - 1);
		nn.right = construct(in, mid + 1, hi);

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

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);
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

		if (item > node.data) {
			return find(node.right, item);
		} else {
			return find(node.left, item);
		}
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

	public void addNode(int item) {
		addNode(root, item);
	}

	private void addNode(Node node, int item) {

		if (item <= node.data) {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else {
				addNode(node.left, item);
			}
		} else if (item > node.data) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else {
				addNode(node.right, item);
			}
		}
	}

	public void removeNode(int item) {
		removeNode(null, root, item);
	}

	private void removeNode(Node parent, Node node, int item) {

		if (node == null) {
			return;
		}

		if (item < node.data) {
			removeNode(node, node.left, item);
		} else if (item > node.data) {
			removeNode(node, node.right, item);
		} else {

			if (node.left == null && node.right == null) {

				if (node.data <= parent.data) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else if (node.left == null && node.right != null) {

				if (node.data <= parent.data) {
					parent.left = node.right;
					parent.right = null;
				} else {
					parent.right = node.right;
					parent.left = null;
				}
			} else if (node.left != null && node.right == null) {

				if (node.data <= parent.data) {
					parent.left = node.left;
					parent.right = null;
				} else {
					parent.left = null;
					parent.right = node.left;
				}
			} else if (node.left != null && node.right != null) {

				int temp = max(node.left);
				node.data = temp;
				removeNode(node, node.left, item);

			}
		}
	}
}