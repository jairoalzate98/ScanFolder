package views;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import controller.Controller;
import controller.Events;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainWindow(Controller controller) {
		setTitle("ScanFolder");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		JButton jbtnSelectFolder = new JButton(ConstantsGui.SELECT_FOLDER_TEXT);
		jbtnSelectFolder.setActionCommand(Events.SELECT_FOLDER.toString());
		jbtnSelectFolder.addActionListener(controller);
		add(jbtnSelectFolder, BorderLayout.SOUTH);
		setVisible(true);
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