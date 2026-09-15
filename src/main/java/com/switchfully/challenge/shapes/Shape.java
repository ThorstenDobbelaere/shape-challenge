package com.switchfully.challenge.shapes;

import com.switchfully.challenge.visitors.ShapeVisitor;

public abstract class Shape {

    public abstract double getSurface();

    public abstract  <T> void accept(ShapeVisitor<T> visitor);
}
