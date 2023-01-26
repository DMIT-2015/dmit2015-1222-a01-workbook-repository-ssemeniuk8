package dmit2015.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BMITest {

    @Test
    void calculateBMI_shouldPass() {
        // Arrange
        double expected = 22.8;
        double weight = 150;
        double height = 68;
        BMI testObject = new BMI();
        testObject.setWeight(weight);
        testObject.setHeight(height);

        // Act
        double actual = testObject.calculateBMI();

        // Assert
        assertEquals(expected, actual, 0.01);
    }

    @Test
    void calculateBMICategory_shouldPass() {
        // Arrange
        String expected = "Normal";
        double weight = 150;
        double height = 68;
        BMI testObject = new BMI();
        testObject.setWeight(weight);
        testObject.setHeight(height);

        // Act
        String actual = testObject.calculateBMICategory();

        // Assert
        assertEquals(expected, actual);
    }
}