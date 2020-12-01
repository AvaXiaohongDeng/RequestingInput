/*Try showConfirmationDialog() and showInputDialog()*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestingInput extends JFrame implements ActionListener {
    JPanel pnl = new JPanel();
    JTextField field = new JTextField("",18);
    JButton btl1 = new JButton("Confirmation Dialog");
    JButton btl2 = new JButton("Input Dialog");

    public RequestingInput(){
        super("Swing Window");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);

        pnl.add(field);
        pnl.add(btl1);
        pnl.add(btl2);

        btl1.addActionListener(this);
        btl2.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btl1){
            int n = JOptionPane.showConfirmDialog(this,"DO you agree",
                    "Confirmation Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
            switch(n){
                case 0:field.setText("Agreed");break;
                case 1:field.setText("Disagreed");break;
                case 2:field.setText("Cancelled");break;
            }
        }
        if(e.getSource()==btl2){
            field.setText(JOptionPane.showInputDialog(this,"Enter your " +
                    "comment","Input Dialog",JOptionPane.PLAIN_MESSAGE));
        }
    }

    public static void main(String[] args) {
        RequestingInput gui = new RequestingInput();
    }
}
