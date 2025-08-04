import java.util.Scanner;


class Histogram_test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Set image size: n (#rows), m(#kolumns)");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Obraz obraz_1 = new Obraz(n, m);

        obraz_1.calculate_histogram();
        obraz_1.print_histogram();

//         Watek[] NewThr = new Watek[94];
//
//         for (int i = 0; i < 94; i++) {
//             (NewThr[i] = new Watek(obraz_1, i)).start();
//         }
//
//         for (int i = 0; i < 94; i++) {
//             try {
//         	NewThr[i].join();
//             } catch (InterruptedException e) {}
//         }


        System.out.println("Set number of threads");
        int num_threads = scanner.nextInt();

        Thread[] watki = new Thread[num_threads];

        for(int i = 0; i < num_threads; i++){
            (watki[i] = new Thread(new Run(obraz_1, i, 94, num_threads))).start();
        }

        for (int i = 0; i < num_threads; i++) {
             try {
         	watki[i].join();
             } catch (InterruptedException e) {}
         }

         obraz_1.check_histogram();

    }

}
