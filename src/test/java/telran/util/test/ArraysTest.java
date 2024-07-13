package telran.util.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.Random;

public class ArraysTest {
    private static final int N_ELEMENTS = 1_000;
    int[] numbers = { 10, 7, 12, -4, 13, 3, 14 };

    @Test
    void searchTest() {
        assertEquals(0, search(numbers, 10));
        assertEquals(6, search(numbers, 14));
        assertEquals(3, search(numbers, -4));
        assertEquals(-1, search(numbers, 100));
    }

    @Test
    void addTest() {
        int newNumber = 100;
        int[] expected = { 10, 7, 12, -4, 13, 3, 14, 100 };
        assertArrayEquals(expected, add(numbers, newNumber));
    }

    @Test
    void insertTest() {
        int insertNumber = 200;
        int insertIndex = 3;
        int[] expected = { 10, 7, 12, 200, -4, 13, 3, 14 };
        assertArrayEquals(expected, insert(numbers, insertIndex, insertNumber));
    }

    @Test
    void removeTest() {
        int removeIndex = 1;
        int[] expected = { 10, 12, -4, 13, 3, 14 };
        assertArrayEquals(expected, remove(numbers, removeIndex));
    }

    @Test
    void sortTest() {
        int[] testNumbers = java.util.Arrays.copyOf(numbers, numbers.length);
        int[] expected = { -4, 3, 7, 10, 12, 13, 14 };
        sort(testNumbers);
        assertArrayEquals(expected, testNumbers);
    }

    @Test
    void sortTestRandomArray() {
        int[] array = getRandomArray(N_ELEMENTS);
        int limit = array.length - 1;
        sort(array);
        for (int i = 0; i < limit; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }

    private int[] getRandomArray(int nElements) {
        int[] res = new int[nElements];
        Random random = new Random();
        for (int i = 0; i < nElements; i++) {
            res[i] = random.nextInt();
        }
        return res;
    }

    @Test
    void binarySearchTest() {
        int[] testAr = { 1, 3, 4, 6, 10, 11, 12, 15, 17, 100 };
        assertEquals(9, binarySearch(testAr, 100));
        assertEquals(-1, binarySearch(testAr, 99));
        assertEquals(0, binarySearch(testAr, 1));
        assertEquals(-1, binarySearch(testAr, 200));
    }

    @Test
    void insertSortedTest() {
        int[] testAr = { 2, 3, 4, 6, 10, 100 };
        int[] expStart = { 1, 2, 3, 4, 6, 10, 100 };
        int[] exp = { 2, 3, 4, 6, 9, 10, 100 };
        int[] expEnd = { 2, 3, 4, 6, 10, 100, 1000 };
        int[] testAr1 = { 2, 2, 2, 2 };
        int[] exp1 = { 1, 2, 2, 2, 2 };

        assertArrayEquals(expStart, insertSorted(testAr, 1));
        assertArrayEquals(exp, insertSorted(testAr, 9));
        assertArrayEquals(expEnd, insertSorted(testAr, 1000));
        assertArrayEquals(exp1, insertSorted(testAr1, 1));

    }

    @Test
    void isOneSwapArr() {
        int[] testSwap = { 2, 3, 7, 5, 4, 8, 9 };
        int[] expect = { 2, 3, 4, 5, 7, 8, 9 };

        assertArrayEquals(expect, isOneSwapArr(testSwap));
    }

    // @Test
    // void isOneSwap() {
    //     int[] testSwap = { 2, 3, 7, 5, 4, 9 };
    //     int[] expect = { 2, 3, 4, 5, 7, 8, 9 };

    //     assertTrue(isOneSwap(testSwap));
    // }
}
