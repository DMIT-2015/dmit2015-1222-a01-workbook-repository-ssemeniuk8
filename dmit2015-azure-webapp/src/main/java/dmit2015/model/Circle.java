package dmit2015.model;

public class Circle {

    private double radius;

    public double getRadius() {
        return radius;
    }

    // Checked-Exception example
//    public void setRadius(double radius) throws Exception {
//        if (radius <= 0){
//            throw new Exception("Radius must be greater than 0");
//        }
//        this.radius = radius;
//    }

    // Runtime Exception Example
    public void setRadius(double radius) {
        if (radius <= 0){
            throw new RuntimeException("Radius must be greater than 0");
        }
        this.radius = radius;
    }

    public Circle() {
        setRadius(1);
    }

    public Circle(double radius) {
        //this.radius = radius;
        setRadius(radius);
    }

    public double Area()
    {
        return Math.PI * radius * radius;
    }

    public double Perimeter()
    {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args)
    {
        Circle circle = new Circle();

        System.out.printf("The radius of the circle is %s\n", circle.getRadius());
        System.out.printf("The area of the circle is %.2f\n", circle.Area());
        System.out.printf("The perimeter of the circle is %.2f", circle.Perimeter());

        //Change the radius to 5
        circle.setRadius(5);
        System.out.printf("The radius of the circle is %s\n", circle.getRadius());
        System.out.printf("The area of the circle is %.2f\n", circle.Area());
        System.out.printf("The perimeter of the circle is %.2f", circle.Perimeter());

        //Exception

            circle.setRadius(-25);
            System.out.printf("Exception should have been thrown");


    }
}
