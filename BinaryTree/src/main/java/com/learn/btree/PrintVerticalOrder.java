package com.learn.btree;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.learn.btree.BinaryTree.Node;

public class PrintVerticalOrder {
	private static Map<Integer,ArrayList<Integer>> distanceMap = new TreeMap<Integer,ArrayList<Integer>>();
	
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
		
		printTreeinVerticalInOrder(root1);
		
	}

	private static void printTreeinVerticalInOrder(BinaryTree.Node node) {
	  //do preorder traversal and update the distance map
		updateDistanceMap(node,0); //root node distance is 0
		printbyDistance();
	}

	private static void printbyDistance() {
		Set<Integer> keys =  distanceMap.keySet();
		
		for(Integer key:keys) {
			System.out.println(distanceMap.get(key));
		}
	}

	private static void updateDistanceMap(Node node,int distance) {
		
		if (node == null) return;
		
		if(distanceMap.containsKey(distance)) {
			ArrayList<Integer> nodes = distanceMap.get(distance);
			nodes.add(node.getData());
			distanceMap.put(distance, nodes);
		}else {
			ArrayList<Integer> nodes = new ArrayList<>();
			nodes.add(node.getData());
			distanceMap.put(distance,nodes);
		}
			
		updateDistanceMap(node.getLeft(),distance-1);
		updateDistanceMap(node.getRight(),distance+1);
	}
}
