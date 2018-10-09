package Calc.DESCRIPTION;

import Calc.LOGIC.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Oleg on 03.10.2018.
 */
public class Appearence {

    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton plus;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton minus;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton multiply;
    private JButton a0Button;
    private JButton divide;
    private JButton is;
    private JTextField a0TextField;
    private JPanel thePanel = new JPanel();
    private JPanel mainpanel = new JPanel();
    private JPanel screen  = new JPanel();
    private JButton dotButton;
    private JButton cButton;

    float result;

    public StringBuilder buff = new StringBuilder(a0TextField.getText());

    JFrame mainWindow = new JFrame("Calculator");

    public void createAppearence() {

        a1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    a0TextField.setText(buff.append("1").toString());                }
        });

        a2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText(buff.append("2").toString());                }
        });

        a3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText(buff.append("3").toString());                }
        });

        a4Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText(buff.append("4").toString());                }
        });

        a5Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText(buff.append("5").toString());                }
        });

        a6Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText(buff.append("6").toString());                }
        });

        a7Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText(buff.append("7").toString());                }
        });

        a8Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText(buff.append("8").toString());                }
        });

        a9Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText(buff.append("9").toString());                }
        });

        a0Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText(buff.append("0").toString());                }
        });

        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checking("+");
            }
        });

        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checking("-");
            }
        });

        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checking("*");
            }
        });

        divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checking("/");
            }
        });

        dotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText(buff.append(".").toString());
            }
        });

        is.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String equation = buff.toString();
                System.out.println(equation);
                action(equation);
                buff.setLength(0);
                buff.append(a0TextField.getText());
            }
        });

        cButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a0TextField.setText("0");
                result = 0;
                buff.delete(0,buff.length());
            }
        });


        thePanel.setLayout(new GridLayout(4,4));

        a0TextField = new JTextField(10);
        screen.add(a0TextField);
        screen.add(cButton);
        mainpanel.add(screen,BorderLayout.NORTH);
        thePanel.add(a1Button);
        thePanel.add(a2Button);
        thePanel.add(a3Button);
        thePanel.add(plus);
        thePanel.add(a4Button);
        thePanel.add(a5Button);
        thePanel.add(a6Button);
        thePanel.add(minus);
        thePanel.add(a7Button);
        thePanel.add(a8Button);
        thePanel.add(a9Button);
        thePanel.add(multiply);
        thePanel.add(a0Button);
        thePanel.add(dotButton);

        thePanel.add(is);
        thePanel.add(divide);

        mainpanel.add(thePanel, BorderLayout.SOUTH);
        mainWindow.add(mainpanel);

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //      mainWindow.setLayout(null);
        mainWindow.setSize(200,200);
    //   mainWindow.pack();
        mainWindow.setVisible(true);
    }

    private void checking(String sign) {
        action(buff.toString());
        buff.setLength(0);
        buff.append(a0TextField.getText());
        a0TextField.setText(buff.append(sign).toString());
    }


    private void action(String equation) {
        try {

            if (equation.contains("+")) {
                float numbs[] = splitting(equation, "\\+");
                result = Logic.addition(numbs[0], numbs[1]);
                a0TextField.setText(Float.toString(result));

            } else if (equation.contains("-")) {
                float numbs[] = splitting(equation, "\\-");
                result = Logic.extract(numbs[0], numbs[1]);
                a0TextField.setText(Float.toString(result));
            } else if (equation.contains("*")) {
                float numbs[] = splitting(equation, "\\*");
                result = Logic.multiply(numbs[0], numbs[1]);
                a0TextField.setText(Float.toString(result));
            } else if (equation.contains("/")) {
                float numbs[] = splitting(equation, "\\/");
                result = Logic.divide(numbs[0], numbs[1]);
                a0TextField.setText(Float.toString(result));
            } else {
                System.out.println("No action mentioned");
            }
        }catch (NumberFormatException ex){
            System.out.println("NumberFormatException");
            a0TextField.setText("err");
        }
    }

    public float[] splitting(String forSplitting, String splitter) throws NumberFormatException{
        String []arr = forSplitting.split(splitter);
        float [] num = new float[10];
        for(int i = 0; i<arr.length; i++ ){
            num[i] = Float.parseFloat(arr[i]);
        }
        return num;
    }
}
