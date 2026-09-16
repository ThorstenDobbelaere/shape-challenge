package com.switchfully.challenge.domain;

public abstract class Shape {

    public abstract double getSurface();

    public abstract <T> void accept(ShapeTool<T> shapeTool);
}
