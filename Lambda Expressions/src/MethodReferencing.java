import java.util.ArrayList;

public class MethodReferencing {

    public static void main(String[] args) {

        String str = "Today is a holiday";

        NoParamVoid functionalInterfaceOne = System.out::println;
        NoParamVoid lambdaOne = ()-> System.out.println();

        StringParamVoid functionalInterfaceTwo = System.out::println;
        StringParamVoid lambdaTwo = e -> System.out.println(e);

        NoParamInt functionalInterfaceThree = str::length;
        NoParamInt lambdaThree = () -> str.length();

        Dinosaur pillo = new Dinosaur();

        DinoParamInt dinoParamInt = Dinosaur::giveMeNumberThree;
        DinoParamInt dinoParamInt1 = pillo::giveMeNumberThree;
        DinoParamInt lambdaOneFour = p -> pillo.giveMeNumberThree(p);





        DinoParamInt lamdbaOneThree = Dinosaur::giveMeNumberThree;
//        DinoParamInt lamdbaOneThree = d -> d.giveMeNumberThree();


//        DinoParamInt dinoParamInt1 = Dinosaur::staticStringParamReturnInt;


        StringParamInt funtionalInterfaceFour = String::length;
        System.out.println(funtionalInterfaceFour.returnInt("Hello") + " something new");
        StringParamInt lambdaFour = e -> e.length();

        TwoParamCharacter functionalInterfaceFive = String::charAt;
        TwoParamCharacter lambdaFive = (s, i) -> s.charAt(i);

        HelperClass.printASound("Hello", e -> System.out.println(e));
        HelperClass.printASoundOne("Hello");

        NoParamVoid dinoSound = Dinosaur::staticSound;
        NoParamVoid lambdaSix = () -> Dinosaur.staticSound();
        dinoSound.doSomething();

        Dinosaur dino = new Dinosaur();
        NoParamVoid dinoMakesSound = dino::makeSound;
        NoParamVoid lambdaSeven = () -> dino.makeSound();
        dinoMakesSound.doSomething();

        StringParamVoid lambdaEight = s -> dino.makeSound(s);
        StringParamVoid dinoWithString = dino::makeSound;
        dinoWithString.doSomething("Roar");

        NoParamInt fIGiveBackInt = dino::giveMeNumberThree;
        NoParamInt lambdaNine = ()-> dino.giveMeNumberThree();
        System.out.println(fIGiveBackInt.retunInt());

//        NoParamInt abc = Dinosaur::giveMeNumberThree;
//        NoParamInt lambdaTwelve = dinoD -> dinoD.giveMeNumberThree();

        DinoParamInt dinoParamInt2 = Dinosaur::instanceOne;

        StringParamInt fIGiveMeStringAndIReturnInt = dino::giveMeNumberWithThisString;
        StringParamInt lambdaTen = s -> dino.giveMeNumberWithThisString(s);
        System.out.println(fIGiveMeStringAndIReturnInt.returnInt("abcdefghijklmnopqrstuvwxyz"));

//        StringParamInt fISameAsAbove = Dinosaur::giveMeNumberWithThisString;
//        StringParamInt lambdaEleven = e -> e.length();
//
//        Something<Dinosaur> something = Dinosaur::giveMeNumberThree;
//


    }
}

class Dinosaur {

    static void staticSound() {
        System.out.println("staticSound() Roar...");
    }

    void makeSound() {
        System.out.println("makeSound() Roar...");
    }

    int instanceOne() {
        return 1;
    }

    void makeSound(String sound) {
        System.out.println("makeSound(String s) " + sound);
    }

    int giveMeNumberThree() {
        return 3;
    }

    static int giveMeNumberFour() {
        return 4;
    }

    int giveMeNumberWithThisString(String s) {
        return s.length();
    }
    static int staticStringParamReturnInt(String s) {
        return s.length();
    }

    int giveMeStringWithArraylist(ArrayList<Dinosaur> someDino) {
        return someDino.size();
    }

    int giveMeNumberThree(Dinosaur dinosaur) {
        return 0;
    }
}

class HelperClass {
    public static void printASound(String sound, StringParamVoid doSomething) {
        doSomething.doSomething(sound);
    }

    public static void printASoundOne(String sound) {
        StringParamVoid functionalInterface = e -> System.out.println(e);
        functionalInterface.doSomething(sound);
    }
}

interface NoParamVoid {
    void doSomething();
}

interface StringParamVoid {
    void doSomething(String s);
}

interface NoParamString {
    String doSomething();
}

interface NoParamInt {
    Number retunInt();
}

interface StringParamInt {
    int returnInt(String s);
}

interface TwoParamCharacter {
    char returnChar(String s, int index);
}

interface Something<T> {
    int returnInt(ArrayList<T> ts);
}

interface DinoParamInt {
    int giveDinoReturnInt(Dinosaur dinosaur);
}




