import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//save file
public class File implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

		if (command.equals("New")) {
			if (TimetableManager.saveState == true) {
				FileIO.doFileIO("New");
			} else {
				SaveCheck t = new SaveCheck("New");
				t.setVisible(true);
			}
		}

		else if (command.equals("Open")) {
			if (TimetableManager.saveState == true) {
				FileNameWindow ft = new FileNameWindow("Open");
			} else {
				SaveCheck t = new SaveCheck("Open");
				t.setVisible(true);
			}
		}

		else if (command.equals("Save")) {
			FileNameWindow ft = new FileNameWindow("Save");
		}

	}

}
