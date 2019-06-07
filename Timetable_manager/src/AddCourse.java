
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCourse implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		AddCourseWindow t = new AddCourseWindow();
		t.setVisible(true);
	}
}
