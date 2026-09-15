package com.switchfully.challenge;

import com.switchfully.challenge.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private String name;
    private final List<Shape> shapeList = new ArrayList<>();

    public Drawing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addShape(Shape shape) {
        shapeList.add(shape);
    }

    public double getTotalSurface() {
        return shapeList.stream().mapToDouble(Shape::getSurface).sum();
    }
}
