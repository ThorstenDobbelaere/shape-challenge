package com.switchfully.challenge.shapes.impl;

import com.switchfully.challenge.tools.ShapeTool;

public class Square extends Rectangle{
    public Square(double length) {
        super(length, length);
    }

    public <T> void accept(ShapeTool<T> shapeTool) {
        shapeTool.processSquare(this);
    }
}
