import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;

//Written by Eric Boewer on 23.11.2021
//Assets & Design by Maxi Kingphan on 23.11.2021

interface Callbacks {
    void execute(float price, int count);
}

public class Window extends JFrame {

    private final String pathBackgroundPanel = "Assets\\Panel.png";

    private final int width;
    private final int height;

    public Window(Playground playground, int width, int height) {
        this.width = width;
        this.height = height;
        setTitle("MediaMarkt");
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel background = new JLabel(new ImageIcon(pathBackgroundPanel));
        background.setLocation(0, 0);
        background.setSize(width, height);
        add(background);

        JTextField inputPrice = new JTextField(5);
        inputPrice.setLocation(177, 300);
        inputPrice.setSize(285, 40);
        inputPrice.setBackground(new Color(251, 11, 12));
        inputPrice.setForeground(Color.WHITE);
        inputPrice.setCaretColor(Color.WHITE);
        inputPrice.setFont(new Font("arial", Font.PLAIN, 27));
        inputPrice.setBorder(BorderFactory.createEmptyBorder());
        add(inputPrice);

        JTextField inputCount = new JTextField(5);
        inputCount.setLocation(625, 300);
        inputCount.setSize(153, 40);
        inputCount.setBackground(new Color(251, 11, 12));
        inputCount.setForeground(Color.WHITE);
        inputCount.setCaretColor(Color.WHITE);
        inputCount.setFont(new Font("arial", Font.PLAIN, 27));
        inputCount.setBorder(BorderFactory.createEmptyBorder());
        add(inputCount);

        JButton buttonExecute = new JButton();
        buttonExecute.addActionListener(e -> playground.execute(Float.parseFloat(inputPrice.getText()), Integer.parseInt(inputCount.getText())));
        Image imgAccept = null;
        try {
            imgAccept = ImageIO.read(Objects.requireNonNull(getClass().getResource("Assets/Accept.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert imgAccept != null;
        buttonExecute.setIcon(new ImageIcon(imgAccept));
        buttonExecute.setLocation(295, 400);
        buttonExecute.setSize(107, 106);
        buttonExecute.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        buttonExecute.setVisible(true);
        add(buttonExecute);

        JButton buttonClear = new JButton();
        buttonClear.addActionListener(e -> {
            inputPrice.setText("");
            inputCount.setText("");
        });
        Image imgDecline = null;
        try {
            imgDecline = ImageIO.read(Objects.requireNonNull(getClass().getResource("Assets/Decline.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert imgDecline != null;
        buttonClear.setIcon(new ImageIcon(imgDecline));
        buttonClear.setLocation(670, 400);
        buttonClear.setSize(107, 106);
        buttonClear.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        add(buttonClear);

        //JLabel outputPrice = new JLabel("test");
        //outputPrice.setText("test");
        //outputPrice.setLocation(0, 0);
        //outputPrice.setFont(new Font("arial", Font.PLAIN, 27));
        //outputPrice.setSize(300, 80);
        //frame.add(outputPrice, BorderLayout.CENTER);
        validate();
        revalidate();
        repaint();
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
    }
}
