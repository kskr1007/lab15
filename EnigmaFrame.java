import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EnigmaFrame extends JFrame {
    //text field for initial string
    private JTextField initial;
    //dropdowns for rotors
    private JComboBox<Integer> inner;
    private JComboBox<Integer> middle;
    private JComboBox<Integer> outer;
    //text area for input
    private JTextArea input = new JTextArea(1,50);
    //text area for output
    private JTextArea output = new JTextArea(1,50);
    //encrypt button
    private JButton encrypt = new JButton("encrypt");
    //decrypt button
    private JButton decrypt = new JButton("decrypt");
    //values for dropdowns
    private final Integer[] units ={1,2,3,4,5};
    
    public EnigmaFrame() {
        super();
        //making a field for initial positions
        initial = new JTextField("", 3);
        //making a selection for inner, middle, outer rotors
        inner = new JComboBox<>(units);
        outer = new JComboBox<>(units);
        middle = new JComboBox<>(units);
        
        //making a panel
        JPanel dpanel = new JPanel(new FlowLayout());
        //adding an inner label
        dpanel.add(new JLabel("inner"));
        //adding the inner dropdown
        dpanel.add(inner);
        //adding a middle label
        dpanel.add(new JLabel("middle"));
        //adding a middle dropdown
        dpanel.add(middle);
        //adding an outer label
        dpanel.add(new JLabel("outer"));
        //adding the outer dropdown
        dpanel.add(outer);
        //adding an initial position label
        dpanel.add(new JLabel("Initial Positions"));
        //adding initial position text field
        dpanel.add(initial);
        //adding encrypt button
        dpanel.add(encrypt);
        //adding decrypt button
        dpanel.add(decrypt);
    
        //making a new panel for input, because it needs to store large values
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(new JLabel("Input:"), BorderLayout.NORTH);
        inputPanel.add(input, BorderLayout.CENTER);
    
        //making a new panel for output, because it needs to store large values
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Output:"), BorderLayout.NORTH);
        outputPanel.add(output, BorderLayout.CENTER);
    
        //combining input and output panels into a stack of panels
        JPanel inputOutputStacked = new JPanel();
        inputOutputStacked.setLayout(new GridLayout(2, 1));
        inputOutputStacked.add(inputPanel);
        inputOutputStacked.add(outputPanel);
        
        //adding the original panel and the new input.output panel
        this.add(dpanel, BorderLayout.NORTH);
        this.add(inputOutputStacked, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        //for encrypting
        setUpEncrypt();
        //for decrypting
        setUpDecrypt();
    }
    
    public void setUpEncrypt(){
        encrypt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //marking the chosen inner value
                int in = (int)inner.getSelectedItem();
                //marking the chosen middle value
                int mid = (int) middle.getSelectedItem();
                //marking the chosen outer value
                int out = (int) outer.getSelectedItem();
                //marking the chosen initial String
                String initialString = initial.getText();
                //marking the chosen input message
                String inputMessage = input.getText();
                //creating an enigma instance using the GUI choices
                Enigma enigma = new Enigma(in, mid, out, initialString);
                //creating the encrypted message
                String finalMessage = enigma.encrypt(inputMessage);
                //setting the value of output to be the encrypted message
                output.setText(finalMessage);
            }
        });
    }

    public void setUpDecrypt(){
        decrypt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //marking the chosen inner value
                int in = (int)inner.getSelectedItem();
                //marking the chosen middle value
                int mid = (int) middle.getSelectedItem();
                //marking the chosen outer value
                int out = (int) outer.getSelectedItem();
                //marking the chosen initial String
                String initialString = initial.getText();
                //marking the chosen input message
                String inputMessage = input.getText();
                //creating an enigma instance using the GUI choices
                Enigma enigma = new Enigma(in, mid, out, initialString);
                //creating the decrypted message
                String finalMessage = enigma.decrypt(inputMessage);
                //setting the value of output to be the encrypted message
                output.setText(finalMessage);
            }
        });
    }
    
    
    
}
