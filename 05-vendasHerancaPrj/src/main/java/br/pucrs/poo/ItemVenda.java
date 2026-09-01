package br.pucrs.poo;

public class ItemVenda {
    private int quantidade;
    private Produto prod;

    public ItemVenda(int qtde, Produto umProd) {
        this.quantidade = qtde;
        this.prod = umProd;
    }

    public double getValor() {
        return quantidade * prod.getPreco();
    }

    public String getDetalhe() {
        return String.format("(%d) %-20s    \t %2d X %6.2f  %6.2f",
                prod.getCodigo(), prod.getNome(), this.quantidade,
                prod.getPreco(), this.getValor());
    }

    public Produto getProduto() { return prod; }

    @Override
    public String toString() {
        return "ItemVenda [quantidade=" + quantidade + ", prod=" + prod + "]";
    }

}
