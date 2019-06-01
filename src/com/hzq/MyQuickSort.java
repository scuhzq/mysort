package com.hzq;

import java.util.Arrays;

public class MyQuickSort {

    private static int[] targetArray = {99, 10, -1, 2, 3, -4, 6, 3, 10, -10};

    public static void main(String[] args) {
        quickSort(targetArray, 0, targetArray.length - 1);
        System.out.println(Arrays.toString(targetArray));
    }

    public static void quickSort(int[] A, int low, int high){
        if(low > high){
            return;
        }

        int i = low;
        int j = high;
        int pivotValue = A[low];

        while (i < j){
            //先从右边看，找到一个小于基准值的j
            while (A[j] >= pivotValue && i < j){
                j--;
            }
            while (A[i] <= pivotValue && i < j){
                i++;
            }

            if(i < j){
                swap(A, i, j);
            }
        }
        //将基准与右边的j交换
        swap(A, low, j);
        quickSort(A, low, j - 1);
        quickSort(A, j + 1, high);
    }

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
