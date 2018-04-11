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
				String nameFinal = getNameFinal(name);
				if (root.searchExtention(extention)) {
					Node a = root.getNodeByExtention(extention);
					a.addNode(Node.createNode(nameFinal, true, a));
				}else{
					root.addNode(Node.createNode(extention, false, root));
					Node a = root.getNodeByExtention(extention);
					a.addNode(Node.createNode(nameFinal, true, a));
				}
			}else{
				File[] values = files[i].listFiles();
				addChildTree(values);
			}
		}
	}
	
	public String getNameFinal(String name){
		String fi = name.substring(0, name.lastIndexOf("."));
		fi = fi.substring(fi.lastIndexOf("\\") + 1, fi.length());
		return fi;
	}
}