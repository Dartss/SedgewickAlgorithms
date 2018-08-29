import java.io.IOException;

public class Main {
    static String path = "C:\\Users\\Dmytro_Bulanyi\\Documents\\agorithms\\algs4-data\\32Kints.txt";

    public static void main(String[] args) throws IOException {
        String s = "(8 * 2) + ((4 - 9) - (1 - 7))";
//        String s = "(55 + 22)";
        System.out.println(Dijkstra.calculate(s));
    }
}
