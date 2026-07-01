package dev.charles;

import java.util.Objects;

public class Aresta {
    private Vertice verticeA;
    private Vertice verticeB;

    public Aresta(Vertice verticeA, Vertice verticeB) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
    }

    public Vertice getVerticeA() {
        return verticeA;
    }

    public Vertice getVerticeB() {
        return verticeB;
    }

    public boolean estaEnvolvido(Vertice vertice) {
        return verticeA.equals(vertice) || verticeB.equals(vertice);
    }

    public Vertice vizinhoDe(Vertice vertice) {
        if (verticeA.equals(vertice)) {
            return verticeB;
        }

        if (verticeB.equals(vertice)) {
            return verticeA;
        }

        return null;
    }

    @Override
    public String toString() {
        return verticeA + " -- " + verticeB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aresta aresta = (Aresta) o;

        boolean mesmaOrdem = Objects.equals(verticeA, aresta.verticeA)
                && Objects.equals(verticeB, aresta.verticeB);

        boolean ordemInvertida = Objects.equals(verticeA, aresta.verticeB)
                && Objects.equals(verticeB, aresta.verticeA);

        return mesmaOrdem || ordemInvertida;
    }

    @Override
    public int hashCode() {
        return verticeA.hashCode() + verticeB.hashCode();
    }
}
