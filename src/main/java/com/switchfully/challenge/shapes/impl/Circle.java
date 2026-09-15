package com.switchfully.challenge.shapes.impl;

import com.switchfully.challenge.shapes.Shape;
import com.switchfully.challenge.visitors.ShapeVisitor;

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

    public <T> void accept(ShapeVisitor<T> visitor) {
        visitor.visit(this);
    }

    @Override
    public double getSurface() {
        return Math.PI * radius * radius;
    }
}
