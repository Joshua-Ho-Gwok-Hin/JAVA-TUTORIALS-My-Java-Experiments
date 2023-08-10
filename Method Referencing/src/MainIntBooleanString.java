public class MainIntBooleanString {
    public static void main(String[] args) {
        User john = new User();
        IntBooleanString intBooleanStringFI;

        intBooleanStringFI = john::intBooleanString;
        intBooleanStringFI = (b, s) -> john.intBooleanString(b, s);
        new IntBooleanString(){
            @Override
            public int intBooleanString(boolean b, String s) {
                return john.intBooleanString(b, s);
            }
        };

        intBooleanStringFI = john::voidEmpty;
        intBooleanStringFI = john::voidString;
        intBooleanStringFI = john::intEmpty;
        intBooleanStringFI = john::intString;
        intBooleanStringFI = john::intBooleanString;

        intBooleanStringFI = System.out::println;
        intBooleanStringFI = (b, s) -> System.out.println(s);
        intBooleanStringFI = User::intBooleanString;
    }
}
