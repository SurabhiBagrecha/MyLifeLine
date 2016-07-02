
public class FactoryPatternDemo {

		   public static void main(String[] args) {
			  // int x=""
			   
			   OperationFactory operationFactory = new OperationFactory();

		      //get an object of Circle and call its draw method.
		      Operation operationAdd = operationFactory.getOperation("+");

		      //call draw method of Circle
		      //operationAdd.add();

		      //get an object of Rectangle and call its draw method.
		      Operation operationSubs = operationFactory.getOperation("-");

		      //call draw method of Rectangle
		     // operationSubs.sustract();

		      //get an object of Square and call its draw method.
		      Operation operationPower = operationFactory.getOperation("^");

		      //call draw method of circle
		      //operationPower.power();
		      Operation operationPerc = operationFactory.getOperation("%");

		      //call draw method of circle
		     // operationPerc.percentage();
		   }
		}

