import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FirstGUI extends JFrame implements ActionListener {
    JButton button1;
    JButton button2;
    JButton button3;
    JButton closeButton;
    JLabel label;
    JRadioButton radio1;
    JCheckBox checkBox;

    FirstGUI() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);

        button1 = new JButton("Click me 1");
        add(button1);

        button2 = new JButton("Click me 2");
        add(button2);

        button3 = new JButton("Click me 3");
        add(button3);

        closeButton = new JButton("Close");
        add(closeButton);

        radio1 = new JRadioButton("Select me");
        add(radio1);

        checkBox = new JCheckBox("I agree");
        add(checkBox);

        label = new JLabel("Button was not clicked yet!");
        add(label);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        closeButton.addActionListener(this);
        radio1.addActionListener(this);
        checkBox.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            label.setText("Button 1 was clicked");
        }
        if (e.getSource() == button2) {
            label.setText("Button 2 was clicked");
        }
        if (e.getSource() == button3) {
            label.setText("Button 3 was clicked");
        }
        if (e.getSource() == closeButton) {
            System.exit(0);
        }
        if (e.getSource() == radio1) {
            if (radio1.isSelected()) {
                label.setText("Radio button selected");
            } else {
                label.setText("Radio button deselected");
            }
        }
        if (e.getSource() == checkBox) {
            if (checkBox.isSelected()) {
                label.setText("Checkbox is checked");
            } else {
                label.setText("Checkbox is unchecked");
            }
        }
    }

    public static void main(String args[]) {
        new FirstGUI();
    }
}
