import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCourseWindow extends JFrame implements ActionListener {

	private JTextField courseTitle;
	private JTextField classRoom;
	private JTextField day;
	private JTextField startTime;
	private JTextField endTime;
	public static boolean overlapCheckActivate = false;

	public AddCourseWindow() {
		setTitle("Add Course");
		setSize(500, 300);
		addWindowListener(new CheckOnExit());

		JPanel inputpanel = new JPanel(new GridLayout(6, 1));

		JPanel courseTitlePanel = new JPanel(new FlowLayout());
		courseTitle = new JTextField(30);
		courseTitle.setEditable(true);
		courseTitlePanel.add(new JLabel("Course title"));
		courseTitlePanel.add(courseTitle);
		inputpanel.add(courseTitlePanel);

		JPanel classRoomPanel = new JPanel(new FlowLayout());
		classRoom = new JTextField(30);
		classRoom.setEditable(true);
		classRoomPanel.add(new JLabel("Classroom"));
		classRoomPanel.add(classRoom);
		inputpanel.add(classRoomPanel);

		JPanel dayPanel = new JPanel(new FlowLayout());
		day = new JTextField(30);
		day.setText("Mon, Tue, Wed, Thu, Fri");
		day.setEditable(true);
		dayPanel.add(new JLabel("Day"));
		dayPanel.add(day);
		inputpanel.add(dayPanel);

		JPanel startTimePanel = new JPanel(new FlowLayout());
		startTime = new JTextField(30);
		startTime.setText("HHMM");
		startTime.setEditable(true);
		startTimePanel.add(new JLabel("Start time"));
		startTimePanel.add(startTime);
		inputpanel.add(startTimePanel);

		JPanel endTimePanel = new JPanel(new FlowLayout());
		endTime = new JTextField(30);
		endTime.setText("HHMM");
		endTime.setEditable(true);
		endTimePanel.add(new JLabel("Start time"));
		endTimePanel.add(endTime);
		inputpanel.add(endTimePanel);

		JPanel inputpanelButton = new JPanel(new FlowLayout());
		JButton addButton = new JButton("Add");
		addButton.setMnemonic(KeyEvent.VK_D);
		addButton.addActionListener(this);
		inputpanelButton.add(addButton);
		inputpanel.add(inputpanelButton);

		add(inputpanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ct;
		String cr;
		String sday;
		int st;
		int et;
		int i, j;
		int check;
		int dayj = -1;
		int hours = 0;

		if (e.getActionCommand().equals("Add")) {
			ct = courseTitle.getText();
			cr = classRoom.getText();
			sday = day.getText();
			st = Integer.parseInt(startTime.getText());
			et = Integer.parseInt(endTime.getText());

			courseTitle.setBackground(SetColor.textfieldColor);
			classRoom.setBackground(SetColor.textfieldColor);
			day.setBackground(SetColor.textfieldColor);
			startTime.setBackground(SetColor.textfieldColor);
			endTime.setBackground(SetColor.textfieldColor);

			overlapCheckActivate = true;
			check = Timetable.setTimetable(new Course(ct, cr, sday, st, et));
			overlapCheckActivate = false;

			if (check == 0) {
				for (i = 0; i < 24; i++) {
					for (j = 0; j < 5; j++) {
						TimetableManager.course[i][j].setText("" + Timetable.table[i][j]);
						TimetableManager.timetable.add(TimetableManager.course[i][j]);
					}
				}
				TimetableManager.saveState = false;
			} else if (check == 1) {
				courseTitle.setBackground(SetColor.warningColor);
			} else if (check == 2) {
				classRoom.setBackground(SetColor.warningColor);
			} else if (check == 3) {
				day.setBackground(SetColor.warningColor);
			} else if (check == 4) {
				startTime.setBackground(SetColor.warningColor);
			} else if (check == 5) {
				endTime.setBackground(SetColor.warningColor);
			} else if (check == 6) {

				if (sday.equals("Mon"))
					dayj = 0;
				else if (sday.equals("Tue"))
					dayj = 1;
				else if (sday.equals("Wed"))
					dayj = 2;
				else if (sday.equals("Thu"))
					dayj = 3;
				else if (sday.equals("Fri"))
					dayj = 4;

				i = (st / 100 - 9) * 2;

				if (st % 100 >= 30)
					i += 1;

				if ((et - st) % 100 == 0)
					hours = ((et - st) / 100) * 2;
				else
					hours = (((et - st) / 100) * 2) + 1;
				SetColor.setDefaultColor();
				SetColor.setButtonColor();

				for (j = 0; j < hours; j++) {
					TimetableManager.course[i + j][dayj].setBackground(SetColor.warningColor);
				}

				startTime.setBackground(SetColor.warningColor);
				endTime.setBackground(SetColor.warningColor);

			}

			if (check != 6) {
				SetColor.setDefaultColor();
				SetColor.setButtonColor();
			}
			// Timetable.printTimetable(); //For test
		}

	}

	private class CheckOnExit extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent arg0) {
			SetColor.setDefaultColor();
			SetColor.setButtonColor();
		}

	}

}
