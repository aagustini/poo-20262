package br.pucrs.poo;

public class ProdutoAlco extends Produto{
    private static double taxa = 4.0;

    public ProdutoAlco(int umCodigo, String umNome, double umPreco, int umaTaxa){
        super(umCodigo, umNome, umPreco);
    }

    public double getTaxa(){
        return taxa;
    }

    public void setTaxa(double novaTaxa){
        ProdutoAlco.taxa = novaTaxa;
    }

    @Override
    public double getPreco(){
        double taxaAlco = super.getPreco() * taxa;
        return super.getPreco() + taxaAlco;
    }
}
