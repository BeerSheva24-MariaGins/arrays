package telran.util;

public class Arrays {
    public static int search(int[] ar, int key) {

        int index = 0;
        while (index < ar.length && key != ar[index]) {
            index++;
        }
        return index == ar.length ? -1 : index;
    }

    public static int[] add(int[] ar, int number) {
        int[] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        res[ar.length] = number;
        return res;
    }

    public static int[] insert(int[] ar, int index, int number) {

        int[] res = new int[ar.length + 1];
        System.arraycopy(ar, 0, res, 0, index);
        res[index] = number;
        System.arraycopy(ar, index, res, index + 1, ar.length - index);

        return res;
    }

    public static int[] remove(int[] numbers, int index) {

        int[] res = new int[numbers.length - 1];
        System.arraycopy(numbers, 0, res, 0, index);
        System.arraycopy(numbers, index + 1, res, index, numbers.length - index - 1);

        return res;
    }

    public static boolean pushMaxAtEnd(int[] ar, int length) {
        boolean res = true;
        for (int i = 0; i < length; i++) {
            if (ar[i] > ar[i + 1]) {
                res = false;
                swap(ar, i, i + 1);
            }
        }
        return res;
    }

    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    public static void sort(int[] ar) {
        int length = ar.length;
        boolean flSorted = false;
        while (!flSorted) {
            length--;
            flSorted = pushMaxAtEnd(ar, length);

        }
        
    }
    public static int binarySearch(int [] ar, int key) {
        int left = 0;
        int right = ar.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ar[mid] == key) {
                return mid;
            } else if (ar[mid] < key) {
                left = mid +1;
            } else {
                right = mid - 1;  
            }
        }
        return -1;
    }
    public static int [] insertSorted(int [] arSorted, int number) {    
        int newSize = arSorted.length + 1;
        int[] arSortedMod = new int[newSize];
        System.arraycopy(arSorted, 0, arSortedMod, 0, arSorted.length);
        int i = arSortedMod.length - 1;
        arSortedMod[i] = arSortedMod[i - 1];

        if (arSortedMod[newSize - 1] < number) {
            arSortedMod[newSize - 1] = number;
            return arSortedMod;
        }
        
        while (i > 0 && arSortedMod[i - 1] > number) {
            arSortedMod[i] = arSortedMod[i - 1];
            i--;
        }
        arSortedMod[i] = number;
        return arSortedMod; 
    }

    public static boolean isOneSwap(int [] array) {
        int[] arrSorted = new int[array.length];
        System.arraycopy(array, 0, arrSorted, 0, array.length);    
        sort(arrSorted);    
        int count = 0;    
        int [] temp = new int[array.length];
        for (int i = 0; i < arrSorted.length; i++) {        
            if (arrSorted[i] != array[i]) {            
                temp[count] = i;
                count++;
            }
        }
        if (count == 2) {
            swap(arrSorted, temp[0], temp[1]);
        }
        if (arrSorted == array) {
            return true;
        }    
        return false;
    }
    public static int [] isOneSwapArr(int [] arra) {
        int[] arrSorted = new int[arra.length];
        System.arraycopy(arra, 0, arrSorted, 0, arra.length);    
        sort(arrSorted);    
        int count =0;    
        int [] temp = new int[arra.length];
        for (int i = 0; i < arrSorted.length; i++) {        
            if (arrSorted[i] != arra[i]) {            
                temp[count] = i;
                count++;
            }
        }
        if (count == 2) {
            swap(arrSorted, temp[0], temp[1]);
        }
        if (arrSorted == arra) {
            return arrSorted;
        }    
        return arra;
    }
}

  


