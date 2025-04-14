import java.awt.FlowLayout;
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
    private JTextField initial;
    private JComboBox<Integer> inner;
    private JComboBox<Integer> middle;
    private JComboBox<Integer> outer;
    private JTextArea input = new JTextArea(30,30);
    private JTextArea output = new JTextArea(30,30);
    private JButton encrypt = new JButton("encrypt");
    private JButton decrypt = new JButton("decrypt");
    private final Integer[] units ={1,2,3};
    
    public EnigmaFrame() {
        super();
        initial = new JTextField("", 3);
        inner = new JComboBox<Integer>(units);
        outer = new JComboBox<Integer>(units);
        middle = new JComboBox<Integer>(units);
        JPanel dpanel = new JPanel(new FlowLayout());
        dpanel.add(new JLabel("inner"));
        dpanel.add(inner);
        dpanel.add(new JLabel("middle"));
        dpanel.add(middle);
        dpanel.add(new JLabel("out"));
        dpanel.add(outer);
        dpanel.add(new JLabel("Initial Positions"));
        dpanel.add(initial);
        dpanel.add(encrypt);
        encrypt.setEnabled(true);
        encrypt.setVisible(true);
        dpanel.add(decrypt);
        decrypt.setEnabled(true);
        decrypt.setVisible(true);
        dpanel.add(new JLabel("input"));
        dpanel.add(input);
        dpanel.add(new JLabel("output"));
        dpanel.add(output);
        this.add(dpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        setUpEncrypt();
        setUpDecrypt();
    }
    
    public void setUpEncrypt() {
        encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int in = (int)inner.getSelectedItem();
                int mid = (int) middle.getSelectedItem();
                int out = (int) outer.getSelectedItem();
                String initialString = initial.getText();
                String inputMessage = input.getText();
                Enigma enigma = new Enigma(in, mid, out, initialString);
                String finalMessage = enigma.encrypt(inputMessage);
                output.setText(finalMessage);
            }
        });
    }

    public void setUpDecrypt() {
        decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int in = (int)inner.getSelectedItem();
                int mid = (int) middle.getSelectedItem();
                int out = (int) outer.getSelectedItem();
                String initialString = initial.getText();
                String inputMessage = input.getText();
                Enigma enigma = new Enigma(in, mid, out, initialString);
                String finalMessage = enigma.decrypt(inputMessage);
                output.setText(finalMessage);
            }
        });
    }
    
    
    
}
