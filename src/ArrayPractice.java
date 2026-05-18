import java.util.Arrays;

public class ArrayPractice{
    public static void main(String[] args) {
        int[] arr = new int[11];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * 5) + 1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] == arr[i + 1]){
                System.out.println(i);
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length - 1; i += 2){
            if (arr[i] == arr[i + 1]){
                System.out.println(i);
            }
        }
        System.out.println();
        int[] arrReverse = new int[11];
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--){
            arrReverse[index] = arr[i];
            index++;
        }
        System.out.println(Arrays.toString(arrReverse));
        double[] average = new double[5];
        for (int i = 0; i < average.length; i++){
            if (i < arrReverse.length - 1){
                average[i] = (arrReverse[i] + arrReverse[i + 1]) / 2;
            } else {
                average[i] = arrReverse[arrReverse.length];
            } 
        }

    }





}