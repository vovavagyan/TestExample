import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    private static final char PARENTHESIS_OPEN = '(';
    private static final char SQUARE_BRACKET_OPEN = '[';
    private static final char CURLY_BRACE_OPEN = '{';
    private static final char PARENTHESIS_CLOSE = ')';
    private static final char SQUARE_BRACKET_CLOSE = ']';
    private static final char CURLY_BRACE_CLOSE = '}';

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        System.out.println(isBracketSequenceCorrect(line));
    }

    /**
     * Validates brackets correctness from string
     * If bracket sequence is not correct, then this method returns false, unless returns true
     *
     * @param line string should contain sequence of various brackets (from "{[(])}", it could contain any text inside)
     * @return bool that means if input bracket sequence was correct or not
     */
    public static boolean isBracketSequenceCorrect(String line){
        char[] charLine = line.toCharArray();
        Stack<Character> stackBracket = new Stack<>();
        char lastBracket = ' ';
        for (char ch: charLine) {
                if (ch == SQUARE_BRACKET_OPEN || ch == CURLY_BRACE_OPEN || ch == PARENTHESIS_OPEN) stackBracket.push(ch);
                else if (ch == SQUARE_BRACKET_CLOSE || ch == CURLY_BRACE_CLOSE || ch == PARENTHESIS_CLOSE) {
                    if(stackBracket.size() == 0) return false;
                    lastBracket = stackBracket.peek();
                    if ((lastBracket == PARENTHESIS_OPEN && ch == PARENTHESIS_CLOSE) || (lastBracket == SQUARE_BRACKET_OPEN && ch == SQUARE_BRACKET_CLOSE) || (lastBracket == CURLY_BRACE_OPEN && ch == CURLY_BRACE_CLOSE)) stackBracket.pop();
                    else return false;
                }
        }
        if (stackBracket.size() == 0) return true;
        return false;
    }

}
