
package filacadastrotela.filacadastrofilme;

public interface TAD_Queue {
    public Object enqueue(Object x);
    public Object dequeue();
    public Object peek()throws Exception;
    public boolean isEmpty();
    public boolean isFull();
    public String toString();
}
