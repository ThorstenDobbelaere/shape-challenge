package com.switchfully.challenge.domain.shapes;

import com.switchfully.challenge.domain.Shape;
import com.switchfully.challenge.domain.ShapeTool;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public <T> void accept(ShapeTool<T> shapeTool) {
        shapeTool.processCircle(this);
    }

    @Override
    public double getSurface() {
        return Math.PI * radius * radius;
    }
}
