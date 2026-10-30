# Stack---Matching-Delimiters.

## Description of the Program
Checks whether a sequence of delimiters ( ), [ ] and { } is properly matched and nested, using a stack. Displays each stack operation (push, peek, pop, isEmpty) and the stack contents after every step, then reports whether the sequence is valid or invalid and why.


The program has two Java files:

- **DelimiterChecker** Uses a stack to check whether the delimiters ( ), [ ] and { } in a sequence are properly matched and nested, and reports Valid or Invalid with the reason.
- **DelimiterCheckerTrace** Uses a stack to check whether the delimiters ( ), [ ] and { } in a sequence are properly matched and nested, and shows each stack operation step by step.

## Features
1. Multiple delimiter types: The program supports parentheses ( ), square brackets [ ] and curly braces { }.
2. Stack-based implementation: It applies the Last-In, First-Out (LIFO) principle. Each opening delimiter is pushed onto the stack, and each closing delimiter is compared against the top element.
3. Detection of improper nesting: Sequences such as ([)] and {[(])} are rejected because the closing delimiter does not match the most recent unmatched opening delimiter.
4. Detection of extra closing delimiters: An input such as {[()]}] is reported as invalid because the final closing delimiter has no corresponding opening delimiter.
5. Detection of unclosed delimiters: An input such as {[()] is reported as invalid because opening delimiters remain on the stack after processing.
6. Descriptive error reporting: For invalid input, the program states the reason, such as mismatched delimiters, a closing delimiter with no opener, or an unmatched opening delimiter.
7. Handling of non-delimiter characters: Letters, numbers and operators are ignored, so an expression such as ((a+b)*[c-d]) is correctly identified as valid.
8. Handling of empty input: An empty sequence is treated as valid.
9. Early termination on error: Processing stops at the first detected error, which avoids unnecessary computation.
10. Extensibility: Support for an additional pair, such as < >, requires modifying only the isOpening, isClosing and matches methods.
11. User input at runtime: The sequence to be checked is entered by the user through a Scanner.

## Output recursive search trace 
<img width="623" height="772" alt="image" src="https://github.com/user-attachments/assets/fe9085a3-ab68-49a1-bc7a-589f795096d8" />
<img width="691" height="453" alt="Screenshot 2026-10-31 030707" src="https://github.com/user-attachments/assets/f00f8d90-99c2-4b16-a9c0-9b15d649abba" />





