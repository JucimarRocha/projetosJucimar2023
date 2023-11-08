public class Animal {
    private String nomeAnimal;
    private String tamanhoAnimal;
    private String especie;
    private String raca;
    private String comportamento;

    public Animal(String nomeAnimal, String tamanhoAnimal, String especie, String raca, String comportamento) {
        this.nomeAnimal = nomeAnimal;
        this.tamanhoAnimal = tamanhoAnimal;
        this.especie = especie;
        this.raca = raca;
        this.comportamento = comportamento;


    }

    public Animal() {
        this(null, null, null, null, null);
    }

    public String toString() {
        return "Nome do Animal: " +this.nomeAnimal+ ", Tamanho: " +this.tamanhoAnimal+ ", Espécie: "+this.especie+
                ", Raça: " +this.raca+ ", Comportamento: " +this.comportamento;
    }

    public String getNomeAnimal() {
        return this.nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getTamanhoAnimal() {
        return this.tamanhoAnimal;
    }

    public void setTamanhoAnimal(String tamanhoAnimal) {
        this.tamanhoAnimal = tamanhoAnimal;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return this.raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getComportamento() {
        return this.comportamento;
    }

    public void setComportamento(String comportamento) {
        this.comportamento = comportamento;
    }

}

