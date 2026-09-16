package com.switchfully.challenge.domain.tools;

import com.switchfully.challenge.domain.Shape;
import com.switchfully.challenge.domain.shapes.Circle;
import com.switchfully.challenge.domain.shapes.CompositeShape;
import com.switchfully.challenge.domain.shapes.Rectangle;
import com.switchfully.challenge.domain.shapes.Square;
import com.switchfully.challenge.domain.ShapeTool;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class HtmlGeneratorTool implements ShapeTool<String> {
    private final StringBuilder builder = new StringBuilder();
    private final Stack<String> openTags = new Stack<>();
    private final String spacing = " ".repeat(2);

    public HtmlGeneratorTool() {
        openTag("html");
    }

    @Override
    public void processCircle(Circle circle) {
        addSelfClosingTag("circle", Map.of(
                "radius", circle.getRadius(),
                "surface", circle.getSurface()
        ));
    }

    @Override
    public void processComposite(CompositeShape compositeShape, List<Shape> shapeList) {
        openTag("composite");
        for (Shape shape : shapeList) {
            shape.accept(this);
        }
        closeTag();
    }

    @Override
    public void processRectangle(Rectangle rectangle) {
        addSelfClosingTag("rectangle", Map.of(
                "width", rectangle.getWidth(),
                "length", rectangle.getLength(),
                "surface", rectangle.getSurface()
        ));
    }

    @Override
    public void processSquare(Square square) {
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
        addLine("<%s".formatted(name));
        for (String key: properties.keySet()) {
            builder.repeat(spacing, openTags.size() + 1);
            builder.append("%s = %s".formatted(key, properties.get(key)));
            builder.append(System.lineSeparator());
        }
        addLine("/>");
    }
}
