package punit;

import java.awt.*;

import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {

    TextField number1, number2, result;
    Button addButton, subtractButton, multiplyButton, divideButton;

    public Calculator() {
        setTitle("Simple AWT Calculator");

        number1 = new TextField(10);
        number2 = new TextField(10);
        result = new TextField(10);
        result.setEditable(false);

        addButton = new Button("Add");
        subtractButton = new Button("Subtract");
        multiplyButton = new Button("Multiply");
        divideButton = new Button("Divide");

        setLayout(new FlowLayout());

        add(new Label("Number 1:"));
        add(number1);

        add(new Label("Number 2:"));
        add(number2);

        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        add(new Label("Result:"));
        add(result);

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        setSize(400, 200);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(number1.getText());
            double num2 = Double.parseDouble(number2.getText());
            double output;

            if (e.getSource() == addButton) {
                output = num1 + num2;
                result.setText(String.valueOf(output));
            } else if (e.getSource() == subtractButton) {
                output = num1 - num2;
                result.setText(String.valueOf(output));
            } else if (e.getSource() == multiplyButton) {
                output = num1 * num2;
                result.setText(String.valueOf(output));
            } else if (e.getSource() == divideButton) {
                if (num2 != 0) {
                    output = num1 / num2;
                    result.setText(String.valueOf(output));
                } else {
                    result.setText("Cannot Divide by 0");
                }
            }
        } catch (NumberFormatException ex) {
            result.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
