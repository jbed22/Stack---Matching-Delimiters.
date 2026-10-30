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

public class DelimiterCheckerTrace {

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

    static void showStack(Stack<Character> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack: empty");
            return;
        }
        System.out.print("Stack:");
        for (char c : stack) {
            System.out.print(" " + c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sequence: ");
        String text = input.nextLine();
        System.out.println("\nInput: " + text + "\n");

        Stack<Character> stack = new Stack<>();
        String reason = "";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (isOpening(c)) {
                System.out.println("Read: " + c);
                stack.push(c);
                System.out.println("Operation: PUSH " + c);
                showStack(stack);
                System.out.println();
            } else if (isClosing(c)) {
                System.out.println("Read: " + c);
                if (stack.isEmpty()) {
                    reason = "closing delimiter '" + c + "' has no matching opening delimiter";
                    System.out.println("Operation: ISEMPTY -> true");
                    System.out.println("INVALID: " + reason);
                    break;
                }
                char top = stack.peek();
                System.out.println("Operation: PEEK -> " + top);
                if (matches(top, c)) {
                    stack.pop();
                    System.out.println("Operation: POP " + top);
                    showStack(stack);
                    System.out.println();
                } else {
                    reason = "mismatched delimiters: '" + top + "' is on top but '" + c + "' was read";
                    System.out.println("INVALID: " + reason);
                    break;
                }
            }
        }

        if (reason.isEmpty() && !stack.isEmpty()) {
            reason = "unmatched opening delimiter remains";
            System.out.println("INVALID: " + reason);
        }

        System.out.println();
        if (reason.isEmpty()) {
            System.out.println("Result: Valid");
        } else {
            System.out.println("Result: Invalid - " + reason);
        }
        input.close();
    }
}
