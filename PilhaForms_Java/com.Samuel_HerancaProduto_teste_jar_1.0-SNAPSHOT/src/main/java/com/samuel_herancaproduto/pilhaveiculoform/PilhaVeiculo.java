
package com.samuel_herancaproduto.pilhaveiculoform;

public class PilhaVeiculo {
    private Object[] elemento;
    private int topo;
    private int N;

    public PilhaVeiculo(int qtda){
        N = qtda;
        elemento = new Object[N];
        topo = -1; // Posição invalida do Vetor para representar (Vetor Vazio); 
    }
    
    public Object push(Object x){ // Insere elemento na Pilha;
        if (!isFull()) {
            elemento[++topo] = x;
            return elemento[topo]; 
        }
        throw new RuntimeException("Pilha Cheia!");
    }
    
    public Object pop(){ // Remove e retorna o elemento do topo da Pilha;
        if (!isEmpty()) {
            return elemento[topo--];
        }
        throw new RuntimeException("Pilha Vazia!");
    }
    
    public Object top(){ // Não altera a pilha retorna o elemento do topo da Pilha;
        if (!isEmpty()) {
            return elemento[topo];
        }
        else{
            return null;
        }
    }
    
    public boolean isEmpty(){ // Verifica se a Pilha esta Vazia;
        return(topo == -1);
    }
     
    public boolean isFull(){ // Verífica se a Pilha esta cheia;
        return(topo == N - 1);
    }
     
     public String toString(){ // Mostra os Elementos da Pilha;
        if (!isEmpty()) {
            String msg = "";
            for (int i = 0; i <= topo; i++) {
                msg += elemento[i].toString();
                if (i != topo) {
                    msg += ";";
                }
                return ("Pilha Veículo: {" + msg + " } ");
            }
        }
        throw new RuntimeException("Pilha Vazia! "); 
    }
    
    
}
