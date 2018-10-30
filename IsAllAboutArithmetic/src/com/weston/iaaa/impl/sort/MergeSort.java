package com.weston.iaaa.impl.sort;

/**
 * <p>整合排序</p>
 * 
 * @author weston
 *
 * @param <T>
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {

	@Override
	public void sortAsc(T[] array) {
		sort(array, false);
	}

	@Override
	public void sortDesc(T[] array) {
		sort(array, true);
	}

	@Override
	public void sort(T[] array, boolean isDesc) {
		mergesort(array, 0, array.length - 1, isDesc);
	}

	/**
	 * * A Java method to implement MergeSort algorithm using recursion
	 * 
	 * @param input
	 *            integer array to be sorted
	 * @param start
	 *            index of first element in array
	 * @param end
	 *            index of last element in array
	 */
	private void mergesort(T[] input, int start, int end, boolean isDesc) {
		// break problem into smaller structurally identical problems
		int mid = (start + end) / 2;
		// System.out.println("start:"+start+";end:"+end+";mid;"+mid);
		// if there still more than one member in the array then keep break
		if (start < end) {
			mergesort(input, start, mid, isDesc);
			mergesort(input, mid + 1, end, isDesc);
		}
		// System.out.println(Arrays.toString(input));
		// merge solved pieces to get solution to original problem
		int i = 0, seq1 = start, seq2 = mid + 1;
		T[] tmp =(T[]) new Comparable[end - start +1]; 
		while (seq1 <= mid && seq2 <= end) {
			if (isDesc) {
				tmp[i++] = input[seq1].compareTo(input[seq2]) > 0 ? input[seq1++] : input[seq2++];
			} else {
				tmp[i++] = input[seq1].compareTo(input[seq2]) < 0 ? input[seq1++] : input[seq2++];
			}
		}
		while (seq1 <= mid) {
			tmp[i++] = input[seq1++];
		}
		while (seq2 <= end) {
			tmp[i++] = input[seq2++];
		}
		i = 0;
		while (start <= end) {
			input[start++] = tmp[i++];
		}
	}
}
