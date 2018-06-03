package firsov.Kirill;

import java.util.Random;

public class Main {
    private static int min = -100;
    private static int max = 100;

    public static void main(String[] args) {
        int array[] = new int[20];
        Random rnd = new Random(System.currentTimeMillis());

        for (int i = 0; i < array.length; i ++) {
            array[i] = min + rnd.nextInt(max - min + 1);
        }
        int minMax[] = getMinMax(array);

        int array2[] = new int[5];
        array2[0] = 1;
        array2[1] = 1;
        array2[2] = 1;
        array2[3] = 1;
        array2[4] = 2;

        System.out.println(checkBalance(array2));
    }

    private static int[] getMinMax(int[] arr){
        int[] minMax = new int[2];
        minMax[0] = arr[0];
        minMax[1] = arr[0];
        for (int anArr : arr) {
            if (minMax[0] < anArr) {
                minMax[0] = anArr;
            } else if (minMax[1] > anArr) {
                minMax[1] = anArr;
            }
        }
        return minMax;
    }

    private static boolean checkBalance(int[] arr){
        boolean result = false;
        int j = arr.length - 1;
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < arr.length; i++){
            if (sumLeft <= sumRight && j >= i){
                sumLeft += arr[i];
            } else if (sumLeft > sumRight && j >= i) {
                sumRight += arr[j];
                j--;
                i--;
            }

            if (i == arr.length - 1 && sumLeft == sumRight){
                result = true;
            } else if (i == arr.length -1 && sumLeft != sumRight){
                result = false;
            }
        }
        return result;
    }
}
