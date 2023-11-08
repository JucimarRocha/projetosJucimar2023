import org.junit.Test;
import static org.junit.Assert.*;

public class TesteGerenciamentoAdocao {

    private GerenciamentoAdocao gerenciamentoAdocao = new GerenciamentoAdocao();

    @Test
    public void testRegistrarAnimalNaLista() throws AnimalInformadoIncorretamenteException {
        Animal animal = new Animal("Rex", "Grande", "Cachorro", "Labrador", "Amigável");
        assertTrue(gerenciamentoAdocao.registrarAnimalNaLista(animal));
    }

    @Test
    public void testDeletarAnimal() throws AnimalNaoEncontradoException, AnimalInformadoIncorretamenteException {
        Animal animal = new Animal("Rex", "Grande", "Cachorro", "Labrador", "Amigável");
        gerenciamentoAdocao.registrarAnimalNaLista(animal);

        assertTrue(gerenciamentoAdocao.deletarAnimal("Rex"));
        assertEquals(0, gerenciamentoAdocao.getAnimais().size());
    }

    @Test
    public void testDeletarAnimal_NaoEncontrado() {
        assertFalse(gerenciamentoAdocao.deletarAnimal("Rex"));

    }

}
