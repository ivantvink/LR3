package ui;

import logic.PasswordGenerator;
import utils.ClipboardUtils;

import javax.swing.*;
import java.awt.*;

public class PasswordGeneratorUI {

    private JTextField passwordField;
    private JSlider lengthSlider;
    private JCheckBox includeNumbers;
    private JCheckBox includeUppercase;
    private JCheckBox includeSymbols;
    private JButton generateButton;

    public void createAndShowGUI() {
        // Создание основного окна (фрейма)
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Поле для вывода сгенерированного пароля
        passwordField = new JTextField();
        passwordField.setEditable(false); // Запрещаем редактирование
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        frame.add(passwordField, constraints);

        // Ползунок для выбора длины пароля
        JLabel lengthLabel = new JLabel("Password Length:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        frame.add(lengthLabel, constraints);

        lengthSlider = new JSlider(4, 20, 8);
        lengthSlider.setMajorTickSpacing(4);
        lengthSlider.setMinorTickSpacing(1);
        lengthSlider.setPaintTicks(true);
        lengthSlider.setPaintLabels(true);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        frame.add(lengthSlider, constraints);

        // Чекбоксы для опций генерации пароля
        includeNumbers = new JCheckBox("Include Numbers");
        includeNumbers.setSelected(true);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        frame.add(includeNumbers, constraints);

        includeUppercase = new JCheckBox("Include Uppercase Letters");
        includeUppercase.setSelected(true);
        constraints.gridx = 1;
        constraints.gridy = 2;
        frame.add(includeUppercase, constraints);

        includeSymbols = new JCheckBox("Include Symbols");
        includeSymbols.setSelected(false);
        constraints.gridx = 2;
        constraints.gridy = 2;
        frame.add(includeSymbols, constraints);

        // Кнопка генерации пароля
        generateButton = new JButton("Generate Password");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        frame.add(generateButton, constraints);

        // Обработка события нажатия на кнопку генерации пароля
        generateButton.addActionListener(e -> generatePassword());

        // Отображение окна
        frame.setVisible(true);
    }
    private void generatePassword() {
        int length = lengthSlider.getValue();
        boolean useNumbers = includeNumbers.isSelected();
        boolean useUppercase = includeUppercase.isSelected();
        boolean useSymbols = includeSymbols.isSelected();

        try {
            String password = PasswordGenerator.generate(length, useNumbers, useUppercase, useSymbols);
            passwordField.setText(password);
            ClipboardUtils.copyToClipboard(password);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Generation Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
