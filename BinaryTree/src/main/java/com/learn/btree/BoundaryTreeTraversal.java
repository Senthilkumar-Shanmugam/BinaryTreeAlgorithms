package com.learn.btree;

public class BoundaryTreeTraversal implements Traversal {
	public static void main(String... str) {
		BinaryTree btree = new BinaryTree();

		/*btree.addNode(btree.getRoot(), 100);
		btree.addNode(btree.getRoot(), 50);
		btree.addNode(btree.getRoot(), 150);
		btree.addNode(btree.getRoot(), 25);
		btree.addNode(btree.getRoot(), 75);
		btree.addNode(btree.getRoot(), 140);
		btree.addNode(btree.getRoot(), 200);
		btree.addNode(btree.getRoot(), 30);
		btree.addNode(btree.getRoot(), 70);
		btree.addNode(btree.getRoot(), 80);
		btree.addNode(btree.getRoot(), 35);*/
		
		BinaryTree.Node root20 = new BinaryTree.Node.NodeBuilder().data(20).build();
		BinaryTree.Node node8 = new BinaryTree.Node.NodeBuilder().data(8).build();
		BinaryTree.Node node22= new BinaryTree.Node.NodeBuilder().data(22).build();
	    root20.setLeft(node8);
	    root20.setRight(node22);
	    BinaryTree.Node node4 = new BinaryTree.Node.NodeBuilder().data(4).build();
		BinaryTree.Node node12= new BinaryTree.Node.NodeBuilder().data(12).build();
		node8.setLeft(node4);
		node8.setRight(node12);
		
		BinaryTree.Node node10 = new BinaryTree.Node.NodeBuilder().data(10).build();
		BinaryTree.Node node14= new BinaryTree.Node.NodeBuilder().data(14).build();
		
	    node12.setLeft(node10);
	    node12.setRight(node14);
	    
		BinaryTree.Node node25= new BinaryTree.Node.NodeBuilder().data(25).build();
	    node22.setRight(node25);
		new BoundaryTreeTraversal().boundaryTraversal(root20);
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
