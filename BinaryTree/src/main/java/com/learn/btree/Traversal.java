package com.learn.btree;

public interface Traversal {
	
	default void inorder(BinaryTree.Node root) {
		throw new RuntimeException("method nmot implemented");
	}
	
	default void preorder(BinaryTree.Node root) {
		throw new RuntimeException("method nmot implemented");
	}
	
	default void postorder(BinaryTree.Node root) {
		throw new RuntimeException("method nmot implemented");
	}
	
	default void levelOrderUsingQueue(BinaryTree.Node root) {
		throw new RuntimeException("method nmot implemented");
	}
	
	default void levelOrderUsingHeight(BinaryTree.Node root) {
		throw new RuntimeException("method nmot implemented");
	}
	
	default void boundaryTraversal(BinaryTree.Node root) {
		throw new RuntimeException("method nmot implemented");
	}
	
	default void printTopView(BinaryTree.Node root) {
		throw new RuntimeException("method nmot implemented");
	}
	
	default void printBottomView(BinaryTree.Node root) {
		throw new RuntimeException("method nmot implemented");
	}
}
