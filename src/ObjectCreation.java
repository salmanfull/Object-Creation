import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectCreation {
      public static void main(String args[]){
    	  Car car1 = new Car();     // Using new 
    	  System.out.println(car1);
    	  
    	  try{
    		 Car car2 = (Car) car1.clone();     // Using clone to create 
    		 System.out.println(car2);
    	  }catch(CloneNotSupportedException e){
    		  
    	  }
    	  try{
    	  Car car3 =(Car) Class.forName("Car").newInstance();   //Using reflection
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
    		objectOS.writeObject(car4);
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
