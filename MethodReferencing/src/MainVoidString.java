public class MainVoidString {
    public static void main(String[] args) {
        User john = new User();

        VoidString voidStringFI;
        voidStringFI = System.out::println;
        voidStringFI = s -> System.out.println(s);
        new VoidString(){
            @Override
            public void voidString(String s) {
                System.out.println(s);
            }
        };

        voidStringFI = john::voidString;
        voidStringFI = s -> john.voidString(s);
        new VoidString(){
            @Override
            public void voidString(String s) {
                john.voidString(s);
            }
        };

        voidStringFI = john::intString;
        voidStringFI = s -> john.intString(s);
        new VoidString(){
            public void voidString(String s) {
                john.intString(s);
            }
        };

/*
        Following method-referencing have compilation error. Cannot resolve method.
        voidStringFI = john::voidEmpty;
        voidStringFI = john::intEmpty;
        voidStringFI = john::intBooleanString;
*/
    }
}
