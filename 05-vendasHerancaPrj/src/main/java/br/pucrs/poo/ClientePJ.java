package br.pucrs.poo;

public class ClientePJ extends Cliente {
   private String cnpj;

  public ClientePJ(int umCodigo, String umNome, String umCNPJ) {
    super(umCodigo, umNome);
    this.cnpj = umCNPJ;
  }

  public String getCNPJ() { return cnpj; }

  @Override
  public String toString() {

    return super.toString() + " [cnpj = " + cnpj + "]";
  }

  @Override
  public String getID() {
    return this.cnpj;
    }



}
