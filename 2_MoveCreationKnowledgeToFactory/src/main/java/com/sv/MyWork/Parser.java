package com.sv.MyWork;

public class Parser {

    private NodeFactory nodeFactory;

    public Parser() {
        this.nodeFactory = new NodeFactory();     // фабрика «по умолчанию»
    }

    /* возможность внедрить/переиспользовать другую фабрику */
    public void setNodeFactory(NodeFactory factory) {
        if (factory != null) this.nodeFactory = factory;
    }
    public NodeFactory getNodeFactory() { return nodeFactory; }

    /* Передаём опции дальше – фабрике, а НЕ храним у себя */
    public void setDecodeStringNodes(boolean flag) {
        nodeFactory.setDecodeStringNodes(flag);
    }
    public void setRemoveEscapeCharacters(boolean flag) {
        nodeFactory.setRemoveEscapeCharacters(flag);
    }

    public Node parse(String url) {
        StringParser sp = new StringParser(this);
        return sp.findString("Hello, &amp; world\\n from " + url);
    }
}

/* Вспомогательный класс, знает о фабрике */
class StringParser {

    private final Parser parser;

    StringParser(Parser parser) { this.parser = parser; }

    Node findString(String raw) {
        return parser.getNodeFactory().createStringNode(raw);
    }
}

