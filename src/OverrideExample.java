
class BaseClass {
    public void goodMethod() {
        System.out.println("BaseClass executing good method");
    }

    public void printInformation(CharSequence s) {
        System.out.println("BaseClass prints " + s);
    }

    public CharSequence getInformation() {
        return getClass().getName();
    }
}

class ExtendedClass extends BaseClass {

    //if i will comment this method then by default Base class(Parent class)
    //method goodMethod will be called due to inheritance.
    public void goodMethod() {
        //call base class goodMethod() with super keyword
        //otherwise just  ExtendedClass goodMethod() will called.
        super.goodMethod();
        System.out.println("AND ExtendedClass executing a better method");
    }

    public void printInformation(CharSequence string) {

        System.out.println("ExtendedClass prints " + string);

    }

    public String getInformation() {
        return getClass().getName();
    }
}

public class OverrideExample {
    public static void main(String[] args) {
        ExtendedClass e = new ExtendedClass();
        e.goodMethod();
        e.printInformation(e.getInformation());
        e.printInformation((CharSequence) e.getInformation());
    }
}