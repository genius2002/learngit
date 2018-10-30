package com.weston.iaaa.impl.sort;

public class QuickSort<T extends Comparable<T>> extends AbstractSort<T>{

	@Override
	public void sortAsc(T[] array) {
		order(array, false);
	}

	@Override
	public void sortDesc(T[] array) {
		order(array, true);
	}

	@Override
	public void order(T[] array, boolean isDesc) {
		sort(array, 0, array.length - 1, isDesc);
	}

	private boolean canSwitch(T l, T h, boolean isDesc) {
		if (l.compareTo(h) > 0 && !isDesc) {
			return true;
		} else if (l.compareTo(h) < 0 && isDesc) {
			return true;
		} else {
			return false;
		}

	}

	private void sort(T arr[], int low, int high, boolean isDesc) {
		int l = low;
		int h = high;
		T povit = arr[low];
		// System.out.println("Povit:"+povit);
		while (l < h) {
			while (l < h && canSwitch(arr[h], povit, isDesc)) {
				h--;
			}
			if (l < h) {
				T temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
			}
			// System.out.println("-"+Arrays.toString(arr));
			while (l < h && canSwitch(povit, arr[l], isDesc)) {// arr[l] <=
																// povit
				l++;
			}
			if (l < h) {
				T temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				h--;
			}
			// System.out.println("-"+Arrays.toString(arr));
		}
		if (l > low) {
			sort(arr, low, l - 1, isDesc);
		}

		if (h < high) {
			sort(arr, l + 1, high, isDesc);
		}
	}
}
