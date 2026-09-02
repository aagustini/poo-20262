package br.pucrs.poo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venda {
    private Cliente cliente;
    private ArrayList<ItemVenda> itens;
    private int nroNF;

    private static int proxNroNF = 1000;

    public Venda(Cliente cli) {
        this.cliente = cli;
        this.itens = new ArrayList<>();
        Venda.proxNroNF = Venda.proxNroNF + 1;
        this.nroNF = proxNroNF;
    }

    public static int getProxNF() {
        return proxNroNF + 1;
    }

    public void inserir(Produto prod) {
        this.inserir(1, prod);
    }

    public void inserir(int qtde, Produto prod) {
        itens.add(new ItemVenda(qtde, prod));
    }

    public String getNotaFiscal() {
        double total = 0;
        StringBuilder nota = new StringBuilder("Exercício POO 2026/2\t");
        StringBuilder garantias = new StringBuilder();

        nota.append(LocalDateTime.now().toLocalDate() + "\t");
        nota.append("NF nro: " + this.nroNF + "\n");

        nota.append("Comprador: " + cliente.toString());
        nota.append("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n");
        // não devemos mais usar for tradicional...
        // for (int i = 0; i < itens.size(); i++) {
        // ItemVenda item = lista.get(i);

        // ... com foreach exatamente com o mesmo efeito...
        for (ItemVenda item : itens) {
            nota.append(item.getDetalhe() + "\n");
            // nota.append("\n");
            total = total + item.getValor();

            // if (item.getProduto() instanceof ProdutoEE) {
            // ProdutoEE pee = (ProdutoEE) item.getProduto();

            // usando pattern matching do instanceof ...
            if (item.getProduto() instanceof ProdutoEE pee) {
                garantias.append(pee.getGarantia());
                garantias.append("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n");
            }
        }

        nota.append(String.format("\n     \t\t\t\t    Total: R$ %6.2f\n\n", total));
        nota.append("- - - - - - - - - - - - - - - - - - - - - - - - - -\n");

        nota.append(garantias.toString());
        return nota.toString();
    }

    @Override
    public String toString() {
        return "Venda [cliente=" + cliente + ", itens=" + itens + "]";
    }

}
