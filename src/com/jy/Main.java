package com.jy;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		int[] numbers = new int[] { 3, 32, 321, 1 };
		int numbersLength = numbers.length;
		String[] array = new String[numbersLength];
		// 将数字转换合成字符
		for (int i = 0; i < numbersLength; i++)
			array[i] = numbers[i] + "";

		System.out.println("输入的数组元素:" + Arrays.toString(numbers));
		System.out.println("他们组合而成的最小数:" + printMinNumber(array));
	}

	/**
	 * 将输入数组中的元素组合成数字，找到最小的数
	 * 
	 * @param array
	 *            输入的数组
	 * @return 以字符串的形式返回最小数
	 */
	public static String printMinNumber(String[] array) {
		int arrayLength = array.length;
		if (array == null || arrayLength < 1)
			throw new IllegalArgumentException("Arg must contain value!");
		// 定义自定义的比较器
		MyComparator comparator = new MyComparator();
		// 使用自定义的快速排序
		quickSort(array, 0, arrayLength - 1, comparator);
		// 按照顺序提取数组的每个元素，然后拼接成结果返回
		StringBuilder minSB = new StringBuilder();
		for (String string : array)
			minSB.append(string);
		return minSB.toString();
	}

	/**
	 * 用自定义的比较器实现的一个快速排列
	 * 
	 * @param array
	 *            待排列的数组
	 * @param start
	 *            数组中即将进行排列的开始位置
	 * @param end
	 *            数组中即将进行排列的结束位置
	 * @param comparator
	 *            比较器
	 */
	public static void quickSort(String[] array, int start, int end, Comparator<String> comparator) {
		// 只有当子序列的元素大于1个时才进行排序，否则结束
		if (start < end) {
			// 默认以为第一个元素作为分界值
			int base = start;
			// 定义从头、尾开始查找的索引
			int i = start;
			int j = end + 1;
			while (i < j) {
				// 从头往尾查找大于分界值的元素索引
				while (comparator.compare(array[base], array[++i]) >= 0 && i < end)
					;
				// 从尾往头查找小于分界值的元素索引
				while (comparator.compare(array[base], array[--j]) <= 0 && j > start)
					;
				if (i < j)
					swap(array, i, j);
			}
			// 交换后变成真正的分界点
			// 因为默认的分界点选择的是头部，所以这里只能将base和j交换
			swap(array, base, j);
			// 递归左边、右边的子序列
			quickSort(array, start, j - 1, comparator);
			quickSort(array, j + 1, end, comparator);
		}
	}

	/**
	 * 交换数组中两个元素的值
	 * 
	 * @param array
	 *            待操作的数组
	 * @param i
	 *            其中一个待交换元素的索引
	 * @param j
	 *            另一个待交换元素的索引
	 */
	public static void swap(String[] array, int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
