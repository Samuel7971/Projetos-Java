
package trabalho1_poo.exerc_aula10_compra;

public class Queue implements TAD_Queue {
    private Node head = null, tail = null;
    
    public Queue(){
        head = null;
        tail = null;
    }
    
    public Object enqueue(Object x){
        try {
            if(x == null) return null;
            Node novo = new Node();
            novo.setValor(x);
            novo.setNext(null);
            if(tail == null){
                head = novo;
                tail = novo;
            }
            else{
                tail.setNext(novo);
                tail = novo;
            }
            return x;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Object dequeue(){
        if(head == null) return null;
        Object obj = head.getValor();
        head = head.getNext();
        if(head == null) tail = null;
        return obj;
    }
    
    public Object peek(){
        if(head == null) return null;
        else return head.getValor();
    }
    
    public boolean isEmpty(){
        if(head == null) return true;
        else return false;
    }
    
    public String toString(){
        if(!isEmpty()){
            String saida = "";
            Node aux = head;
            while(aux != null){
                saida += aux.getValor().toString();
                aux = aux.getNext();
            }
            return ("F: [\n" + saida + "]");
        }
        else return ("F: []");
    }
}
