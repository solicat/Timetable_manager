
import java.util.Scanner;

public class TimetableManager {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String courseTitle;
		String classRoom;
		String day;
		int startTime;
		int endTime;

		Timetable TT1 = new Timetable();

//		Course A = new Course("JAVA", "IT-5 355", "Mon", 900, 1030);
//		TT1.setTimetable(A);
//		Course B = new Course("DS", "IT-4 106", "Mon", 1330, 1700);
//		TT1.setTimetable(B);

		System.out.println("courseTItle classRoom day startTime endTime");

		while (true) {
			courseTitle = kb.next();
			classRoom = kb.next();
			day = kb.next();
			startTime = kb.nextInt();
			endTime = kb.nextInt();

			TT1.setTimetable(new Course(courseTitle, classRoom, day, startTime, endTime));

			TT1.printTimetable();
		}
	}

}
