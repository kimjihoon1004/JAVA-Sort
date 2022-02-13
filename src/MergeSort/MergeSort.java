package MergeSort;

public class MergeSort {
	
	/* 
	 * initList : ������ list.
	 * mergedList : ���ĵ� list.
	 * l = Start Index
	 * m = end Index of first list
	 * n = end Index of second list
	 */
	public void merge(int[] initList, int[] mergedList, int l, int m, int n)	{
		
		/*
		 * �ʱ�ȭ���� i1 = l, i2 = m+1, iResult = l �̰�, 
		 * ���ǽ��� i1�� ���� m�� ������ �۰ų� ����, i2�� n���� �۰ų� ������� �̸�,
		 * �������� iResult�� 1 �����ϴ� for �ݺ����̴�. 
		 */
		int i1= l;
		int i2 = m+1;
		int iResult = l;
		for(; i1 <= m && i2 <= n; iResult++)	{
			
			/*
			 * initList�� i1��° ���� i2��° ������ �۰ų� ������ ����.
			 * mergedList�� iResult��°�� initList�� i1��° �� ����.
			 * i1�� �� 1����.
			 */
			if(initList[i1] <= initList[i2])	{
				mergedList[iResult] = initList[i1];
				i1++;
			}
			
			/*
			 * initList�� i1��° ���� i2��° ������ �۰ų� ���� ������ ����.
			 * mergedList�� iResult��°�� initList�� i2��° �� ����.
			 * i2�� �� 1����.
			 */
			else	{
				mergedList[iResult] = initList[i2];
				i2++;
			}
		}	
		
		/*
		 * i1�� ���� m�� ������ ũ�ٸ� ����.
		 * �ʱ�ȭ���� t = i2 �̰�, ���ǽ��� t�� n���� �۰ų� ���� ��� �̸�, �������� t�� 1 �����ϴ� for �ݺ����̴�.
		 * mergedList�� (iResult + t - i2)��°�� initList�� t��° �� ����.
		 */
		if(i1 > m)	{
			for(int t = i2; t <= n; t++)	{
				mergedList[iResult + t - i2] = initList[t];
			}
		}
		
		/*
		 * i1�� ���� m�� ������ ũ���ʴٸ� ����.
		 * �ʱ�ȭ���� t = i1 �̰�, ���ǽ��� t�� m���� �۰ų� ���� ��� �̸�, �������� t�� 1 �����ϴ� for �ݺ����̴�.
		 * mergedList�� (iResult + t - i1)��°�� initList�� t��° �� ����.
		 */
		else	{
			for(int t = i1; t <= m; t++)	{
				mergedList[iResult + t - i1] = initList[t];			
			}
		}	
	}
	
	/*
	 * initList : ������ list.
	 * mergedList : ���ĵ� list.
	 * n : initList�� ����.
	 * l : ������ ����.
	 */
	public void mergePass(int[] initList, int[] resultList, int n, int l)	{
		
		/*
		 * �ʱ�ȭ���� i = 0 �̰�, ���ǽ��� i�� (n-2*l+1)���� �۰ų� ���ƾ� �ϸ�, �������� i�� 2*l�� �����ϴ� for �ݺ����̴�.
		 * merge(initList, resultList, i, i+l-1, i+2*l-1) ��ɹ� ����. 
		 */
		int i = 0;
		for(; i <= n-2*l+1; i += 2*l)	{
			merge(initList, resultList, i, i+l-1, i+2*l-1);
		}
		
		/*
		 * (i+l-1)�� ���� n���� �۴ٸ� ����.
		 * merge(initList, resultList, i, i+l-1, n) ��ɹ� ����.
		 */
		if((i+l-1) < n)	{
			merge(initList, resultList, i, i+l-1, n);
		}
		
		/*
		 * (i+l-1)�� ���� n���� ũ�ų� ������ ����.
		 * resultList�� t��°�� initList�� t���� �� ����.
		 */
		else for(int t = i; t <= n; t++)	{
			resultList[t] = initList[t];
		}
	}
	
	/*
	 * list : ������ �迭.
	 * n : ������ �迭�� ����.
	 * ������ �迭 list�� list�� ������ �̿��� mergeSort ��ɹ�.
	 */
	public void mergeSort(int[] list, int n)	{
		/*
		 * ������ �迭 tempList ����.
		 * n���� ������ �迭 tempList�� 1�߰� �ϹǷ� �ε����� 1���� �����Ѵ�.
		 */
		int[] tempList = new int[n+1];
		
		/*
		 * �ʱ�ȭ���� l = 1�̰�, ���ǽ��� l�� n���� ������� �̸�, �������� l�� 2�� �������� for �ݺ����̴�.
		 * mergePass(list, tempList, n , l)��ɹ� ����.
		 * l�� 2 �����ش�.
		 * mergePass(tempList, list, n, l)��ɹ� ����.
		 */	
		for(int l = 1; l < n; l *= 2)	{
			mergePass(list, tempList, n, l);
			l*=2;
			mergePass(tempList, list, n, l);
		}
	
	}
	
	/*
	 * �迭 list�� ������ ����ϴ� ��ɾ�.
	 */
	public void printList(int[] list) {
			
		/*
		 * i�� 0��°������ list�� ���̸�ŭ �ϳ��� �����ϸ�,
		 * list�� i��° ���� ������ִ� for�ݺ���.
		 */
		for(int i = 0; i < list.length; i++)	{
			System.out.print(list[i]+ " ");
		}
		System.out.println();
	}
	
public static void main(String[] args)	{
		
		/*
		 * mergeSort(= ��������)�� �迭�� list�� ����.
		 */
		int[] list = {26, 5, 77, 1, 61, 11, 59, 15, 48, 19};
		
		/*
		 * �ν��Ͻ� ����..
		 * MergeSort ������ ȣ��.
		 * ������ merge.
		 */
		MergeSort merge = new MergeSort();
		
		/*
		 * mergeSort�� list�� list�� ����(�迭�� �ε����� 0���� ���������� -1)�� �����Ͽ� mergeSort ����.
		 * mergeSort�� ������ list�� ���.
		 */
		merge.mergeSort(list, list.length-1);
		merge.printList(list);
	}
}
