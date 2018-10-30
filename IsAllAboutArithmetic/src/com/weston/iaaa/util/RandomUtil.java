package com.weston.iaaa.util;

public class RandomUtil {

	private RandomUtil() {

	}

	public int[] getRandomArrayB(int length) {
		int[] numbers = new int[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = (int) (Math.random() * 100);
		}
		return numbers;
	}
	
	public Integer[] getRandomArray(int length) {
		Integer[] numbers = new Integer[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = (int) (Math.random() * 100);
		}
		return numbers;
	}

	public static RandomUtil getInstance() {
		return InstanceHolder.instance;
	}

	private static class InstanceHolder {
		private static RandomUtil instance = new RandomUtil();
	}
}
