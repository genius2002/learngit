package com.weston.iaaa.arithmetic.inf.sort;

public interface ISort<T extends Comparable<T>> {
	/**
	 * @param array
	 *            array to be sorted
	 * @param isAsc
	 *            false  : sort in ascdnding order true: sort in
	 *            decreasing order
	 */
	void sort(T[] array, boolean isDesc);
	void sortAsc(T[] array);
	void sortDesc(T[] array);
}
