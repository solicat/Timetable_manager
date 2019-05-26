
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimetableManager extends JFrame implements ActionListener {

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;

	private JTextField courseTitle;
	private JTextField classRoom;
	private JTextField day;
	private JTextField startTime;
	private JTextField endTime;

	Timetable TT1 = new Timetable();

	JPanel guitt = new JPanel(new GridLayout(24, 5));
	JButton[][] course = new JButton[24][5];

	public static void main(String[] args) {
		TimetableManager newTimetable = new TimetableManager();
		newTimetable.setVisible(true);
	}

	public TimetableManager() {

		Course A = new Course("JAVA", "IT-5 355", "Mon", 900, 1030);
		TT1.setTimetable(A);
		Course B = new Course("DS", "IT-4 106", "Mon", 1330, 1700);
		TT1.setTimetable(B);

		int i, j;

		setTitle("TimetableManager");
		setSize(WIDTH, HEIGHT);
		
		setLayout(new GridBagLayout());
		GridBagConstraints[] ttmgbc = new GridBagConstraints[2];
		ttmgbc[0] = new GridBagConstraints();
		ttmgbc[0].gridx = 0;
		ttmgbc[0].gridy = 0;
		ttmgbc[0].weighty = 7;
		ttmgbc[0].fill = GridBagConstraints.BOTH;
		ttmgbc[1] = new GridBagConstraints();
		ttmgbc[1].gridx = 0;
		ttmgbc[1].gridy = 1;
		ttmgbc[1].weighty = 3;
		ttmgbc[1].fill = GridBagConstraints.BOTH;

		JPanel fulltt = new JPanel(new GridBagLayout());
		GridBagConstraints[] fullttgbc = new GridBagConstraints[6];
		
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 3; j++) {
				fullttgbc[i * 3 + j] = new GridBagConstraints();
				fullttgbc[i * 3 + j].gridx = j;
				fullttgbc[i * 3 + j].gridy = i;
			}
		}
		fullttgbc[0].weightx = 1;
		fullttgbc[0].weighty = 1;
		fullttgbc[0].fill = GridBagConstraints.BOTH;
		fullttgbc[1].weightx = 8;
		fullttgbc[1].weighty = 1;
		fullttgbc[1].fill = GridBagConstraints.BOTH;
		fullttgbc[2].weightx = 1;
		fullttgbc[2].weighty = 1;
		fullttgbc[2].fill = GridBagConstraints.BOTH;
		fullttgbc[3].weightx = 1;
		fullttgbc[3].weighty = 6;
		fullttgbc[3].fill = GridBagConstraints.BOTH;
		fullttgbc[4].weightx = 8;
		fullttgbc[4].weighty = 6;
		fullttgbc[4].fill = GridBagConstraints.BOTH;
		fullttgbc[5].weightx = 1;
		fullttgbc[5].weighty = 6;
		fullttgbc[5].fill = GridBagConstraints.BOTH;
		
		for(i = 0; i < 24; i++)
		{
			for(j = 0; j < 5; j++)
			{
				course[i][j] = new JButton("" + TT1.table[i][j]);
				course[i][j].addActionListener(this);
				
				guitt.add(course[i][j]);
			}
		}		
		
		JPanel DAY = new JPanel(new GridLayout(1, 5));
		
		JLabel Mon = new JLabel("Mon");
		JLabel Tue = new JLabel("Tue");
		JLabel Wed = new JLabel("Wed");
		JLabel Thu = new JLabel("Thu");
		JLabel Fri = new JLabel("Fri");
		DAY.add(Mon);
		DAY.add(Tue);
		DAY.add(Wed);
		DAY.add(Thu);
		DAY.add(Fri);
		
		
		fulltt.add(new JLabel(""), fullttgbc[0]);
		fulltt.add(DAY, fullttgbc[1]);
		
		JPanel time = new JPanel(new GridLayout(24, 1));

		for (i = 0; i < 24; i++) {
			if (i % 2 == 0) {
				time.add(new JLabel((i / 2 + 1) + "A"));
			} else
				time.add(new JLabel((i / 2 + 1) + "B"));
		}
		
		JPanel realTime = new JPanel(new GridLayout(24, 1));
		
		for (i = 0; i < 24; i++) {
			if (i % 2 == 0) {
				realTime.add(new JLabel((i / 2 + 9) + ":00 ~ " + (i / 2 + 9) + ":30"));
			} else
				realTime.add(new JLabel((i / 2 + 9) + ":30 ~ " + (i / 2 + 10) + ":00"));
		}
		
		fulltt.add(new JButton(""), fullttgbc[2]);
		fulltt.add(time, fullttgbc[3]);
		fulltt.add(guitt, fullttgbc[4]);
		fulltt.add(realTime, fullttgbc[5]);
		
		
		add(fulltt, ttmgbc[0]);
		
		JPanel input = new JPanel(new GridLayout(6, 1));

		JPanel courseTitlePanel = new JPanel(new FlowLayout());
		courseTitle = new JTextField(30);
		courseTitle.setEditable(true);
		courseTitlePanel.add(new JLabel("Course title"));
		courseTitlePanel.add(courseTitle);
		input.add(courseTitlePanel);

		JPanel classRoomPanel = new JPanel(new FlowLayout());
		classRoom = new JTextField(30);
		classRoom.setEditable(true);
		classRoomPanel.add(new JLabel("Classroom"));
		classRoomPanel.add(classRoom);
		input.add(classRoomPanel);

		JPanel dayPanel = new JPanel(new FlowLayout());
		day = new JTextField(30);
		day.setEditable(true);
		dayPanel.add(new JLabel("Day"));
		dayPanel.add(day);
		input.add(dayPanel);

		JPanel startTimePanel = new JPanel(new FlowLayout());
		startTime = new JTextField(30);
		startTime.setEditable(true);
		startTimePanel.add(new JLabel("Start time"));
		startTimePanel.add(startTime);
		input.add(startTimePanel);

		JPanel endTimePanel = new JPanel(new FlowLayout());
		endTime = new JTextField(30);
		endTime.setEditable(true);
		endTimePanel.add(new JLabel("Start time"));
		endTimePanel.add(endTime);
		input.add(endTimePanel);

		JPanel inputButton = new JPanel(new FlowLayout());
		JButton addButton = new JButton("Add");
		addButton.addActionListener(this);
		inputButton.add(addButton);
		input.add(inputButton);

		add(input, ttmgbc[1]);
	}

	public void actionPerformed(ActionEvent e) {
		String ct;
		String cr;
		String sday;
		int st;
		int et;
		int i, j;

		if (e.getActionCommand().equals("Add")) {
			ct = courseTitle.getText();
			cr = classRoom.getText();
			sday = day.getText();
			st = Integer.parseInt(startTime.getText());
			et = Integer.parseInt(endTime.getText());

			TT1.setTimetable(new Course(ct, cr, sday, st, et));

			for (i = 0; i < 24; i++) {
				for (j = 0; j < 5; j++) {
					course[i][j].setText("" + TT1.table[i][j]);
					guitt.add(course[i][j]);
				}
			}

			TT1.printTimetable();
		}
		
		else if(!(e.getActionCommand().equals(" "))){
			JFrame window = new JFrame("Aaa");
			window.setSize(200, 200);
			window.setVisible(true);
			
		}
	}
}
