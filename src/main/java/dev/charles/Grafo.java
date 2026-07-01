package dev.charles;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Grafo {
    private List<Vertice> vertices;
    private Set<Aresta> arestas;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new LinkedHashSet<>();
    }

    // Manipulacao de Vertices
    public void addVertice(Vertice vertice) {
        if (vertices.contains(vertice)) {
            System.out.println("Esse vertice ja esta cadastrado: " + vertice);
            return;
        }

        vertices.add(vertice);
        System.out.println("Vertice adicionado: " + vertice);
    }

    public void removeVertice(Vertice vertice) {
        if (vertices.isEmpty()) {
            System.out.println("A lista de vertices esta vazia, nao tem como remover.");
            return;
        }

        if (!vertices.contains(vertice)) {
            System.out.println("Vertice nao encontrado: " + vertice);
            return;
        }

        removerRelacionamentosDoVertice(vertice);
        vertices.remove(vertice);
        System.out.println("Vertice removido: " + vertice);
    }

    private void removerRelacionamentosDoVertice(Vertice vertice) {
        arestas.removeIf(aresta -> aresta.estaEnvolvido(vertice));
    }

    public boolean possuiEsteVertice(Vertice vertice) {
        return vertices.contains(vertice);
    }

    public void getVertices() {
        if (vertices.isEmpty()) {
            System.out.println("Nenhum vertice cadastrado.");
            return;
        }

        vertices.forEach(System.out::println);
    }

    // Manipulacao de Arestas
    public void adicionarAresta(Vertice a, Vertice b) {
        if (!vertices.contains(a) || !vertices.contains(b)) {
            System.out.println("Nao foi possivel adicionar a aresta. Os dois vertices precisam estar cadastrados.");
            return;
        }

        if (a.equals(b)) {
            System.out.println("Nao foi possivel adicionar uma aresta ligando o vertice nele mesmo: " + a);
            return;
        }

        Aresta novaAresta = new Aresta(a, b);

        if (arestas.contains(novaAresta)) {
            System.out.println("Essa aresta ja existe: " + novaAresta);
            return;
        }

        arestas.add(novaAresta);
        System.out.println("Aresta adicionada: " + novaAresta);
    }

    public void removerAresta(Vertice a, Vertice b) {
        Aresta aresta = new Aresta(a, b);

        if (arestas.remove(aresta)) {
            System.out.println("Aresta removida: " + aresta);
        } else {
            System.out.println("Aresta nao encontrada: " + aresta);
        }
    }

    public boolean verificarRelacionamento(Vertice a, Vertice b) {
        return arestas.contains(new Aresta(a, b));
    }

    public void getArestas() {
        if (arestas.isEmpty()) {
            System.out.println("Nenhuma aresta cadastrada.");
            return;
        }

        arestas.forEach(System.out::println);
    }

    public List<Vertice> encontrarVizinhos(Vertice vertice) {
        List<Vertice> vizinhos = new ArrayList<>();

        for (Aresta aresta : arestas) {
            if (aresta.estaEnvolvido(vertice)) {
                Vertice vizinho = aresta.vizinhoDe(vertice);

                if (vizinho != null) {
                    vizinhos.add(vizinho);
                }
            }
        }

        return vizinhos;
    }

    public void mostrarVizinhos(Vertice vertice) {
        List<Vertice> vizinhos = encontrarVizinhos(vertice);

        if (vizinhos.isEmpty()) {
            System.out.println(vertice + " nao possui vizinhos.");
            return;
        }

        System.out.println("Vizinhos de " + vertice + ": " + vizinhos);
    }

    public void bfs(Vertice inicio) {
        if (!vertices.contains(inicio)) {
            System.out.println("Vertice inicial nao encontrado: " + inicio);
            return;
        }

        Queue<Vertice> fila = new LinkedList<>();
        List<Vertice> visitados = new ArrayList<>();

        fila.add(inicio);
        visitados.add(inicio);

        System.out.println("Busca em largura iniciando em: " + inicio);

        while (!fila.isEmpty()) {
            Vertice verticeAtual = fila.poll();
            System.out.println("Visitando: " + verticeAtual);

            for (Vertice vizinho : encontrarVizinhos(verticeAtual)) {
                if (!visitados.contains(vizinho)) {
                    visitados.add(vizinho);
                    fila.add(vizinho);
                }
            }
        }
    }

    public void dfs(Vertice inicio) {
        if (!vertices.contains(inicio)) {
            System.out.println("Vertice inicial nao encontrado: " + inicio);
            return;
        }

        Stack<Vertice> pilha = new Stack<>();
        List<Vertice> visitados = new ArrayList<>();

        pilha.push(inicio);

        System.out.println("Busca em profundidade iniciando em: " + inicio);

        while (!pilha.isEmpty()) {
            Vertice atual = pilha.pop();

            if (visitados.contains(atual)) {
                continue;
            }

            System.out.println("Visitando: " + atual);
            visitados.add(atual);

            for (Vertice vizinho : encontrarVizinhos(atual)) {
                if (!visitados.contains(vizinho)) {
                    pilha.push(vizinho);
                }
            }
        }
    }
}
