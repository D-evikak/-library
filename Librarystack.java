package librarystack;
public class Stack {
  private int arr[];
    private int top;
    private int capacity;

    // Constructor 1: Empty stack with given size
    public Stack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    // Constructor 2: 
    public Stack(int[] inputArr) {
        capacity = inputArr.length;
        arr = new int[capacity];
        top = -1;
        for (int val : inputArr) {
            arr[++top] = val;
        }
    }

    // Push single element
    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow!");
            return;
        }
        arr[++top] = x;
    }

    // Overloaded Push: Push 2 elements
    public void push(int x, int y) {
        push(x);
        push(y);
    }

    // Pop single element
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return arr[top--];
    }

    // Overloaded Pop: Pop n elements
    public void pop(int n) {
        for (int i = 0; i < n; i++) {
            int val = pop();
            if (val != -1) {
                System.out.println("Popped: " + val);
            } else break;
        }
    }

    // Display entire stack
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack contents (bottom to top):");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Overloaded Display: Show top n elements
    public void display(int n) {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        if (n > top + 1) n = top + 1;
        System.out.println("Top " + n + " elements:");
        for (int i = top; i > top - n; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

import java.util.Scanner;
public class LibraryStackDemo {

	public static void main(String[] args) {
		
		        Scanner sc = new Scanner(System.in);
		        Stack st = null;

		        System.out.println("Choose how to initialize stack:");
		        System.out.println("1. Empty stack with size");
		        System.out.println("2. Stack initialized with array");
		        int choice = sc.nextInt();

		        if (choice == 1) {
		            System.out.print("Enter size of stack: ");
		            int size = sc.nextInt();
		            st = new Stack(size);
		        } else if (choice == 2) {
		            System.out.print("Enter number of elements: ");
		            int n = sc.nextInt();
		            int arr[] = new int[n];
		            System.out.println("Enter elements: ");
		            for (int i = 0; i < n; i++) {
		                arr[i] = sc.nextInt();
		            }
		            st = new Stack(arr);
		        }

		        int option;
		        do {
		            System.out.println("\n--- Stack Menu ---");
		            System.out.println("1. Push one element");
		            System.out.println("2. Push two elements");
		            System.out.println("3. Pop one element");
		            System.out.println("4. Pop multiple elements");
		            System.out.println("5. Display full stack");
		            System.out.println("6. Display top n elements");
		            System.out.println("7. Exit");
		            System.out.print("Enter your choice: ");
		            option = sc.nextInt();

		            switch(option) {
		                case 1:
		                    System.out.print("Enter element: ");
		                    int val = sc.nextInt();
		                    st.push(val);
		                    break;

		                case 2:
		                    System.out.print("Enter two elements: ");
		                    int v1 = sc.nextInt();
		                    int v2 = sc.nextInt();
		                    st.push(v1, v2);
		                    break;

		                case 3:
		                    int popped = st.pop();
		                    if (popped != -1) {
		                        System.out.println("Popped: " + popped);
		                    }
		                    break;

		                case 4:
		                    System.out.print("Enter number of elements to pop: ");
		                    int n = sc.nextInt();
		                    st.pop(n);
		                    break;

		                case 5:
		                    st.display();
		                    break;

		                case 6:
		                    System.out.print("Enter number of top elements: ");
		                    int topN = sc.nextInt();
		                    st.display(topN);
		                    break;

		                case 7:
		                    System.out.println("Exiting...");
		                    break;

		                default:
		                    System.out.println("Invalid choice!");
		            }
		        } while(option != 7);

		        sc.close();
		    }
		}

	