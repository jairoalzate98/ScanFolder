package models;

import java.util.ArrayList;

public class Node {

	private String name;
	private ArrayList<Node> nodeList;
	private boolean isLeaf;
	private Node fatherNode;
	private double sizeOfNode;
	
	public Node(String name, boolean isLeaf, Node fatherNode, double sizeOfNode) {
		this.name = name;
		nodeList = new ArrayList<>();
		this.isLeaf = isLeaf;
		this.fatherNode = fatherNode;
		this.sizeOfNode = sizeOfNode;
	}
	
	public static Node createNode(String name, boolean isLeaf, Node fatherNode, double sizeOfNode){
		return new Node(name, isLeaf, fatherNode, sizeOfNode);
	}
	
	public boolean searchExtention(String extention){
		for (int i = 0; i < nodeList.size(); i++) {
			if (nodeList.get(i).getName().equals(extention)) {
				return true;
			}
		}
		return false;
	}
	
	public Node getNodeByExtention(String extention){
		Node a = null;
		for (int i = 0; i < nodeList.size(); i++) {
			if (nodeList.get(i).getName().equals(extention)) {
				a = nodeList.get(i);
			}
		}
		return a;
	}
	
	public void addNode(Node node){
		nodeList.add(node);
	}
	
	public Node getFatherNode(){
		return fatherNode;
	}
	

	public double getSizeOfNode() {
		return sizeOfNode;
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