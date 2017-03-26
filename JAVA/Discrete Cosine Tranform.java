import java.util.*;
import java.math.*;

class DCT{
	
	static int [][] img_dct(int [][]in){
		
		double gray=0,dct=0,sum=0,au=0,av=0,cosi=0,cosj=0,coen=0,coem=0,pi=3;
		int [][]result = new int[32][32];
	
		for(int u=0;u<32;u++){
			for(int v=0;v<32;v++){
					
				sum=0.0;
								
				for(int i=0;i<32;i++){
					for(int j=0;j<32;j++){
						
					if(i==0)
						au=1/Math.sqrt(2);
					else
						au=1;
					if(j==0)
						av=1/Math.sqrt(2);
					else
						av=(1);			
							
					gray = in[i][j];	
					cosi = Math.cos((pi*u*(2*i+1))/64);
					cosj = Math.cos((pi*v*(2*j+1))/64);
					
					dct=gray*cosi*cosj*au*av;
					sum+=dct;			
					}
				}
				coen=Math.sqrt(0.015625);
				coem=Math.sqrt(0.03125);
				result[u][v]=(int)(sum*coen*coem);
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