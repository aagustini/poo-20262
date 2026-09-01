package br.pucrs.poo;

import java.util.ArrayList;

public class CadastroClientes {
    private ArrayList<Cliente> lista;

    // sim... parece não fazer sentido
    // pq então?
    // - porque implementa um "padrão de projeto" chamado singleton
    // e em algum momento vamos entender a importância disso
    private CadastroClientes() {
        lista = new ArrayList<>();
    }

    private static CadastroClientes instance;

    public static CadastroClientes getInstance() {
        if (instance == null) {
            instance = new CadastroClientes();
            // aqui eu poderia chamar um método para popular o cadastro
            // popular -> criar objetos, ler de arquivo ou buscar num BD
        }
        return instance;

    }

    public void inserir(Cliente cli) {
        lista.add(cli);
    }

   // public void inserir(int umCod, String umNome) {
   //     Cliente novo = new Cliente(umCod, umNome);
   //     lista.add(novo);
   //     lista.add(new Cliente(umCod, umNome));
   // }

    public Cliente pesquisar(int cod) {
        for (Cliente cli : lista) {
            if (cli.getCodigo() == cod)
                return cli;
        }
        return null;
    }

    public Cliente pesquisar(String id) {
        for (Cliente cli : lista) {
            if (cli.getID().compareTo(id) == 0) {
                return cli;
            }
        }
        return null;
    }



        // for (Cliente cli : lista) {

    // // ruim!!!
    // // if (cli instanceof ClientePF) {
    // // ClientePF pf = (ClientePF)cli;
    // // if ( pf.getCPF().equals(cod) ) {
    // // //if ( ((ClientePF)cli).getCPF().equals(cod) ) {
    // // return cli;
    // // }
    // // }
    // if (cli.getID().equals(cod))
    // return cli;

    // }
    //   return null;
    //}

    public String toString() {
        /*
         * String aux = "\nCadastro de Clientes\n- - - - - - - - - - -\n";
         * for (Cliente umCliente : lista) {
         * aux = aux + umCliente.toString() + "\n";
         * //aux += umCliente.toString() + "\n";
         *
         * }
         * return aux;
         */

        StringBuilder aux = new StringBuilder("\nCadastro de Clientes\n- - - - - - - - - - -\n");
        for (Cliente umCliente : lista) {
            aux.append(umCliente.toString() + "\n");

        }
        return aux.toString();

    }
}
