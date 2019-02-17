package com.learn.btree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BinaryTree implements Traversal{
	
	private Node root;
	
	@Data
	@AllArgsConstructor
	static class Node{
		private int data;
		private Node left;
		private Node right;
	}
	
	public void addNode(Node rootNode,int data) {
		if(rootNode == null) {
			root = new Node(data,null,null);
		}else {
			if(data > rootNode.getData()) {
				if(rootNode.getRight()!= null)
					addNode(rootNode.getRight(),data);
				else {
					rootNode.setRight(new Node(data,null,null));
				}
				
			}else if(data < rootNode.getData()) {
				if(rootNode.getLeft() !=null)
					addNode(rootNode.getLeft(),data);
				else
					rootNode.setLeft(new Node(data,null,null));
			}
		}
	}
	
	
	public void removeNode(Node root) {
		
	}

}
