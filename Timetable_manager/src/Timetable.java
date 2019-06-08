
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

	public static boolean setTimetable(Course A) {
		int i, j, len;
		int startTime;
		int endTime;
		int hours;

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
			return false;

		startTime = A.getHours().getStartTime();
		endTime = A.getHours().getEndTime();

		if (A.getHours().getStartTime() < 900 && A.getHours().getStartTime() >= 0)
			startTime = 900;
		else
			return false;
		
		if (A.getHours().getEndTime() > 2100 && A.getHours().getEndTime() < 2400)
			endTime = 2100;
		else
			return false;

		if (A.getHours().getStartTime() % 100 > 59)
			return false;
		if (A.getHours().getEndTime() % 100 > 59)
			return false;
		
		if(startTime > endTime)
			return false;

		i = (startTime / 100 - 9) * 2;

		if (startTime % 100 >= 30)
			i += 1;

		if ((endTime - startTime) % 100 == 0)
			hours = ((endTime - startTime) / 100) * 2;
		else
			hours = (((endTime - startTime) / 100) * 2) + 1;

		for (len = 0; len < hours; len++)
			table[i + len][j] = A;

		return true;
	}

	public static Course[][] getTimetable() {
		return table;
	}

}
