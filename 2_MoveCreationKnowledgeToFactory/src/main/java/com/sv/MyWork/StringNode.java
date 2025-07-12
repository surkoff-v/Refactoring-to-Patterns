package com.sv.MyWork;

/** Базовый «сырой» узел со строковым содержимым. */
public class StringNode implements Node {
    private final String text;

    public StringNode(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}

class DecodingStringNode implements Node {
    private final Node delegate;

    DecodingStringNode(Node delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getText() {
        // минимальная «расшифровка» HTML-entities:
        return delegate.getText()
                .replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">");
    }
}

class EscapeRemovalStringNode implements Node {
    private final Node delegate;

    EscapeRemovalStringNode(Node delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getText() {
        // убираем простейшие escape-последовательности
        return delegate.getText()
                .replace("\\n", "\n")
                .replace("\\r", "\r")
                .replace("\\t", "\t");
    }
}

