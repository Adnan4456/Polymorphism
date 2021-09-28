/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 9: Reusing Implementations Through Inheritance
Topic: Utilize polymorphism to cast and call methods
Sub-Topic: Array casting and generics
*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class CastExtras {
    // Just want a few classes to play with

    static class BaseClass {
        String name = "Base Case";

        public String toString() {
            return getClass().getName();
        }
    }

    static class NextClass extends BaseClass {
        String name = "Next Best Case";
    }

    // main method, we'll test out some more casting examples
    public static void main(String[] args) {

        // Let's create the most generic of arrays
        Object[] myObjectArray = new Object[10];

        // This fills an Object array with Objects that are NextClass
        // It does not change the type of array to NextClass[]
        Arrays.fill(myObjectArray, new NextClass());

        // You can put any type of Object in there
        myObjectArray[5] = new StringBuilder("test");

        System.out.println(myObjectArray.getClass().getTypeName());
        System.out.println(Arrays.toString(myObjectArray));

        //we are going to loop through our array and cast each
        //object first to a NextClass to print the name attribute on
        // NextClass , and then we cast to BaseClass to print the
        // name attribute on the BaseClass.
        try {

            for (Object o: myObjectArray){
                //We can cast to most specific class
                NextClass n = new NextClass();
                System.out.println(n.name);

                //we can cast to less specific class if we prefer more
                //generic name
                BaseClass b = (BaseClass) o;
                System.out.println(b.name);
            }

        }
        catch (Exception e){
            //Not to mention any object might be in your array...
            e.printStackTrace(System.out);
        }
        //Next we will create an array of mixed type, using the common
        //denominator BaseClass.
        BaseClass mixedArray[] = new BaseClass[6];
        //fill half with Next Class
        Arrays.fill(mixedArray , 0,3,new NextClass());
        //fill half with Base Class
        Arrays.fill(mixedArray,3,6,new BaseClass());

        System.out.println(Arrays.toString(mixedArray));
        for (BaseClass n: mixedArray){
            //if we simple print values of base class array
            //We get all base class object even we save Next class object
            //  System.out.println(n.name);

            //we cast object array . if we want NextClass more specific name.
            //otherwise we get all base class values.
            System.out.println(n+":"+
                    //ternary conditional operator uses instanceOf
                    ((n instanceof NextClass) ? ((NextClass) n).name : n.name)
            );
        }

        //Run time error ,
        // it feasible that mixed array could be populated with object of its child only
        //but JVM would not allow it.
        //if you cast mixed array with child class it will error.
    //    NextClass[] nextArray = (NextClass[]) mixedArray;

        //fill all with just NextClass objects (child class).
        Arrays.fill(mixedArray , new NextClass());
        //JVM still does not allow it.

      //  NextClass[] nextArray2 = (NextClass[])mixedArray;
        //you can not downcast an generic type array of parent type
        //to its child type.You will get Run time exception.
    }
}