import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConverterApp {
    private final JFrame frame = new JFrame("Temperature Converter");
    private final int width = 800;
    private final int height = 800;
    private double currentTemp;

    private void createFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void createMainPage(){
        JPanel buttonsPanel = new JPanel();
        //buttonsPanel.setLayout(null);
        JLabel greeting = new JLabel("<html>Hello! You can use this service to convert temperatures " +
                "from Celsius to another scales and back.<br/> Press buttons and begin!</html>");
        greeting.setFont(new Font("Times New Roman", Font.BOLD, 18));
        buttonsPanel.add(greeting);
        Button buttonToCelsius = new Button("To Celsius Mode");
        Button buttonFromCelsius = new Button("From Celsius Mode");
        Button buttonExit = new Button("Exit");

        buttonFromCelsius.setBackground(Color.cyan);
        buttonFromCelsius.setFont(new Font("Times New Roman", Font.BOLD, 20));
        buttonFromCelsius.setForeground(Color.red);
        buttonsPanel.add(buttonFromCelsius);

        buttonToCelsius.setBackground(Color.cyan);
        buttonToCelsius.setFont(new Font("Times New Roman", Font.BOLD, 20));
        buttonToCelsius.setForeground(Color.red);
        buttonsPanel.add(buttonToCelsius);
        buttonExit.setBackground(Color.cyan);
        buttonExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
        buttonExit.setForeground(Color.red);
        buttonsPanel.add(buttonExit);

        ImageIcon pic1 = new ImageIcon("src/pic1.jpg");
        buttonsPanel.add(new JLabel(pic1));



        frame.getContentPane().add(buttonsPanel);

        buttonToCelsius.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createToCelsiusModeFrame();
            }
        });

        buttonFromCelsius.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFromCelsiusModeFrame();
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });


    }



    private void createFromCelsiusModeFrame(){
        JFrame fromCelsiusModeFrame = new JFrame("Temperature Converter. From Celsius");
        fromCelsiusModeFrame.setPreferredSize(new Dimension(width, height));
        fromCelsiusModeFrame.setLocationRelativeTo(null);
        fromCelsiusModeFrame.setResizable(false);
        fromCelsiusModeFrame.pack();
        fromCelsiusModeFrame.setVisible(true);

        JPanel toCelsiusModePanel = new JPanel();
        //toCelsiusModePanel.setLayout(new BoxLayout(toCelsiusModePanel, BoxLayout.Y_AXIS));

        int fieldSize = 65;

        JLabel annotationEnter = new JLabel("Enter temperature in Celsius degrees below: ");
        TextField tempField = new TextField(fieldSize);
        JLabel annotationSelect = new JLabel("Select temperature scale: ");
        ButtonGroup bg = new ButtonGroup();
        JRadioButton farenheitBtn = new JRadioButton("Farenheit");
        JRadioButton kelvinBtn = new JRadioButton("Kelvin");
        JRadioButton reaumurBtn = new JRadioButton("Reaumur");
        JRadioButton romerBtn = new JRadioButton("Romer");
        JRadioButton delisleBtn = new JRadioButton("Delisle");
        bg.add(farenheitBtn);
        bg.add(kelvinBtn);
        bg.add(reaumurBtn);
        bg.add(romerBtn);
        bg.add(delisleBtn);
        toCelsiusModePanel.add(annotationEnter);
        toCelsiusModePanel.add(tempField);
        toCelsiusModePanel.add(annotationSelect);
        toCelsiusModePanel.add(farenheitBtn);
        toCelsiusModePanel.add(kelvinBtn);
        toCelsiusModePanel.add(reaumurBtn);
        toCelsiusModePanel.add(romerBtn);
        toCelsiusModePanel.add(delisleBtn);


        JLabel annotationResult = new JLabel("                      See the result in selected scale: ");
        TextField resultField = new TextField(fieldSize);
        resultField.setEditable(false);
        toCelsiusModePanel.add(annotationResult);
        toCelsiusModePanel.add(resultField);

        farenheitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTemp = Integer.parseInt(tempField.getText());
                resultField.setText(String.valueOf(FarenheitConverter.convert(currentTemp)));
            }
        });

        kelvinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTemp = Integer.parseInt(tempField.getText());
                resultField.setText(String.valueOf(KelvinConverter.convert(currentTemp)));
            }
        });

        reaumurBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTemp = Integer.parseInt(tempField.getText());
                resultField.setText(String.valueOf(ReaumurConverter.convert(currentTemp)));
            }
        });

        romerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTemp = Integer.parseInt(tempField.getText());
                resultField.setText(String.valueOf(RomerConverter.convert(currentTemp)));
            }
        });

        delisleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTemp = Integer.parseInt(tempField.getText());
                resultField.setText(String.valueOf(DelisleConverter.convert(currentTemp)));
            }
        });

        toCelsiusModePanel.setVisible(true);


        Button exitBtn = new Button("Exit");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fromCelsiusModeFrame.setVisible(false);
                fromCelsiusModeFrame.dispose();
            }
        });
        toCelsiusModePanel.add(exitBtn);

        ImageIcon pic2 = new ImageIcon("src/pic2.jpg");
        toCelsiusModePanel.add(new JLabel(pic2));

        fromCelsiusModeFrame.getContentPane().add(toCelsiusModePanel);

    }

    private void createToCelsiusModeFrame(){
        JFrame toCelsiusModeFrame = new JFrame("Temperature Converter. To Celsius");
        toCelsiusModeFrame.setPreferredSize(new Dimension(width, height));
        toCelsiusModeFrame.setLocationRelativeTo(null);
        toCelsiusModeFrame.setResizable(false);
        toCelsiusModeFrame.pack();
        toCelsiusModeFrame.setVisible(true);

        JPanel toCelsiusModePanel = new JPanel();
        //toCelsiusModePanel.setLayout(new BoxLayout(toCelsiusModePanel, BoxLayout.Y_AXIS));

        int fieldSize = 65;

        ButtonGroup bg = new ButtonGroup();
        JRadioButton farenheitBtn = new JRadioButton("Farenheit");
        JRadioButton kelvinBtn = new JRadioButton("Kelvin");
        JRadioButton reaumurBtn = new JRadioButton("Reaumur");
        JRadioButton romerBtn = new JRadioButton("Romer");
        JRadioButton delisleBtn = new JRadioButton("Delisle");
        bg.add(farenheitBtn);
        bg.add(kelvinBtn);
        bg.add(reaumurBtn);
        bg.add(romerBtn);
        bg.add(delisleBtn);
        JLabel annotationEnter = new JLabel("Enter temperature in some scale that you will select below: ");
        toCelsiusModePanel.add(annotationEnter);
        TextField tempField = new TextField(fieldSize);
        toCelsiusModePanel.add(tempField);
        JLabel annotationSelect = new JLabel("Select temperature scale: ");
        toCelsiusModePanel.add(annotationSelect);
        toCelsiusModePanel.add(farenheitBtn);
        toCelsiusModePanel.add(kelvinBtn);
        toCelsiusModePanel.add(reaumurBtn);
        toCelsiusModePanel.add(romerBtn);
        toCelsiusModePanel.add(delisleBtn);


        JLabel annotationResult = new JLabel("                      See the result in Celsius scale: ");
        TextField resultField = new TextField(fieldSize);
        resultField.setEditable(false);
        toCelsiusModePanel.add(annotationResult);
        toCelsiusModePanel.add(resultField);

        farenheitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTemp = Integer.parseInt(tempField.getText());
                resultField.setText(String.valueOf(FarenheitConverter.convertToCelsius(currentTemp)));
            }
        });

        kelvinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTemp = Integer.parseInt(tempField.getText());
                resultField.setText(String.valueOf(KelvinConverter.convertToCelsius(currentTemp)));
            }
        });

        reaumurBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTemp = Integer.parseInt(tempField.getText());
                resultField.setText(String.valueOf(ReaumurConverter.convertToCelsius(currentTemp)));
            }
        });

        romerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTemp = Integer.parseInt(tempField.getText());
                resultField.setText(String.valueOf(RomerConverter.convertToCelsius(currentTemp)));
            }
        });

        delisleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTemp = Integer.parseInt(tempField.getText());
                resultField.setText(String.valueOf(DelisleConverter.convertToCelsius(currentTemp)));
            }
        });


        toCelsiusModePanel.setVisible(true);

        Button exitBtn = new Button("Exit");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toCelsiusModeFrame.setVisible(false);
                toCelsiusModeFrame.dispose();
            }
        });
        toCelsiusModePanel.add(exitBtn);

        ImageIcon pic3 = new ImageIcon("src/pic3.jpg");
        toCelsiusModePanel.add(new JLabel(pic3));

        toCelsiusModeFrame.getContentPane().add(toCelsiusModePanel);

    }

    private void exit(){
        frame.setVisible(false);
        frame.dispose();
    }



    public void work(){
        createFrame();
        createMainPage();
    }


}
