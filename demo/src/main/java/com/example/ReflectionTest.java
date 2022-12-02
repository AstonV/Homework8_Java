package com.example;

import java.lang.reflect.*;

public class ReflectionTest {
    public static void main(String[] args) {

        Method[] personMethods = Person.class.getDeclaredMethods();
        System.out.println("Person class methods:");
        for(int i = 0;i < personMethods.length; i++ ) {
            System.out.printf("%-15s - Total Parameters: %2d ", personMethods[i].getName(), personMethods[i].getParameterCount());

            Class[] parameters = personMethods[i].getParameterTypes();

            if (parameters.length > 0) {
                System.out.print("Parameter Types: ");
            }
            for (Class p : parameters) {
                System.out.print(" " + p.getName());
            }
            System.out.print("\n");
        }


        Method[] addressMethods = Address.class.getMethods();
        System.out.print("---------------------------------------------");
        System.out.println("\nAddress class methods:");
        for(int i = 0; i < addressMethods.length; i++) {
            System.out.printf("%-15s - Total Parameters: %2d ", addressMethods[i].getName(), addressMethods[i].getParameterCount());

            Class[] parameters = addressMethods[i].getParameterTypes();

            if (parameters.length > 0) {
                System.out.print("Parameter Types: ");
            }
            for (Class p : parameters) {
                System.out.print(" " + p.getName());
            }
            System.out.print("\n");
        }

        Field[] addressFields = Address.class.getDeclaredFields();
        System.out.print("---------------------------------------------");
        System.out.println("\nAddress class fields:");
        for(Field field :addressFields) {
            System.out.printf("%-10s %-8s   %s\n", field.getName(),
                    field.getAnnotatedType().getType().getTypeName(),
                    Modifier.toString(field.getModifiers()));
        }
        System.out.println("---------------------------------------------");

        try {
            Person p1 = Person.class.newInstance();
            Address Address1 = new Address(1,"Washington Sq", "San Jose","95148","CA");

            p1.setFirstName("Binh");
            p1.setLastName("Vu");
            p1.setAge(22);
            p1.setSsn("123-45-6789");
            p1.setAddress(Address1);

            System.out.println(p1.toString());

        } catch  (IllegalAccessException | InstantiationException e) {
            System.out.println(e);
        }
    }
}
