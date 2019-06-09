import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OverwriteCheck implements ActionListener{

	private JFrame window;
	public static String command = "YES";
	
	public OverwriteCheck() {
		window = new JFrame("Overwrite?");
		window.setLayout(new GridLayout(2, 1));
		
		JPanel overwritePanel = new JPanel(new FlowLayout());
		JLabel overwrite = new JLabel("Do you want to overwrite?");
		overwritePanel.add(overwrite);
		
		JPanel buttonPanel = new JPanel(new FlowLayout());
		JButton yes = new JButton("YES");
		yes.setMnemonic(KeyEvent.VK_Y);
		yes.addActionListener(this);
		JButton no = new JButton("NO");
		no.setMnemonic(KeyEvent.VK_N);
		no.addActionListener(this);
		buttonPanel.add(yes);
		buttonPanel.add(no);
		
		window.add(overwritePanel);
		window.add(buttonPanel);
		
		window.setSize(300, 200);
		window.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		command = e.getActionCommand();
		if(command.equals("NO")) {
			FileNameWindow windowtemp = new FileNameWindow("Save");
			window.dispose();
		}
		else {
			FileIO.doFileIO("Save");
			window.dispose();
		}
		
	}

}
