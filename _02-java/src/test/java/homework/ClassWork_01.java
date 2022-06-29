package homework;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Random;
import java.util.Scanner;

public class ClassWork_01 {
    private final int NOT_EXIST = -1;


//    @Parameterized.Parameter(value = 3)
    int num = 3;

    @Test
    public void classWork01(){

        int[] arr = new int[6];

        initArray(arr);
        System.out.println("getArrString(arr) = " + getArrString(arr));
        System.out.println("getMax(arr) = " + getMax(arr));

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("\"what num do you want to find ?\" = " + "what num do you want to find ?");
//        int num = scanner.nextInt();
        System.out.println("num = " + num);
        System.out.println("getIndex(arr,num) = " + getIndex(arr, num));


    }

    public void initArray(int[] arr){
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            arr[i] = random.nextInt(9) + 1;
        }
    }

    public String getArrString(int[] arr){
        StringBuilder builder = new StringBuilder("{");

        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i] + ",");
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");

        return builder.toString();
    }

    public int getMax(int[] arr){
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }

        return max;
    }

    public int getIndex(int[] arr, int num){
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) return i;
        }

        return NOT_EXIST;
    }


}
