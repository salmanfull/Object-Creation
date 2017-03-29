import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectCreation {
      public static void main(String args[]){
    	  Car car1 = new Car();     // Method 1 : Using new 
    	  System.out.println(car1);
    	  
    	  try{
    		 Car car2 = (Car) car1.clone();     //  Method 2 :Using clone to create 
    		 System.out.println(car2);
    	  }catch(CloneNotSupportedException e){
    		  
    	  }
    	  try{
    	  Car car3 =(Car) Class.forName("Car").newInstance();   // Method 3 :Using reflection
    	  System.out.println(car3);
    	  }
    	  catch(Exception e){
    		  
    	  }
    	  
    	  Car car4 = new Car();
    	  FileOutputStream fileOS = null;
    	  ObjectOutputStream objectOS = null;
    	  try{
    	     fileOS = new FileOutputStream("car.ser");                 
    		objectOS = new ObjectOutputStream(fileOS);
    		objectOS.writeObject(car4);                         // Method 4 : Serializing object to the file
    		objectOS.close();
    	  }
    	  catch(Exception e){
    		e.printStackTrace();
    	  }
    	  FileInputStream fileIS = null;
          ObjectInputStream objectIS = null;
          try{
        	  fileIS = new FileInputStream("car.ser");
              objectIS = new ObjectInputStream(fileIS);

              Car car5 = (Car) objectIS.readObject(); // de-serializes the car object from file

              objectIS.close();
              System.out.println(car5);
     	  }
     	  catch(Exception e){
     		 e.printStackTrace();
     	  }
      }
}
