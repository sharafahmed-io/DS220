import java.util.LinkedList;

class HashTable {
    private final int SIZE = 10;
    private LinkedList<Pair>[] table;

    class Pair {
        int key, value;
        Pair(int k, int v) {
            key = k;
            value = v;
        }
    }

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        for (Pair p : table[index]) {
            if (p.key == key) {
                p.value = value;
                return;
            }
        }
        table[index].add(new Pair(key, value));
    }

    public Integer get(int key) {
        int index = hash(key);
        for (Pair p : table[index]) {
            if (p.key == key) return p.value;
        }
        return null;
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put(1, 100);
        ht.put(2, 200);
        System.out.println("Key 1: " + ht.get(1));
    }
}