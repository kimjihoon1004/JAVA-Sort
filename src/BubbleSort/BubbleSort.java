package BubbleSort;

public class BubbleSort {
	
	/*
	 * swap문
	 * 배열 array의 a번째와 a+1번째의 값을 바꿔주는 명령어.
	 */
	public static void swap(int array[], int a)	{
		int temp = array [a+1];
		array[a+1] = array[a];
		array[a] = temp;
	}

	/*
	 * sort문
	 * 배열 a의 j번째(맨앞)부터 i번쨰(맨뒤)까지 다음에 오는 값(j+1)과  크기를 비교하여 앞에 값(j)이 더 크면 swap해주는 명령어.
	 * i의 값이 하나씩 작아지는 이유는 대소 비교를 하면 가장 큰 값이 맨 뒤에 오기 때문에 더 이상 비교할 필요가 없기 때문이다.
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
	 * printArrays문
	 * 배열의 값을 출력해주는 명령어.
	 */
	public static void printArrays(int[] a)	{
		for(int i = 0; i < a.length; i++)	{
			System.out.print(a[i] + " ");
		}
	}

	/*
	 * 실행문
	 */
	public static void main(String[] args)	{	
		int[] a = {9,2,7,8,1,10,3};
		sort(a);
		printArrays(a);
	}
}
