package telran.util.test;

import org.junit.jupiter.api.Test;

import telran.util.CharacterRule;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

//  import java.util.Comparator;
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
        assertEquals(2, binarySearch(testAr, 4));
        assertEquals(-10, binarySearch(testAr, 99));
        assertEquals(0, binarySearch(testAr, 1));
        assertEquals(-11, binarySearch(testAr, 200));
        assertEquals(-1, binarySearch(testAr, 0));
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
    void isOneSwapArrTest() {
        int[] testSwap = { 2, 3, 7, 5, 4, 8, 9 };
        int[] expect = { 2, 3, 4, 5, 7, 8, 9 };

        assertArrayEquals(expect, isOneSwapArr(testSwap));
    }

    @Test
    void isOneSwapTest() {

        int[] arTrue1 = { 1, 2, 10, 4, 7, 3 };
        int[] arTrue2 = { 1, 2, 10, 4, 4, 20 };
        int[] arTrue3 = { 1, 2, 10, 4, 20, 30 };
        int[] arTrue4 = { 10, 2, 1, 10, 20, 30 };
        int[] arFalse1 = { 20, 3, 3, 10, 20, 30 };
        int[] arFalse2 = { 1, 2, 10, 4, 7, 5 };
        int[] arFalse3 = { 1, 2, 3, 4, 5, 10 };
        int[][] arraysTrue = { arTrue1, arTrue2, arTrue3, arTrue4 };
        int[][] arraysFalse = { arFalse1, arFalse2, arFalse3 };
        for (int i = 0; i < arraysTrue.length; i++) {
            assertTrue(isOneSwap(arraysTrue[i]), "" + (i + 1));
        }
        for (int i = 0; i < arraysFalse.length; i++) {
            assertFalse(isOneSwap(arraysFalse[i]), "" + (i + 1));
        }
    }

    @Test
    void sortAnyTypeTest() {
        String[] strings = { "lmn", "cfta", "w", "aa" };
        String[] expectedASCII = { "aa", "cfta", "lmn", "w" };
        String[] expectedLength = { "w", "aa", "lmn", "cfta" };
        sort(strings, (a, b) -> a.compareTo(b));
        assertArrayEquals(expectedASCII, strings);
        sort(strings, (a, b) -> Integer.compare(a.length(), b.length()));
        assertArrayEquals(expectedLength, strings);
    }

    @Test
    void binarySearchAnyTypeTest() {
        Integer[] testAr = { 1, 3, 4, 6, 10, 11, 12, 15, 17, 100 };
        Integer[] testAr1 = { 1000, 2000 };
        assertEquals(0, binarySearchAny(testAr, 1, (a, b) -> a.compareTo(b)));
        assertEquals(0, binarySearchAny(testAr1, 1000, (a, b) -> a.compareTo(b)));
        String[] expectedASCII = { "aa", "cfta", "lmn", "w" };
        String[] expectedLength = { "w", "aa", "lmn", "cfta" };
        assertEquals(3, binarySearchAny(expectedASCII, "w", (a, b) -> a.compareTo(b)));
        assertEquals(1, binarySearchAny(expectedLength, "aa", (a, b) -> Integer.compare(a.length(), b.length())));

    }

    @Test
    void binarySearchNoComparator() {
        String[] strings = { "aa", "cfta", "lmn", "w" };
        Person prs1 = new Person(10, "Vasya");
        Person prs2 = new Person(20, "Itay");
        Person prs3 = new Person(30, "Sara");
        Person[] persons = {
                prs1, prs2, prs3
        };
        assertEquals(1, binarySearchWithoutComporator(strings, "cfta"));
        assertEquals(0, binarySearchWithoutComporator(persons, prs1));
        assertEquals(-1, binarySearchWithoutComporator(persons, new Person(5, "Serg")));
    }

    @Test
    void evenOddSorting() {
        Integer[] array = { 7, -8, 10, -100, 13, -10, 99 };
        Integer[] expected = { -100, -10, -8, 10, 99, 13, 7 }; // even numbers in ascending order first, odd in
                                                               // descending order after that
        sort(array, (a, b) -> {
            int result = 0;
            if (a % 2 == 0 && b % 2 != 0) {
                result = -1;
            } else if (a % 2 == 0 && b % 2 == 0) {
                result = a - b;
            } else if (a % 2 != 0 && b % 2 != 0) {
                result = b - a;
            } else if (a % 2 != 0 && b % 2 == 0) {
                result = 1;
            }
            return result;
        });
        assertArrayEquals(expected, array);
    }

    @Test
    void findTest() {
        Integer[] array = { 7, -8, 10, -100, 13, -10, 99 };
        Integer[] expected = { 7, 13, 99 };
        assertArrayEquals(expected, find(array, n -> n % 2 != 0));
    }

    @Test
    void removeIfTest() {
        Integer[] array = { 7, -8, 10, 18, 24, 99, 98, -97 };
        Integer[] expected = { -8, 10, 18, 24, 98 };
        assertArrayEquals(expected, removeIf(array, n -> n % 2 != 0));
    }
    
    @Test
    void matchesRulesTestt() {
        char[] chars = { 'a', 'b', 'c', '1', '2', '3' };

        CharacterRule[] mustBeRules = new CharacterRule[] {
                new CharacterRule(Character::isLetter, "must contain a letter"),
                new CharacterRule(Character::isDigit, "must contain a digit")
        };

        CharacterRule[] mustNotBeRules = new CharacterRule[] {
                new CharacterRule(ch -> ch == 'x', "must not contain 'x'")
        };

        String result = matchesRules(chars, mustBeRules, mustNotBeRules);
        assertEquals("", result);

        char[] charsWithX = { 'a', 'b', 'c', 'x' };
        result = matchesRules(charsWithX, mustBeRules, mustNotBeRules);
        assertEquals("No match for must-be rule: must contain a digit; Match found for must-not-be rule: must not contain 'x'; ", result);

        char[] charsWithoutDigit = { 'a', 'b', 'c' };
        result = matchesRules(charsWithoutDigit, mustBeRules, mustNotBeRules);
        assertEquals("No match for must-be rule: must contain a digit; ", result);
    }

    @SuppressWarnings("unused")
    private static String matchesRuless(char[] chars, CharacterRule[] mustBeRules, CharacterRule[] mustNotBeRules) {
        StringBuilder message = new StringBuilder();

        
        for (CharacterRule rule : mustBeRules) {
            boolean found = false;
            for (char ch : chars) {
                if (rule.getPredicate().test(ch)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                message.append("No match for must-be rule: ").append(rule.getErrorMessage()).append("; ");
            }
        }

        
        for (CharacterRule rule : mustNotBeRules) {
            for (char ch : chars) {
                if (rule.getPredicate().test(ch)) {
                    message.append("Match found for must-not-be rule: ").append(rule.getErrorMessage()).append("; ");
                    break;
                }
            }
        }

        return message.toString();
    }

}
