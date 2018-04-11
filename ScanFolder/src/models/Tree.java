package models;

import java.io.File;

public class Tree {

	private Node root;
	
	public Node getRoot(){
		return root;
	}
	
	public void addRoot(String information){
		root = new Node(information, false, null, 0);
	}
	
	public void addChildTree(File[] files, double sizeOfFiltler){
		for (int i = 0; i < files.length; i++) {
			String name = files[i].getPath();
			if (!files[i].isDirectory()) {
				double sizeOfFile = getSizeOfFile(files[i]);
				String extention = name.substring(name.lastIndexOf("."), name.length());
				String nameFinal = getNameFinal(name);
				if (root.searchExtention(extention)) {
					Node a = root.getNodeByExtention(extention);
					Node max = a.getNodeList().get(0);
					Node min = a.getNodeList().get(1);
					if (sizeOfFile <= sizeOfFiltler) {
						max.addNode(Node.createNode(nameFinal, true, a, sizeOfFile));
					}else{
						min.addNode(Node.createNode(nameFinal, true, a, sizeOfFile));
					}
				}else{
					root.addNode(Node.createNode(extention, false, root, sizeOfFile));
					Node a = root.getNodeByExtention(extention);
					Node max = Node.createNode("Es menor que: " + sizeOfFiltler, false, a, 0);
					a.addNode(max);
					Node min = Node.createNode("Es mayor que: " + sizeOfFiltler, false, a, 0);
					a.addNode(min);
					if (sizeOfFile <= sizeOfFiltler) {
						max.addNode(Node.createNode(nameFinal, true, a, sizeOfFile));
					}else{
						min.addNode(Node.createNode(nameFinal, true, a, sizeOfFile));
					}
				}
			}else{
				File[] values = files[i].listFiles();
				addChildTree(values, sizeOfFiltler);
			}
		}
	}

	private double getSizeOfFile(File file) {
		double bytes = file.length();
		double kilobytes = (bytes / 1024);
		return kilobytes;
	}
	
	public String getNameFinal(String name){
		String fi = name.substring(0, name.lastIndexOf("."));
		fi = fi.substring(fi.lastIndexOf("\\") + 1, fi.length());
		return fi;
	}
}