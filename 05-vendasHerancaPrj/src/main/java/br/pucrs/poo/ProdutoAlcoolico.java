package br.pucrs.poo;

public class ProdutoAlcoolico extends Produto {

    // static - um valor de importo único para todos produtos
    // deveriamos ter...
    // public static double getTaxaAlcool() {}
    // public static void setTaxaAlcool(double novaTaxa)
    // para permitir atualizar a taxa de imposto
    private static double impostoBebum = 5; // 500%

    public ProdutoAlcoolico(int umCodigo, String umNome, double umPreco) {
        super(umCodigo, umNome, umPreco);
    }

    @Override
    public double getPreco() {
        double taxaBebum = super.getPreco() * impostoBebum;

        return super.getPreco() + taxaBebum;
    }

    @Override
    public String toString() {

        return String.format("%s - Imposto extra: %.0f%%",
                super.toString(),
                this.impostoBebum * 100);

    }

}
