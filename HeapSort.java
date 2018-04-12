/**
 * @Title HeapSort
 * @Description TODO
 * @author chruixu
 * @date 2018年04月12日 10:58
 * @version V1.0
 * @see 
 * @since V1.0
 * 
 */
public class HeapSort {
    public static void main ( String[] args ) {
        int[] a={0,1,4,2,5,6,5,3,3};
        //maxHeapAdjust ( a, 1, a.length-1 );
        //buildMaxHeap ( a, a.length-1 );
        heapsort ( a, a.length-1 );
        for ( int i : a ) {
            System.out.println ( i );
        }
    }
    /*
     * 堆排序
     */
    public static void heapsort(int[] a,int heapsize){
        buildMaxHeap ( a, heapsize );
        int max=a[1];
        a[1]=a[heapsize];
        a[heapsize]=max;
        for(int i=heapsize-1;i>0;i--){
            maxHeapAdjust ( a, 1, i );
            max=a[1];
            a[1]=a[i];
            a[i]=max;  
        }
        
    }
    /*
     * 建立一个大顶堆
     */
    private static void buildMaxHeap(int[] a,int heapsize){
        for(int i=heapsize/2;i>0;i--){
            maxHeapAdjust ( a, i, heapsize );
        }
    }
    /*
     * 调整结点i,使满足大顶堆的性质
     */
    private static void maxHeapAdjust(int[] a, int i,int heapsize){
        int left=2*i;
        int right=2*i+1;
        int key=a[i];
        int largest=i;
        if(left<=heapsize&&key<a[left]){
            largest=left;
        }
        if(right<=heapsize&&a[right]>a[largest]){
            largest=right;
        }
        if(largest!=i){
            int temp=a[i];
            a[i]=a[largest];
            a[largest]=temp;
            maxHeapAdjust ( a, largest, heapsize );
        }
        
    }
}
