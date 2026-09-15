package com.switchfully.challenge.visitors.impl;

import com.switchfully.challenge.shapes.impl.Circle;
import com.switchfully.challenge.shapes.impl.CompositeShape;
import com.switchfully.challenge.shapes.impl.Rectangle;
import com.switchfully.challenge.shapes.impl.Square;
import com.switchfully.challenge.visitors.ShapeVisitor;

import java.util.Stack;

public class HtmlGeneratorTool implements ShapeVisitor {
    private final StringBuilder builder = new StringBuilder();
    private final Stack<String> openTags = new Stack<>();
    private final String spacing = " ".repeat(2);

    public HtmlGeneratorTool() {
        builder.append("<html>");
    }

    @Override
    public void visit(Circle circle) {
    }

    @Override
    public void visit(CompositeShape compositeShape) {
    }

    @Override
    public void visit(Rectangle rectangle) {
    }

    @Override
    public void visit(Square square) {
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
}
