import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;

//Written by Eric Boewer on 23.11.2021
//Assets & Design by Maxi Kingphan on 23.11.2021
//https://github.com/Eric-Bwr/School-MediaMarkt

interface Callbacks {
    void getOutputPrice(JLabel outputPrice);
    void execute(float price, int count);
    void incorrectInput();
}

public class Window extends JFrame {

    private final String pathBackgroundPanel = "Assets\\Panel.png";
    private final String pathButtonAccept = "Assets\\Accept.png";
    private final String pathButtonDecline = "Assets\\Decline.png";

    public Window(Playground playground) {
        setTitle("MediaMarkt");
        setSize(1000, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setContentPane(new JLabel(new ImageIcon(pathBackgroundPanel)));

        JTextField inputPrice = new JTextField(1);
        inputPrice.setLocation(170, 280);
        inputPrice.setSize(285, 40);
        inputPrice.setBackground(new Color(251, 11, 12));
        inputPrice.setForeground(Color.WHITE);
        inputPrice.setCaretColor(Color.WHITE);
        inputPrice.setFont(new Font("arial", Font.PLAIN, 27));
        inputPrice.setBorder(BorderFactory.createEmptyBorder());
        add(inputPrice);

        JTextField inputCount = new JTextField(1);
        inputCount.setLocation(620, 280);
        inputCount.setSize(152, 40);
        inputCount.setBackground(new Color(251, 11, 12));
        inputCount.setForeground(Color.WHITE);
        inputCount.setCaretColor(Color.WHITE);
        inputCount.setFont(new Font("arial", Font.PLAIN, 27));
        inputCount.setBorder(BorderFactory.createEmptyBorder());
        add(inputCount);

        JButton buttonExecute = new JButton();
        buttonExecute.addActionListener(e -> {
            try {
                playground.execute(Float.parseFloat(inputPrice.getText()), Integer.parseInt(inputCount.getText()));
            }catch (Exception d) {
                playground.incorrectInput();
            }
        });
        buttonExecute.setIcon(new ImageIcon(pathButtonAccept));
        buttonExecute.setLocation(140, 400);
        buttonExecute.setSize(110, 110);
        buttonExecute.setContentAreaFilled(false);
        buttonExecute.setFocusable(false);
        buttonExecute.setBorder(BorderFactory.createEmptyBorder());
        add(buttonExecute);

        JButton buttonDecline = new JButton();
        buttonDecline.addActionListener(e -> {
            inputPrice.setText("");
            inputCount.setText("");
        });
        buttonDecline.setIcon(new ImageIcon(pathButtonDecline));
        buttonDecline.setLocation(700, 400);
        buttonDecline.setSize(110, 110);
        buttonDecline.setContentAreaFilled(false);
        buttonDecline.setFocusable(false);
        buttonDecline.setBorder(BorderFactory.createEmptyBorder());
        add(buttonDecline);

        JLabel outputPrice = new JLabel("");
        outputPrice.setLocation(350, 530);
        outputPrice.setSize(250, 100);
        outputPrice.setForeground(Color.WHITE);
        outputPrice.setFont(new Font("arial", Font.PLAIN, 45));
        add(outputPrice);
        playground.getOutputPrice(outputPrice);

        EventQueue.invokeLater(() -> setVisible(true));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
    }
}
