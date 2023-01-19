package dmit2015.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void area_ValidValues_shouldPass() {
        //Arrange
        Rectangle currentRectangle = new Rectangle();
        //Act
        currentRectangle.setLength(10);
        currentRectangle.setWidth(20);
        //Assert
        assertEquals(200, currentRectangle.area());
    }

    @Test
    void perimeter_ValidValues_shouldPass() {
        //Arrange
        Rectangle currentRectangle = new Rectangle();
        //Act
        currentRectangle.setLength(10);
        currentRectangle.setWidth(20);
        //Assert
        assertEquals(200, currentRectangle.perimeter());
    }

    @Test
    void diagonal_ValidValues_shouldPass() {
        //Arrange
        Rectangle currentRectangle = new Rectangle();
        //Act
        currentRectangle.setLength(40);
        currentRectangle.setWidth(35);
        //Assert
        assertEquals(53.15, currentRectangle.diagonal(), 0.005);
    }
}