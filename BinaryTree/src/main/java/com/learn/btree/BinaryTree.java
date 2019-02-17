package com.learn.btree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class BinaryTree implements Traversal{
	
	private Node root;
	
	@Data
	@AllArgsConstructor
	@Builder
	static class Node{
		private int data;
		private Node left;
		private Node right;
		private int hd = Integer.MAX_VALUE;
	}
	
	public void addNode(Node rootNode,int data) {
		if(rootNode == null) {
			root = new Node(data,null,null,Integer.MAX_VALUE);
		}else {
			if(data > rootNode.getData()) {
				if(rootNode.getRight()!= null)
					addNode(rootNode.getRight(),data);
				else {
					rootNode.setRight(new Node(data,null,null,Integer.MAX_VALUE));
				}
				
			}else if(data < rootNode.getData()) {
				if(rootNode.getLeft() !=null)
					addNode(rootNode.getLeft(),data);
				else
					rootNode.setLeft(new Node(data,null,null,Integer.MAX_VALUE));
			}
		}
	}
	
	
	public void removeNode(Node root) {
		
	}

}
