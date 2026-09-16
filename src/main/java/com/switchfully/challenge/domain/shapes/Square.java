package com.switchfully.challenge.domain.shapes;

import com.switchfully.challenge.domain.ShapeTool;

public class Square extends Rectangle{
    public Square(double length) {
        super(length, length);
    }

    public <T> void accept(ShapeTool<T> shapeTool) {
        shapeTool.processSquare(this);
    }
}
