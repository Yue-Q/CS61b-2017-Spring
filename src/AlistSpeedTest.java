public class AlistSpeedTest {
    public static void main(String[] args) {
        int i = 1000000000;
        AList L = new AList();
        while (i > 0) {
            L.addLast(i);
            i = i - 1;
        }
    }
}
