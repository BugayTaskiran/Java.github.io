//Alperen Bugay Taşkıran
public class OperandStack {
    private double[] stack;
    private int top;

    public OperandStack(int capacity) {
        stack = new double[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(double item) {
        if (top == stack.length - 1) {
            System.out.println("Error");
            return;
        }
        stack[++top] = item;
    }

    public double pop() {
        if (isEmpty()) {
            System.out.println("Error");
            return Double.MIN_VALUE;
        }
        return stack[top--];
    }

    public double peek() {
        if (isEmpty()) {
            System.out.println("Error");
            return Double.MIN_VALUE;
        }
        return stack[top];
    }

    public int size() {
        return top + 1;
    }
}
