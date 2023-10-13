package br.edu.ifs.ED.lista;
import java.lang.reflect.Array;

public class ListaSimplesEncadeada<T extends Comparable<T>> extends Lista<T> {

    private No<T> primeiro;
    private No<T> ultimo;

    private No<T> aux;
    private No<T> atual;
    private int tamanho;

    public ListaSimplesEncadeada(){

    }

    @Override
    public void incluir(T elemento) throws Exception {

        if (elemento == null) {
            throw new Exception("Elemento não pode ser nulo");
        }

        No<T> novoNo = new No<T>(elemento);


        if (this.ultimo == null) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else {
            this.ultimo.proximo = novoNo;
            this.ultimo = novoNo;
        }
        tamanho++;
    }


    public T get(int posicao)  throws Exception {
        if (posicao < 0 || posicao >= tamanho) {
            throw new Exception("Posição solicitada não existe na lista");
        }
        atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.dado;
    }


    public int getPosElemento(T elemento)  throws Exception {
        atual = primeiro;
        int posicao = 0;
        while (atual != null) {
            if (atual.dado.equals(elemento)) {
                return posicao;
            }
            atual = atual.proximo;
            posicao++;
        }
        throw new Exception("Elemento não localizado");
    }

    @Override
    public void remover(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) {
            throw new Exception("Posição solicitada não existe na lista");
        }
        if (posicao == 0) {
            primeiro = primeiro.proximo;
            if (primeiro == null) {
                ultimo = null;
            }
        } else {
            aux = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                aux = aux.proximo;
            }
            if (aux.proximo == ultimo) {
                ultimo = aux;
            }
            No<T> removido = aux.proximo;
            aux.proximo = removido.proximo;
        }
        tamanho--;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    public void limpar() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }



    @Override
    public boolean contem(T elemento) throws Exception {

        if (elemento == null) {
            throw new Exception("Elemento não pode ser nulo");
        }

        atual = primeiro;
        while (atual != null) {
            if (atual.dado.equals(elemento)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

//    comparar tamanhos das listas?
    @Override
    public int compareTo(Lista<T> item) {
            if (item == null) {
                return 1;
            }

            if (this.getTamanho() < item.getTamanho()) {
                return -1;
            } else if (this.getTamanho() > item.getTamanho()) {
                return 1;
            } else {
                return 0;
            }
    }
//    metodo sem ser recursivo(teste)
//    @Override
//    public T[] transformarEmVetor() {
//
//        atual = primeiro;
//
//        if (atual != null) {
//            Class<?> tipoElemento = atual.dado.getClass();
//            T[] vetor = (T[]) Array.newInstance(tipoElemento, tamanho);
//
//            for (int i = 0; i < tamanho; i++) {
//                vetor[i] = atual.dado;
//                atual = atual.proximo;
//            }
//
//            return vetor;
//        } else {
//            // Se a lista estiver vazia, retorne um array genérico
//            return (T[]) new Object[tamanho];
//        }
//
//    }

    public T[] transformarEmVetor() {
        atual = primeiro;
        if (atual != null) {
          Class<?> tipoElemento = atual.dado.getClass(); //verificar o tipo de dados da lista encadeada
          T[] vetor = (T[]) Array.newInstance(tipoElemento, tamanho); //criar um vetor com o mesmo tipo
          transformarEmVetorRecursivo(primeiro, vetor, 0); //chamar o metodo recursivo
            return vetor;
        }

        return (T[]) new Object[tamanho]; //retornar o vetor com o mesmo tamanho da lista encadeada
    }

    private int transformarEmVetorRecursivo(No<T> no, T[] vetor, int i) { // o metodo recebe um nó,o vetor e o indice como parametro
        if (no != null) {
            vetor[i] = no.dado;
            return transformarEmVetorRecursivo(no.proximo, vetor, i + 1);
        }
        return i;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        No<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.dado);
            if (atual.proximo != null) {
                sb.append(", ");
            }
            atual = atual.proximo;
        }

        sb.append("]");
        return sb.toString();
    }



}
