import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Funcionarios {
    private static List<Funcionario> funcionarios = new ArrayList<>();

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void addFuncionarios(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> getPorMesNascimento(Integer inicio, Integer fim){
        return funcionarios.stream()
                .filter(f -> f.getMesAniversario() >= inicio && f.getMesAniversario() <= fim)
                .toList();
    }

    public Funcionario getMaisVelho(){
        return funcionarios.stream()
                .min(Comparator.comparing(Pessoa::getDataNascimento))
                .orElseThrow();
    }

    public void maisVelho(){
        funcionarios.stream()
                .min(Comparator.comparing(Pessoa::getDataNascimento))
                .ifPresent(f -> System.out.println(f.getNome() + " tem " + f.getIdade() + " anos"));
    }
    public void removerPorNome(String nome){
        funcionarios.removeIf(n -> n.getNome().equals(nome));
    }

    public void listarFuncionarios(){
        funcionarios.forEach(f -> System.out.println(f.toString()));
    }

    public Map<String, List<Funcionario>> getPorFuncao(){
        Map<String, List<Funcionario>> funcPorFuncao = new HashMap<>();

        funcionarios.forEach(f -> funcPorFuncao.put(f.getFuncao(), funcionarios.stream()
                .filter(n -> n.getFuncao().equals(f.getFuncao())).toList()));

        return funcPorFuncao;
    }
    public List<Funcionario> getEmOrdemAlfabetica(){
         return funcionarios.stream()
                 .sorted(Comparator.comparing(Pessoa::getNome))
                 .toList();
    }
    public BigDecimal getSalarioTotal(){
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal(0));
    }

    public void salarioPorMinimo(){
        BigDecimal minimo = new BigDecimal(1212);

        funcionarios.forEach(f -> System.out.println(f.getNome() + " recebe " +
                f.getSalario().divide(minimo, RoundingMode.HALF_EVEN)+ " salarios mínimos"));
    }

    public void aumentarTodosSalarios(Double percentual){
        funcionarios.forEach(f -> f.aumentarSalario(percentual));
    }
}
