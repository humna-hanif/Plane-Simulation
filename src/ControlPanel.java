import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ControlPanel extends JPanel {
	private Plane plane1, plane2;
	private MovingPlane plane;
	private MovementHolder holder;

	public ControlPanel(MovementHolder holder, Plane plane1, Plane plane2, MovingPlane plane) {
		this.holder = holder;

		this.plane = plane;

		ButtonGroup bg = new ButtonGroup();

		JToggleButton btn1 = new JToggleButton("Do Nothing");
		JToggleButton btn2 = new JToggleButton("Follow Leader");
		JToggleButton btn3 = new JToggleButton("Move Randomly");

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				holder.setBtnClicked(1);
			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				holder.setBtnClicked(2);
			}

		});

		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				holder.setBtnClicked(3);
			}
		});

		bg.add(btn1);
		bg.add(btn2);
		bg.add(btn3);
		btn1.setSelected(true);

		btn1.setSize(45, 30);
		btn2.setSize(45, 30);
		btn3.setSize(45, 30);

		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
	}
}
