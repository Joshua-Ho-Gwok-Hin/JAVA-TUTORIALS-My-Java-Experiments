public class Main {
    private int two = 2;
    static int three = 5;
    public static void main(String[] args) {
        int two = 3;
//        int three = 2;
        three = 20;
        if (three > 4) {
            System.out.println("three is inside main");
        } else {
            System.out.println("three is from static three");
        }

    }
}