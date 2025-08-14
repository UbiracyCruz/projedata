import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> func = Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2000.44), "Operador"),
                new Funcionario("João", LocalDate.of(1990,5,12), BigDecimal.valueOf(2284.38),"Operador"),
                new Funcionario("Caio", LocalDate.of(1961,5,2), BigDecimal.valueOf(9836.14),"Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988,10,14), BigDecimal.valueOf(19119.88),"Diretor"),
                new Funcionario("Alice", LocalDate.of(1995,1,5), BigDecimal.valueOf(2234.68),"Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999,11,19), BigDecimal.valueOf(1582.72),"Operador"),
                new Funcionario("Arthur", LocalDate.of(1993,3,31), BigDecimal.valueOf(4071.84),"Contador"),
                new Funcionario("Laura", LocalDate.of(1994,7,8), BigDecimal.valueOf(3017.45),"Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003,5,24), BigDecimal.valueOf(1606.85),"Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996,9,2), BigDecimal.valueOf(2799.93),"Gerente")
        );
        List<Funcionario> funcionarios = new ArrayList<>(func);
        Map<String, List<Funcionario>> funcPorFuncao = new HashMap<>();

        funcionarios.removeIf(n -> n.getNome().equals("João"));

        funcionarios.forEach(f -> System.out.println(f.toString()));

        funcionarios.forEach(f -> f.aumentarSalario(10.0));

        funcionarios.forEach(f -> funcPorFuncao.put(f.getFuncao(), funcionarios.stream()
                .filter(n -> n.getFuncao().equals(f.getFuncao())).toList()));

        System.out.printf("\nImprimindo funcionários agrupados por função\n");
        funcPorFuncao.forEach((f,p) -> p.forEach(System.out::println));

        System.out.printf("\nImprimindo funcionários que fazem aniversário nos meses 10, 11 e 12\n");
        funcionarios.stream()
                .filter(f -> f.getMesAniversario() >= 10 && f.getMesAniversario() <= 12)
                .forEach(System.out::println);

        System.out.printf("\nImprimindo funcionário com maior idade\n");

        funcionarios.stream()
                .min(Comparator.comparing(Pessoa::getDataNascimento))
                .ifPresent(f -> System.out.println(f.getNome() + " tem " + f.getIdade() + " anos"));

        System.out.printf("\nImprimindo funcionários em ordem alfabetica\n");
        funcionarios.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(System.out::println);

        System.out.printf("\nImprimindo o salário total dos funcionários\n");
        funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal::add)
                .ifPresent(System.out::println);


        System.out.printf("\nImprimindo quantos salários minimos (1212) cada funcionário recebe\n");
        funcionarios.forEach(f -> System.out.println(f.getNome() + " recebe " +
                f.getSalario().divide(new BigDecimal(1212), RoundingMode.HALF_EVEN)+ " salarios mínimos"));

    }
}
