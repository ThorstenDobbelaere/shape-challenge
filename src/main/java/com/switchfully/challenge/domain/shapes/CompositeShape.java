package com.switchfully.challenge.domain.shapes;

import com.switchfully.challenge.domain.Shape;
import com.switchfully.challenge.domain.ShapeTool;

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
