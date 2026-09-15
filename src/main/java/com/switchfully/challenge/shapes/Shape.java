package com.switchfully.challenge.shapes;

import com.switchfully.challenge.visitors.ShapeVisitor;

public abstract class Shape {

    public abstract double getSurface();

    public abstract  <T> T accept(ShapeVisitor<T> visitor);
}
