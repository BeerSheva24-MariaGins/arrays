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
        int result = -1;
        
        
        while (left <= right) {
            int mid = (left + right) / 2;           
            if (ar[mid] == key) {
                result = mid;  
                break;                             
            } else if (ar[mid] < key) {
                left = mid +1;
            } else {
                right = mid - 1;  
            }
            result = -left - 1;            
        }
        return result;
    }
    public static int [] insertSorted(int [] arSorted, int number) {        
        int newIndex = binarySearch(arSorted, number);
        int [] result;
        if (newIndex > 0) {
            result = insert(arSorted, newIndex, number);
        } else {
            result = insert(arSorted, -(newIndex + 1), number);
        }
        return result;
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
        return count == 2;
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
            return arrSorted;
        }
          
        return arra;
    }
}

  


