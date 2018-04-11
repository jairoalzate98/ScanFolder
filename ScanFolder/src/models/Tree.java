package models;

import java.io.File;

public class Tree {

	private Node root;
	
	public Node getRoot(){
		return root;
	}
	
	public void addRoot(String information){
		root = new Node(information, false, null);
	}
	
	public void addChildTree(File[] files){
		
	}
}
