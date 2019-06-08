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

		if (!(e.getActionCommand().equals("<html><br /></html>"))) {
			int timecheck;
			String timeString;
			String timeToString = "";

			JFrame window = new JFrame(
					Timetable.table[time][day].getCourseTitle() + " " + Timetable.table[time][day].getClassRoom());
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

			JPanel ddayPanel = new JPanel(new FlowLayout());
			JLabel ddayLabel = new JLabel("Day: ");
			JLabel dday = new JLabel(Timetable.table[time][day].getHours().getDay());
			ddayPanel.add(ddayLabel);
			ddayPanel.add(dday);

			JPanel startTimePanel = new JPanel(new FlowLayout());
			JLabel startTimeLabel = new JLabel("Start time: ");
			timecheck = Timetable.table[time][day].getHours().getStartTime();
			timeString = Integer.toString(timecheck);
			if (timecheck < 1000) {
				timeToString += "0";
				timeToString += timeString.charAt(0);
			} else {
				timeToString += timeString.substring(0, 2);
			}
			
			timeToString += ":";
			
			if (timecheck < 1000) {				
				timeToString += timeString.substring(1);
			} else {
				timeToString += timeString.substring(2);
			}
			JLabel startTime = new JLabel(timeToString);
			startTimePanel.add(startTimeLabel);
			startTimePanel.add(startTime);

			timeToString = "";
			JPanel endTimePanel = new JPanel(new FlowLayout());
			JLabel endTimeLabel = new JLabel("End time: ");
			timecheck = Timetable.table[time][day].getHours().getEndTime();
			timeString = Integer.toString(timecheck);
			if (timecheck < 1000) {
				timeToString += "0";
				timeToString += timeString.charAt(0);
			} else {
				timeToString += timeString.substring(0, 2);
			}
			
			timeToString += ":";
			
			if (timecheck < 1000) {				
				timeToString += timeString.substring(1);
			} else {
				timeToString += timeString.substring(2);
			}
			JLabel endTime = new JLabel(timeToString);
			endTimePanel.add(endTimeLabel);
			endTimePanel.add(endTime);

			data.add(courseTitlePanel);
			data.add(classRoomPanel);
			data.add(ddayPanel);
			data.add(startTimePanel);
			data.add(endTimePanel);

			window.add(data, BorderLayout.CENTER);
			window.setSize(500, 200);
			window.setVisible(true);
		}
	}

}
