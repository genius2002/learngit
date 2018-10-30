package com.weston.iaaa;

import com.weston.iaaa.impl.sort.BubbleSort;
import com.weston.iaaa.impl.sort.HeapSort;
import com.weston.iaaa.impl.sort.InsertionSort;
import com.weston.iaaa.impl.sort.MergeSort;
import com.weston.iaaa.impl.sort.QuickSort;
import com.weston.iaaa.util.RandomUtil;

public class MainTester {
	public static void main(String[] args) {
		Integer[] randomOrder = RandomUtil.getInstance().getRandomArray(1000000);
		// String[] randomOrder = {"c","a","b"};
		boolean isDesc = false;
		InsertionSort insertionSort = new InsertionSort();
		MergeSort mergeSort = new MergeSort();
		BubbleSort bubbleSort = new BubbleSort();
		QuickSort quickSort = new QuickSort();
		HeapSort heapSort = new HeapSort();
		// System.out.println(Arrays.toString(randomOrder));

		// heap sort
		Integer[] heapArray = copy(randomOrder);
		long begin = System.currentTimeMillis();
		quickSort.sort(heapArray, isDesc);
		System.out.println("Sorted array uisng heap sort cost:[" + (System.currentTimeMillis() - begin) + "]");

		// quick sort
		Integer[] quickArray = copy(randomOrder);
		begin = System.currentTimeMillis();
		quickSort.sort(quickArray, isDesc);
		System.out.println("Sorted array uisng quick sort cost:[" + (System.currentTimeMillis() - begin) + "]");
		// System.out.println(Arrays.toString(quickArray));

//		// insertion sort
//		Integer[] insArray = copy(randomOrder);
//		begin = System.currentTimeMillis();
//		insertionSort.order(insArray, isDesc);
//		System.out.println("Sorted array uisng insretion sort cost:[" + (System.currentTimeMillis() - begin) + "]");
//		// System.out.println(Arrays.toString(insArray));

		// merger sort
		Integer[] mergArray = copy(randomOrder);
		begin = System.currentTimeMillis();
		mergeSort.sort(mergArray, isDesc);
		System.out.println("Sorted array uisng merger sort cost:[" + (System.currentTimeMillis() - begin) + "]");
		// System.out.println(Arrays.toString(insArray));

//		// bubble sort
//		Integer[] bubArray = copy(randomOrder);
//		begin = System.currentTimeMillis();
//		bubbleSort.order(bubArray, isDesc);
//		System.out.println("Sorted array uisng bubble sort cost:[" + (System.currentTimeMillis() - begin) + "]");
//		// System.out.println(Arrays.toString(bubArray));
	}

	public static Integer[] copy(Integer[] randomOrder) {
		Integer[] result = new Integer[randomOrder.length];
		System.arraycopy(randomOrder, 0, result, 0, randomOrder.length);
		return result;
	}
}
