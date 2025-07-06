package com.surkoffv.initial;

public class Parser {

    /*  Параметры, которыми «клиент»
        конфигурирует поведение строковых узлов. */
    private boolean decodeStringNodes   = false;
    private boolean removeEscapeChars   = false;

    /* сеттеры вызываются клиентом */
    public void setDecodeStringNodes(boolean flag)   { this.decodeStringNodes = flag; }
    public void setRemoveEscapeCharacters(boolean f) { this.removeEscapeChars = f;    }

    /* геттеры нужны StringParser’у */
    boolean shouldDecodeStringNodes()   { return decodeStringNodes; }
    boolean shouldRemoveEscapeChars()   { return removeEscapeChars; }

    /** Точка входа: клиент вызывает именно этот метод. */
    public Node parse(String url) {
        // демо: вместо реального разбора HTML просто
        // вызываем StringParser и возвращаем узел.
        StringParser sp = new StringParser(this);
        return sp.findString("Hello, &amp; world\\n from " + url);
    }
}

/** Вспомогательный парсер, знающий о Parser
 *  и делегирующий создание узла в StringNode.createStringNode(...) */
class StringParser {

    private final Parser parser;

    StringParser(Parser parser) {
        this.parser = parser;
    }

    Node findString(String raw) {
        return StringNode.createStringNode(
                raw,
                parser.shouldDecodeStringNodes(),
                parser.shouldRemoveEscapeChars());
    }
}
