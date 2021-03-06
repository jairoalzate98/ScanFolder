package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import models.Tree;
import views.MainWindow;

public class Controller implements ActionListener{

	private Tree tree;
	private MainWindow mainWindow;
	
	public Controller() {
		tree = new Tree();
		mainWindow = new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case SELECT_FOLDER:
			selectFolder();
			break;
		}
	}

	private void selectFolder() {
		try {
			String pathFolder = mainWindow.setVisibleFileChooser();
			String value = JOptionPane.showInputDialog(mainWindow, "Por favor ingrese el tama�o de filtro (KiloBytes)");
			File [] files = new File(pathFolder).listFiles();
			tree.addRoot(pathFolder);
			tree.addChildTree(files, Double.parseDouble(value));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		mainWindow.paintTree(tree.getRoot());
		mainWindow.revalidate();
		mainWindow.repaint();
	}
}