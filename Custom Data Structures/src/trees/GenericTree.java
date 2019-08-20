package trees;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {

	Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Enter data for root node");
		} else {
			System.out.println("Enter data for " + ith + "element of " + parent.data);
		}

		int item = sc.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println("Enter the number of child of " + nn.data);
		int noc = sc.nextInt();

		for (int i = 0; i <= noc - 1; i++) {

			Node child = construct(nn, i);
			nn.children.add(child);
		}

		return nn;
	}

	public void display() {
		System.out.println("----------------------------");
		display(root);
		System.out.println("----------------------------");
	}

	private void display(Node node) {

		String str = node.data + " --> ";
		for (Node child : node.children) {
			str += child.data + " ";
		}
		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {

			int cs = size(child);
			ts += cs;
		}
		return ts + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		int tmax = node.data;

		for (Node child : node.children) {
			int cm = max(child);
			if (cm > tmax) {
				tmax = cm;
			}
		}

		return tmax;
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {

			boolean b = find(child, item);

			if (b) {
				return true;
			}
		}

		return false;
	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		int th = -1;
		for (Node child : node.children) {
			int ch = ht(child);

			if (ch > th) {
				th = ch;
			}
		}
		return th + 1;
	}
}