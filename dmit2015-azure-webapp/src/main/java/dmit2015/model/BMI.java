package dmit2015.model;

import lombok.Data;

public @Data class BMI {

    private double weight;

    private double height;

    public double calculateBMI() {
        return (703 * weight) / (height * height);
    }

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
