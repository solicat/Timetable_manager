import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public AddCourseWindow() {
		setTitle("Add Course");
		setSize(500, 300);

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
		boolean check;

		if (e.getActionCommand().equals("Add")) {
			ct = courseTitle.getText();
			cr = classRoom.getText();
			sday = day.getText();
			st = Integer.parseInt(startTime.getText());
			et = Integer.parseInt(endTime.getText());

			check = Timetable.setTimetable(new Course(ct, cr, sday, st, et));

			if (check) {
				for (i = 0; i < 24; i++) {
					for (j = 0; j < 5; j++) {
						TimetableManager.course[i][j].setText("" + Timetable.table[i][j]);
						TimetableManager.timetable.add(TimetableManager.course[i][j]);
					}
				}
				TimetableManager.saveState = false;
			}

			Timetable.printTimetable();
		}

	}

}
