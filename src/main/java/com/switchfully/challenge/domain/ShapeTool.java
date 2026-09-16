package com.switchfully.challenge.domain;

import com.switchfully.challenge.domain.shapes.Circle;
import com.switchfully.challenge.domain.shapes.CompositeShape;
import com.switchfully.challenge.domain.shapes.Rectangle;
import com.switchfully.challenge.domain.shapes.Square;

import java.util.List;

public interface ShapeTool<R>{
    void processCircle(Circle circle);
    void processComposite(CompositeShape compositeShape, List<Shape> shapeList);
    void processRectangle(Rectangle rectangle);
    void processSquare(Square square);

    R getResult();
}
