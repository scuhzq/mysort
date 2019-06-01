package com.hzq;

import java.util.Arrays;

/***
 * 1. mergeSort递归划分
 * 2. merge 合并两个子数组
 * 3. 当low < high时，才继续mergeSort划分
 * 4. 三个while循环，处理合并两个子数组
 */
public class MyMergeSort {

    private static int[] targetArray = {99, 10, -1, 2, 3, -4, 6, 3, 10, -10};

    public static void main(String[] args) {
        mergeSort(targetArray, 0, targetArray.length - 1);
        System.out.println(Arrays.toString(targetArray));
    }

    //划分
    public static void mergeSort(int[] A, int low, int high){
        //当low < high时才处理
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            merge(A, low, high);
        }
    }

    //对数组[low, mid] [mid+1, high]进行归并
    public static void merge(int[] A, int low, int high){
        int[] tempArray = new int[high - low + 1];
        int i = low;
        int mid = (low + high) / 2;
        int j = mid + 1;
        int tempIndex = 0;

        while (i <= mid && j <= high){
            if(A[i] <= A[j]){
                tempArray[tempIndex++] = A[i++];
            } else {
                tempArray[tempIndex++] = A[j++];
            }
        }

        while (i <= mid){
            tempArray[tempIndex++] = A[i++];
        }

        while (j <= high){
            tempArray[tempIndex++] = A[j++];
        }

        //复制tempArray到A的指定位置
        int start = low;
        for(int x = 0; x < tempArray.length; x++){
            A[start++] = tempArray[x];
        }
    }
}
