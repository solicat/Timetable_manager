import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class File implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		int i, j;

		if (command.equals("New")) {
			
			Timetable temp = new Timetable(); // reset Timetable.table
			Timetable.table = Timetable.getTimetable();

			for (i = 0; i < 24; i++) {
				for (j = 0; j < 5; j++) {
					TimetableManager.course[i][j].setText("" + Timetable.table[i][j]);
				}
			}
			
			TimetableManager.saveState = true;

		} else if (command.equals("Open")) {
			Timetable temp = new Timetable(); // reset Timetable.table
			Timetable.table = Timetable.getTimetable();

			for (i = 0; i < 24; i++) {
				for (j = 0; j < 5; j++) {
					TimetableManager.course[i][j].setText("" + Timetable.table[i][j]);
				}
			}

			ObjectInputStream inputStream;
			Course courseTemp;

			try {
				inputStream = new ObjectInputStream(new FileInputStream("test"));
				// Read file
				for (i = 0; i < 24; i++) {
					for (j = 0; j < 5; j++) {
						courseTemp = (Course) inputStream.readObject();
						Timetable.setTimetable(courseTemp);
					}
				}

				// Write to timetable
				for (i = 0; i < 24; i++) {
					for (j = 0; j < 5; j++) {
						TimetableManager.course[i][j].setText("" + Timetable.table[i][j]);
					}
				}
				
				TimetableManager.saveState = true;

				inputStream.close();

			} catch (FileNotFoundException e1) {

			} catch (ClassNotFoundException e1) {

			} catch (IOException e1) {

			}

		} else if (command.equals("Save")) {
			ObjectOutputStream outputStream;
			Course temp;
			try {
				outputStream = new ObjectOutputStream(new FileOutputStream("test"));

				for (i = 0; i < 24; i++) {
					for (j = 0; j < 5; j++) {
						temp = Timetable.table[i][j];
						outputStream.writeObject(temp);
					}
				}

				outputStream.close();

				TimetableManager.saveState = true;
			} catch (IOException e1) {

			}
		}

	}

}
