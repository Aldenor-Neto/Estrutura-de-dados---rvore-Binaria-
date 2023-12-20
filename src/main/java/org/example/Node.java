package org.example;

public class Node {
    private int data;
    private Node pai;
    private Node left;
    private Node Higth;

    public Node(int value) {
        this.data = value;
    }

    public void addLeft(int value) {
        Node newNode = new Node(value);
        this.left = newNode;
    }

    public void addHigth(int value) {
        Node newNode = new Node(value);
        this.Higth = newNode;
    }

    public Node getPai() {
        return pai;
    }

    public void setPai(Node pai) {
        this.pai = pai;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getHigth() {
        return Higth;
    }

    public void setHigth(Node higth) {
        this.Higth = higth;
    }


}
