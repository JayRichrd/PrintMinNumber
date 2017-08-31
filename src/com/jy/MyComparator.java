package com.jy;

import java.util.Comparator;

/**
 * 自定义的比较器
 * 
 * @author jiangyu
 *
 */
public class MyComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		if (arg0 == null || arg1 == null)
			throw new IllegalArgumentException("Arg should not be null!");
		// 将两个字符串组合
		String s1 = arg0 + arg1;
		String s2 = arg1 + arg0;
		// 将组合后的比较结果作为两个字符串比较的结果返回
		return s1.compareTo(s2);
	}

}
