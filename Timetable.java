
public class Timetable {
	public static Course table[][];

	
	public static int i1=23,j1=0;
	public static int[] line= {25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25};
	public static int[] column= {6,6,6,6,6};
	
	
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
		//A=00, B=30
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
		// find day of the week
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
			return 1;

		startTime = A.getHours().getStartTime();
		endTime = A.getHours().getEndTime();
		//find start time and end time
		if (A.getHours().getStartTime() < 900 && A.getHours().getStartTime() >= 0)
			startTime = 900;
		else if(A.getHours().getStartTime() < 0 || A.getHours().getStartTime() > 2400)
			return 2;
		
		if (A.getHours().getEndTime() > 2100 && A.getHours().getEndTime() < 2400)
			endTime = 2100;
		else if(A.getHours().getEndTime() < 0 || A.getHours().getEndTime() > 2400)
			return 3;

		if (A.getHours().getStartTime() % 100 > 59)
			return 2;
		if (A.getHours().getEndTime() % 100 > 59)
			return 3;
		
		if(startTime > endTime)
			return 2;


		i = (startTime / 100 - 9) * 2;

		if (startTime % 100 >= 30)
			i += 1;

		if ((endTime - startTime) % 100 == 0)
			hours = ((endTime - startTime) / 100) * 2;
		else
			hours = (((endTime - startTime) / 100) * 2) + 1;

		for (len = 0; len < hours; len++)
			table[i + len][j] = A;

		return 0;
	}
	
	public static int geti()
	
	{
		return i1;
	}

	public static void seti(int i)
	{
	i1=i;
	}
	public static void setj(int j)
	{
	j1=j;
	}
	public static int getj()
	{
		return j1;
	}
	
	public static int geti(int i)
	{
		return line[i];
	}
	
	public static int getj(int j)
	{
		return column[j];
		
	}
	
	public static void seti(int n1, int n2)
	{
		line[n1]=n2;
	}
	public static void setj(int n1, int n2)
	{
		column[n1]=n2;
	}
	

	public static Course[][] getTimetable() {
		return table;
	}

}
