package orzechp.coding.exercises;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzTest {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private static final String FIZZBUZZ = "fizzbuzz";
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String FOUR = "4";
    private static final String SEVEN = "7";
    private static final String EIGHT = "8";
    private static final String ELEVEN = "11";
    private static final String FOURTEEN = "14";
    private static final String SIXTEEN = "16";
    private static final String SEVENTEEN = "17";
    private static final String NINETEEN = "19";
    private static final String OUTPUT = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz";
    private static final String LUCKY = "lucky";

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void testIfFizzBuzzObjectCreated() throws Exception {
        assertNotNull(fizzBuzz);
    }

    @Test
    public void testIfTheProgramCoverRangeFromOneToTwenty() throws Exception {
        assertThat(fizzBuzz.getRangeDifference(), is(19));
    }

    @Test
    public void testIfNumberContainsThreeThanRetunLucky() throws Exception {
        assertEquals(LUCKY, fizzBuzz.translateNumber(3));
        assertEquals(LUCKY, fizzBuzz.translateNumber(13));
    }

    @Test
    public void testIfFizzForNumbersAreMultiplesOfThree() throws Exception {
        assertEquals(FIZZ, fizzBuzz.translateNumber(6));
        assertEquals(FIZZ, fizzBuzz.translateNumber(9));
        assertEquals(FIZZ, fizzBuzz.translateNumber(12));
        assertEquals(FIZZ, fizzBuzz.translateNumber(18));
    }

    @Test
    public void testIfBuzzForNumbersAreMultiplesOfFive() throws Exception {
        assertEquals(BUZZ, fizzBuzz.translateNumber(5));
        assertEquals(BUZZ, fizzBuzz.translateNumber(10));
        assertEquals(BUZZ, fizzBuzz.translateNumber(20));
    }

    @Test
    public void testIfFizzBuzzAreMultiplesOf15() throws Exception {
        assertEquals(FIZZBUZZ, fizzBuzz.translateNumber(15));
    }

    @Test
    public void testWhenTheNumbersAreNotMultiplesOfThreeFiveAndFifteen() throws Exception {
        assertEquals(ONE, fizzBuzz.translateNumber(1));
        assertEquals(TWO, fizzBuzz.translateNumber(2));
        assertEquals(FOUR, fizzBuzz.translateNumber(4));
        assertEquals(SEVEN, fizzBuzz.translateNumber(7));
        assertEquals(EIGHT, fizzBuzz.translateNumber(8));
        assertEquals(ELEVEN, fizzBuzz.translateNumber(11));
        assertEquals(FOURTEEN, fizzBuzz.translateNumber(14));
        assertEquals(SIXTEEN, fizzBuzz.translateNumber(16));
        assertEquals(SEVENTEEN, fizzBuzz.translateNumber(17));
        assertEquals(NINETEEN, fizzBuzz.translateNumber(19));
    }

    @Test
    public void testHowManyTimesFizzOccured() throws Exception {
        assertThat(fizzBuzz.getCount(OUTPUT, FIZZ), is(4));
    }

    @Test
    public void testHowManyTimesBuzzOccured() throws Exception {
        assertThat(fizzBuzz.getCount(OUTPUT, BUZZ), is(3));
    }

    @Test
    public void testHowManyTimesFizzBuzzOccured() throws Exception {
        assertThat(fizzBuzz.getCount(OUTPUT, FIZZBUZZ), is(1));
    }

    @Test
    public void testHowManyTimesLuckyOccured() throws Exception {
        assertThat(fizzBuzz.getCount(OUTPUT, LUCKY), is(2));
    }

    @Test
    public void testIsNumberTrue() {
        assertTrue(fizzBuzz.isNumber("11"));
    }

    @Test
    public void testIsNumberFalse() {
        assertFalse(fizzBuzz.isNumber("notNumber"));
    }

    @Test
    public void testHowManyTimesIntegerOccured() throws Exception {
        assertThat(fizzBuzz.getCountNumbers(OUTPUT), is(10));
    }

    @Test
    public void testIfOutputIsCorrect() throws Exception {
        assertNotNull(fizzBuzz.generateOutput());
        assertThat(fizzBuzz.generateOutput(), is(OUTPUT));
    }

    @Test
    public void testIfReportIsCorrect() throws Exception {
        assertNotNull(fizzBuzz.generateOutput());
        assertThat(fizzBuzz.generateOutput(), is(OUTPUT));
        assertNotNull(fizzBuzz.generateReport(OUTPUT));
        assertThat(fizzBuzz.generateReport(OUTPUT), containsString("fizz: 4"));
        assertThat(fizzBuzz.generateReport(OUTPUT), containsString("buzz: 3"));
        assertThat(fizzBuzz.generateReport(OUTPUT), containsString("fizzbuzz: 1"));
        assertThat(fizzBuzz.generateReport(OUTPUT), containsString("lucky: 2"));
        assertThat(fizzBuzz.generateReport(OUTPUT), containsString("integer: 10"));
    }
}