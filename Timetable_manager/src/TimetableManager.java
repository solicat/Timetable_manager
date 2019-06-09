
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class TimetableManager extends JFrame {

	public static final int WIDTH = 1100;
	public static final int HEIGHT = 1000;

	private Font timetableFont = new Font("Arial", Font.BOLD, 10);

	private Timetable TT = new Timetable(); //Initialize Timetable.table

	public static JButton[][] course = new JButton[24][5];

	public static boolean saveState = true;

	public static JPanel timetable = new JPanel(new GridLayout(24, 5));

	public static void main(String[] args) {
		TimetableManager newTimetable = new TimetableManager();
		newTimetable.setVisible(true);
	}

	public TimetableManager() {
		int i, j;

		setTitle("Timetable Manager");
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Timetable panel
		JPanel mainpanel = new JPanel(new GridBagLayout());
		GridBagConstraints[] mpConstraints = new GridBagConstraints[6];
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 3; j++) {
				mpConstraints[i * 3 + j] = new GridBagConstraints();
				mpConstraints[i * 3 + j].gridx = j;
				mpConstraints[i * 3 + j].gridy = i;
			}
		}

		mpConstraints[0].weightx = 1;
		mpConstraints[0].weighty = 1;
		mpConstraints[0].fill = GridBagConstraints.BOTH;
		mpConstraints[1].weightx = 8;
		mpConstraints[1].weighty = 1;
		mpConstraints[1].fill = GridBagConstraints.BOTH;
		mpConstraints[2].weightx = 1;
		mpConstraints[2].weighty = 1;
		mpConstraints[2].fill = GridBagConstraints.BOTH;
		mpConstraints[3].weightx = 1;
		mpConstraints[3].weighty = 19;
		mpConstraints[3].fill = GridBagConstraints.BOTH;
		mpConstraints[4].weightx = 8;
		mpConstraints[4].weighty = 19;
		mpConstraints[4].fill = GridBagConstraints.BOTH;
		mpConstraints[5].weightx = 1;
		mpConstraints[5].weighty = 19;
		mpConstraints[5].fill = GridBagConstraints.BOTH;

		for (i = 0; i < 24; i++) {
			for (j = 0; j < 5; j++) {
				course[i][j] = new JButton("" + Timetable.table[i][j]);
				course[i][j].addActionListener(new CourseDetail(i, j));
				course[i][j].setFont(timetableFont);
				course[i][j].setBackground(SetColor.defaultColor);
				timetable.add(course[i][j]);
			}
		}

		JPanel DAY = new JPanel(new GridLayout(1, 5));

		JLabel Mon = new JLabel("Mon");
		JLabel Tue = new JLabel("Tue");
		JLabel Wed = new JLabel("Wed");
		JLabel Thu = new JLabel("Thu");
		JLabel Fri = new JLabel("Fri");
		Mon.setHorizontalAlignment(JLabel.CENTER);
		Tue.setHorizontalAlignment(JLabel.CENTER);
		Wed.setHorizontalAlignment(JLabel.CENTER);
		Thu.setHorizontalAlignment(JLabel.CENTER);
		Fri.setHorizontalAlignment(JLabel.CENTER);
		DAY.add(Mon);
		DAY.add(Tue);
		DAY.add(Wed);
		DAY.add(Thu);
		DAY.add(Fri);

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

		mainpanel.add(new JLabel(), mpConstraints[0]);
		mainpanel.add(DAY, mpConstraints[1]);
		mainpanel.add(new JLabel(), mpConstraints[2]);

		mainpanel.add(time, mpConstraints[3]);
		mainpanel.add(timetable, mpConstraints[4]);
		mainpanel.add(realTime, mpConstraints[5]);

		add(mainpanel, BorderLayout.CENTER);

		// Menu bar
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem New = new JMenuItem("New", KeyEvent.VK_N);
		New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		New.addActionListener(new File());
		file.add(New);

		JMenuItem Open = new JMenuItem("Open", KeyEvent.VK_O);
		Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		Open.addActionListener(new File());
		file.add(Open);

		JMenuItem Save = new JMenuItem("Save", KeyEvent.VK_S);
		Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		Save.addActionListener(new File());
		file.add(Save);

		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem addCourse = new JMenuItem("Add Course", KeyEvent.VK_D);
		addCourse.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		addCourse.addActionListener(new AddCourse());
		edit.add(addCourse);

		JMenuBar bar = new JMenuBar();
		bar.add(file);
		bar.add(edit);
		setJMenuBar(bar);
	}

}
