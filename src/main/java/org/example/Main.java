package org.example;

public class Main {
    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria(0);
        arvore.geraArvoreAleatoria(7);

        boolean value = arvore.isQuaseCompleta(arvore.getRaiz());
        System.out.println(value);
}
}