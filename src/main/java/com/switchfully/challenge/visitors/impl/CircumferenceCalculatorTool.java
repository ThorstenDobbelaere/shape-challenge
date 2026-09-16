package com.switchfully.challenge.visitors.impl;

import com.switchfully.challenge.shapes.Shape;
import com.switchfully.challenge.shapes.impl.Circle;
import com.switchfully.challenge.shapes.impl.CompositeShape;
import com.switchfully.challenge.shapes.impl.Rectangle;
import com.switchfully.challenge.shapes.impl.Square;
import com.switchfully.challenge.visitors.ShapeTool;

import java.util.List;

public class CircumferenceCalculatorTool implements ShapeTool<Double> {
    private double totalCircumference = 0;

    @Override
    public void processCircle(Circle circle) {
        totalCircumference += circle.getRadius() * 2 * Math.PI;
    }

    @Override
    public void processComposite(CompositeShape compositeShape, List<Shape> shapeList) {
        for(Shape shape : shapeList) {
            shape.accept(this);
        }
    }

    @Override
    public void processRectangle(Rectangle rectangle) {
        totalCircumference += (2 * rectangle.getLength() + 2 * rectangle.getWidth());
    }

    @Override
    public void processSquare(Square square) {
        totalCircumference += (4 * square.getLength());
    }

    @Override
    public Double getResult() {
        return totalCircumference;
    }
}
