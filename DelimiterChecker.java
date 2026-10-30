/* Description: Checks whether a sequence of delimiters ( ), [ ] and { } is
   properly matched and nested, using a stack. Displays each stack operation
   (push, peek, pop, isEmpty) and the stack contents after every step, then
   reports whether the sequence is valid or invalid and why.

   Programmed by: Lamayon Eduardo Jr. BSIT CN 48079-CC104
   DATA STRUCTURES AND ALGORITHMS

   Last Modified: 10/29/26

   Version: 2.0

   Acknowledgements: Generative AI used (Claude by Anthropic). Prompt: "debug
   and explain a stack-based matching delimiters."
*/
import java.util.Scanner;
import java.util.Stack;

public class DelimiterChecker {

    static boolean isOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    static boolean isClosing(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    static boolean matches(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sequence: ");
        String text = input.nextLine();

        Stack<Character> stack = new Stack<>();
        String reason = "";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (isOpening(c)) {
                stack.push(c);
            } else if (isClosing(c)) {
                if (stack.isEmpty()) {
                    reason = "closing delimiter '" + c + "' has no matching opening delimiter";
                    break;
                }
                char top = stack.peek();
                if (matches(top, c)) {
                    stack.pop();
                } else {
                    reason = "mismatched delimiters: '" + top + "' is on top but '" + c + "' was read";
                    break;
                }
            }
        }

        if (reason.isEmpty() && !stack.isEmpty()) {
            reason = "unmatched opening delimiter remains";
        }

        if (reason.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid - " + reason);
        }
        input.close();
    }
}
