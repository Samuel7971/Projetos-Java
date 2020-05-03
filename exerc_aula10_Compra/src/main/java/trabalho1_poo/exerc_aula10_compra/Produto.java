
package trabalho1_poo.exerc_aula10_compra;

public class Produto {
    private String nomeComp;
    private String nomeProd;
    private float valorProd;
    
    public Produto(){}
    
    public Produto(String nomeComp, String nomeProd, float valorProd){
        this.nomeComp = nomeComp;
        this.nomeProd = nomeProd;
        this.valorProd = valorProd;
    }

    /**
     * @return the nomeComp
     */
    public String getNomeComp() {
        return nomeComp;
    }

    /**
     * @param nomeComp the nomeComp to set
     */
    public void setNomeComp(String nomeComp) {
        this.nomeComp = nomeComp;
    }

    /**
     * @return the nomeProd
     */
    public String getNomeProd() {
        return nomeProd;
    }

    /**
     * @param nomeProd the nomeProd to set
     */
    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    /**
     * @return the valorProd
     */
    public float getValorProd() {
        return valorProd;
    }

    /**
     * @param valorProd the valorProd to set
     */
    public void setValorProd(float valorProd) {
        this.valorProd = valorProd;
    }
    
    @Override
    public String toString(){
        return ("\n Nome comprador: " + nomeComp + " - " + "Nome produto: " + nomeProd + " - " + " valor: " + valorProd + "\n");
    }
    
}
