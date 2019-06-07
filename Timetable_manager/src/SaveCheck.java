import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SaveCheck extends JFrame implements ActionListener {

	private String state;

	public SaveCheck(String state) {
		this.state = state;

		setLayout(new BorderLayout());

		JLabel save = new JLabel("Do you want to save?");
		save.setHorizontalAlignment(JLabel.CENTER);

		add(save, BorderLayout.CENTER);

		JPanel checkButton = new JPanel(new FlowLayout());
		JButton yes = new JButton("YES");
		yes.addActionListener(this);
		JButton no = new JButton("NO");
		no.addActionListener(this);
		JButton cancel = new JButton("CANCEL");
		cancel.addActionListener(this);

		checkButton.add(yes);
		checkButton.add(no);
		checkButton.add(cancel);

		add(checkButton, BorderLayout.SOUTH);

		setSize(500, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals("YES")) {
			FileIO.doFileIO("Save");
			FileIO.doFileIO(state);
			dispose();
		} else if (command.equals("NO")) {
			FileIO.doFileIO(state);
			dispose();
		} else if (command.equals("CANCEL")) {
			dispose();
		}
	}

}
