
public class ArrayDequeue implements DequeInterface {
	
	private Object[] arr = (Object[]) new Object[1];
	private int num=0;
	
  public void insertFirst(Object o){
		if(arr.length!=num){
			for(int i=num-1;i>=0;i--){
			arr[i+1]=arr[i];
			}
			arr[0]=o;
		}
		else{
			Object[] arr1 = (Object[]) new Object[2*arr.length];
			for(int i=0;i<arr.length;i++){
				arr1[i+1]=arr[i];
			}
			arr1[0]=o;
			arr = arr1;
		}
		num++;
  
  }
  
  public void insertLast(Object o){
		if(arr.length!=num){
			arr[num]=o;
		}
		else{
			Object[] arr1 = (Object[]) new Object[2*arr.length];
			for(int i=0;i<arr.length;i++){
				arr1[i]=arr[i];
			}
			arr1[num]=o;
			arr = arr1;
		}
		num++;
    
  }
  
  public Object removeFirst() throws EmptyDequeException{
		if (num == 0)
			throw new EmptyDequeException("Nothing to remove");
		else {
			Object temp =arr[0];
			for(int i=0;i<num;i++){
				arr[i]=arr[i+1];
			}
			num--;
			return temp;
		}
  }
  
  public Object removeLast() throws EmptyDequeException{
	  		if (num == 0)
			throw new EmptyDequeException("Nothing to remove");
		else {
			num--;
			return arr[num];
		}
  }
  public Object first() throws EmptyDequeException{
		if (num == 0)
			throw new EmptyDequeException("Nothing to print");
		else {
			return arr[0];
		}
  }
  
  public Object last() throws EmptyDequeException{
	  		if (num == 0)
			throw new EmptyDequeException("Nothing to print");
		else {
			return arr[num-1];
		}
  }
  
  public int size(){
		return num;
  }
  public boolean isEmpty(){
		return num==0;
  }
  public String toString(){
	  String p = "[";
	  if(num>0){
	  p= p+ arr[0];
	  for(int i=1;i<num;i++){
		  p = p + ", "+arr[i];
	  }
	  }
	  p = p + "]";
	  return p;
  
  }
  
  
  public static void main(String[] args){
    int  N = 10;
    DequeInterface myDeque = new ArrayDequeue();
    for(int i = 0; i < N; i++) {
      myDeque.insertFirst(i);
      myDeque.insertLast(-1*i);
    }
   
    int size1 = myDeque.size();
    System.out.println("Size: " + size1);
    System.out.println(myDeque.toString());
    
    if(size1 != 2*N){
      System.err.println("Incorrect size of the queue.");
    }
    
    //Test first() operation
    try{
      int first = (int)myDeque.first();
      int size2 = myDeque.size(); //Should be same as size1
      if(size1 != size2) {
        System.err.println("Error. Size modified after first()");
      }
    }
    catch (EmptyDequeException e){
      System.out.println("Empty queue");
    }
    
    //Remove first N elements
    for(int i = 0; i < N; i++) {
      try{
        int first = (Integer)myDeque.removeFirst();
      }
      catch (EmptyDequeException e) {
        System.out.println("Cant remove from empty queue");
      }
      
    }
    
    
    int size3 = myDeque.size();
    System.out.println("Size: " + myDeque.size());
    System.out.println(myDeque.toString());
    
    if(size3 != N){
      System.err.println("Incorrect size of the queue.");
    }
    
    try{
      int last = (int)myDeque.last();
      int size4 = myDeque.size(); //Should be same as size3
      if(size3 != size4) {
        System.err.println("Error. Size modified after last()");
      }
    }
    catch (EmptyDequeException e){
      System.out.println("Empty queue");
    }
    
    //empty the queue  - test removeLast() operation as well
    while(!myDeque.isEmpty()){
        try{
          int last = (int)myDeque.removeLast();
        }
        catch (EmptyDequeException Object) {
          System.out.println("Cant remove from empty queue");
        }
    }
    
    int size5 = myDeque.size();
    if(size5 != 0){
      System.err.println("Incorrect size of the queue.");
    }
    
  }
  
}