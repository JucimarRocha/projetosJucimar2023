import java.util.ArrayList;
import java.util.List;
public class GerenciamentoAdocao implements InterfaceAnimal {
    private ArrayList<Animal> animais;
    public GerenciamentoAdocao() {
        this.animais = new ArrayList<>();
    }

    public void sair() {
        System.exit(0);
    }

    public void limparLista() {
        this.animais.clear();
    }


    public boolean atualizarInfoAnimal(String nomeAnimal, String novoTamanho, String novaEspecie, String novaRaca, String novoComportamento) throws AnimalNaoEncontradoException {
        if (!this.animais.isEmpty()) {
            for (Animal animal : this.animais) {
                if (animal.getNomeAnimal().equals(nomeAnimal)) {
                    // Encontrou o animal, agora atualize as informações
                    animal.setNomeAnimal(nomeAnimal);
                    animal.setTamanhoAnimal(novoTamanho);
                    animal.setEspecie(novaEspecie);
                    animal.setRaca(novaRaca);
                    animal.setComportamento(novoComportamento);

                    return true;
                }
            }
        }
        throw new AnimalNaoEncontradoException("Animal não encontrado na lista de animais.");
    }

    @Override
    public boolean registrarAnimalNaLista(Animal animal) throws AnimalInformadoIncorretamenteException {
        if (animal.getNomeAnimal() == null) {
            throw new AnimalInformadoIncorretamenteException("Animal contem null como caracteristica.");
        } else {
            return this.animais.add(animal);
        }
    }

    @Override
    public String pesquisarAnimalPeloTamanho(String tamanhoDoAnimalVerificar) throws AnimalNaoEncontradoException, ListaAnimalVaziaException {
        if (!this.animais.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for (Animal a : this.animais) {
                if (a.getTamanhoAnimal().equals(tamanhoDoAnimalVerificar)) {
                    msg.append(a).append("\n").append("==--==").append("\n");
                }
            }
            if (msg.toString().equals("")) {
                throw new AnimalNaoEncontradoException("Animal do tamanho informado não foi encontrado na lista animais.");
            }
            return msg.toString();
        }
        throw new ListaAnimalVaziaException("A lista animais se encontra vazia.");
    }

    @Override
    public List<Animal> obterListaDeAnimais() throws ListaAnimalVaziaException {
        if (!this.animais.isEmpty()) {
            return this.animais;
        }
        throw new ListaAnimalVaziaException("A lista animais se encontra vazia.");
    }

    public String obterTextoComListaDeAnimais(List<Animal> animais) {
        StringBuilder msg = new StringBuilder();
        for (Animal a : animais) {
            msg.append(a.toString()).append("\n").append("=-=").append("\n");//varre a lista de animais e concatena o toString na variável msg
        }
        return msg.toString();
    }

    @Override
    public boolean deletarAnimal(String nomeDoAnimal) {
        if (!this.animais.isEmpty()) {
            for (Animal a : this.animais) {
                if (a.getNomeAnimal().equals(nomeDoAnimal)){
                    this.animais.remove(a);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Animal> getAnimais() {
        return this.animais;
    }
    public void setAnimais(ArrayList<Animal> animais) {
        this.animais = animais;
    }

}