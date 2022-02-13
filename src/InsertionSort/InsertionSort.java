package InsertionSort;

public class InsertionSort {	
	
	/*
	 * printArrays문
	 * a배열을 하나씩 출력하는 명령어.
	 */
	public static void printArrays(int[] a)	{
		for(int i = 0; i < a.length; i++)	{
			System.out.print(a[i] + " ");
		}
	}
	
	/*
	 * sort문
	 * target이 다음 index에 위치하기 때문에, 배열의 마지막 전 index까지 가야하므로 (a배열의 길이 - 1)번 반복되는 for반복문.
	 * target은 a[i]의 다음에 오는 값이어야 하므로 a[i+1]로 설정한다.
	 * 변수 j를 추가한 이유는 i만으로도 실행 할 수 있지만, for반복문의 변수가 i 하나이므로 실행 횟수가 그만큼 늘어나 시간이 더 소요되기 때문이다.
	 * 따라서 while반복문을 변수 j를 사용하여 a배열의 인덱스에 대입해 값을 바꿔준다.
	 * target과 현 index와 대소비교 후 j를 하나씩 감소하여 0번 index까지 값의 대소를 비교해준다.
	 * while 반복문이 모두 끝났다면, target의 위치는 [j+1]번째로 바꿔준다.
	 */
	public static void sort(int[] a)	{
		for(int i = 0; i < a.length-1; i++)	{
			int target = a[i+1];
			int j = i;
			
			while(j >= 0 && target < a[j])	{
				/*System.out.println("!!!");*/
				a[j+1] = a[j];
				j--;
			}
			
			a[j+1] = target;
		}
	}
	
	/*
	 * 실행문
	 */
	public static void main(String[] args)	{
		int array[] = {7, 3, 2, 8, 9, 4, 6, 1, 5};
		
		sort(array);
		/*System.out.println("1");*/
		printArrays(array);
		
	}
}
