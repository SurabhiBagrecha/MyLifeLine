
public class OperationFactory {

	 public Operation getOperation(String operationType){
	      if(operationType == null){
	         return null;
	      }		
	      if(operationType.equalsIgnoreCase("+")){
	         return new Add();
	         
	      } else if(operationType.equalsIgnoreCase("RECTANGLE")){
	         return new Substract();
	         
	      } else if(operationType.equalsIgnoreCase("SQUARE")){
	         return new Power();
	      }
	      else if(operationType.equalsIgnoreCase("SQUARE")){
		         return new Percentage();
		  }
	      
	      return null;
	   }
}
