import java.util.List;
import java.util.concurrent.*;
import java.util.ArrayList;

public class MainTP {
    private static final int NTHREADS = 10;
    private static final int NTASK = 40;

    public static void main(String []arg){
        double offset = Math.PI / NTASK;

        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
        List<Future<Double>> wyniki_czastkowe = new ArrayList<Future<Double>>();

        for (int i = 0; i < NTASK; i++) {
            Callable<Double> calka = new Calka_callable(i*offset, (i+1)*offset, 0.000001);
            Future<Double> wynik = executor.submit(calka);
            wyniki_czastkowe.add(wynik);
        }

        double wynik_calki = 0.0;

        for(Future<Double> wynik: wyniki_czastkowe){
            try {
                wynik_calki+=wynik.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        while (!executor.isTerminated()) {}

        System.out.println("Wynik calki: " + wynik_calki );
    }
}
