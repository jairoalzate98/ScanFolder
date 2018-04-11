package views;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.Controller;
import controller.Events;
import models.Node;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTree jTree;
	private DefaultMutableTreeNode model;

	public MainWindow(Controller controller) {
		setTitle("ScanFolder");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		JButton jbtnSelectFolder = new JButton(ConstantsGui.SELECT_FOLDER_TEXT);
		jbtnSelectFolder.setActionCommand(Events.SELECT_FOLDER.toString());
		jbtnSelectFolder.addActionListener(controller);
		add(jbtnSelectFolder, BorderLayout.SOUTH);
		model = new DefaultMutableTreeNode();
		jTree = new JTree(model);
		add(new JScrollPane(jTree), BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void paintTree(Node root) {
		model.removeAllChildren();
		DefaultMutableTreeNode uiRoot = new DefaultMutableTreeNode(root);
		model.add(uiRoot);
		for (int i = 0; i < root.getNodeList().size(); i++) {
			createNode(uiRoot, root.getNodeList().get(i));
		}
	}
	
	private void createNode(DefaultMutableTreeNode actual, Node node) {
		if (node != null) {
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(node);
			actual.add(newNode);
			for (int i = 0; i < node.getNodeList().size(); i++) {
				createNode(newNode, node.getNodeList().get(i));
			}
		}
	}
	
	public String setVisibleFileChooser() throws Exception{
		String path= "";
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = jFileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();
			path = file.getPath();
		}else if(result == JFileChooser.CANCEL_OPTION){
			new Exception("Please select a directory");
		}
		return path;
	}
}