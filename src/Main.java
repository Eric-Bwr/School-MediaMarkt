import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Playground playground = new Playground();
        EventQueue.invokeLater(() -> new Window(playground));
    }
}
