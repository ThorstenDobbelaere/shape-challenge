package com.switchfully.challenge.domain.tools;

import com.switchfully.challenge.domain.Shape;
import com.switchfully.challenge.domain.shapes.Circle;
import com.switchfully.challenge.domain.shapes.CompositeShape;
import com.switchfully.challenge.domain.shapes.Rectangle;
import com.switchfully.challenge.domain.shapes.Square;
import com.switchfully.challenge.domain.ShapeTool;

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
