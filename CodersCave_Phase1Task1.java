import java.util.*;
public class BMICal {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a=1;
        double weightInKilograms, heightInMeters, BMI;
        try {
            while (a == 1) {
                System.out.println("Enter Your Weight In Kilograms");
                weightInKilograms = sc.nextDouble();
                System.out.println("Enter Your Height In Meters");
                heightInMeters = sc.nextDouble();
                BMI = weightInKilograms / (heightInMeters * heightInMeters);
                System.out.println("Your BMI is" + BMI);
                if (BMI <= 18.5) {
                    System.out.println("You are Underweight");
                } else if (BMI > 18.5 && BMI <= 24.9) {
                    System.out.println("You are Normal Weight");
                } else if (BMI >= 25 && BMI <= 29.9) {
                    System.out.println("You are Over Weight");
                } else {
                    System.out.println("You are Obesity");
                }
                System.out.println("Do You Want To Calculate Again 1,0");
                a = sc.nextInt();
            }
        }
        catch(Exception e){
            System.out.println("Enter the valid Input");
        }
        }

}
