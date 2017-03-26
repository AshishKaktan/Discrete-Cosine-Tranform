#include<bits/stdc++.h>
#define pi 3.141592653589

using namespace std;

int **img_dct(int in[8][8]){
	
	float gray,dct,sum=0.0,au=0.0,av=0.0,cosi,cosj,coen,coem;
	int **result = new int*[8];	
	
	for(int i=0;i<8;i++){
		result[i]=new int[8];
	}
	
	for(int u=0;u<8;u++){
		for(int v=0;v<8;v++){
					
			sum=0.0;
							
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
				
				if(i==0)
					au=1.0/sqrt(2.0);
				else
					au=1;
				if(j==0)
					av=1.0/sqrt(2.0);
				else
					av=(1.0);	
			
				gray = in[i][j];	
				cosi = cos((pi*u*(2*i+1))/16.0);
				cosj = cos((pi*v*(2*j+1))/16.0);
				
				dct=gray*cosi*cosj*au*av;
				
				sum+=dct;			
				}
			}
			coen=sqrt(1.0/8.0);
			coem=sqrt(2.0/8.0);
			result[u][v]=sum*coen*coem;
		  //string
		}
	}
	return result;
}

int main(){
	int A[8][8]= {{255,255,255,255,255,255,255,255},
	{255,255,255,255,255,255,255,255},
	{255,255,255,255,255,255,255,255},
	{255,255,255,255,255,255,255,255},
	{255,255,255,255,255,255,255,255},
	{255,255,255,255,255,255,255,255},
	{255,255,255,255,255,255,255,255},
	{255,255,255,255,255,255,255,255}};
	
	int **B;
	B=img_dct(A);

	for(int i=0;i<8;i++){
		for(int j=0;j<8;j++){
			cout<<B[i][j]<<" 	";
		}
		cout<<"\n";
	}
	
}
