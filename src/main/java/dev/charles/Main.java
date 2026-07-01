package dev.charles;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Vertice charles = new Vertice("Charles");
        Vertice gustavo = new Vertice("Gustavo");
        Vertice ana = new Vertice("Ana");
        Vertice maria = new Vertice("Maria");
        Vertice joao = new Vertice("Joao");

        System.out.println("=== ADICIONANDO VERTICES ===");
        grafo.addVertice(charles);
        grafo.addVertice(gustavo);
        grafo.addVertice(ana);
        grafo.addVertice(maria);
        grafo.addVertice(joao);

        System.out.println("\n=== LISTA DE VERTICES ===");
        grafo.getVertices();

        System.out.println("\n=== ADICIONANDO ARESTAS ===");
        grafo.adicionarAresta(charles, gustavo);
        grafo.adicionarAresta(charles, ana);
        grafo.adicionarAresta(gustavo, maria);
        grafo.adicionarAresta(ana, joao);
        grafo.adicionarAresta(maria, joao);

        System.out.println("\n=== LISTA DE ARESTAS ===");
        grafo.getArestas();

        System.out.println("\n=== VERIFICANDO RELACIONAMENTOS ===");
        System.out.println("Charles tem relacionamento com Ana? " + grafo.verificarRelacionamento(charles, ana));
        System.out.println("Charles tem relacionamento com Maria? " + grafo.verificarRelacionamento(charles, maria));

        System.out.println("\n=== VIZINHOS ===");
        grafo.mostrarVizinhos(charles);
        grafo.mostrarVizinhos(joao);

        System.out.println("\n=== BUSCA EM LARGURA ===");
        grafo.bfs(charles);

        System.out.println("\n=== BUSCA EM PROFUNDIDADE ===");
        grafo.dfs(charles);

        System.out.println("\n=== REMOVENDO ARESTA CHARLES -- ANA ===");
        grafo.removerAresta(charles, ana);
        grafo.getArestas();

        System.out.println("\n=== REMOVENDO VERTICE GUSTAVO ===");
        grafo.removeVertice(gustavo);

        System.out.println("\n=== VERTICES APOS REMOCAO ===");
        grafo.getVertices();

        System.out.println("\n=== ARESTAS APOS REMOCAO ===");
        grafo.getArestas();
    }
}
