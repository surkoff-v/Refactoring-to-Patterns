package com.sv.initial;

/** Базовый «сырой» узел со строковым содержимым. */
public class StringNode implements Node {
    private final String text;

    private StringNode(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    /*  static-метод-фабрика — именно здесь сейчас
        сосредоточена логика «обёртывания» узла
        в нужные декораторы. */
    public static Node createStringNode(String text,
                                        boolean shouldDecode,
                                        boolean shouldRemoveEscape) {

        Node node = new StringNode(text);

        if (shouldDecode) {
            node = new DecodingStringNode(node);
        }
        if (shouldRemoveEscape) {
            node = new EscapeRemovalStringNode(node);
        }
        return node;
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

