
public class Main {

    public static void main(String[] args) throws InterruptedException {

        draw.start();
        draw.verify();
        while (true) {
   
            // draw.image("D:/Pictures/anime/chino/4bbdb7f405c415c78000637c00b291a0.jpg",
            // 20, 20, 300,
            // new int[] { 1, -40 });
            draw.update();
        }
    }
}