package org.example;

import java.util.ArrayList;

public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria(int value) {
        Node newNode = new Node(value);
        this.raiz = newNode;
    }

    // Soma do conteúdo de todos os noz com recursão
    public int somaConteudoNoz(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.getData() + somaConteudoNoz(node.getLeft()) + somaConteudoNoz(node.getHigth());
        }
    }

    //Soma do conteúdo de todos os noz com interatividade
    public int somaConteudoInterativo(Node node) {
        ArrayList<Node> fila = new ArrayList<>();
        Node current = node;
        fila.add(current);
        int cont = current.getData();

        while (current != null) {
            if (current.getLeft() != null) {
                fila.add(current.getLeft());
                cont += current.getLeft().getData();
            }
            if (current.getHigth() != null) {
                fila.add(current.getHigth());
                cont += current.getHigth().getData();
            }
            fila.remove(0);
            if (fila.size() > 0) {
                current = fila.get(0);
            } else {
                current = null;
            }
        }
        return cont;
    }

    // profundidade com recursão
    public int profundidadeNoz(Node node) {
        if (node == null) {
            return 0;
        } else {
            int esquerda = profundidadeNoz(node.getLeft());
            int direita = profundidadeNoz(node.getHigth());

            return Math.max(esquerda, direita) + 1;
        }
    }

    //verifica se a arvore é propria
    public boolean isPropria(Node node) {
        if (node == null) {
            return false;
        }
        if (node.getLeft() == null & node.getHigth() == null) {
            return true;
        }
        if (node.getLeft() == null | node.getLeft() == null) {
            return false;
        }
        return isPropria(node.getLeft()) & isPropria(node.getHigth());
    }

    //verifica se a arvore é completa
    public boolean isCompleta(Node node) {
        if (node == null) {
            return true;
        }
        if (node.getLeft() == null & node.getHigth() == null) {
            return true;
        }
        if (node.getLeft() == null | node.getHigth() == null) {
            return false;
        }
        return profundidadeNoz(node.getHigth()) == profundidadeNoz(node.getLeft()) & isCompleta(node.getLeft()) & isCompleta(node.getHigth());
    }

    //verifica se arvore é quase completa
    public boolean isQuaseCompleta(Node node) {
        if (node == null) {
            return true;
        }
        int nodeLeft = profundidadeNoz(node.getLeft());
        int nodeHigth = profundidadeNoz(node.getHigth());

        return Math.abs(nodeLeft - nodeHigth) == 1;
    }

    // contador  de noz com recursão
    public int numeroNoz(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + numeroNoz(node.getLeft()) + numeroNoz(node.getHigth());
        }
    }

    //contador de noz interativo
    public int contadorNoz(Node node) {
        ArrayList<Node> fila = new ArrayList<>();
        Node current = node;
        fila.add(current);
        int cont = 1;

        while (current != null) {
            if (current.getLeft() != null) {
                fila.add(current.getLeft());
                cont++;
            }
            if (current.getHigth() != null) {
                fila.add(current.getHigth());
                cont++;
            }
            fila.remove(0);
            if (fila.size() > 0) {
                current = fila.get(0);
            } else {
                current = null;
            }
        }
        return cont;
    }

    public void printPreFixa(Node current) {
        if (current == null) {
            System.out.println("arvore vazia");
            return;
        } else {
            System.out.print(current.getData() + ", ");
            if (current.getLeft() != null) {
                printPreFixa(current.getLeft());
            }
            if (current.getHigth() != null) {
                printPreFixa(current.getHigth());
            }
        }
    }

    public void printPosFixa(Node current) {
        if (current == null) {
            return;
        }
        printPosFixa(current.getLeft());
        printPosFixa(current.getHigth());
        System.out.print(current.getData() + ", ");
    }

    public void printinFixa(Node current) {
        if (current == null) {
            return;
        }
        printinFixa(current.getLeft());
        System.out.print(current.getData() + ", ");
        printinFixa(current.getHigth());
    }

    public void geraArvoreAleatoria(int numNode) {
        ArrayList<Node> fila = new ArrayList<>();
        fila.add(raiz);
        int cont = 1;
        while (cont < numNode) {
            Node current = fila.get(0);
            fila.remove(0);
            current.addLeft(cont);
            cont++;
            if (cont < numNode) {
                current.addHigth(cont);
                cont++;
            }
            fila.add(current.getLeft());
            fila.add(current.getHigth());
        }
    }

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }


}
