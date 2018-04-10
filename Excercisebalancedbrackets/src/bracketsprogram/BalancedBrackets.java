package bracketsprogram;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args){
        final String invalidString = "INVALID";
        final String yseString = "YES";
        final String noString = "NO";
        System.out.println("INPUT:");
        System.out.println("\nEnter the number of inputs to check:");

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<String> outputArrayList = new ArrayList<>();
        // get the number of lines of string
        int n = scanner.nextInt();

        // checking the boundary value for number of lines of string
        // constraint no.1 (1 ≤ n ≤ 10 3)
        if (n >= 1 && n <= 1000) {
            // get the input strings and store it in the ArrayList
            while (n >= 1) {
                String s = scanner.next();
                // constraint no.2 (1 ≤ len s ≤ 10 3 , where len s is the length of the sequence)
                if (s.length() >= 1 && s.length() <= 1000) {
                    // regular expression to check if the input has only brackets
                    String brackets = "/(/)/{/}\\[\\]";
                    // use matches() fuction to check validity of above regex
                    // constraint no.3 (Each character in the sequence will be a bracket (i.e., { , } , ( , ) , [ , and ] ))
                    if (s.matches("[" + brackets + "]+")) {
                        stringArrayList.add(s);
                    } else {
                        // add place holder for invalid input
                        stringArrayList.add(invalidString);
                    }
                    n--;
                }
            }
            
            System.out.println("\nOUPUT Is:\n");
            // Logic for checking Balanced Brackets
            for (String input : stringArrayList) {
                Stack<Character> stack = new Stack<>();
                char top = 0;
                for (int i = 0; i < input.length(); i++) {
                    if (!stack.isEmpty()) {
                        top = stack.peek();
                    }
                    stack.push(input.charAt(i));
                    if (!stack.isEmpty() && stack.size() > 1) {
                        if ((top == '[' && stack.peek() == ']') ||
                                (top == '{' && stack.peek() == '}') ||
                                (top == '(' && stack.peek() == ')')) {
                            stack.pop();
                            stack.pop();
                        }
                    }
                }
                
                
                if (stack.isEmpty()) {
                 System.out.println(yseString);
                 
                } else {
                	System.out.println(noString);
                	
               }
            }
            

            for (String output : outputArrayList) {
                System.out.println(output);
            }

        } else {
            System.out.println("Invalid number of lines");
        }
    }


}