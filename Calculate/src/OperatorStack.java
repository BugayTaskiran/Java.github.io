//Alperen Bugay Taşkıran
public class OperatorStack {
    private char[] stack;
    private int top;

    public OperatorStack(int capacity) {
        stack = new char[capacity];
        top = -1;
    }

    public void push(char value) {
        if (top == stack.length - 1) {
            System.out.println("Error");
            return;
        }
        stack[++top] = value;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Error");
            return ' ';
        }
        return stack[top--];
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("Error");
            return ' ';
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }
}
