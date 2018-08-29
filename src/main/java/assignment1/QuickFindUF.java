package assignment1;

public class QuickFindUF implements UF {
    private int[] id;
    private int count;

    public QuickFindUF(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int a, int b) {
        int aid = id[a];
        int bid = id[b];
        for (int i = 0; i < count; i++) {
            if (id[i] == aid) id[i] = bid;
        }
        id[a] = id[b];
    }

    @Override
    public boolean connected(int a, int b) {
        return (id[a] == id[b]);
    }

    @Override
    public int count() {
        return count;
    }
}
