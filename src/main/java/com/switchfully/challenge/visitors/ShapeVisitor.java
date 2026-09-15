package com.switchfully.challenge.visitors;

import com.switchfully.challenge.shapes.Shape;
import com.switchfully.challenge.shapes.impl.Circle;
import com.switchfully.challenge.shapes.impl.CompositeShape;
import com.switchfully.challenge.shapes.impl.Rectangle;
import com.switchfully.challenge.shapes.impl.Square;

import java.util.List;

public interface ShapeVisitor <R>{
    void visit(Circle circle);
    void visit(CompositeShape compositeShape, List<Shape> shapeList);
    void visit(Rectangle rectangle);
    void visit(Square square);

    R getResult();
}
