
public class Course {
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
		return courseTitle + " " + classRoom;
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
