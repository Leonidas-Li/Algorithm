package com.example.myapplication;

import org.junit.Test;

/**
 * Created by lihuaqiang on 2020/8/30.
 * Description: 暂无
 * Other: 暂无
 */
public class Sort {

    public static int[] origin = new int[]{7, 8, 3, 2, 6, 5, 9, 0, 2, 1, 4, 5};

    @Test
    public void testBubbleUpSort() {
        for (int i = 0; i < origin.length - 1; i++) {
            for (int j = 0; j < origin.length - 1; j++) {
                if (origin[j] > origin[j + 1]) {
                    int temp = origin[j];
                    origin[j] = origin[j + 1];
                    origin[j + 1] = temp;
                }
            }
        }
        for (int i : origin) {
            System.out.println(i);
        }
    }

    @Test
    public void testQuickSort() {
        quickSort(origin, 0, origin.length - 1);
        for (int i : origin) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }

        int base = arr[left], i = left, j = right;
        while (i != j) {
            // 从右往左找，找 小于 base的数
            while (arr[j] >= base && i < j) {
                j--;
            }
            // 从左往右找，找 大于 base的数
            while (arr[i] <= base && i < j) {
                i++;
            }
            // 交换 大值 和 小值 位置
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 找到了 基准数 该放置的基准位置 i，讲基准数放到基准位置
        arr[left] = arr[i];
        arr[i] = base;

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    @Test
    public void testInsertSort() {
        for (int i = 1; i < origin.length; i++) {
            int base = origin[i]; // 将要插入的值
            int j = i - 1;
            while (j >= 0 && origin[j] > base) {
                origin[j + 1] = origin[j];
                j--;
            }
            // 找到了可以插入的位置j+1进行插入
            origin[j + 1] = base;
        }
        for (int i : origin) {
            System.out.println(i);
        }
    }

    @Test
    public void shellSort() {
        // 设置增量
        for (int gap = origin.length / 2; gap > 0; gap /= 2) {
            // 根据增量进行分组
            for (int i = 0; i < gap; i++) {
                // 对第i组进行直接插入排序
                int startIndex = i;
                for (int willInsert = i + gap; willInsert < origin.length; willInsert += gap) {
                    int willInertValue = origin[willInsert];
                    int j = willInsert - gap;
                    while (j >= startIndex && origin[j] > willInertValue) {
                        origin[j + gap] = origin[j];
                        j -= gap;
                    }
                    origin[j + gap] = willInertValue;
                }
            }
        }
        for (int i : origin) {
            System.out.println(i);
        }
    }
}
