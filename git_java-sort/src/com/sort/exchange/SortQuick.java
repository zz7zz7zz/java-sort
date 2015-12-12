package com.sort.exchange;

//交换排序—快速排序（Quick Sort）
/*
 * 1）选择一个基准元素,通常选择第一个元素或者最后一个元素,

2）通过一趟排序讲待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小。另一部分记录的 元素值比基准值大。

3）此时基准元素在其排好序后的正确位置

4）然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。
 */
//http://blog.csdn.net/hguisu/article/details/7776068
public class SortQuick {

	public static void quickSort(int []array , int low , int high)
	{
		if(low < high)
		{
			int middle = partition(array,low, high);
//			int middle = partition2(array,low, high);
//			System.out.println("middle:"+middle);
			quickSort(array, low, middle-1);
			quickSort(array, middle+1,high );
		}
	}
	
	public static int partition(int []array , int low , int high)
	{	
		int baseElement=array[low];
		while(low < high)
		{
				while(low < high && array[high] >= baseElement)
				{
					--high;
				}
				if(array[low]!=array[high])//一定是要两个不相等的数才可以交换
				{
					array[low] =  array[low] ^ array[high];
					array[high] = array[high] ^ array[low];
					array[low] =  array[low] ^ array[high];
				}
								
				while(low < high && array[low] <= baseElement)
				{
					++low;
				}
				if(array[low]!=array[high])
				{
					array[low] =  array[low] ^ array[high];
					array[high] = array[high] ^ array[low];
					array[low] =  array[low] ^ array[high];
				}			
		}
		
		return low;
	}
	
	
	public static int partition2(int []array , int low , int high)
	{
		int baseElement=array[low];
		while(low < high)
		{
				while(low < high && array[high] >= baseElement)
				{
					--high;
				}
				array[low] = array[high];
								
				while(low < high && array[low] <= baseElement)
				{
					++low;
				}
				array[high] = array[low];
		}
		
		array[low]=baseElement;
		return low;
	}
	
	public static void pArray(int []array)
	{
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<array.length; i++)
		{
			sb.append(" ").append(array[i]);
		}
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		
		
		int [] array={5,3,9,1,7,2,4,8,6};
		pArray(array);
		quickSort(array,0,array.length-1);
		pArray(array);
	}

}
