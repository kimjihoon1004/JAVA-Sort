package MergeSort;

public class MergeSort {
	
	/* 
	 * initList : 정렬할 list.
	 * mergedList : 정렬된 list.
	 * l = Start Index
	 * m = end Index of first list
	 * n = end Index of second list
	 */
	public void merge(int[] initList, int[] mergedList, int l, int m, int n)	{
		
		/*
		 * 초기화식은 i1 = l, i2 = m+1, iResult = l 이고, 
		 * 조건식은 i1의 값이 m의 값보다 작거나 같고, i2는 n보다 작거나 같을경우 이며,
		 * 증감식은 iResult가 1 증가하는 for 반복문이다. 
		 */
		int i1= l;
		int i2 = m+1;
		int iResult = l;
		for(; i1 <= m && i2 <= n; iResult++)	{
			
			/*
			 * initList의 i1번째 값이 i2번째 값보다 작거나 같으면 실행.
			 * mergedList의 iResult번째에 initList의 i1번째 값 대입.
			 * i1의 값 1증가.
			 */
			if(initList[i1] <= initList[i2])	{
				mergedList[iResult] = initList[i1];
				i1++;
			}
			
			/*
			 * initList의 i1번째 값이 i2번째 값보다 작거나 같지 않으면 실행.
			 * mergedList의 iResult번째에 initList의 i2번째 값 대입.
			 * i2의 값 1증가.
			 */
			else	{
				mergedList[iResult] = initList[i2];
				i2++;
			}
		}	
		
		/*
		 * i1의 값이 m의 값보다 크다면 실행.
		 * 초기화식은 t = i2 이고, 조건식은 t가 n보다 작거나 같을 경우 이며, 증감식은 t가 1 증가하는 for 반복문이다.
		 * mergedList의 (iResult + t - i2)번째에 initList의 t번째 값 대입.
		 */
		if(i1 > m)	{
			for(int t = i2; t <= n; t++)	{
				mergedList[iResult + t - i2] = initList[t];
			}
		}
		
		/*
		 * i1의 값이 m의 값보다 크지않다면 실행.
		 * 초기화식은 t = i1 이고, 조건식은 t가 m보다 작거나 같을 경우 이며, 증감식은 t가 1 증가하는 for 반복문이다.
		 * mergedList의 (iResult + t - i1)번째에 initList의 t번째 값 대입.
		 */
		else	{
			for(int t = i1; t <= m; t++)	{
				mergedList[iResult + t - i1] = initList[t];			
			}
		}	
	}
	
	/*
	 * initList : 정렬할 list.
	 * mergedList : 정렬된 list.
	 * n : initList의 갯수.
	 * l : 병합할 갯수.
	 */
	public void mergePass(int[] initList, int[] resultList, int n, int l)	{
		
		/*
		 * 초기화식은 i = 0 이고, 조건식은 i가 (n-2*l+1)보다 작거나 같아야 하며, 증감식은 i가 2*l씩 증가하는 for 반복문이다.
		 * merge(initList, resultList, i, i+l-1, i+2*l-1) 명령문 실행. 
		 */
		int i = 0;
		for(; i <= n-2*l+1; i += 2*l)	{
			merge(initList, resultList, i, i+l-1, i+2*l-1);
		}
		
		/*
		 * (i+l-1)의 값이 n보다 작다면 실행.
		 * merge(initList, resultList, i, i+l-1, n) 명령문 실행.
		 */
		if((i+l-1) < n)	{
			merge(initList, resultList, i, i+l-1, n);
		}
		
		/*
		 * (i+l-1)의 값이 n보다 크거나 같으면 실행.
		 * resultList의 t번째에 initList의 t번재 값 대입.
		 */
		else for(int t = i; t <= n; t++)	{
			resultList[t] = initList[t];
		}
	}
	
	/*
	 * list : 정수형 배열.
	 * n : 정수형 배열의 갯수.
	 * 정수형 배열 list와 list의 갯수를 이용한 mergeSort 명령문.
	 */
	public void mergeSort(int[] list, int n)	{
		/*
		 * 정수형 배열 tempList 생성.
		 * n개의 정수형 배열 tempList를 1추가 하므로 인덱스는 1부터 시작한다.
		 */
		int[] tempList = new int[n+1];
		
		/*
		 * 초기화식은 l = 1이고, 조건식은 l이 n보다 작을경우 이며, 증감식은 l이 2씩 곱해지는 for 반복문이다.
		 * mergePass(list, tempList, n , l)명령문 실행.
		 * l을 2 곱해준다.
		 * mergePass(tempList, list, n, l)명령문 실행.
		 */	
		for(int l = 1; l < n; l *= 2)	{
			mergePass(list, tempList, n, l);
			l*=2;
			mergePass(tempList, list, n, l);
		}
	
	}
	
	/*
	 * 배열 list의 값들을 출력하는 명령어.
	 */
	public void printList(int[] list) {
			
		/*
		 * i는 0번째값부터 list의 길이만큼 하나씩 증가하며,
		 * list의 i번째 값을 출력해주는 for반복문.
		 */
		for(int i = 0; i < list.length; i++)	{
			System.out.print(list[i]+ " ");
		}
		System.out.println();
	}
	
public static void main(String[] args)	{
		
		/*
		 * mergeSort(= 병합정렬)할 배열인 list를 생성.
		 */
		int[] list = {26, 5, 77, 1, 61, 11, 59, 15, 48, 19};
		
		/*
		 * 인스턴스 생성..
		 * MergeSort 생성자 호출.
		 * 참조값 merge.
		 */
		MergeSort merge = new MergeSort();
		
		/*
		 * mergeSort할 list와 list의 길이(배열의 인덱스는 0부터 시작함으로 -1)를 대입하여 mergeSort 실행.
		 * mergeSort를 수행한 list를 출력.
		 */
		merge.mergeSort(list, list.length-1);
		merge.printList(list);
	}
}
