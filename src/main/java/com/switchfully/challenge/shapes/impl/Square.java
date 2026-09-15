package com.switchfully.challenge.shapes.impl;

import com.switchfully.challenge.visitors.ShapeVisitor;

public class Square extends Rectangle{
    public Square(double length) {
        super(length, length);
    }

    public <T> void accept(ShapeVisitor<T> visitor) {
        visitor.visit(this);
    }
}
