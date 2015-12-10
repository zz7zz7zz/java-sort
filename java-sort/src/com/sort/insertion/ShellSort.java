package com.sort.insertion;

/*
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序
 */
public class ShellSort {

	public static void shellSort(int []array )
	{
		int d=array.length;
		while(true)
		{
			d=d/2;
			
			for (int x = 0; x < d; x++) 
			{
				for (int i = x+d; i < array.length; i=i+d)
				{

					if(array[i]<array[i-d])
					{
						int tmp=array[i];
						int j;
						for ( j = i-d; j >=0; j=j-d) 
						{
							if(array[j]>tmp)//向后移动
							{
								array[j+d] = array[j];
							}
							else
							{
								break;
							}
						}
						array[j+d]=tmp;
					}
				}
			}
			
			if(d==1)
			{
				break;
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
		shellSort(array);
		pArray(array);

	}

}
