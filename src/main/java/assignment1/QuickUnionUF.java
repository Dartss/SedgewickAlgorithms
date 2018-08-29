package assignment1;

public class QuickUnionUF implements UF {
    private int[] id;
    private int count;

    public QuickUnionUF(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int a, int b) {
        int roota = getRoot(a);
        int rootb = getRoot(b);
        id[roota] = rootb;
    }

    @Override
    public boolean connected(int a, int b) {
        return (getRoot(a) == getRoot(b));
    }

    private int getRoot(int a) {
        int root = id[a];
        while(root != a) {
            a = root;
            root = id[a];
        }
        return root;
    }

    @Override
    public int count() {
        return count;
    }
}
