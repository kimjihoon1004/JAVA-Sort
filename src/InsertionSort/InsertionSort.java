package InsertionSort;

public class InsertionSort {	
	
	/*
	 * printArrays��
	 * a�迭�� �ϳ��� ����ϴ� ��ɾ�.
	 */
	public static void printArrays(int[] a)	{
		for(int i = 0; i < a.length; i++)	{
			System.out.print(a[i] + " ");
		}
	}
	
	/*
	 * sort��
	 * target�� ���� index�� ��ġ�ϱ� ������, �迭�� ������ �� index���� �����ϹǷ� (a�迭�� ���� - 1)�� �ݺ��Ǵ� for�ݺ���.
	 * target�� a[i]�� ������ ���� ���̾�� �ϹǷ� a[i+1]�� �����Ѵ�.
	 * ���� j�� �߰��� ������ i�����ε� ���� �� �� ������, for�ݺ����� ������ i �ϳ��̹Ƿ� ���� Ƚ���� �׸�ŭ �þ �ð��� �� �ҿ�Ǳ� �����̴�.
	 * ���� while�ݺ����� ���� j�� ����Ͽ� a�迭�� �ε����� ������ ���� �ٲ��ش�.
	 * target�� �� index�� ��Һ� �� j�� �ϳ��� �����Ͽ� 0�� index���� ���� ��Ҹ� �����ش�.
	 * while �ݺ����� ��� �����ٸ�, target�� ��ġ�� [j+1]��°�� �ٲ��ش�.
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
	 * ���๮
	 */
	public static void main(String[] args)	{
		int array[] = {7, 3, 2, 8, 9, 4, 6, 1, 5};
		
		sort(array);
		/*System.out.println("1");*/
		printArrays(array);
		
	}
}
