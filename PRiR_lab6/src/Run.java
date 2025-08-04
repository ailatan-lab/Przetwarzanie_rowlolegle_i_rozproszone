public class Run implements Runnable{
    private Obraz obraz;
    private int id_w;
    int n;
    int l_w;

    public Run(Obraz o, int id_w, int n, int l_w){
        obraz = o;
        this.id_w = id_w;
        this.n = n;
        this.l_w = l_w;
    }

    @Override
    public void run() {
        int N = (int) Math.ceil((double)n / (double)l_w);
        int start = N * id_w;
        int stop = N * (id_w + 1);
        int krok = 1;

       // int id = id_w;

        if (stop > n) stop = n;

        obraz.calculate_histogram_w2(start, stop, krok);

        for (int i = start; i < stop; i += krok) {
            obraz.print_histogram_w2(id_w, i);
        }
    }
}
