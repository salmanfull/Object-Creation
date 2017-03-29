import java.io.Serializable;

public class Car implements Cloneable, Serializable {
  private String color;
  private String manufacture;
  
  public Car(){
	  color = "Red";
	  manufacture = "BMW";
  }
  
  public String getColor(){
	  return color;
  }
  
  public String getManufacturer(){
	  return manufacture;
  }
  
  public String toString(){
	    return "This car is in " + color + " color and manufactured by " + manufacture;
  }
  
  public Object clone() throws CloneNotSupportedException {
      return super.clone();
  }
}
