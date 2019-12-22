package com.datastructures.assignment.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class CheckBrackets {
	
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        System.out.println(isBalanced(text));
    }

	protected static String isBalanced(String text) {
		Stack<Bracket> bracketStack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
            	 bracketStack.push(new Bracket(next, position+1));
            	 continue;
            }

            if (next == ')' || next == ']' || next == '}') {
            	 if(bracketStack.isEmpty()) {
                 	return "1";
                 }
                 Bracket top = bracketStack.pop();
                 if(!top.Match(next)) {
                 	return String.valueOf(position+1);
                 }
            }
        }
        return bracketStack.isEmpty()?"Success":"1";
	}
	

}
