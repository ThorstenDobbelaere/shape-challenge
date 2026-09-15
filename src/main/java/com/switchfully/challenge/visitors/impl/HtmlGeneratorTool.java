package com.switchfully.challenge.visitors.impl;

import com.switchfully.challenge.shapes.Shape;
import com.switchfully.challenge.shapes.impl.Circle;
import com.switchfully.challenge.shapes.impl.CompositeShape;
import com.switchfully.challenge.shapes.impl.Rectangle;
import com.switchfully.challenge.shapes.impl.Square;
import com.switchfully.challenge.visitors.ShapeVisitor;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class HtmlGeneratorTool implements ShapeVisitor<String> {
    private final StringBuilder builder = new StringBuilder();
    private final Stack<String> openTags = new Stack<>();
    private final String spacing = " ".repeat(2);

    public HtmlGeneratorTool() {
        openTag("html");
    }

    @Override
    public void visit(Circle circle) {
        addSelfClosingTag("circle", Map.of(
                "radius", circle.getRadius(),
                "surface", circle.getSurface()
        ));
    }

    @Override
    public void visit(CompositeShape compositeShape, List<Shape> shapeList) {
        openTag("composite");
        for (Shape shape : shapeList) {
            shape.accept(this);
        }
        closeTag();
    }

    @Override
    public void visit(Rectangle rectangle) {
        addSelfClosingTag("rectangle", Map.of(
                "width", rectangle.getWidth(),
                "length", rectangle.getLength(),
                "surface", rectangle.getSurface()
        ));
    }

    @Override
    public void visit(Square square) {
        addSelfClosingTag("square", Map.of(
                "size", square.getLength(),
                "surface", square.getSurface()
        ));
    }

    @Override
    public String getResult() {
        closeTag();
        return builder.toString();
    }

    private void openTag(String tagName) {
        addLine("<%s>".formatted(tagName));
        openTags.add(tagName);
    }

    private void closeTag() {
        String tag = openTags.pop();
        addLine("</%s>".formatted(tag));
    }

    private void addLine(String content) {
        builder.repeat(spacing, openTags.size());
        builder.append(content);
        builder.append(System.lineSeparator());
    }

    private void addSelfClosingTag(String name, Map<String, Object> properties) {
        builder.repeat(spacing, openTags.size());
        builder.append("<%s".formatted(name));
        builder.append(System.lineSeparator());

        for (String key: properties.keySet()) {
            builder.repeat(spacing, openTags.size() + 1);
            builder.append("%s = %s".formatted(key, properties.get(key)));
            builder.append(System.lineSeparator());
        }

        builder.repeat(spacing, openTags.size());
        builder.append("/>");
        builder.append(System.lineSeparator());
    }
}
