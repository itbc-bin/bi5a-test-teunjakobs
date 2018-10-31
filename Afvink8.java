package Afvinkopdracht8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Afvink8 extends JFrame implements ActionListener {
        private static JButton buttonanalyseer, buttonblader;
        protected static JTextArea textarea1;
        private static JLabel label, label1;
        protected static JPanel panel;
        protected static JTextField textfield1;
        static final String[] ONE = {"A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V"};
        static final String[] hydrofooblijst = {"Hydrofoob", "Hydrofiel", "Hydrofiel", "Hydrofiel", "Hydrofiel", "Hydrofiel", "Hydrofiel", "Hydrofiel", "Hydrofiel", "Hydrofoob", "Hydrofoob", "Hydrofiel", "Hydrofoob", "Hydrofoob", "Hydrofoob", "Hydrofiel", "Hydrofiel", "Hydrofoob", "Hydrofiel", "Hydrofoob"};
        protected static BufferedReader inFile;

        public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
            Afvink8 frame = new Afvink8();
            frame.setTitle("PRO-VIS");
            frame.setSize(600, 400);
            frame.createGUI();
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            frame.setVisible(true);
        }

        private void createGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            Container window = getContentPane();
            window.setLayout(new FlowLayout());

            label1 = new JLabel("bestand");
            window.add(label1);

            textfield1 = new JTextField(30);
            window.add(textfield1);

            buttonblader = new JButton("Blader");
            buttonblader.addActionListener(this);
            window.add(buttonblader);

            buttonanalyseer = new JButton("Analyseer");
            buttonanalyseer.addActionListener(this);
            window.add(buttonanalyseer);

            label = new JLabel("Sequentie");
            window.add(label);

            textarea1 = new JTextArea(10, 40);
            window.add(textarea1);

            panel = new JPanel();
            panel.setBackground(Color.DARK_GRAY);
            panel.setPreferredSize(new Dimension(470, 100));
            window.add(panel);
        }

        public void actionPerformed(ActionEvent event) {
            Analyse analyse = new Analyse();
            String input = textarea1.getText();
            try {
                if (event.getSource() == buttonanalyseer) {
                    analyse.analyse(input);
                }
            } catch (NotAminozuur notAminozuur) {
                notAminozuur.printStackTrace();
            }
            try {
                if (event.getSource() == buttonblader){
                    analyse.bladeren(input);
                }
            } catch (NotAminozuur notAminozuur){
                notAminozuur.printStackTrace();
            }
        }}
