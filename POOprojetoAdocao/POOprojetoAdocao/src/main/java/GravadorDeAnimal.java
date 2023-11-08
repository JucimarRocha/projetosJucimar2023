import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeAnimal {
    private final String arquivoAdocao = "animal.txt";
    private final GravadorDeDadosAnimal gravadorAdocao;

    public GravadorDeAnimal() {
        this.gravadorAdocao = new GravadorDeDadosAnimal();
    }

    public void gravaAnimal(List<Animal> animais) throws IOException {
        List<String> textoAGravar = new ArrayList<>();
        for (Animal a : animais) {
            String linha = a.getNomeAnimal() +"#"+ a.getTamanhoAnimal() +"#"+ a.getEspecie() +"#"+ a.getRaca() +"#"+
                    a.getComportamento();
            textoAGravar.add(linha);
        }
        this.gravadorAdocao.gravaTextoEmArquivo(textoAGravar, this.arquivoAdocao);
    }

    public ArrayList<Animal> recuperarAnimal() throws IOException {
        List<String> dadosDosAnimais = this.gravadorAdocao.recuperaTextoDeArquivo(this.arquivoAdocao);
        ArrayList<Animal> listaAnimais = new ArrayList<>();
        for(String s : dadosDosAnimais) {
            String[] dados = s.split("#");
            Animal animal = new Animal(dados[0], dados[1], dados[2], dados[3], dados[4]);
            listaAnimais.add(animal);
        }
        return listaAnimais;
    }
}