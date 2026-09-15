package com.switchfully.challenge.visitors;

import com.switchfully.challenge.shapes.impl.Circle;
import com.switchfully.challenge.shapes.impl.CompositeShape;
import com.switchfully.challenge.shapes.impl.Rectangle;
import com.switchfully.challenge.shapes.impl.Square;

public interface ShapeVisitor <T>{
    T visit(Circle circle);
    T visit(CompositeShape compositeShape);
    T visit(Rectangle rectangle);
    T visit(Square square);
}
