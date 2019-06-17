import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddCourseWindow extends JFrame implements ActionListener {

	private JTextField courseTitle;
	private JTextField classRoom;
	private JTextField day;
	private JTextField startTime;
	private JTextField endTime;
	public static int line=0;
	public static int column=0;
	public AddCourseWindow() {
		setTitle("Add Course");
		setSize(500, 300);

		JPanel inputpanel = new JPanel(new GridLayout(6, 1));
		
		
		//add course title in window
		JPanel courseTitlePanel = new JPanel(new FlowLayout());
		courseTitle = new JTextField(30);
		courseTitle.setEditable(true);
		courseTitlePanel.add(new JLabel("Course title"));
		courseTitlePanel.add(courseTitle);
		inputpanel.add(courseTitlePanel);

		//add classroom name in window
		JPanel classRoomPanel = new JPanel(new FlowLayout());
		classRoom = new JTextField(30);
		classRoom.setEditable(true);
		classRoomPanel.add(new JLabel("Classroom"));
		classRoomPanel.add(classRoom);
		inputpanel.add(classRoomPanel);

		//add date in window
		JPanel dayPanel = new JPanel(new FlowLayout());
		day = new JTextField(30);
		day.setText("Mon, Tue, Wed, Thu, Fri");
		day.setEditable(true);
		dayPanel.add(new JLabel("Day"));
		dayPanel.add(day);
		inputpanel.add(dayPanel);

		//add start time in window
		JPanel startTimePanel = new JPanel(new FlowLayout());
		startTime = new JTextField(30);
		startTime.setText("HHMM");
		startTime.setEditable(true);
		startTimePanel.add(new JLabel("Start time"));
		startTimePanel.add(startTime);
		inputpanel.add(startTimePanel);

		//add end time in window
		JPanel endTimePanel = new JPanel(new FlowLayout());
		endTime = new JTextField(30);
		endTime.setText("HHMM");
		endTime.setEditable(true);
		endTimePanel.add(new JLabel("End time"));
		endTimePanel.add(endTime);
		inputpanel.add(endTimePanel);

		//add button in window
		JPanel inputpanelButton = new JPanel(new FlowLayout());
		JButton addButton = new JButton("Add");
		addButton.setMnemonic(KeyEvent.VK_D);
		addButton.addActionListener(this);
		inputpanelButton.add(addButton);
		inputpanel.add(inputpanelButton);
		
		add(inputpanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ct;		//course title
		String cr;		//classroom name	
		String sday;	//date
		
		int st;			//start time
		int et;			//end time
		int i, j;
		int check;
		boolean c=true; //check overlap
		
		int Day=0;
		
	
		
		
		if (e.getActionCommand().equals("Add")) {
			
			
			
			ct = courseTitle.getText();
			cr = classRoom.getText();
			sday = day.getText();
			st = Integer.parseInt(startTime.getText());
			et = Integer.parseInt(endTime.getText());
			//System.out.println(sday);
			day.setBackground(SetColor.textfieldColor);
			startTime.setBackground(SetColor.textfieldColor);
			endTime.setBackground(SetColor.textfieldColor);
			
			
			
			if(sday.equals("Mon"))
				Day=0;
			else if(sday.equals("Tue"))
				Day=1;
			else if(sday.equals("Wed"))
				Day=2;
			else if(sday.equals("Thu"))
				Day=3;
			else
				Day=4;
				
			column=Day;
			line=st;
			
			check = Timetable.setTimetable(new Course(ct, cr, sday, st, et));
			
			//check overlap
			//Timetable.getj()==Day
			
			
			if(Timetable.getj()==Day)
			{
				if(Timetable.geti()==(st-900)/100)
				{
					c=false;
				}
			}
			else
				c=true;
				
			
			
				
			if(c==true) {
			if (check == 0) {
				for (i = 0; i < 24; i++) {
					for (j = 0; j < 5; j++) {
						
						
						
							
						
					
						TimetableManager.course[i][j].setText("" + Timetable.table[i][j]);
						TimetableManager.timetable.add(TimetableManager.course[i][j]);
					
						
						
						
							
						
					}
				}
				
				
				TimetableManager.saveState = false;
			} else if (check == 1) {
				day.setBackground(SetColor.warningColor);
			} else if (check == 2) {
				startTime.setBackground(SetColor.warningColor);
			} else if (check == 3) {
				endTime.setBackground(SetColor.warningColor);
			}
			c=true;
			Timetable.seti((st-900)/100);
			Timetable.setj(Day);

	}
			
			if(c==false)
			{
				new OverlapWindow();
			}
			if(sday=="Mon")
				Day=0;
			else if(sday=="Tue")
				Day=1;
			else if(sday=="Wed")
				Day=2;
			else if(sday=="Thu")
				Day=3;
			if(sday=="Fri")
				Day=4;
		}
			

	}
}

class OverlapWindow extends JFrame {
	
	OverlapWindow()
	{
		setTitle("Time Overlap");
	
	
	JPanel NewWindowContainer =new JPanel();
	setContentPane(NewWindowContainer);
	
	JLabel NewLabel=new JLabel("시간이 중복 됩니다.");
	
	NewWindowContainer.add(NewLabel);
	
	setSize(300,100);
	setResizable(false);
	setVisible(true);
	
	}
	
}
