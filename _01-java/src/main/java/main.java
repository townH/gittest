import javax.sound.midi.MidiChannel;
import java.util.Random;
import java.util.Scanner;
import java.util.jar.JarEntry;

/**
 * 打印 1 ~ 200 的质数（素数）
 */
public class main {
    public static void main(String[] args) {
        main primeNum = new main();
//        primeNum.getSmallest(primeNum.inputNum(), primeNum.inputNum());
//        primeNum.getLCM(primeNum.inputNum(),primeNum.inputNum());
//        primeNum.array04();

        primeNum.homework_05();

        primeNum.homework_06();

    }


    public void homework_06(){
        System.out.println("-----homework_06  --------boundary-----");
        int[] arr = {5,3,13,23,15,64,54,32};

        System.out.print("\nbubbleSort 排序前数组是：");
        printArray(arr, arr.length);
        bubbleSort(arr);
        printArray(arr, arr.length);

        int[] arr01 = {89,43,23,1,2,43,56,34,23,22};
        System.out.print("\nselectSort排序前数组是：");
        printArray(arr01,arr01.length);
        selectSort(arr01);
//        quickSort(arr01,0,arr01.length - 1);
        printArray(arr01, arr01.length);

        //1.3 快速排序
        int[] arr02 = {748,45,23,321,98,23};
        System.out.print("\nselectSort排序前数组是：");
        printArray(arr02,arr02.length);
        quickSort(arr02,0,arr02.length - 1);
        printArray(arr02, arr02.length);

        //
        System.out.print("\n请输入要查找的数值：");
        Scanner scanner = new Scanner(System.in);
        int findNum = scanner.nextInt();

        binarySearch(arr01, 0, arr01.length, findNum);
    }


    public void inputArray(int[] arr){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public void printArray(int[]arr,int len){
        System.out.print("\n[");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }


    // 二分查找-=================================
    public int binarySearch(int[]arr,int begin , int end ,int num ){

//
//        if ( arr[mid] == num) return mid;
//        if (arr[mid] > num) binarySearch(arr, mid + 1, arr.length - 1,num);
//        if (arr[mid] < num ) binarySearch(arr, begin, mid, num);

        int count = 0;
        int mid =  (begin + end)/ 2;

        while(begin < end){

            if ( arr[mid] == num) {
                count++;

                System.out.println("共比较了" + count + "次");
                return mid;
            }
            if (arr[mid] > num) {
                count++;

                end = mid - 1;
                mid = (begin + end) / 2;
            }
            if (arr[mid] < num){
                count++;

                begin = mid + 1;
                mid = (begin + end ) / 2;
            }
        }

        System.out.println("数组中不存在这个数字 ！！！\n  共比较了" + count + "次");
        return -1;
    }



    // 快速排序 ---------------------------------

//    1、 找一个基准点（一般以数组开头为基准点），把所有比它大的数都换到右边，把所有比他小的书都换到左边。
//    2、 以该基准点作分界点，将数组划分为两个数组。继续① 步骤

    public void quickSort(int[] arr,int begin,int end){
        if (begin >= end) return;

        int mid = arr[begin];
        int i = begin;
        int j = end;

        while (i < j){
            while(arr[j] >= mid && i < j) j--;
            while(arr[i] <= mid && i < j) i++;

            if (i < j){
                int tempt = arr[j];
                arr[j] = arr[i];
                arr[i] = tempt;
            }
        }
        arr[begin] = arr[i];
        arr[i] = mid;

        quickSort(arr, begin, i-1);
        quickSort(arr,i+1, end);
    }



//冒泡排序-=========================================
    public void bubbleSort(int[] arr){
        //优化
        //是否已经有序
        boolean ordered = true;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    int tempt = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempt;

                    ordered = false;
                }

                //是否已经有序
                if (ordered) return;
            }
        }
    }


    public void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i + 1;j<arr.length;j++){
                if (arr[j] < arr[min]) min = j;
            }

            int tempt = arr[min];
            arr[min] = arr[i];
            arr[i] = tempt;
        }
    }


    public void homework_05(){
        System.out.println("-----homework_05  --------boundary-----");


        final int upper = 35;
        final int lower = 21;
        final int row = 4;
        final int rank = 2;



//        int[][] arr = new int[2][4];
        int[][] arr = new int[row][rank];

        int count = 0;

        while(count < row * rank){
            int num = generateRandomInt_05(upper, lower);
            if (!hasRepeatedNum(arr,num)){
                arr[ count / rank ][count % rank] = num;
                count++;
            }

        }
//        for (int i = 0; i < arr.length;) {
//            for (int j = 0; j < arr[i].length; ) {
//                int num = generateRandomInt_05(21, 35);
//                if (!hasRepeatedNum(arr,num)){
//                    arr[i][j] = num;
//                    i++;
//                    j++;
//                    count++;
//                }
//
//
//            }
//        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public boolean hasRepeatedNum(int[][]arr,int num){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (num == arr[i][j]) return true;
            }
        }

        return false;
    }

    public int generateRandomInt_05(int upper,int lower){
        Random random = new Random();
       return random.nextInt(upper + 1) + lower;
    }

    public void array04(){
        int[][] ints = new int[8][8];

        int value = 1;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j] = value++;
            }
        }

        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i][i];
        }

        System.out.println("对角线平均值： " + sum / ints.length);

//        for (int[] anInt : ints) {
//            for (int i : anInt) {
//                System.out.println(i + " ");
//            }
//
//            System.out.println("\n");
//        }
    }





    /**
     * 求1 ~ 200 的质数（素数）
     */
    public void getPrime(){
        int primeNum = 0;
        boolean tag;

        for (int i=2;i<=200;i++){
            tag = true;

            for (int j=2;j<i;j++){
                if (i % j == 0){
                    tag = false;
                    break;
                }
            }

            if(tag){
                primeNum++;
                System.out.println(i + "\t");
            }
        }

        System.out.println("共有" + primeNum + "个素数");

    }

    /**
     * 暴力求最大公约数
     * @return
     */
    public int getSmallest(int num1,int num2){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("please:");
//        int num1 = scanner.nextInt();
//        System.out.println("please:");
//        int num2 = scanner.nextInt();

        int smallest = num1 < num2 ? num1:num2;

        while(smallest > 0){
            if (num1 % smallest == 0 && num2 % smallest == 0){
                System.out.println("最小公约数为 ：" + smallest);
                return smallest;
            }
            smallest--;
        }

//        int time = 0 ;
//        while (num1 % 2 == 0 && num2 % 2 == 0){
//            num1 /= 2;
//            num2 /= 2;
//
//            time++;
//        }
//
//        int tempt = (int) Math.pow(2, time);
//        int smallest = 1 > tempt?1:tempt;
//        System.out.println("Smallest = " + smallest);



        return smallest;
    }


    /**
     * 求最小公倍数LCM
     * @param num1
     * @param num2
     */
    public void getLCM(int num1,int num2){


        System.out.println("LCM:\t" + num2 * num1 / this.getSmallest(num1,num2));

    }

    public int inputNum(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please:");
        return scanner.nextInt();
    }


}
