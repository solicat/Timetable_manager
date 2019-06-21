import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

public class SetColor implements ActionListener {
	public static Color warningColor = new Color(0xF19CA2);
	public static Color textfieldColor = new Color(0xFFFFFF);

	private static int theme = 0;
	private static Color[] defaultColor = { new Color(0xE2EFEE), new Color(0xCFFFE1), new Color(0xF1CEA8),
			new Color(0XFDF7E0) };
	private static Color[][] color = {
			{ new Color(0xA3B5C1), new Color(0xACCACC), new Color(0xDAE4CC), new Color(0xF0ECE1), new Color(0xF4E0D9),
					new Color(0xBFE9FF), new Color(0xFFE9CD), new Color(0xF8D7D0) },
			{ new Color(0x92C1EF), new Color(0x6FDDDD), new Color(0x80D8B2), new Color(0x99EAD7), new Color(0x328482),
					new Color(0x4BBCBA), new Color(0x80CDD8), new Color(0x8EEFAA) },
			{ new Color(0xE8A1C2), new Color(0xFFAD87), new Color(0xFF9583), new Color(0xDE8E8C), new Color(0xC86274),
					new Color(0x7473A9), new Color(0xA19FCF), new Color(0x9B6E97) },
			{ new Color(0XE4B1E6), new Color(0XA5E69E), new Color(0X6BE8AC), new Color(0XFF9C75), new Color(0XEB9BC7),
					new Color(0X6BE8A3), new Color(0XFFF991), new Color(0X68FF6E) } };

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
						TimetableManager.course[i][j].setBackground(color[theme][top % color[theme].length]);
						top++;
					}

					else
						TimetableManager.course[i][j].setBackground(color[theme][k % color[theme].length]);
				}

				check = true;
			}
		}
	}

	public static void setDefaultColor() {
		int i, j;

		for (i = 0; i < 24; i++) {
			for (j = 0; j < 5; j++) {
				TimetableManager.course[i][j].setBackground(defaultColor[theme]);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Pastel")) {
			theme = 0;
		} else if (e.getActionCommand().equals("Green Blue")) {
			theme = 1;
		} else if (e.getActionCommand().equals("Red Purple")) {
			theme = 2;
		} else if (e.getActionCommand().equals("Candy")) {
			theme = 3;
		}
		setDefaultColor();
		setButtonColor();
	}
}
