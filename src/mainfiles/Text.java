package mainfiles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Text extends JComponent{
	
	public String text;
	int x, y;
	
	// text object constructor
	public Text(String text, int x, int y) {
		this.text = text;
		this.x = x;
		this.y = y;
	}
	
	public void paintComponent(Graphics graphics) {
		Graphics2D g2D = (Graphics2D)graphics;
		
		g2D.setFont(new Font("Montserrat", Font.BOLD, 15));
		g2D.setColor(new Color(255, 255, 255));
		g2D.drawString(this.text, x, y);
	}
}
