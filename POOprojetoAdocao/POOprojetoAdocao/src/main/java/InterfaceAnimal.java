import java.util.List;

public interface InterfaceAnimal {
    boolean registrarAnimalNaLista(Animal animal) throws AnimalInformadoIncorretamenteException;
    String pesquisarAnimalPeloTamanho(String tamanhoDoAnimalVerificar) throws AnimalNaoEncontradoException, ListaAnimalVaziaException;
    List<Animal> obterListaDeAnimais() throws ListaAnimalVaziaException;
    boolean deletarAnimal(String nomeDoAnimal) throws AnimalNaoEncontradoException;



}
