import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class ThreeSum {
    public static int brute(int[] array) {
        int N = array.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        count++;
//                        System.out.format("YES : [i] = %d, [j] = %d, [k] = %d \n", array[i],array[j],array[k]);
                    }
                }
            }
        }
        return count;
    }

    public static int sortAndHash(int[] array) {
        int N = array.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>(N);

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int neededN = -(array[i] + array[j]);
                if (map.containsKey(neededN) && map.get(neededN) > j) {
//                    System.out.format("YES : [i] = %d, [j] = %d, [k] = %d \n", array[i],array[j],array[k]);
                    count++;
                }
            }
        }

        return count;
    }

    public static int sortAndBinary(int[] array) {
        Arrays.sort(array);
        int N = array.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int k = binarySearch(array, -(array[i] + array[j]));
                if (k > j) {
//                    System.out.format("YES : [i] = %d, [j] = %d, [k] = %d \n", array[i],array[j],array[k]);
                    count++;
                }
            }
        }

        return count;
    }


    private static int binarySearch(int[] a, int o) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == o) {
                return mid;
            } else if (a[mid] < o) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (a[0] == o) return 0;
        if (a[a.length - 1] == o) return a.length;

        return -1;
    }
}
