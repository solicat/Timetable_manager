import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//save check
public class SaveCheck extends JFrame implements ActionListener {

	public static String state;
	public static String command;

	public SaveCheck(String state) {
		SaveCheck.state = state;

		setTitle("Save?");
		setLayout(new BorderLayout());

		JLabel save = new JLabel("Do you want to save?");
		save.setHorizontalAlignment(JLabel.CENTER);

		add(save, BorderLayout.CENTER);

		JPanel checkButton = new JPanel(new FlowLayout());
		JButton yes = new JButton("YES");
		yes.setMnemonic(KeyEvent.VK_Y);
		yes.addActionListener(this);
		JButton no = new JButton("NO");
		no.setMnemonic(KeyEvent.VK_N);
		no.addActionListener(this);
		JButton cancel = new JButton("CANCEL");
		cancel.setMnemonic(KeyEvent.VK_C);
		cancel.addActionListener(this);

		checkButton.add(yes);
		checkButton.add(no);
		checkButton.add(cancel);

		add(checkButton, BorderLayout.SOUTH);

		setSize(500, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		command = e.getActionCommand();
		if (command.equals("YES")) {
			FileNameWindow temp = new FileNameWindow("Save");
			dispose();
		} else if (command.equals("NO")) {
			if (state.equals("New")) {
				FileIO.doFileIO(state);
			} else {
				FileNameWindow temp = new FileNameWindow(state); // Open
			}
			dispose();
		} else if (command.equals("CANCEL")) {
			dispose();
		}
	}

}
