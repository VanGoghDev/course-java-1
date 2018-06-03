package firsov.Kirill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class MyWindow extends JFrame {

    public Human person;

    private String[] tabsName = {
            "Main Information", "Training program"
    };
    private JTabbedPane tabs = new JTabbedPane();

    private ButtonGroup g = new ButtonGroup();

    private int[] heightDescription = new int[61];
    private int[] weightDescription = new int[171];

    private JLabel genderLabel = new JLabel("Choose your gender:");
    private JRadioButton maleRadioButton = new JRadioButton("Male", false);
    private JRadioButton femaleRadioButton = new JRadioButton("Female", false);

    private JLabel welcomeLabel = new JLabel("Welcome to InShape v 0.0.1 !");

    private JLabel nameLabel = new JLabel("Type you name:");
    private JTextField textField = new JTextField(30);

    private JLabel ageLabel = new JLabel("Enter your age:");
    private JTextField ageTextField = new JTextField(30);

    private JLabel parametersLabel = new JLabel("Select your parameters");
    private JLabel heightLabel = new JLabel("Height, sm:");
    private JLabel weightLabel = new JLabel("Weight, kg:");
    private JComboBox comboHeight = new JComboBox();
    private JComboBox comboWeight = new JComboBox();

    private JButton confirmButton = new JButton("Confirm");
    private JTextField answerTextField = new JTextField();

    private JComboBox activityLevel = new JComboBox();
    private JComboBox goalsComboBox = new JComboBox();
    private JButton countCalories = new JButton("Count calories");
    private JTextField printBMR = new JTextField();
    private JTextField proteinsField = new JTextField();
    private JTextField fatsField = new JTextField();
    private JTextField carbsField = new JTextField();

    private ActionListener counCaloriesActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String activity;
            String goal;
            int flagActivity;
            int flagGoal;

            printBMR.setEditable(false);

            CountMed countPerson = new CountMed(person);

            activity =(String) activityLevel.getSelectedItem();
            goal = (String) goalsComboBox.getSelectedItem();
            switch (activity) {
                case "Non active":
                    flagActivity = 1;
                    break;
                case "Little bit":
                    flagActivity = 2;
                    break;
                case "Active":
                    flagActivity = 3;
                    break;
                case "Very active":
                    flagActivity = 4;
                    break;
                    default:
                        flagActivity = 1;
            }
            switch (goal) {
                case "Loosing Weight":
                    flagGoal = 1;
                    break;
                case "Slowly loose of weight":
                    flagGoal = 2;
                    break;
                case "Keep your weight":
                    flagGoal = 3;
                    break;
                case "Getting weight slowly":
                    flagGoal = 4;
                    break;
                case "Getting weight":
                    flagGoal = 5;
                    break;
                    default:
                        flagGoal = 1;
            }
            countPerson.countBMR(flagActivity, flagGoal);
            printBMR.setText("You should take in " + countPerson.bmr + " calories");
        }
    };

    private ActionListener confirmActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name;
            char gender = 'M';
            int age;
            int height;
            int weight;

            textField.setEditable(false);
            ageTextField.setEditable(false);
            answerTextField.setEditable(false);

            name = textField.getText();
            age = Integer.parseInt(ageTextField.getText());

            //узнаем какой radiobutton выбран
            Enumeration<AbstractButton> allRadiobutton = g.getElements();
            while(allRadiobutton.hasMoreElements()){
                JRadioButton temp = (JRadioButton)allRadiobutton.nextElement();
                if(temp.isSelected()){
                    String tempGender = temp.getText();
                    gender = tempGender.charAt(0);
                }
            }

            height = (int) comboHeight.getSelectedItem();
            weight = (int) comboWeight.getSelectedItem();


            person = new Human(name, gender, age, weight, height);

            answerTextField.setText("Your bio mass index: " + person.bmi);
        }
    };

    MyWindow() {
        setTitle("InShape");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(600, 600, 520, 500);

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new GridLayout(16, 1));
        firstTab(jPanel1);

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayout(16, 1));
        secondTab(jPanel2);
/*
        int i = 0;
        for (String tabName: tabsName) {
            tabs.addTab(tabName, jPanel1);
        }*/

        tabs.add(tabsName[0], jPanel1);
        tabs.add(tabsName[1], jPanel2);
        add(tabs);

        //firstTab();
        setVisible(true);
    }

    private void firstTab(JPanel panel){
        confirmButton.addActionListener(confirmActionListener);

        add(tabs);
        panel.add(welcomeLabel);
        panel.add(nameLabel);
        panel.add(textField);
        panel.add(ageLabel);
        panel.add(ageTextField);
        panel.add(genderLabel);
        g.add(maleRadioButton); g.add(femaleRadioButton);
        panel.add(maleRadioButton);
        panel.add(femaleRadioButton);
        panel.add(parametersLabel);
        panel.add(heightLabel);
        panel.add(comboHeight);
        panel.add(weightLabel);
        panel.add(comboWeight);
        panel.add(confirmButton);
        panel.add(answerTextField);
        setComboBoxValues();
    }

    private void secondTab(JPanel panel){
        countCalories.addActionListener(counCaloriesActionListener);
        JLabel label1 = new JLabel("Select your activity level:");
        JLabel label2 = new JLabel("What is your goal?");
        String[] activityLevels = {
          "Non active", "Little bit", "Active", "Very Active"
        };
        String[] goals = {
          "Loosing weight", "Slowly loose of weight", "Keep your weight", "Getting weight slowly", "Getting weight"
        };
        for (int i = 0; i < 4; i++) {
            activityLevel.addItem(activityLevels[i]);
        }

        for (int i = 0; i < 5; i++) {
            goalsComboBox.addItem(goals[i]);
        }
        panel.add(label1);
        panel.add(activityLevel);
        panel.add(label2);
        panel.add(goalsComboBox);
        panel.add(countCalories);
        panel.add(printBMR);
    }

    private void setComboBoxValues(){
        for (int i = 0; i <= 60; i++) {
            heightDescription[i] = i + 150;
        }

        for (int i = 30; i <= 170; i++) {
            weightDescription[i] = i + 30;
        }

        for (int i = 0; i <= 60 ; i++) {
            comboHeight.addItem(heightDescription[i]);
        }

        for (int i = 30; i <= 170 ; i++) {
            comboWeight.addItem(weightDescription[i]);
        }
    }
}