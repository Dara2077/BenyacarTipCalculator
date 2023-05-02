import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainGUIWindow extends JFrame implements ActionListener, KeyListener {
    private JPanel panel1;
    private JTextField JTextFieldBill;
    private JTextField JTextFieldTip;
    private JTextField JTextFieldNumPeople;
    private JButton JButtonIncreaseTip;
    private JButton JButtonIncreaseNumPeople;
    private JButton JButtonDecreaseTip;
    private JButton JButtonDecreaseNumPeople;
    private JTextField JTextFieldFinalTip;
    private JTextField JTextFieldFinalTotal;
    private JLabel JLabelBill;
    private JLabel JLabelTip;
    private JLabel JLabelNumPeople;
    private JLabel JLabelFinalTip;
    private JLabel JLabelFinalTotal;

    public MainGUIWindow(){
        createUIComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source instanceof JButton){
            JButton button = (JButton) source;
            String text = button.getText().substring(0, (button.getText().length() - 1));
            String name = button.getName();
            if (name.equals("JButtonIncreaseTip") || name.equals("JButtonDecreaseTip")){
                if (text.equals("+")){
                    JTextFieldTip.setText(Double.parseDouble(text) + 5 + "");
                }
                else{
                    JTextFieldTip.setText(Double.parseDouble(text) - 5 + "");
                }
            }
            else{
                if (!JTextFieldNumPeople.equals("1")){
                    if (text.equals("+")){
                        JTextFieldNumPeople.setText(Double.parseDouble(text) + 1 + "");
                    }
                    else{
                        JTextFieldNumPeople.setText(Double.parseDouble(text) - 1 + "");
                    }
                }
            }

        }
    };

    @Override
    public void keyTyped(KeyEvent e){};

    @Override
    public void keyPressed(KeyEvent e){};

    @Override
    public void keyReleased(KeyEvent e){};

    private void createUIComponents(){
        setContentPane(panel1);
        setTitle("My GUI!");
        setSize(600, 400);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        JButtonDecreaseNumPeople.addActionListener(this);
        JButtonIncreaseNumPeople.addActionListener(this);
        JButtonDecreaseTip.addActionListener(this);
        JButtonIncreaseTip.addActionListener(this);
    }


    public void updateValues(){
        double bill = Double.parseDouble(JTextFieldBill.getText());
        String tipString = JTextFieldTip.getText();
        double tipValue = (Double.parseDouble(tipString.substring(0, tipString.length() - 1)))/100;
        double numPeople = Double.parseDouble(JTextFieldNumPeople.getText());
        double tip = (bill * tipValue)/numPeople;
        double total = (bill/numPeople) + tip;
        JTextFieldFinalTip.setText(tip + "");
        JTextFieldFinalTotal.setText(total + "");
    }
}
