import java.io.*;
import java.util.*;

public class RPNCalc {
	public static void main(String[] args) {

		String fileName = "D:/RPNInput.txt";
		String fileName2 = "RPNOutput.txt";
		Scanner inputStream = null;
		PrintWriter outputStream = null;

		// read
		try {
			inputStream = new Scanner(new File(fileName)); // try to open the
															// file
		} catch (Exception e) {
			System.out.println("Could not open the file named " + fileName); // if
																				// it
																				// doesn't
																				// find
																				// it,
																				// tell
																				// them
			System.exit(0); // and then exit.
		}

		// write
		try {
			outputStream = new PrintWriter(
					new FileOutputStream(fileName2, true)); // try to create the
															// file
		} catch (Exception e) {
			System.out.println("Could not open the file named " + fileName2); // if
																				// it
																				// doesn't
																				// find
																				// it,
																				// tell
																				// them
			System.exit(0); // and then exit.
		}

		while (inputStream.hasNextLine()) {
			String equation = inputStream.nextLine();
			if (equation == null)
				break;
			Stack<String> tokens = new Stack<String>();
			tokens.addAll(Arrays.asList(equation.trim().split("[ \t]+"))); // remove
																			// spaces
																			// and
																			// split
																			// into
																			// list.
			if (tokens.peek().equals(""))
				continue; // if tks equals nothing
			try {
				int r = evaluaterpn(tokens); // set the variable r to the
												// equation answer.
				if (!tokens.empty())
					throw new Exception(); // if the list is not empty, print
											// out answer.
				System.out.println(r);
			} catch (Exception e) {
				System.out.println("error");
			}
		}
	}

	private static int evaluaterpn(Stack<String> tks) throws Exception {
		String tk = tks.pop();
		int x, y;
		try {
			x = Integer.parseInt(tk);
		} catch (Exception e) {
			y = evaluaterpn(tks);
			x = evaluaterpn(tks);
			if (tk.equals("+")){
				x += y;
			}
			else if (tk.equals("-")){
				x -= y;
			}
			else if (tk.equals("*")){
				x *= y;
			}
			else if (tk.equals("/"))
				x /= y;
			else if (tk.equals("%"))
				x %= y;
			else if (tk.equals("^"))
				x ^= y;
			else
				throw new Exception();
		}
		return x;
	}
}