/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.temperatureconverter;

/**
 *
 * @author MWENDE 
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {
    private JTextField inputField;
    private JButton fahrenheitToCelsiusButton;
    private JButton celsiusToFahrenheitButton;
    private JLabel resultLabel;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Labels to provide instructions
        JLabel instructionLabel = new JLabel("Enter temperature:");
        JLabel conversionLabel = new JLabel("Select conversion type:");
        
        //creating textfield, buttons and result label
        inputField = new JTextField(10);
        fahrenheitToCelsiusButton = new JButton("Fahrenheit to Celsius");
        celsiusToFahrenheitButton = new JButton("Celsius to Fahrenheit");
        resultLabel = new JLabel("Result: ");

        //adding components to the panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 5, 5)); //5 rows to accommodate the labels
        panel.add(instructionLabel);
        panel.add(inputField);
        panel.add(conversionLabel);
        panel.add(fahrenheitToCelsiusButton);
        panel.add(celsiusToFahrenheitButton);

        fahrenheitToCelsiusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertFahrenheitToCelsius();
            }
        });

        celsiusToFahrenheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCelsiusToFahrenheit();
            }
        });

        add(panel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        // Center the window on the screen
        setLocationRelativeTo(null);
    }

    //function to convert fahrenheit to celsius
    private void convertFahrenheitToCelsius() {
        try {
            double temperature = Double.parseDouble(inputField.getText());
            double celsius = (temperature - 32) * 5 / 9;
            resultLabel.setText("Result: " + celsius + " Celsius");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Invalid Input");
        }
    }

    //function to convert celsius to fahrenheit 
    private void convertCelsiusToFahrenheit() {
        try {
            double temperature = Double.parseDouble(inputField.getText());
            double fahrenheit = (temperature * 9 / 5) + 32;
            resultLabel.setText("Result: " + fahrenheit + " Fahrenheit");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Invalid Input");
        }
    }

    //main function
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverter().setVisible(true);
            }
        });
    }
}
