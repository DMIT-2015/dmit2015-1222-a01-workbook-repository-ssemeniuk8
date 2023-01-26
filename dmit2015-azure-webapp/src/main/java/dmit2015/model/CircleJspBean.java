package dmit2015.model;

import lombok.Data;

public @Data class CircleJspBean {
    private double radius;

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }
}
