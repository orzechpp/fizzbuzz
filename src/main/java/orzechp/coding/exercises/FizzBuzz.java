package orzechp.coding.exercises;

import java.util.StringTokenizer;

import static java.lang.String.valueOf;

public class FizzBuzz {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private static final String FIZZBUZZ = "fizzbuzz";
    private static final String LUCKY = "lucky";
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int ZERO = 0;
    private static final String SPACE = " ";
    public static final String CARET = "\n";
    private static Integer FROM = 1;
    private static Integer TO = 20;


    public static void main(String[] args) {
        String output = generateOutput();
        System.out.println(output);
        System.out.println(generateReport(output));

    }

    public static Integer getRangeDifference() {
        return Math.abs(FROM - TO);
    }


    public static String translateNumber(int input) {

        boolean multipleOfThree = input % THREE == ZERO;
        boolean multipleOfFive = input % FIVE == ZERO;

        if (valueOf(input).contains("3")) {
            return LUCKY;
        }

        if (multipleOfThree && multipleOfFive) {
            return FIZZBUZZ;
        } else if (multipleOfThree) {
            return FIZZ;
        } else if (multipleOfFive) {
            return BUZZ;
        }
        return valueOf(input);
    }

    public static String generateOutput() {
        StringBuilder output = new StringBuilder();

        for (int i = FROM; i <= TO; i++) {
            output.append(translateNumber(i));
            if (i < TO) {
                output.append(SPACE);
            }
        }
        return valueOf(output);
    }

    public static Integer getCount(String output, String word) {
        int count = 0;
        StringTokenizer buzzTokens = new StringTokenizer(output, SPACE);
        while (buzzTokens.hasMoreTokens()) {
            if (buzzTokens.nextToken().equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static Integer getCountNumbers(String output) {
        int count = 0;
        StringTokenizer buzzTokens = new StringTokenizer(output, SPACE);
        while (buzzTokens.hasMoreTokens()) {
            if (isNumber(buzzTokens.nextToken())) {
                count++;
            }
        }
        return count;
    }

    public static boolean isNumber(String input) {

        boolean valid = true;
        input = input.trim();

        if (input.isEmpty() == false) {
            try {
                Double.valueOf(input).doubleValue();
            } catch (NumberFormatException e) {
                valid = false;
            }
        }
        return valid;
    }

    public static String generateReport(String output) {

        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fizz: " + getCount(output, FIZZ) + CARET);
        reportBuilder.append("buzz: " + getCount(output, BUZZ) + CARET);
        reportBuilder.append("fizzbuzz: " + getCount(output, FIZZBUZZ) + CARET);
        reportBuilder.append("lucky: " + getCount(output, LUCKY) + CARET);
        reportBuilder.append("integer: " + getCountNumbers(output) + CARET);


        return valueOf(reportBuilder);
    }
}