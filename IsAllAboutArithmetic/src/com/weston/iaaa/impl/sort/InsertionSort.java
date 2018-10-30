package com.weston.iaaa.impl.sort;

/**
 * <p>插入排序</p>
 * 
 * @author weston
 *
 * @param <T>
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSort<T> {

	@Override
	public void sortAsc(T[] array) {
		orderAsc(array);
	}

	@Override
	public void sortDesc(T[] array) {
		orderDesc(array);
	}

	@Override
	public void sort(T[] array, boolean isDesc) {
		if (isDesc) {
			orderDesc(array);
		} else {
			orderAsc(array);
		}
	}

	private void orderAsc(T[] array) {
		// insertion sort starts from second element
		for (int i = 1; i < array.length; i++) {
			T numberToInsert = array[i];
			Integer compareIndex = i;
			while (compareIndex > 0 && array[compareIndex - 1].compareTo(numberToInsert) > 0) {
				array[compareIndex] = array[compareIndex - 1]; // shifting element
				compareIndex--; // moving backwards, towards index 0
			} // compareIndex now denotes proper place for number to be sorted
			array[compareIndex] = numberToInsert;
		}
	}

	private void orderDesc(T[] array) {
		// insertion sort starts from second element
		for (int i = array.length - 1; i > 0; i--) {
			T numberToInsert = array[i - 1];
			Integer compareIndex = i - 1;
			// System.out.println("number2insert:[ "+numberToInsert+"
			// ];compareIndex:[ "+compareIndex+" ];");
			while (compareIndex < array.length - 1 && array[compareIndex + 1].compareTo(numberToInsert) > 0) {
				array[compareIndex] = array[compareIndex + 1]; // shifting element
				compareIndex++; // moving backwards, towards index 0
			} // compareIndex now denotes proper place for number to be sorted
			array[compareIndex] = numberToInsert;
			// System.out.println(Arrays.toString(array));
		}
	}
}
