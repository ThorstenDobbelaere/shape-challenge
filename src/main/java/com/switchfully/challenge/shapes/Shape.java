package com.switchfully.challenge.shapes;

import com.switchfully.challenge.visitors.ShapeTool;

public abstract class Shape {

    public abstract double getSurface();

    public abstract  <T> void accept(ShapeTool<T> shapeTool);
}
