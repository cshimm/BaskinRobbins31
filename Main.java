import java.util.HashMap;

public class Main {
    static HashMap<Integer, Integer> cache = new HashMap<>();
    static int baskinRobbins31(int n) {
        if (n <= 1) return n;
        if (!cache.containsKey(n))
            cache.put(n, baskinRobbins31(n - 1) + baskinRobbins31(n - 2) + 1);
        return cache.get(n);
    }

    public static void main(String[] args) {
        int result = baskinRobbins31(31);
        System.out.println(result);
    }
}