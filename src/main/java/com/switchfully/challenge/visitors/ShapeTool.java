package com.switchfully.challenge.visitors;

import com.switchfully.challenge.shapes.Shape;
import com.switchfully.challenge.shapes.impl.Circle;
import com.switchfully.challenge.shapes.impl.CompositeShape;
import com.switchfully.challenge.shapes.impl.Rectangle;
import com.switchfully.challenge.shapes.impl.Square;

import java.util.List;

public interface ShapeTool<R>{
    void processCircle(Circle circle);
    void processComposite(CompositeShape compositeShape, List<Shape> shapeList);
    void processRectangle(Rectangle rectangle);
    void processSquare(Square square);

    R getResult();
}
