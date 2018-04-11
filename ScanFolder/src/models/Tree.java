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
		for (int i = 0; i < files.length; i++) {
			String name = files[i].getPath();
			if (!files[i].isDirectory()) {
				String extention = name.substring(name.lastIndexOf("."), name.length());
				if (root.searchExtention(extention)) {
					
				}else{
					root.addNode(Node.createNode(extention, false, root));
					Node a = root.getNodeByExtention(extention);
					a.addNode(Node.createNode(name, true, a));
				}
			}else{
				root.addNode(Node.createNode(name, false, root));
			}
		}
	}
}
