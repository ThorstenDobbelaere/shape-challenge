package com.switchfully.challenge.domain.shapes;

import com.switchfully.challenge.domain.Shape;
import com.switchfully.challenge.domain.ShapeTool;

public class Rectangle extends Shape {

    private double length;

    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public <T> void accept(ShapeTool<T> shapeTool) {
        shapeTool.processRectangle(this);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getSurface() {
        return length * width;
    }
}
