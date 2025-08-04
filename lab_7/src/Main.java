import java.util.Scanner;

public class Main {
    public static void main(String []arg){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj dx");
        double dx = scanner.nextDouble();
        Calka_callable calka = new Calka_callable(0, Math.PI, dx);

        calka.compute_integral();
    };

}
