package com.switchfully.challenge.visitors;

import com.switchfully.challenge.shapes.impl.Circle;
import com.switchfully.challenge.shapes.impl.CompositeShape;
import com.switchfully.challenge.shapes.impl.Rectangle;
import com.switchfully.challenge.shapes.impl.Square;

public interface ShapeVisitor <T>{
    void visit(Circle circle);
    void visit(CompositeShape compositeShape);
    void visit(Rectangle rectangle);
    void visit(Square square);
}
