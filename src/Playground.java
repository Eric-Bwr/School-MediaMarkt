import javax.swing.*;

public class Playground implements Callbacks {

    private JLabel outputPrice;

    public Playground() {

    }

    public void getOutputPrice(JLabel outputPrice) {
        this.outputPrice = outputPrice;
    }

    public void execute(float price, int count) {
        outputPrice.setText(price * count + "€");
    }

    public void incorrectInput() {
        outputPrice.setText("N/A");
    }
}