public class MainVoidEmpty {
    public static void main(String[] args) {
        User john = new User();
        VoidEmpty voidEmptyFI;
        String str = "Hello World";
        int myInt = 2;

        voidEmptyFI = ()->{};
        new VoidEmpty() {
            @Override
            public void voidEmpty() {}
        };

        voidEmptyFI = System.out::println;
        voidEmptyFI = () -> System.out.println();
        new VoidEmpty() {
            @Override
            public void voidEmpty() {
                System.out.println();
            }
        };

        voidEmptyFI = john::voidEmpty;
        voidEmptyFI = () -> john.voidEmpty();
        new VoidEmpty(){
            public void voidEmpty() {
                john.voidEmpty();
            }
        };

        voidEmptyFI = () -> john.voidString(str);
        new VoidEmpty() {
            public void voidEmpty() {
                john.voidString(str);
            }
        };


        voidEmptyFI = john::intEmpty;
        voidEmptyFI = () -> john.intEmpty();
        new VoidEmpty() {
            @Override
            public void voidEmpty() {
                john.intEmpty();
            }
        };

        voidEmptyFI = () -> john.intString(str);
        new VoidEmpty() {
            public void voidEmpty() {
                john.intString(str);
            }
        };

        voidEmptyFI = () -> john.intBooleanString(true, str);
        new VoidEmpty(){
            public void voidEmpty() {
                john.intBooleanString(true, str);
            }
        };
    }
}