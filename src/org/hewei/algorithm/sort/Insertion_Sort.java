package org.hewei.algorithm.sort;


import java.util.Scanner;

public class Insertion_Sort {
    public static void main(String[] args) {

        final int MAX = 1000;

        int n;
        int[] R = new int[MAX];

        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        for(int i = 0; i < n; i++) { R[i] = input.nextInt(); }

        insertionSort(R, n);

    }

    /**
     * 插入排序
     * @param R 数组
     * @param n 元素个数
     */
    private static void insertionSort(int[] R, int n) {
        for(int i = 1; i < n; i++) {
            // 缓存插入的值
            int v = R[i];
            // 从要插入值的上一个位置开始处理
            int j = i - 1;
            while (j >= 0 && R[j] > v) {
                R[j+1] = R[j];
                j--;
            }
            R[j+1] = v;
            printArray(R, n);
        }
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
