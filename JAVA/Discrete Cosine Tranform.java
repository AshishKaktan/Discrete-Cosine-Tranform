import java.util.*;
import java.math.*;

class DCT{
	
	static double[] c;
	static void init(){
		c=new double[32];
		for(int i=1;i<32;i++){
			c[i]=1.0;
		}
		c[0]=1/Math.sqrt(2.0);
	}
	
	static int [][] img_dct(int [][]in){
		
		int [][]result = new int[32][32];
		init();
		for(int u=0;u<32;u++){
			for(int v=0;v<32;v++){
				double sum=0.0;
								
				for(int i=0;i<32;i++){
					for(int j=0;j<32;j++){
						sum+=Math.cos(((2*i+1)/(2.0*32))*u*Math.PI)*Math.cos(((2*i+1)/(2.0/32))*v*Math.PI)*in[i][j];		
					}
				}
				sum=sum*((c[u]*c[v])/4.0);
				result[u][v]=sum;
			}
		}
		return result;
	}

	public static void main(String [] ar){
		
		Random rand = new Random();	
		int mean=0;
		String hash="";
		int [][] A = new int[32][32];
		int [][] res = new int[32][32];
		for(int i=0;i<32;i++){
			for(int j=0;j<32;j++){
				A[i][j] = rand.nextInt(255);
			}
		}
		res=img_dct(A);
	}
	
	
};
