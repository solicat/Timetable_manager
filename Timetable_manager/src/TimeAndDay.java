import java.io.Serializable;

public class TimeAndDay implements Serializable {
	private String day;
	private int startTime;
	private int endTime;

	public TimeAndDay() {
		this.day = "";
		this.startTime = 0;
		this.endTime = 0;
	}

	public TimeAndDay(String day, int startTime, int endTime) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public String toString() {
		return day + startTime + " ~ " + endTime;
	}

}
