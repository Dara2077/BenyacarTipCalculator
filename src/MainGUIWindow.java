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
            String text = JTextFieldTip.getText().substring(0, (JTextFieldTip.getText().length() - 1));
            if (button.equals(JButtonIncreaseTip) || button.equals(JButtonDecreaseTip)){
                if (button.getText().equals("+")){
                    JTextFieldTip.setText((int)(Double.parseDouble(text) + 5.0) + "%");
                }
                else{
                    if (Double.parseDouble(text) - 5.0 < 0){
                        JTextFieldTip.setText(0 + "%");
                    }
                    else{
                        JTextFieldTip.setText((int)(Double.parseDouble(text) - 5.0) + "%");
                    }
                }
            }
            else{
                    if (button.getText().equals("+")){
                        JTextFieldNumPeople.setText((int)Double.parseDouble(JTextFieldNumPeople.getText()) + 1 + "");
                    }
                    else{
                        if (!(JTextFieldNumPeople.getText()).equals("1")){
                        JTextFieldNumPeople.setText((int)Double.parseDouble(JTextFieldNumPeople.getText()) - 1 + "");
                    }
                }
            }

        }
        updateValues();
    }


    @Override
    public void keyTyped(KeyEvent e){
        updateValues();
    };

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
