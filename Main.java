import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    static HashMap<Integer, Integer> cache = new HashMap<>();

    public static int baskinRobbins31(int n) {
        if (n <= 1) return 0;
        return baskinRobbins31(n - 1) + baskinRobbins31(n - 2) + 1;
    }

    public static int baskinRobbins31_memoization(int n) {
        if (n <= 1) return 0;
        if (!cache.containsKey(n))
            cache.put(n, baskinRobbins31(n));
        return cache.get(n);
    }

    public static int baskinRobbinsHelper(int n) {
        return baskinRobbins31(n) + 1;
    }

    public static int baskinRobbinsHelper_memoization(int n) {
        return baskinRobbins31_memoization(n) + 1;
    }

    public static void main(String[] args) {
        int[] values = {10, 20, 30};
        for (var value : values) {
            long start = System.nanoTime();
            var result = baskinRobbinsHelper(value);
            System.out.println(value + ": " + (System.nanoTime() - start));
        }
        System.out.println();
        for (var value : values) {
            long start = System.nanoTime();
            var result = baskinRobbinsHelper_memoization(value);
            System.out.println(value + ": " + (System.nanoTime() - start));
        }
    }

    @Test
    void baskinRobbins31Test() {
        assertEquals(baskinRobbinsHelper(31), 2178309);
        assertEquals(baskinRobbinsHelper_memoization(31), 2178309);
    }
}