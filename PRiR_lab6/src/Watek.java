public class Watek extends Thread{
    Obraz obraz;
    int znak;

    public Watek(Obraz o, int znak){
        obraz = o;
        this.znak = znak;
    }

    public void run() {
        obraz.calculate_histogram_w1(znak);

        synchronized (obraz) {
            obraz.print_histogram_w1(znak);
        }
    }

}
