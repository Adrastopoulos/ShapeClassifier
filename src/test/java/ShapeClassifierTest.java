import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeClassifierTest {

    /**
     * Example Test
     */
    @DisplayName("Example Test")
    @Test
    public void example() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Equilateral,Large,Yes,100,100,100");
        assertNotEquals("Yes", answer);
    }

    /**
     * Boundary Value Tests
     */
    @DisplayName("Minimum Valid Triangle")
    @Test
    public void testMinimumValidTriangle() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Equilateral,Small,No,1,1,1");
        assertEquals("Equilateral", result, "Triangle with minimum valid sides should be Equilateral");
    }

    @DisplayName("Zero Length Sides")
    @Test
    public void testZeroLengthSides() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Equilateral,Small,No,0,0,0");
        assertEquals("Invalid", result, "Zero-length sides should be invalid");
    }

    @DisplayName("Maximum Size Triangle")
    @Test
    public void testMaximumSizeTriangle() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Equilateral,Large,Yes,99,99,99");
        assertEquals("Equilateral", result, "Maximum size triangle should be valid Equilateral");
    }

    /**
     * Partition Tests
     */
    @DisplayName("Two Equal Sides")
    @Test
    public void testTwoEqualSides() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Isosceles,Medium,Yes,7,7,4");
        assertEquals("Isosceles", result, "Triangle with two equal sides should be Isosceles");
    }

    @DisplayName("Triangle Inequality Violation")
    @Test
    public void testTriangleInequalityViolation() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("NonTriangle,Small,No,2,2,8");
        assertEquals("Invalid", result, "Sides violating triangle inequality should be invalid");
    }

    @DisplayName("All Different Sides")
    @Test
    public void testAllDifferentSides() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Scalene,Medium,Yes,9,7,5");
        assertEquals("Scalene", result, "Triangle with all different sides should be Scalene");
    }
}