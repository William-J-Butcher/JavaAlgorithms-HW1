package geekBrains.Butcher.algorithm;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args){
        int[] array = myArray();
        int n = array.length;
        HeapSort ob = new HeapSort();
        ob.sort(array);
    }


    public static void sort(int[] array){
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i --)
            pyramid(array, n, i);
        for (int i = n - 1; i >= 0; i --){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            pyramid(array, i, 0);
            System.out.print(array[i] + " ");
        }

    }

    public static void pyramid(int[] array, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && array[left] > array[largest])
            largest = right;
        if (right < n && array[right] > array[largest])
            largest = right;
        if (largest != i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            pyramid(array, n, largest);
        }
    }

    public static int[] myArray(){
        Random rand = new Random();
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array;
    }
}


