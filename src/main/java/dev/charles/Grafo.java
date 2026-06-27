package dev.charles;

import java.util.*;

public class Grafo {
    private List<Vertice> vertices;
    private Set<Aresta> arestas;


    //Manipulacao de Vertices
    public void addVertice(Vertice vertice){
        if(vertices.contains(vertice)){
            System.out.println("Esse elemento já está cadastrado!");
            return;
        }
        vertices.add(vertice);
    }

    public void removeVertice(Vertice vertice){
        if(vertices.isEmpty()){
            System.out.println("A lista de vertices está vazia, não tem como remover");
            return;
        }

        destruidorRelacionamento(vertice);
        vertices.remove(vertice);
    }

    private void destruidorRelacionamento(Vertice vertice) {
        // Destruir relacionamento envolvendo vertice recebida
        // Recebeu A destroi todos relacionamento que A possui
        for(Aresta relacionamento : arestas){
            if(relacionamento.estaEnvolvido(vertice)){
                arestas.remove(relacionamento);
            }
        }
    }

    public boolean possuiEsteVertice(Vertice vertice){
        return vertices.contains(vertice);
    }

    public void getVertices(){
        vertices.forEach(System.out::println);
    }

    //Manipulacao de Arestas
    public void adicionarAresta(Vertice a, Vertice b){
        arestas.add(new Aresta(a, b));
    }

    public void adicionarAresta(Vertice a, Vertice b, int peso){
        arestas.add(new Aresta(a, b, peso));
    }

    public void removerAresta(Vertice a, Vertice b){

        for(Aresta aresta : arestas){
            if(aresta.estaEnvolvido(a) && aresta.estaEnvolvido(b)){
                arestas.remove(aresta);
            }
        }
    }

    public boolean verificarRelacionamento(Vertice a, Vertice b){

        for(Aresta aresta : arestas){
            if(aresta.estaEnvolvido(a) && aresta.estaEnvolvido(b)){
                return true;
            }
        }
        return false;
    }

    public void getArestas(){
        arestas.forEach(System.out::println);
    }

    public List<Vertice> encontrarVizinhos(Vertice vertice){
        return arestas.stream()
                .filter(x -> x.estaEnvolvido(vertice))
                .map(x -> x.vizinhoDe(vertice))
                .toList();
    }

    public void bfs(Vertice inicio){
        Queue<Vertice> fila = new LinkedList<>();
        List<Vertice> visitados = new ArrayList<>();

        System.out.println("Iniciei no: " + inicio);
        fila.addAll(encontrarVizinhos(inicio));
        visitados.add(inicio);

        while(!fila.isEmpty()){
            Vertice verticeAtual = fila.poll();
            System.out.println("Passando em: " + verticeAtual);

            visitados.add(verticeAtual);
            List<Vertice> vizinhosNaoVisitados = encontrarVizinhos(verticeAtual).stream()
                    .filter(x -> !visitados.contains(x))
                    .toList();

            visitados.addAll(vizinhosNaoVisitados);
            fila.addAll(vizinhosNaoVisitados);
        }
        System.out.println("Acabou");
    }

    public void dfs(Vertice inicio){
        Stack<Vertice> pilha = new Stack<>();
        List<Vertice> visitados = new ArrayList<>();

        pilha.push(inicio);

        while(!pilha.isEmpty()){
            Vertice atual = pilha.pop();

            if(visitados.contains(atual)){
                continue;
            }

            System.out.println("Visitando: " + atual);
            visitados.add(atual);

            List<Vertice> vizinhosNaoVisitados = encontrarVizinhos(atual).stream()
                    .filter(x -> !visitados.contains(x))
                    .toList();

            pilha.addAll(vizinhosNaoVisitados);
        }

        System.out.println("Acabou");
    }
}
