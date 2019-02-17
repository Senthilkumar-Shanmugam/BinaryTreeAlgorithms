package com.learn.btree;

public class BoundaryTreeTraversal implements Traversal {
	public static void main(String... str) {
		BinaryTree btree = new BinaryTree();

		btree.addNode(btree.getRoot(), 100);
		btree.addNode(btree.getRoot(), 50);
		btree.addNode(btree.getRoot(), 150);
		btree.addNode(btree.getRoot(), 25);
		btree.addNode(btree.getRoot(), 75);
		btree.addNode(btree.getRoot(), 140);
		btree.addNode(btree.getRoot(), 200);
		btree.addNode(btree.getRoot(), 30);
		btree.addNode(btree.getRoot(), 70);
		btree.addNode(btree.getRoot(), 80);
		btree.addNode(btree.getRoot(), 35);
		new BoundaryTreeTraversal().boundaryTraversal(btree.getRoot());
	}

	@Override
	public void boundaryTraversal(BinaryTree.Node root) {
		
		if(root == null)
			return;
		System.out.print(root.getData()+" ");
		
		if(root.getLeft() !=null)
			printLeftBoundary(root.getLeft());
		
		printLeafNodes(root);
		
		if(root.getRight() != null)
		 printRightBoundaryBottomUp(root.getRight());
	}

	private static void printLeftBoundary(BinaryTree.Node root) {
		if(root == null) return;
		//print only if its not a leaf node
		if(root.getLeft() !=null || root.getRight() != null)
		 System.out.print(root.getData()+" ");
		
		if(root.getLeft() != null)
			printLeftBoundary(root.getLeft());
		else if(root.getRight() != null)
			printLeftBoundary(root.getRight());

	}

	private static void printLeafNodes(BinaryTree.Node root) {
		if(root == null) return;
		
		if(root.getLeft() == null && root.getRight() == null)
			System.out.print(root.getData()+" ");
		
		printLeafNodes(root.getLeft());
		printLeafNodes(root.getRight());
	}

	private static void printRightBoundaryBottomUp(BinaryTree.Node root) {
      //print reverse fashion, using implicit stack or explicit stack
		if(root.getRight() != null)
			printRightBoundaryBottomUp(root.getRight());
		else if(root.getLeft() != null)
			printRightBoundaryBottomUp(root.getLeft());
		//ignore leaf nodes
		if(root.getLeft() !=null || root.getRight() != null)
		System.out.print(root.getData() +" ");
	}
}
