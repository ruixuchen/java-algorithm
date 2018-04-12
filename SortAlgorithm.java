/**
 * @Title SortAlgorithm
 * @Description TODO
 * @author chruixu
 * @date 2018年04月09日 13:27
 * @version V1.0
 * @see 
 * @since V1.0
 * 
 */
public class SortAlgorithm<T extends Comparable<T>> {
    
    /*
     * 选择排序
     */
    public void selectionSort(T[] a,int start,int end){
        for(int i=start;i<end-1;i++){
            int posMin=i;
            for(int j=i+1;j<end;j++){
                if(a[j].compareTo ( a[posMin] )<0){
                    posMin=j;
                }
            }
            T temp=a[i];
            a[i]=a[posMin];
            a[posMin]=temp;
        }
    }
    /*
     * 基于递归的选择排序
     */
    public void selectionSortRecursive(T[] a,int start,int end){
        if(start<end){
            int posMin=start;
            for(int i=start+1;i<end;i++){
                if(a[i].compareTo ( a[posMin] )<0){
                    posMin=i;
                }
            }
            T temp=a[start];
            a[start]=a[posMin];
            a[posMin]=temp;
            selectionSortRecursive ( a, start+1, end );    
        }
    }
    /*
     * 插入排序
     */
    public static void insertionSort(int[] a,int start,int end){
        for(int i=start+1;i<=end;i++){
            int key=a[i];
            int j=i-1;
            while(j>=start&&a[j]>key){
                a[j+1]=a[j];
                j--;
            }
            j++;
            a[j]=key;     
        }
    }
    /*
     * 基于递归的插入排序
     */
    public static void insertionSortRecursive(int[] a,int start,int end){       
        if(end>=start){           
            insertionSortRecursive ( a, start, end-1 );
            int j=end-1;
            int key=a[end];
            while(j>=start&&a[j]>key){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
    }
    
    /*
     * 冒泡排序
     */
    public void bubbleSort(T[] a,int start,int end){
        for(int i=start;i<end;i++){
            for(int j=start;j<end-i-1;j++){
                if(a[j].compareTo ( a[j+1] )>0){
                   T temp=a[j+1];
                   a[j+1]=a[j];
                   a[j]=temp;
                }
            }
        }
    }
    /*
     * 基于递归的冒泡排序
     */
    public void bubbleSortRecursive(T[] a,int start,int end){
        if(end>start){
            for(int i=start;i<end-1;i++){
                if(a[i].compareTo ( a[i+1] )>0){
                    T temp=a[i+1];
                    a[i+1]=a[i];
                    a[i]=temp;
                }
            }
            bubbleSortRecursive ( a, start, end-1 );
        }
    }
    
    /*
     * 归并排序
     */
    public void mergeSortRecursive(int[] a,int start,int end){
        if(end>start){
            int middle=(start+end)/2;
            mergeSortRecursive ( a, start, middle );
            mergeSortRecursive ( a, middle+1, end );
            merge ( a, start, middle, end );
        }
    }
    
    private void merge(int[] a,int start,int middle,int end){
        int[] a1=new int[middle-start+1+1];//多一位是哨兵位
        for(int i=0;i<middle-start+1+1;i++){
            a1[i]=a[start+i];
        }
        int[] a2=new int[end-middle+1];
        for(int i=0;i<end-middle;i++){
            a2[i]=a[middle+i+1];
        }
        a1[middle-start+1]=Integer.MAX_VALUE;
        a2[end-middle]=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        for(int k=start;k<=end;k++){
            if(a1[i]<a2[j]){
                a[k]=a1[i];
                i++;
            } else{
                a[k]=a2[j];
                j++;
            }
        }
    }
    
    public static void main ( String[] args ) {
        SortAlgorithm<Integer> sortAlgorithm=new SortAlgorithm<Integer> ();
        Integer[] b={1,4,2,6,3,1,100,99,88};
        sortAlgorithm.selectionSortRecursive ( b, 0, b.length );
        for ( Integer integer : b ) {
            System.out.println ( integer );
        }
    }
}
