package Afvinkopdracht8;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Analyse extends Afvink8 {

    private static JFileChooser fileChooser;

    public static void readFile(){
        try {
            inFile = new BufferedReader(new FileReader(textfield1.getText()));
            textarea1.setText("");
            String line;
            while ((line = inFile.readLine()) != null) {
                textarea1.append(line + "");
            }
            System.out.println(inFile);
            inFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Afvink8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Afvink8.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public String bladeren (String blader) throws NotAminozuur{
        File selectedFile;
        int reply;
        fileChooser = new JFileChooser();
        reply = fileChooser.showOpenDialog(this);

        if (reply == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            textfield1.setText(selectedFile.getAbsolutePath());
            readFile();
        }
    return blader;}

    public String analyse(String symbol) throws NotAminozuur{

        int maxLengte = textarea1.getText().length();
        Graphics paper1 = panel.getGraphics();
        Graphics paper2 = panel.getGraphics();
        Graphics paper3 = panel.getGraphics();

        int charCounter = 0;
        String[] arr = symbol.split("");
        for (String inputsplit : arr) {
            String isamino = "";
            for (int i = 0; i < ONE.length; i++) {
                if (ONE[i].equalsIgnoreCase(inputsplit)) {
                    if (hydrofooblijst[i].equalsIgnoreCase("Hydrofoob")) {
                        isamino = "hydrofoob";
                        paper1.setColor(Color.RED);
                        paper1.fillRect(400 / maxLengte * charCounter, 0, 400 / maxLengte, 20);
                    } else if (hydrofooblijst[i].equalsIgnoreCase("Hydrofiel")) {
                        isamino = "hydrofiel";
                        paper1.setColor(Color.BLUE);
                        paper1.fillRect(400 / maxLengte * charCounter, 0, 400 / maxLengte, 20);
                    }
                }
            }
            charCounter+=1;
            if (isamino.equals("")) {
                try {
                    throw new NotAminozuur("Dit is geen valide aminozuur: "+inputsplit);
                } catch (NotAminozuur notAminozuur) {
                    notAminozuur.printStackTrace();
                }
                System.exit(0);
            }
        }

            paper2.setColor(Color.RED);
            paper2.fillRect(0,25,40,20);
            paper2.drawString("Hydrofoob",40,40);
            paper3.setColor(Color.BLUE);
            paper3.fillRect(0,60,40,20);
            paper3.drawString("Hydrofiel",40,75);


    return symbol;}
}
class NotAminozuur extends Exception{
    public NotAminozuur(){
        super();

    }
    public NotAminozuur(String Error){
        super(Error);
    }
}

