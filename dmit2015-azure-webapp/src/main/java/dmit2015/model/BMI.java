package dmit2015.model;

/**
 * This class calculates the BMI and BMI Category for a person.
 *
 * @author Sasha Semeniuk
 * @version 2023.1.20
 */

import lombok.Data;

public @Data class BMI {

    private double weight;

    private double height;

    /**
     * Compute and return the BMI value using lbs and inches
     * @return the BMI value
     */
    public double calculateBMI() {
        return (703 * weight) / (height * height);
    }

    /**
     * Compute and return the BMI Category
     * @return the BMI Category
     */
    public String calculateBMICategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

}
