package com.switchfully.challenge.visitors.impl;

import com.switchfully.challenge.shapes.Shape;
import com.switchfully.challenge.shapes.impl.Circle;
import com.switchfully.challenge.shapes.impl.CompositeShape;
import com.switchfully.challenge.shapes.impl.Rectangle;
import com.switchfully.challenge.shapes.impl.Square;
import com.switchfully.challenge.visitors.ShapeVisitor;

import java.util.List;

public class CircumferenceCalculatorTool implements ShapeVisitor<Double> {
    private double totalCircumference = 0;

    @Override
    public void visit(Circle circle) {
        totalCircumference += circle.getRadius() * 2 * Math.PI;
    }

    @Override
    public void visit(CompositeShape compositeShape, List<Shape> shapeList) {
        for(Shape shape : shapeList) {
            shape.accept(this);
        }
    }

    @Override
    public void visit(Rectangle rectangle) {
        totalCircumference += (2 * rectangle.getLength() + 2 * rectangle.getWidth());
    }

    @Override
    public void visit(Square square) {
        totalCircumference += (4 * square.getLength());
    }

    @Override
    public Double getResult() {
        return totalCircumference;
    }
}
