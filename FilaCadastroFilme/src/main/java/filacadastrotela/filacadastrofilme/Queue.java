
package filacadastrotela.filacadastrofilme;


public class Queue implements TAD_Queue {
    
    private int total;
    private int head;
    private int tail;
    private Object fila[];
    private int MAX;
    
    public Queue(){
        MAX = 20;
        total = 0;
        head = -1;
        tail = -1;
        fila = new Object[MAX];
    }
    
    public Queue(int capacidade){
        MAX = capacidade;
        total = 0;
        head = -1;
        tail = -1;
        fila = new Object[MAX];
    }
    
    @Override
    public Object enqueue(Object x){
        if (!isFull() && x != null) {
            if (++tail >= MAX) {
                tail = 0;
            }
            if (head == -1) {
                head = tail;
            }
            fila[tail] = x;
            total++;
            return x;
        }
        else return null;
    }
    
    @Override
    public Object dequeue(){
        if (!isEmpty()) {
            Object obj = fila[head];
            if(++head >= MAX)head = 0;
            total--;
            if (total == 0) {
                head = -1;
                tail = -1;
            }
            return obj;
        }
        else return null;
    }
    
    @Override
    public Object peek(){
        if (!isEmpty()) {
            return fila[head];
        }
        return("Fila esta vazia!");
    }
    
    @Override
    public boolean isEmpty(){
        return (total == 0);
    }
    
    @Override
    public boolean isFull(){
        return (total == MAX);
    }
    
    @Override
    public String toString(){
        if (!isEmpty()) {
            String str = "";
            int pos = head;
            for (int i = 1; i <= total; i++) {
                str += fila[pos].toString() + "\n";
                if(i != total) str += ".";
                pos++;
                if(pos >= MAX) pos = 0;
            }
            return("F: " + "[ \n" + str + "]");
        }
        return ("F: []");
 
    }
    
}
