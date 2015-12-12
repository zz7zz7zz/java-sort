package com.sort.exchange;

//交换排序:冒泡排序
public class SortBubble {

	//传统冒泡排序
	public static void sortBubble(int [] array)
	{
		for(int i=0; i<array.length; i++)
		{
			for(int j=i+1; j<array.length; j++)
			{
				if(array[i] > array[j])
				{			
					array[i] = array[i] ^ array[j];
					array[j] = array[j] ^ array[i];
					array[i] = array[i] ^ array[j];
				}
			}
		}
	}

	//优化过的冒泡排序1：
	//设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可。
	public static void sortBubble2(int [] array)
	{
		int last_check_index=array.length-1;
		while(last_check_index>0)
		{
			int last_swap_index=0;
			for(int j=0; j<last_check_index; j++)
			{
				if(array[j] > array[j+1])
				{  
					last_swap_index = j;
					array[j] = array[j] ^ array[j+1];
					array[j+1] = array[j+1] ^ array[j];
					array[j] = array[j] ^ array[j+1];
				}
			}
			last_check_index=last_swap_index;
		}
	}

	//优化过的冒泡排序2：
	//传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值,我们考虑利用在每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) , 从而使排序趟数几乎减少了一半。
	public static void sortBubble3(int [] array)
	{
		int low=0;
		int high=array.length -1;
		
		while(low<high)
		{
			for(int i =low;i<high;i++)
			{
				if(array[i]>array[i+1])
				{
					array[i] = array[i] ^ array[i+1];
					array[i+1] = array[i+1] ^ array[i];
					array[i] = array[i] ^ array[i+1];
				}
			}
			--high;
			
			for(int j =high;j>low; --j)
			{
				if(array[j] < array[j-1])
				{
					array[j] = array[j] ^ array[j-1];
					array[j-1] = array[j-1] ^ array[j];
					array[j] = array[j] ^ array[j-1];
				}
			}
			++low;		
		}
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
		
//		sortBubble(array);
//		sortBubble2(array);
		sortBubble3(array);
		
		pArray(array);		
	}
}
