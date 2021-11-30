public class Main {

    private static final int width = 1000;
    private static final int height = 700;

    public static void main(String[] args) {
        Playground playground = new Playground();
        new Window(playground, width, height);
    }
}
