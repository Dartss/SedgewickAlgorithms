package assignment1;

public interface UF {
    void union(int a, int b);

    boolean connected(int a, int b);

    int count();
}
