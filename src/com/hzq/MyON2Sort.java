package com.hzq;

import java.util.Arrays;

public class MyON2Sort {

    private static int[] targetArray = {99, 10, -1, 2, 3, -4, 6, 3, 10, -10};

    public static void main(String[] args) {
//        selectSort(targetArray);
//        bubbleSort(targetArray);
        insertSort(targetArray);
        System.out.println(Arrays.toString(targetArray));
    }


    //3.插入排序(相邻比较，每次插入后，当前数组就是有序的。对于已排序的数组效率很高)
    public static void insertSort(int[] A){
        int length = A.length;
        for (int i = 1; i < length; i++){
            if(A[i] < A[i-1]){
                //第i个带插入的元素先保存
                int temp = A[i];

                //处理从[0, i]的数组插入排序
                int j;//最后j的位置就是temp的位置
                for (j = i; j > 0 && temp < A[j-1]; j--){
                    A[j] = A[j-1];//将元素右移一个
                }
                A[j] = temp;
            }
        }
    }

    //2.冒泡排序(相邻交换，小的往上冒)
    public static void bubbleSort(int[] A){
        int length = A.length;
        for (int i = 0; i < length; i++){
            for (int j = length - 1; j > i; j--){
                if(A[j] < A[j-1]){
                    swap(A, j, j-1);
                }
            }
        }

    }

    //1.简单选择排序(选择minIndex，进行交换)
    public static void selectSort(int[] A){
        int length = A.length;
        for(int i = 0; i < length; i++){
            int minIndex = i;
            for(int j = i + 1; j < length; j++){
                if(A[j] < A[minIndex]){
                    minIndex = j;
                }
            }
            swap(A, i, minIndex);
        }
    }

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
