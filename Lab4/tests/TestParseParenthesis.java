package Lab4.tests;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Lab4.ParseParenthesis;

public class TestParseParenthesis {
    private ParseParenthesis parser = new ParseParenthesis();

    @ParameterizedTest
    @ValueSource(strings = { "1", "-1", "0", "10000024234234", "-2334" })
    public void testSignleInt(String candidate){
        assumeTrue(this.parser.isExpressionCorrect(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = { "1a", "- a", "0", "100000 24234234", "-  2334" })
    public void testInvalidInt(String candidate) {
        assumeFalse(this.parser.isExpressionCorrect(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = { "1.01", "-12.34242", "0.0", "10000024234234.12313", "-2334.2323" })
    public void testSignleDouble(String candidate) {
        assumeTrue(this.parser.isExpressionCorrect(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = { "1.a1", "-12.3 4242", "0,0", "10000.024234234.12313", "- 2334.2323" })
    public void testInvalidDouble(String candidate) {
        assumeFalse(this.parser.isExpressionCorrect(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = { "1.01+", "-12.34242  -", "/0.0", "10000024234234.12313 *", "* -2334.2323 /" })
    public void testInvalidOperatorHanging(String candidate) {
        assumeFalse(this.parser.isExpressionCorrect(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "1.01 + 2", "-12.34242 + -4", "0.0 / 4.2323", "10000024234234.12313 * -123131123.34", "-2334.2323 --2.34",
        "(1.01) + 2", "(-12.34242 + -4)", "(0.0) / (4.2323)", "(10000024234234.12313 * (-123131123.34))", "(((-2334.2323)) -(-2.34))"
    })
    public void testRegularExpression(String candidate) {
        assumeTrue(this.parser.isExpressionCorrect(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1.01 -+ 2", "-12.34242 +* -4", "+0.0 / 4.2323", "10000024234234.12313 * (-123131123.34", ")-2334.2323 --2.34",
            "(1.01) + (2", "(-12.34242) + -4)", "(0.0) (/ (4.2323)", "(10000024234234.12313 (*) (-123131123.34))",
            "((((-2334.2323)) -(-2.34))", "(1).23"
    })
    public void testInvalidRegularExpression(String candidate) {
        assumeFalse(this.parser.isExpressionCorrect(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(1.23) + (1.34 + 4 -0) - ((4.2323) / (1.23 + (4.56--1)))",
            "(1.23) + (1.34 + 4 -0) - (1.23)*((4.2323) / (1.23 + (4.56--1)))"
    })
    public void testComplexExpression(String candidate) {
        assumeTrue(this.parser.isExpressionCorrect(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(1.23) + (1.34 + 4 -0) - ()((4.2323) / (1.23 + (4.56--1)))",
            "(1.23) + (1.34 + 4 -0) - (1.23)((4.2323) / (1.23 + (4.56--1)))",
            "(1.23) + (1.34 + 4 -0) *- (1.23)((4.2323) / (1.23 + (4.56--1)))"
    })
    public void testInvalidComplexExpression(String candidate) {
        assumeFalse(this.parser.isExpressionCorrect(candidate));
    }
}
