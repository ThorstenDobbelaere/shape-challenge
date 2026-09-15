package com.switchfully.challenge.shapes.impl;

import com.switchfully.challenge.shapes.Shape;
import com.switchfully.challenge.visitors.ShapeVisitor;

import java.util.ArrayList;
import java.util.List;

public class CompositeShape extends Shape {

    private final List<Shape> shapeList = new ArrayList<>();

    public void addShape(Shape shape) {
        shapeList.add(shape);
    }

    public <T> T accept(ShapeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public double getSurface() {
        return shapeList.stream()
                .mapToDouble(Shape::getSurface)
                .sum();
    }
}
