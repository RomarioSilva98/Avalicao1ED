package br.edu.ifs.ED.lista;

public class Teste {

    public static void main(String[] args) throws Exception {

    ListaSimplesEncadeada <Integer> lista = new ListaSimplesEncadeada<>();

        lista.incluir(7);
        lista.incluir(5);
        lista.incluir(3);
        lista.incluir(9);
        lista.incluir(1);
        lista.incluir(11);
//        System.out.println(lista.getPosElemento(2));

        System.out.println(lista);

        lista.remover(5);
        System.out.println(lista);
        System.out.println(lista.contem(5));
//        System.out.println(lista.getTamanho());
//        lista.limpar();
        System.out.println(lista);

        Integer[] vetor = lista.transformarEmVetor();

        System.out.print("Vetor: ");
        for (Integer elemento : vetor) {
            System.out.print(elemento + " ");
        }






    }


}
