package com.switchfully.challenge.shapes.impl;

import com.switchfully.challenge.shapes.Shape;
import com.switchfully.challenge.tools.ShapeTool;

import java.util.ArrayList;
import java.util.List;

public class CompositeShape extends Shape {

    private final List<Shape> shapeList = new ArrayList<>();

    public void addShape(Shape shape) {
        shapeList.add(shape);
    }

    public <T> void accept(ShapeTool<T> shapeTool) {
        shapeTool.processComposite(this, shapeList);
    }

    @Override
    public double getSurface() {
        return shapeList.stream()
                .mapToDouble(Shape::getSurface)
                .sum();
    }
}
