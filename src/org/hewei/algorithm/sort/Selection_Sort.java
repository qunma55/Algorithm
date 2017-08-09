package org.hewei.algorithm.sort;

import java.util.Scanner;

public class Selection_Sort {

    public static void main(String[] args) {
        final int MAX = 1000;
        int n;
        int[] R = new int[MAX];

        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        for(int i = 0; i < n; i++) { R[i] = input.nextInt(); }

        selectionSort(R, n);
    }

    /**
     * 选择排序
     * @param R 数组
     * @param n 元素个数
     */
    private static void selectionSort(int[] R, int n) {
        int temp, sw = 0, minj;
        // i 表示未排序元素的下标最小的那个元素下标
        for(int i = 0; i < n - 1; i++) { // 由于最后两个元素交换位置，所以只需排到 n - 1
            minj = i; // 未排序部分最小元素的下标
            for(int j = i; j < n; j++) {
                if(R[j] < R[minj]) minj = j;
            }
            temp = R[i]; R[i] = R[minj];  R[minj] = temp;
            if(i != minj) sw++;
        }
        printArray(R, n);
        System.out.print(sw);
    }

    /**
     * 打印数组
     * @param R 数组
     * @param n 元素个数
     */
    private static void printArray(int[] R, int n) {
        for(int i = 0; i < n; ++i) {
            System.out.print(R[i] + " ");
        }
        System.out.println();
    }
}
