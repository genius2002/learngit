package com.weston.iaaa.impl.sort;

import java.util.Arrays;

import com.weston.iaaa.util.RandomUtil;

public class HeapSort<T extends Comparable<T>> extends AbstractSort<T> {

	private int left(int n) {
		return 2 * n + 1;
	}

	private int right(int n) {
		return 2 * n + 2;
	}

	/**
	 * 构建大根堆
	 * 
	 * @param n
	 * @param data
	 */
	private void buildHeap(int n, T[] data,boolean isDesc) {
		if(isDesc) {
			for (int i = data.length / 2 - 1; i >= 0; i--) {
				adjustHeapMT(data, i, data.length);
			}
		}else {
			for (int i = data.length / 2 - 1; i >= 0; i--) {
				adjustHeapBT(data, i, data.length);
			}
		}
	}

	/**
	 * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
	 * 
	 * @param arr
	 * @param i
	 * @param length
	 */
	public void adjustHeapBT(T[] arr, int i, int length) {
		T temp = arr[i];// 先取出当前元素i
		for (int k = left(i); k < length; k = left(k)) {// 从i结点的左子结点开始，也就是2i+1处开始
			if (k + 1 < length && arr[k].compareTo(arr[right(i)]) < 0) {// 如果左子结点小于右子结点，k指向右子结点
				k++;
			}
			if (arr[k].compareTo(temp) > 0) {// 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
				arr[i] = arr[k];
				i = k;
			} else {
				break;
			}
		}
		arr[i] = temp;// 将temp值放到最终的位置
	}
	
	/**
	 * 调整小顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
	 * 
	 * @param arr
	 * @param i
	 * @param length
	 */
	public void adjustHeapMT(T[] arr, int i, int length) {
		T temp = arr[i];// 先取出当前元素i
		for (int k = left(i); k < length; k = left(k)) {// 从i结点的左子结点开始，也就是2i+1处开始
			if (k + 1 < length && arr[k].compareTo(arr[right(i)]) >0) {// 如果左子结点大于右子结点，k指向右子结点
				k++;
			}
			if (arr[k].compareTo(temp) < 0) {// 如果子节点小于父节点，将子节点值赋给父节点（不用进行交换）
				arr[i] = arr[k];
				i = k;
			} else {
				break;
			}
		}
		arr[i] = temp;// 将temp值放到最终的位置
	}

	public static void main(String[] args) {
		Integer[] randomOrder = RandomUtil.getInstance().getRandomArray(10);
		System.out.println(Arrays.toString(randomOrder));
		HeapSort<Integer> stackSort = new HeapSort<Integer>();
		stackSort.sortAsc(randomOrder);
		System.out.println(Arrays.toString(randomOrder));
	}

	@Override
	public void order(T[] array, boolean isDesc) {
		if (isDesc) {
			sortDesc(array);
		} else {
			sortAsc(array);
		}
	}

	@Override
	public void sortAsc(T[] array) {
		buildHeap(10, array,true);
		for (int j = array.length - 1; j > 0; j--) {
			swap(array, 0, j);// 将堆顶元素与末尾元素进行交换
			adjustHeapMT(array, 0, j);// 重新对堆进行调整
		}
	}

	public void swap(T[] arr, int a, int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	@Override
	public void sortDesc(T[] array) {
		buildHeap(10, array,false);
		for (int j = array.length - 1; j > 0; j--) {
			swap(array, 0, j);// 将堆顶元素与末尾元素进行交换
			adjustHeapBT(array, 0, j);// 重新对堆进行调整
		}
	}

}
