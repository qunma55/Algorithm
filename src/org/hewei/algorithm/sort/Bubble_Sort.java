package org.hewei.algorithm.sort;

import java.util.Scanner;
public class Bubble_Sort {
    public static void main(String[] args) {
        final int MAX = 1000;
        int n;
        int[] R = new int[MAX];

        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        for(int i = 0; i < n; i++) { R[i] = input.nextInt(); }

        System.out.print(bubbleSort(R, n));
    }

    /**
     * 冒泡排序
     * @param R 数组
     * @param n 元素个数
     */
    private static int bubbleSort(int[] R, int n) {
        Boolean flag = true; // 存在顺序相反的相邻元素
        int i = 0; // 已排序的下标
        int sw = 0; // 反序数
        while(flag) {
            flag = false;
            for(int j = n-1 ; j > i ; j--) {
                if(R[j] < R[j - 1]) {
                    int temp = R[j];
                    R[j] = R[j-1];
                    R[j-1] = temp;
                    sw++;
                    flag = true; // 如果元素（最后一个值）不需要和任何一个值交换，结束排序
                }
            }
        }

        printArray(R, n);
        return sw;
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
