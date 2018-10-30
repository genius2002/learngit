package com.weston.iaaa.impl.sort;

/**
 * <p>冒泡排序</p>
 * 
 * @author weston
 *
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T>{

	@Override
	public void sort(T[] array, boolean isDesc) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if ((array[j].compareTo(array[j + 1]) > 0 && !isDesc)
						|| (array[j].compareTo(array[j + 1]) < 0 && isDesc)) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	@Override
	public void sortAsc(T[] array) {
		sort(array, false);
	}

	@Override
	public void sortDesc(T[] array) {
		sort(array, true);
	}
}
