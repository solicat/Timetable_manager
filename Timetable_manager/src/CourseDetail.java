import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			saveDate = new String[120];
			top = 0;

			JFrame window = new JFrame(e.getActionCommand());
			window.setLayout(new BorderLayout());
			
			JPanel data = new JPanel();
			data.setLayout(new GridLayout(6, 1));

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

			data.add(courseTitlePanel);
			data.add(classRoomPanel);
			data.add(timePanel);

			for (i = 0; i < 5; i++) {	//Row direction
				for (j = 0; j < 24; j++) {
					currentDate = Timetable.table[j][i].getHours().getDay() + ", "
							+ Timetable.table[j][i].getHours().getStartTime() + " ~ "
							+ Timetable.table[j][i].getHours().getEndTime();
					currentCourse = Timetable.table[j][i].getCourseTitle();

					check = true;

					for (k = 0; k < top; k++) {
						if (saveDate[k].equals(currentDate)) {
							check = false;
							break;
						}
					}

					if (!saveDate.equals(currentDate) && currentCourse.equals(course) && check) {
						JPanel dayPanel = new JPanel(new FlowLayout());
						JLabel dayLabel = new JLabel(currentDate);
						dayPanel.add(dayLabel);
						data.add(dayPanel);
						saveDate[top++] = currentDate;
					}
				}
			}

			window.add(data, BorderLayout.CENTER);
			window.setSize(500, 200);
			window.setVisible(true);
		}
	}

}
