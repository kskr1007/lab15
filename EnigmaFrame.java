import java.awt.BorderLayout;
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
    private JComboBox<Integer> out;
    private JTextArea input = new JTextArea(5,20);
    private JTextArea output = new JTextArea(5,20);
    private JButton encrypt = new JButton("encrypt");
    private JButton decrypt = new JButton("decrypt");
    private final Integer[] units ={1,2,3};
    
    public EnigmaFrame() {
        super();
        initial = new JTextField(" ", 10);
        inner = new JComboBox<Integer>(units);
        out   = new JComboBox<Integer>(units);
        middle   = new JComboBox<Integer>(units);
        JPanel dpanel = new JPanel(new FlowLayout());
        JFrame frame = new JFrame();

        dpanel.add(new JLabel("inner"));
        dpanel.add(inner);
        dpanel.add(new JLabel("middle"));
        dpanel.add(middle);
        dpanel.add(new JLabel("out"));
        dpanel.add(out);
        dpanel.add(new JLabel("Initial Positions"));
        dpanel.add(initial);
        dpanel.add(encrypt);
        dpanel.add(decrypt);
        dpanel.add(new JLabel("input"));
        dpanel.add(input);
        dpanel.add(new JLabel("output"));
        dpanel.add(output);
        this.add(dpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.add(dpanel, BorderLayout.CENTER);
        setUp();
    }
    public void setUp(){
        ActionListener listen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int innerVal = (int) inner.getSelectedItem();
                int middleVal = (int) middle.getSelectedItem();
                int outerVal = (int) out.getSelectedItem();
                String initialString = initial.getText();
                Enigma enigma = new Enigma(innerVal, middleVal, outerVal, initialString);
                String encrypted = enigma.encrypt(input.getText());
                output.setText(encrypted);
            }
        };
        encrypt.addActionListener(listen);
    }
    
    
}
