package BubbleSort;

public class BubbleSort {
	
	/*
	 * swap��
	 * �迭 array�� a��°�� a+1��°�� ���� �ٲ��ִ� ��ɾ�.
	 */
	public static void swap(int array[], int a)	{
		int temp = array [a+1];
		array[a+1] = array[a];
		array[a] = temp;
	}

	/*
	 * sort��
	 * �迭 a�� j��°(�Ǿ�)���� i����(�ǵ�)���� ������ ���� ��(j+1)��  ũ�⸦ ���Ͽ� �տ� ��(j)�� �� ũ�� swap���ִ� ��ɾ�.
	 * i�� ���� �ϳ��� �۾����� ������ ��� �񱳸� �ϸ� ���� ū ���� �� �ڿ� ���� ������ �� �̻� ���� �ʿ䰡 ���� �����̴�.
	 */
	public static void sort(int[] a)	{
		for(int i = a.length-1; i > 0; i--)	{
			for(int j = 0; j < i; j++)	{
				if(a[j] > a[j+1])	{
					swap(a,j);
				}
			}
		}
	}	
	
	/*
	 * printArrays��
	 * �迭�� ���� ������ִ� ��ɾ�.
	 */
	public static void printArrays(int[] a)	{
		for(int i = 0; i < a.length; i++)	{
			System.out.print(a[i] + " ");
		}
	}

	/*
	 * ���๮
	 */
	public static void main(String[] args)	{	
		int[] a = {9,2,7,8,1,10,3};
		sort(a);
		printArrays(a);
	}
}
