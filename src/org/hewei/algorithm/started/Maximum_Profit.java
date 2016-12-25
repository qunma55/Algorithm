package org.hewei.algorithm.started;

import java.util.Scanner;

/**
 *      外汇交易可以通过兑换不同国家的货币赚取汇率差。比如1美元兑换100日元
 * 时购入1000美元，然后等到汇率变成108日元时再卖出，这样就可以赚取（108 - 100） * 1000
 * 日元。
 *      现在请将货币在t时刻的价格R(t)(t = 0, 1, 2, 3, ...) 作为输入数据，
 * 计算出 R(j) - R(i) 的最大值。
 * 输入：第一行输入整数n，接下来n行依次给整数R(t)（t = 1,2,..,n-1）赋值。
 * 输出：在单独一行输出最大值。
 * 限制：2 <= n <= 200 000, 1 <= R(t) <= 10^8
 */
public class Maximum_Profit {
    public static void main(String[] args) {

        final int MAX = 200000;

        int[] R = new int[MAX];
        int n;

        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        for(int i = 0; i < n; i++) { R[i] = input.nextInt(); }

        int maxv = -2000000000;
        int minv = R[0];

        for( int i = 1; i < n; i++) {
            maxv = max(maxv, R[i] - minv); // 更新最大差值
            minv = min(minv, R[i]); // 缓存现阶段最小值
        }

        System.out.print(maxv);
    }

    private static int max(int a, int b) { return a > b ? a : b; }

    private static int min(int a, int b) { return a < b ? a : b; }
}
