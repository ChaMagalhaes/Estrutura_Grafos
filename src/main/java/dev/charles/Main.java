package dev.charles;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Vertice verticeA = new Vertice("charles");
        Vertice verticeB = new Vertice("Gustavo");

        Aresta conexao = new Aresta(verticeA, verticeB);
        Aresta conexao2 = new Aresta(verticeB, verticeA);

        System.out.println(conexao2.equals(conexao));

        Set<Aresta> arestas = new TreeSet<>();
        arestas.add(conexao);
        arestas.add(conexao2);
    }
}
