import java.awt.Color;

public class SetColor {
	public static Color defaultColor = new Color(0xE2EFDE);
	private static Color[] color = { new Color(0xA3B5C1), new Color(0xACCACC), new Color(0xDAE4CC), new Color(0xF0ECE1),
			new Color(0xF4E0D9), new Color(0xBFE9FF), new Color(0xFFE9CD), new Color(0xF8D7D0), new Color(0xF19CA2) };

	public static void setButtonColor() {
		String courseTitle[] = new String[120];
		int top = 0;
		int i, j, k;
		boolean check = true;

		for (i = 0; i < 24; i++) {
			for (j = 0; j < 5; j++) {
				if (!TimetableManager.course[i][j].getText().equals("<html><br /></html>")) {
					for (k = 0; k < top; k++) {
						if (courseTitle[k].equals(Timetable.table[i][j].getCourseTitle())) {
							check = false;
							break;
						}
					}

					if (check == true) {
						courseTitle[top] = Timetable.table[i][j].getCourseTitle();
						TimetableManager.course[i][j].setBackground(color[top % color.length]);
						top++;
					}

					else
						TimetableManager.course[i][j].setBackground(color[k]);
				}

				check = true;
			}
		}
	}

	public static void setDefaultColor() {
		int i, j;

		for (i = 0; i < 24; i++) {
			for (j = 0; j < 5; j++) {
				TimetableManager.course[i][j].setBackground(defaultColor);
			}
		}
	}
}
