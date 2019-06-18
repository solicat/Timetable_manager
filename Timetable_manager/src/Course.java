
import java.io.Serializable;
import java.util.StringTokenizer;

public class Course implements Serializable {
	private String courseTitle;
	private String classRoom;
	private TimeAndDay hours;

	public Course() {
		courseTitle = "";
		classRoom = "";
		this.hours = new TimeAndDay();
	}

	public Course(String courseTitle, String classRoom, String day, int startTime, int endTime) {
		this.courseTitle = courseTitle;
		this.classRoom = classRoom;
		this.hours = new TimeAndDay(day, startTime, endTime);
	}

	public String toString() {
		StringTokenizer courseToken = new StringTokenizer(courseTitle);
		String title = "";

		// Make courseTitle's initial
		while (courseToken.hasMoreTokens()) {
			title += courseToken.nextToken().charAt(0);
		}

		// Multiple line text on button
		return "<html>" + title + "<br />" + classRoom + "</html>";
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public TimeAndDay getHours() {
		return hours;
	}

	public void setHours(TimeAndDay hours) {
		this.hours = hours;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
}
