# SimpleTextEditor-
Implement 4 types of commands related to manipulating the text:     • "1 {string}" - appends [string] to the end of the text.     • "2 {count}" - erases the last [count] elements from the text.     • "3 {index}" - returns the element at position [index] from the text.     • "4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation.
package StacksAndQueues.Exc;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] operations = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(operations[0]);

            switch (command) {

                case 1:
                    String string = operations[1];
                    text.append(string);
                    stack.push(text.toString());
                    break;
                case 2:
                    int index = text.length() - Integer.parseInt(operations[1]);
                    text.delete(index, text.length());
                    stack.push(text.toString());
                    break;
                case 3:
                    index = Integer.parseInt(operations[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;
                case 4:
                    stack.pop();
                    String currentText = stack.peek();
                    text.delete(0, text.length());
                    if (currentText != null) {
                        text.append(currentText);
                    }
                    break;
            }

        }
    }
}
