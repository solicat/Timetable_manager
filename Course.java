
import java.io.Serializable;
import java.util.StringTokenizer;

public class Course implements Serializable{
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
		
		while(courseToken.hasMoreTokens()) {
			title += courseToken.nextToken().charAt(0);
		}
		
		return "<html>" + title + "<br />" + classRoom + "</html>";
	}
	//get course title
	public String getCourseTitle() {
		return courseTitle;
	}
	//set course title
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	//get hours
	public TimeAndDay getHours() {
		return hours;
	}
	//set hours
	public void setHours(TimeAndDay hours) {
		this.hours = hours;
	}
	//get classroom
	public String getClassRoom() {
		return classRoom;
	}
	//set classroom
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
}
