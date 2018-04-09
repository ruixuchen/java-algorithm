
package com.crx.qichacha;

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
    public static void main ( String[] args ) {
        SortAlgorithm<Integer> sortAlgorithm=new SortAlgorithm<Integer> ();
        Integer[] b={1,4,2,6,3,1,100,99,88};
        sortAlgorithm.selectionSortRecursive ( b, 0, b.length );
        for ( Integer integer : b ) {
            System.out.println ( integer );
        }
    }
}
