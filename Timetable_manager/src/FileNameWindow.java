import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileNameWindow implements ActionListener {

	private JTextField fileName;
	private JFrame window;

	public FileNameWindow(String state) {
		window = new JFrame();
		window.setTitle(state);
		window.setSize(300, 200);
		window.setLayout(new GridLayout(2, 1));

		JPanel file = new JPanel();
		file.setLayout(new FlowLayout());

		JLabel name = new JLabel("File name");
		file.add(name);

		fileName = new JTextField(15);
		fileName.setEditable(true);
		file.add(fileName);

		window.add(file);

		JPanel runpanel = new JPanel(new FlowLayout());
		JButton run = new JButton(state);
		run.addActionListener(this);
		runpanel.add(run);

		window.add(runpanel);

		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File temp = new File(fileName.getText());
		if (e.getActionCommand().equals("Open")) {
			if (temp.exists()) {
				FileIO.file = temp.getName();
				FileIO.doFileIO("Open");
				window.dispose();
			}
		}
		if (e.getActionCommand().equals("Save")) {
			FileIO.file = temp.getName();
			FileIO.doFileIO("Save");
			window.dispose();

			if (SaveCheck.command.equals("YES")) {
				SaveCheck.command = "";
				FileNameWindow windowtemp = new FileNameWindow(SaveCheck.state);
			}
		}
	}
}
