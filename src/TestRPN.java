import java.util.Arrays;
import java.util.Stack;

public class TestRPN  {
	
	public void checkOperandType() {
		try{
			String data = "10,2,5,+,+";
			dataStack(data); 
			
		}catch(ArithmeticException ex)
		{
			System.out.println("");
		}
	       
	}
	
	
	private void dataStack(String data){
			String equation = data;
			if (equation == null)
				return ;
			
			Stack<String> tokens = new Stack<String>();
			tokens.addAll(Arrays.asList(equation.trim().split(",")));
			/*if (tokens.peek().equals(""))
				continue; // if tks equals nothing
*/			try {
				int r = evaluatePowerByRaviTeja(tokens);
				System.out.println("Final Value : "+r);// set the variable r to the
												// equation answer.
				if (!tokens.empty())
					throw new Exception(); // if the list is not empty, print
											// out answer.
				System.out.println(r);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	private static int evaluatePowerByRaviTeja(Stack<String> tks)
			throws Exception {
		String tk = tks.pop();
		int x, y; 
		double finalValue;
		try {
			try {
				x = Integer.parseInt(tk);
			} catch (Exception e) {
				if(!tk.equals("%")){
					y = evaluatePowerByRaviTeja(tks);
				}else{
					y = 100;
				}
				
				x = evaluatePowerByRaviTeja(tks);
				
				Operation operation = new Power();
				finalValue = operation.performOperation(x,y);
				x = (int)finalValue;
				System.out.println("final Value of power is  "+x);
				
				/*Operation operation = new Percentage();
				System.out.println("X "+x+" Y "+y);
				finalValue = operation.performOperation(x,y);
				x = (int)finalValue;
				System.out.println("final Value of percentege is  "+x);*/
				
				/*Operation operation = new Add();
				finalValue = operation.performOperation(x,y);
				x = (int)finalValue;
				System.out.println("final Value of Add is  "+x);*/
				
				/*if (tk.equals("^")) {
					double b = Math.pow(x, y);
					System.out.println("Power : " + b);
				}else if (tk.equals("+")){
					x += y;
				}else if (tk.equals("%"))
					x /= y;
				else {
					throw new Exception();
				}*/
			}

		} catch (Exception e) {
			throw new Exception();
		}
		return x;
	}
	
	public static void main(String args[]){
		new TestRPN().checkOperandType();
		
	}
	
 
}
