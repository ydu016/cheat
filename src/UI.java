import javax.swing.*;  
  
public class UI{

	JFrame frame;
	JLabel label;
	JPanel panel;
	
	UI(){
		this.frame = new JFrame();
		this.label = new JLabel("akb48");
		this.panel = new JPanel();
		panel.add(label);
		panel.setLayout(null);
		label.setBounds(125,75,100,20);
		frame.getContentPane().add(panel);  
        frame.setSize(500,500);  
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    public static void main(String args[]){  
    	UI ui = new UI();
    }  
}  