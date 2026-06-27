package dev.charles;

import java.util.Objects;

public class Aresta implements Comparable<Aresta>{
    private Vertice verticeA;
    private Vertice verticeB;

    public Aresta(Vertice verticeA, Vertice verticeB){
        this.verticeA = verticeA;
        this.verticeB = verticeB;
    }

    public boolean estaEnvolvido(Vertice vertice){
        return verticeA == vertice || verticeB == vertice;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aresta aresta = (Aresta) o;
        return Objects.equals(verticeA, aresta.verticeA) && Objects.equals(verticeB, aresta.verticeB) ||
                Objects.equals(verticeA, aresta.verticeB) && Objects.equals(verticeB, aresta.verticeA);
    }

    @Override
    public int hashCode() {
        int num;
        num = Objects.hash(verticeA, verticeB);
        System.out.println(num);
        return num;
    }

    @Override
    public int compareTo(Aresta o) {

        int valor =  o.verticeA.getNome().compareTo(this.verticeA.getNome());
        int valor2 = o.verticeA.getNome().compareTo(this.verticeB.getNome());

        if(valor == 0 || valor2 == 0){
            return 0;
        }else {
            return valor;
        }
    }

    public Vertice vizinhoDe(Vertice vertice) {
        if(vertice.equals(this.verticeA)){
            return this.verticeB;
        }else{
            return this.verticeA;
        }
    }
}