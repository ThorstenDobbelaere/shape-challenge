package com.switchfully.challenge.shapes;

import java.util.ArrayList;
import java.util.List;

public class CompositeShape extends Shape {

    private final List<Shape> shapeList = new ArrayList<>();

    public void addShape(Shape shape) {
        shapeList.add(shape);
    }

    @Override
    public double getSurface() {
        return shapeList.stream()
                .mapToDouble(Shape::getSurface)
                .sum();
    }
}
