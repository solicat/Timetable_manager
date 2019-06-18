import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CourseDetail implements ActionListener {

	private int time;
	private int day;

	public CourseDetail(int time, int day) {
		this.time = time;
		this.day = day;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int i, j, k;
		String course = Timetable.table[time][day].getCourseTitle();
		String currentCourse;
		String saveDate[];
		String currentDate;
		int top;
		boolean check;

		if (!(e.getActionCommand().equals("<html><br /></html>"))) {
			int starttimecheck;
			int endtimecheck;
			String starttimeString;
			String starttimeToString = "";
			String endtimeString;
			String endtimeToString = "";

			JFrame window = new JFrame(
					Timetable.table[time][day].getCourseTitle() + " " + Timetable.table[time][day].getClassRoom());

			saveDate = new String[120];
			top = 0;
			window.setLayout(new BorderLayout());

			JPanel data = new JPanel();
			data.setLayout(new GridLayout(7, 1));

			JPanel courseTitlePanel = new JPanel(new FlowLayout());
			JLabel courseTitleLabel = new JLabel("Course title: ");
			JLabel courseTitle = new JLabel(Timetable.table[time][day].getCourseTitle());
			courseTitlePanel.add(courseTitleLabel);
			courseTitlePanel.add(courseTitle);

			JPanel classRoomPanel = new JPanel(new FlowLayout());
			JLabel classRoomLabel = new JLabel("Classroom: ");
			JLabel classRoom = new JLabel(Timetable.table[time][day].getClassRoom());
			classRoomPanel.add(classRoomLabel);
			classRoomPanel.add(classRoom);

			JPanel timePanel = new JPanel(new FlowLayout());
			JLabel timeLabel = new JLabel("Time: ");
			timePanel.add(timeLabel);

			JPanel buttonPanel = new JPanel(new FlowLayout());
			JButton delete = new JButton("Delete");
			delete.setMnemonic(KeyEvent.VK_D);
			delete.addActionListener(new DeleteCourse(time, day));
			JButton deleteAll = new JButton("Delete All");
			deleteAll.setMnemonic(KeyEvent.VK_A);
			deleteAll.addActionListener(new DeleteCourse(time, day));
			buttonPanel.add(delete);
			buttonPanel.add(deleteAll);

			data.add(courseTitlePanel);
			data.add(classRoomPanel);
			data.add(timePanel);

			for (i = 0; i < 5; i++) { // Column direction
				for (j = 0; j < 24; j++) {
					starttimeToString = "";
					endtimeToString = "";

					starttimecheck = Timetable.table[j][i].getHours().getStartTime();
					starttimeString = Integer.toString(starttimecheck);
					if (starttimecheck < 1000) {
						starttimeToString += "0";
						starttimeToString += starttimeString.charAt(0);
					} else {
						starttimeToString += starttimeString.substring(0, 2);
					}

					starttimeToString += ":";

					if (starttimecheck < 1000) {
						starttimeToString += starttimeString.substring(1);
					} else {
						starttimeToString += starttimeString.substring(2);
					}

					endtimecheck = Timetable.table[j][i].getHours().getEndTime();
					endtimeString = Integer.toString(endtimecheck);
					if (endtimecheck < 1000) {
						endtimeToString += "0";
						endtimeToString += endtimeString.charAt(0);
					} else {
						endtimeToString += endtimeString.substring(0, 2);
					}

					endtimeToString += ":";

					if (endtimecheck < 1000) {
						endtimeToString += endtimeString.substring(1);
					} else {
						endtimeToString += endtimeString.substring(2);
					}

					currentDate = Timetable.table[j][i].getHours().getDay() + ", " + starttimeToString + " ~ "
							+ endtimeToString;
					currentCourse = Timetable.table[j][i].getCourseTitle();

					check = true;

					for (k = 0; k < top; k++) {
						if (saveDate[k].equals(currentDate)) {
							check = false;
							break;
						}
					}

					if (currentCourse.equals(course) && check) {
						JPanel dayPanel = new JPanel(new FlowLayout());
						JLabel dayLabel = new JLabel(currentDate);
						dayPanel.add(dayLabel);
						data.add(dayPanel);
						saveDate[top++] = currentDate;
					}
				}
			}

			data.add(buttonPanel);

			window.add(data, BorderLayout.CENTER);
			window.setSize(500, 300);
			window.setVisible(true);
		} else {
			AddCourseWindow temp = new AddCourseWindow();
			temp.setVisible(true);
		}
	}

}
