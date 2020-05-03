
package trabalho1_poo.exerc_aula10_compra;

public class Node {
    private Object valor;
    private Node next;
    
    public Object getValor(){
        return valor;
    }
    public void setValor(Object valor){
        this.valor = valor;
    }
    
    public Node getNext(){
        return next;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
}
