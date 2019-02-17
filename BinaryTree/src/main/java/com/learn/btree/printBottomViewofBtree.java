package com.learn.btree;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

import com.learn.btree.BinaryTree.Node;

public class printBottomViewofBtree {
	
	private static Map<Integer,Integer> dMap = new TreeMap<>();

	public static void main(String[] args) {
		BinaryTree.Node root1 = new BinaryTree.Node.NodeBuilder().data(1).build();
		BinaryTree.Node node2 = new BinaryTree.Node.NodeBuilder().data(2).build();
		BinaryTree.Node node3= new BinaryTree.Node.NodeBuilder().data(3).build();
		root1.setLeft(node2);
		root1.setRight(node3);
		BinaryTree.Node node4 = new BinaryTree.Node.NodeBuilder().data(4).build();
		BinaryTree.Node node5= new BinaryTree.Node.NodeBuilder().data(5).build();
		node2.setLeft(node4);
		node2.setRight(node5);
		BinaryTree.Node node6 = new BinaryTree.Node.NodeBuilder().data(6).build();
		BinaryTree.Node node7= new BinaryTree.Node.NodeBuilder().data(7).build();
		node3.setLeft(node6);
		node3.setRight(node7);
		
		//levelOrderTraversal(root);
		printBootomView(root1);
	}

	private static void printBootomView(Node root) {
		levelOrderTraversal(root);
		printbyDistance();
	}

	private static void levelOrderTraversal(Node root) {
		if(root == null) return;
        Queue<Node> q = new LinkedList<>();
		int hd = 0;
	    root.setHd(hd);
		q.add(root);
		
		while(!q.isEmpty()) {
			Node n = q.remove();
			//System.out.print(n.getData()+" ");
			hd = n.getHd();
			dMap.put(hd, n.getData());
			
			if(n.getLeft() != null) {
			    n.getLeft().setHd(hd-1);
				q.add(n.getLeft());

			}
			
			if(n.getRight() != null) {
				n.getRight().setHd(hd+1);
				q.add(n.getRight());
			}
		}
	}
	
	
	private static void printbyDistance() {
		Set<Integer> keys =  dMap.keySet();
		
		for(Integer key:keys) {
			System.out.print(dMap.get(key)+" ");
		}
	}

}
