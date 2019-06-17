import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//delete course
public class DeleteCourse implements ActionListener {

	private int time;
	private int day;

	public DeleteCourse(int time, int day) {
		this.time = time;
		this.day = day;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Timetable.seti(23);//중복처리 초기화
		Timetable.setj(4);//중복처리 초기화
		int i, j;
		String courseTitle = Timetable.table[time][day].getCourseTitle();
		String date = Timetable.table[time][day].getHours().getDay()
				+ Timetable.table[time][day].getHours().getStartTime()
				+ +Timetable.table[time][day].getHours().getEndTime();
		String temp;

		
		if (e.getActionCommand().equals("Delete")) {
			for (i = 0; i < 24; i++) {
				for (j = 0; j < 5; j++) {
					temp = Timetable.table[i][j].getHours().getDay() + Timetable.table[i][j].getHours().getStartTime()
							+ +Timetable.table[i][j].getHours().getEndTime();
					if (Timetable.table[i][j].getCourseTitle().equals(courseTitle) && temp.equals(date)) {
						Timetable.table[i][j] = new Course();
						TimetableManager.saveState = false;
					}
				}
			}
		} else if (e.getActionCommand().equals("Delete All")) {
			for (i = 0; i < 24; i++) {
				for (j = 0; j < 5; j++) {
					if (Timetable.table[i][j].getCourseTitle().equals(courseTitle)) {
						Timetable.table[i][j] = new Course();
						TimetableManager.saveState = false;
					}
				}
			}
		}

		for (i = 0; i < 24; i++) {
			for (j = 0; j < 5; j++) {
				TimetableManager.course[i][j].setText("" + Timetable.table[i][j]);
			}
		}
		
		SetColor.setDefaultColor();
		SetColor.setButtonColor();
	}

}
