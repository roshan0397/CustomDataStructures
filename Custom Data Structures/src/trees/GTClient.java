package trees;

public class GTClient {

	public static void main(String[] args) {

		// 10 3 20 2 30 0 40 0 50 0 60 2 70 0 80 0

		GenericTree gt = new GenericTree();

		gt.display();
		System.out.println(gt.size());
		System.out.println(gt.max());
		System.out.println(gt.find(20));
		System.out.println(gt.ht());
	}
}
