package com.learn.btree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BinaryTree implements Traversal{
	
	private Node root;
	
	@Data
	@AllArgsConstructor
	static class Node{
		private String data;
		private Node left;
		private Node right;
	}
	
	private void addNode(Node node) {
		
	}
	
	
	private void removeNode(Node node) {
		
	}

}
