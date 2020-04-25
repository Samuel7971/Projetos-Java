
package filacadastrotela.filacadastrofilme;

public class Filme {
    private String titulo;
    private String diretor;
    private String genero;
    private String pais;
    private int ano;

    public Filme() {
    }

    public Filme(String titulo, String diretor, String genero, String pais, int ano) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.genero = genero;
        this.pais = pais;
        this.ano = ano;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the diretor
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * @param diretor the diretor to set
     */
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return ("Filme: " + "Título: " + titulo + ", Diretor: " + diretor + ", Gênero: " + genero + ", País: " + pais + ", Ano: " + ano);
    }
    
    
    
}
