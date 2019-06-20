import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {

	public static String file;

	public static void doFileIO(String state) {
		int i, j;

		if (state.equals("New")) {
			Timetable temp = new Timetable(); // reset Timetable.table

			for (i = 0; i < 24; i++) {
				for (j = 0; j < 5; j++) {
					TimetableManager.course[i][j].setText("" + Timetable.table[i][j]);
				}
			}

			TimetableManager.saveState = true;

			SetColor.setDefaultColor();
		}

		else if (state.equals("Open")) {

			FileIO.doFileIO("New");

			ObjectInputStream inputStream;
			Course courseTemp;

			try {
				inputStream = new ObjectInputStream(new FileInputStream(file));
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

				inputStream.close();

				TimetableManager.saveState = true;

				SetColor.setButtonColor();

			} catch (FileNotFoundException e1) {
				System.out.println("FileNotFoundException");
			} catch (ClassNotFoundException e1) {
				System.out.println("ClassNotFoundException");
			} catch (IOException e1) {
				System.out.println("IOException");
			}

		} else if (state.equals("Save")) {

			ObjectOutputStream outputStream;
			Course temp;

			try {
				outputStream = new ObjectOutputStream(new FileOutputStream(file));

				for (i = 0; i < 24; i++) {
					for (j = 0; j < 5; j++) {
						temp = Timetable.table[i][j];
						outputStream.writeObject(temp);
					}
				}

				outputStream.close();

				TimetableManager.saveState = true;
			} catch (IOException e1) {
				System.out.println("IOException");
			}
		}
	}
}
