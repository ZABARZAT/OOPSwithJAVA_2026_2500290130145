
import java.util.Scanner;

public class Agevalidation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter age");
        int age = sc.nextInt();

        try {
            checkAge(age);
        } catch (AgeInvalidException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    static void checkAge(int age) throws AgeInvalidException {
        if (age < 18) {
            throw new AgeInvalidException("Age is not valid to vote");
        }

        System.out.println("Eligible to vote");
    }
}

class AgeInvalidException extends Exception {

    AgeInvalidException(String msg) {
        super(msg);
    }
}