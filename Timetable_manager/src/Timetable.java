
public class Timetable {
	public static Course table[][];

	public Timetable() {
		int i, j;

		table = new Course[24][5];
		for (i = 0; i < table.length; i++) {
			for (j = 0; j < table[i].length; j++) {
				table[i][j] = new Course();
			}
		}
	}

	// For test
	public static void printTimetable() {
		int i, j;

		System.out.println("	Mon		Tue		Wen		Thu		Fri");
		for (i = 0; i < table.length; i++) {
			System.out.print(i / 2 + 1);
			if (i % 2 == 0)
				System.out.print("A");
			else
				System.out.print("B");
			for (j = 0; j < table[i].length; j++) {
				if (table[i][j].getCourseTitle().equals(""))
					System.out.print("		");
				System.out.print(" " + table[i][j]);
			}
			System.out.println();
		}

	}

	public static int setTimetable(Course A) {
		int i, j, len;
		int startTime;
		int endTime;
		int hours;

		if (A.getCourseTitle().equals(""))
			return 1;

		if (A.getClassRoom().equals(""))
			return 2;

		if (A.getHours().getDay().equals("Mon"))
			j = 0;
		else if (A.getHours().getDay().equals("Tue"))
			j = 1;
		else if (A.getHours().getDay().equals("Wed"))
			j = 2;
		else if (A.getHours().getDay().equals("Thu"))
			j = 3;
		else if (A.getHours().getDay().equals("Fri"))
			j = 4;
		else
			return 3;

		startTime = A.getHours().getStartTime();
		endTime = A.getHours().getEndTime();

		// Check hour
		if (A.getHours().getStartTime() < 900 && A.getHours().getStartTime() >= 0)
			startTime = 900;
		else if (A.getHours().getStartTime() < 0 || A.getHours().getStartTime() > 2400)
			return 4;

		if (A.getHours().getEndTime() > 2100 && A.getHours().getEndTime() < 2400)
			endTime = 2100;
		else if (A.getHours().getEndTime() < 0 || A.getHours().getEndTime() > 2400)
			return 5;

		// Check minute
		if (A.getHours().getStartTime() % 100 > 59)
			return 4;
		if (A.getHours().getEndTime() % 100 > 59)
			return 5;

		// Check time order
		if (startTime > endTime)
			return 6;

		i = (startTime / 100 - 9) * 2;

		if (startTime % 100 >= 30)
			i += 1;

		if ((endTime - startTime) % 100 == 0)
			hours = ((endTime - startTime) / 100) * 2;
		else
			hours = (((endTime - startTime) / 100) * 2) + 1;

		// Check overlap
		if (AddCourseWindow.overlapCheckActivate == true) {
			for (len = 0; len < hours; len++) {
				if (!(table[i + len][j].getCourseTitle().equals("") && table[i + len][j].getClassRoom().equals("")))
					return 6;
			}
		}

		for (len = 0; len < hours; len++)
			table[i + len][j] = A;

		return 0;
	}

}
