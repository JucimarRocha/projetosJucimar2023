import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDadosAnimal implements InterfaceAnimal {
    public List<String> recuperaTextoDeArquivo(String nomeArquivo) throws IOException{
        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();
        try{
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto;
            do{
                texto = leitor.readLine();
                if(texto != null) {
                    textoLido.add(texto);
                }
            }while(texto != null);
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
        return textoLido;
    }

    public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo) throws IOException{
        BufferedWriter gravador = null;
        try{
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            for(String s : texto) {
                gravador.write(s + "\n");
            }
        }finally {
            if (gravador != null) {
                gravador.close();
            }
        }
    }

    @Override
    public boolean registrarAnimalNaLista(Animal animal) throws AnimalInformadoIncorretamenteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarAnimalNaLista'");
    }

    @Override
    public String pesquisarAnimalPeloTamanho(String tamanhoDoAnimalVerificar)
            throws AnimalNaoEncontradoException, ListaAnimalVaziaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisarAnimalPeloTamanho'");
    }

    @Override
    public List<Animal> obterListaDeAnimais() throws ListaAnimalVaziaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterListaDeAnimais'");
    }

    @Override
    public boolean deletarAnimal(String nomeDoAnimal) throws AnimalNaoEncontradoException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarAnimal'");
    }

}