package com.surkoffv.MyWork;

public class NodeFactory {

    private boolean decodeStringNodes;

    private boolean removeEscapeCharacters;

    public void setDecodeStringNodes(boolean decodeStringNodes) {
        this.decodeStringNodes = decodeStringNodes;
    }

    public void setRemoveEscapeCharacters(boolean removeEscapeCharacters) {
        this.removeEscapeCharacters = removeEscapeCharacters;
    }


    public Node createStringNode(String text) {

        Node node = new StringNode(text);

        if (decodeStringNodes) {
            node = new DecodingStringNode(node);
        }
        if (removeEscapeCharacters) {
            node = new EscapeRemovalStringNode(node);
        }
        return node;
    }

}