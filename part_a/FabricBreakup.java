import java.util.*;
import java.io.*;
import java.util.Scanner;

class Stacks
{

public int t=-1;
public int [] S;

public void New(int N){
 S = new int[N];	
}

public void Push(int o){
	
	t=t+1;
	S[t]=o;

}

public int Top()throws EmptyStackException{
	if(IsEmpty()){
	throw new EmptyStackException();
	}
	else{
	return S[t];
	}
}


public int Pop() throws EmptyStackException{
	if(IsEmpty()){
	throw new EmptyStackException();
	}
	else{
	t=t-1;
	return S[t+1];
	}
}

public boolean IsEmpty(){

	return t==-1;
}

public int Size(){

	return t+1;
}

}

public class FabricBreakup{
	
	
	public static void main(String args[]){
	
	try{
	FileInputStream fstream = new FileInputStream(args[0]);

	Scanner s = new Scanner(fstream);

	int N = s.nextInt();
	
	Stacks Stack = new Stacks();
	int[][] a = new int[N][3];
	
	for(int i=0;i<N;i++){
		a[i][0] = s.nextInt();
		a[i][1] = s.nextInt();
		if(a[i][1]==1){
			a[i][2] = s.nextInt();
		}
	}
	
	
	
	Stack.New(N);
	
int max = 0;
int t=0;
int[] MAX = new int[N];
int l=0;


	for(int i=0;i<N;i++){
		if(a[i][1]==1){
			

			if(max==0){
				max = a[i][2];
				MAX[0]=max;
				l++;
				t=0;
				Stack.Push(t);
				
			}
			
			else if(a[i][2]>=MAX[l-1]){
				max = a[i][2];
				MAX[l]=max;
				l++;
				t=0;
				Stack.Push(t);
				
			}
			else if(a[i][2]<MAX[l-1]){
				t = Stack.Pop()+1;
				Stack.Push(t);
				
			}
			
		}
		else if(a[i][1]==2){
			int j = i+1;
			int k=0;
			if(Stack.IsEmpty()){
				k = -1;
			}
			else{
				k= Stack.Pop();
			}
		System.out.println(j+ " " + k);

		l--;
		if(l==-1){
			l=0;
			max=0;
		}
		
		}
	}
	

	} catch(FileNotFoundException e){
		System.out.println("Error: FIle Not Found");
	}


}



}
