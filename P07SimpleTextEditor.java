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
