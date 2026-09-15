package com.switchfully.challenge.shapes.impl;

import com.switchfully.challenge.visitors.ShapeVisitor;

public class Square extends Rectangle{
    public Square(double length) {
        super(length, length);
    }

    public <T> T accept(ShapeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
