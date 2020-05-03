package trabalho1_poo.exerc_aula10_compra;

public class Pilha implements TAD_Pilha{
    private Node topo = null;
    
    public Pilha(){
        topo = null;
    }
    
    @Override
    public Node push(Object x){
        try {
            if(x == null) return null;
            Node novo = new Node();
            novo.setValor(x);
            novo.setNext(topo);
            topo = novo;
            return novo;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Object pop(){
        if(topo == null) return null;
        Object valor = topo.getValor();
        Node aux = topo;
        topo = topo.getNext();
        aux = null;
        return valor;
    }
    
    @Override
    public Object top(){
        if(topo == null) return null;
        else return topo.getValor();
    }
    
    @Override
    public boolean isEmpty(){
        return (topo == null);
    }
    
    @Override
    public String toString(){
        if(!isEmpty()){
            String saida = "";
            Node aux = topo;
            while(aux != null){
                saida = aux.getValor().toString() + saida;
                aux = aux.getNext();
//                if(aux != null)
//                    saida = "," + saida;
            }
            return ("P: [\n" + saida + "]");
        }
        else return("P: [ Pilha vazia! ]");
    } 
}
