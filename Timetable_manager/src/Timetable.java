
public class Timetable {
	private Course table[][];

	public Timetable() {
		int i, j;

		table = new Course[24][5];
		for (i = 0; i < table.length; i++) {
			for (j = 0; j < table[i].length; j++) {
				table[i][j] = new Course();
			}
		}
	}

	public void printTimetable() {
		int i, j;

		System.out.println("	Mon		Tue		Wen		Thu		Fri");
		for (i = 0; i < table.length; i++) {
			System.out.print(i / 2 + 1);
			if (i % 2 == 0)
				System.out.print("A");
			else
				System.out.print("B");
			for (j = 0; j < table[i].length; j++) {
				if(table[i][j].getCourseTitle().equals(""))
					System.out.print("		");
				System.out.print(" " + table[i][j]);
			}
			System.out.println();
		}

	}

	public void setTimetable(Course A) {
		int i, j, len;

		if (A.getHours().getDay().equals("Mon"))
			j = 0;
		else if (A.getHours().getDay().equals("Tue"))
			j = 1;
		else if (A.getHours().getDay().equals("Wed"))
			j = 2;
		else if (A.getHours().getDay().equals("Thu"))
			j = 3;
		else
			j = 4;

		i = (A.getHours().getStartTime() / 100 - 9) * 2;

		if (A.getHours().getStartTime() % 100 >= 30)
			i += 1;
		
		for(len = 0; len < A.getHours().classHours(); len++)
			table[i + len][j] = A;
	}
	
	public Course[][] getTimetable()
	{
		return table;
	}

}
