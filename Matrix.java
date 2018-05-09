import java.math.BigInteger;
import java.util.List;

/**
 * 矩阵类
 * @author admin
 *
 * @param <T>
 */
public class Matrix<T extends Number> {
	private Object[][] data;
	public Object[][] getData() {
		return data;
	}
	public void setData(Object[][] data) {
		this.data = data;
		this.row=data.length;
		this.column=data.length==0?0:data[0].length;
	}
	private int row;
	private int column;
	public Matrix(int row,int column){
		this.row=row;
		this.column=column;
		this.data=new Object[row][column];
		
	}
	public Matrix() {
		
	}
	
	public Matrix<BigInteger> multiply(Matrix<BigInteger> otherMatrix){
		Matrix<BigInteger> product=new Matrix<>(this.row, otherMatrix.column);
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<otherMatrix.column;j++) {
				product.data[i][j]=new BigInteger("0");
				for(int k=0;k<this.column;k++) {
					product.data[i][j]=((BigInteger)product.data[i][j]).add(((BigInteger)this.data[i][k]).multiply((BigInteger)otherMatrix.data[k][j]));
				}
			}
		}
		return product;
	}
	
	public Matrix<T> multiply(Matrix<T> otherMatrix,Class clazz){
		Matrix<T> product=new Matrix<>(this.row, otherMatrix.column);
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<otherMatrix.column;j++) {
				product.data[i][j]=(int)0;
				for(int k=0;k<this.column;k++) {
					if(BigInteger.class.equals(clazz)) {
						product.data[i][j]=((BigInteger)product.data[i][j]).add(((BigInteger)this.data[i][k]).multiply((BigInteger)otherMatrix.data[k][j]));
					}else {
						product.data[i][j]=(Integer)product.data[i][j]+(Integer)this.data[i][k]*(Integer)otherMatrix.data[k][j];
					}
					
				}
			}
		}
		return product;
	}
	
	/**
	 * 矩阵加法
	 * @param otherMatrix
	 * @param clazz
	 * @return
	 */
	public Matrix<T> add(Matrix<T> otherMatrix,Class clazz){
		Matrix<T> sum=new Matrix<>(this.row,this.column);
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<otherMatrix.column;j++) {
				sum.data[i][j]=(int)0;
				if(clazz.equals(BigInteger.class)) {
					sum.data[i][j]=((BigInteger)this.data[i][j]).add((BigInteger)otherMatrix.data[i][j]);
				}else {
					sum.data[i][j]=(Integer)this.data[i][j]+(Integer)otherMatrix.data[i][j];
				}
			}
		}
		return sum;
	}
	
	
	public void print() {
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.column;j++) {
				System.out.print(this.data[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
}
