package task3;

import java.util.Objects;

public class Cylinder implements Shape{
    private final double radius;
    private final double high;
    private final double volume;

    public Cylinder(double radius, double high) {
        if (radius <= 0 || high <= 0) throw new IllegalArgumentException("value can't be less than or equals 0");

        this.radius = radius;
        this.high = high;
        this.volume = calculateVolume();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "Volume=" + calculateVolume() +
                '}';
    }
    @Override
    public double calculateVolume() {

        double volumeOfCylinder = high * Math.PI * Math.pow(radius, 2);
        if (volumeOfCylinder == Double.POSITIVE_INFINITY) {
            throw new IllegalArgumentException("too big value for correct calculate this operation");
        } else {
            return volumeOfCylinder;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(cylinder.radius, radius) == 0 && Double.compare(cylinder.high, high) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, high);
    }

    @Override
    public double getVolume() {
        return volume;
    }
}
