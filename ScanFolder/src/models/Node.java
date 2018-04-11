package models;

import java.util.ArrayList;

public class Node {

	private String name;
	private ArrayList<Node> nodeList;
	private boolean isLeaf;
	private Node fatherNode;
	
	public Node(String name, boolean isLeaf, Node fatherNode) {
		this.name = name;
		nodeList = new ArrayList<>();
		this.isLeaf = isLeaf;
		this.fatherNode = fatherNode;
	}
	
	public static Node createNode(String name, boolean isLeaf, Node fatherNode){
		return new Node(name, isLeaf, fatherNode);
	}
	
	public void addNode(Node node){
		if (!isLeaf) {
			nodeList.add(node);
		}
	}
	
	public Node getFatherNode(){
		return fatherNode;
	}
	

	public String getName() {
		return name;
	}

	public ArrayList<Node> getNodeList() {
		return nodeList;
	}

	public boolean isLeaf() {
		return isLeaf;
	}
	
	@Override
	public String toString() {
		return name;
	}
}