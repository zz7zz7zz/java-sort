package com.sort.insertion;

public class SortInsert {

	/*
	 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
要点：设立哨兵，作为临时存储和判断数组边界之用。

如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的。

时间复杂度：O（n^2）.

其他的插入排序有二分插入排序，2-路插入排序
	 */
	public static void InsertSort(int []array , int length)
	{
			for(int i=1;i<array.length;i++)
			{
				if(array[i]<array[i-1])
				{
						int tmp=array[i];
						int j;
						for (j =i-1; j >=0; --j)
						{
							if(array[j]>tmp)//向后移动
							{
								array[j+1] = array[j];
							}
							else
							{
								break;
							}
						}
						array[j+1]=tmp;
				}
				else
				{
					//插入即可
				}
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
		pArray(array);
		InsertSort(array,array.length);
		pArray(array);

	}

}
