import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2000.44), "Operador");
        new Funcionario("João", LocalDate.of(1990,5,12), BigDecimal.valueOf(2284.38),"Operador");
        new Funcionario("Caio", LocalDate.of(1961,5,2), BigDecimal.valueOf(9836.14),"Coordenador");
        new Funcionario("Miguel", LocalDate.of(1988,10,14), BigDecimal.valueOf(19119.88),"Diretor");
        new Funcionario("Alice", LocalDate.of(1995,1,5), BigDecimal.valueOf(2234.68),"Recepcionista");
        new Funcionario("Heitor", LocalDate.of(1999,11,19), BigDecimal.valueOf(1582.72),"Operador");
        new Funcionario("Arthur", LocalDate.of(1993,3,31), BigDecimal.valueOf(4071.84),"Contador");
        new Funcionario("Laura", LocalDate.of(1994,7,8), BigDecimal.valueOf(3017.45),"Gerente");
        new Funcionario("Heloísa", LocalDate.of(2003,5,24), BigDecimal.valueOf(1606.85),"Eletricista");
        new Funcionario("Helena", LocalDate.of(1996,9,2), BigDecimal.valueOf(2799.93),"Gerente");

        Funcionarios funcionarios = new Funcionarios();
        Map<String, List<Funcionario>> funcPorFuncao = funcionarios.getPorFuncao();

        funcionarios.removerPorNome("João");

        funcionarios.listarFuncionarios();

        funcionarios.aumentarTodosSalarios(10.0);

        System.out.printf("\nImprimindo funcionários agrupados por função\n");
        funcPorFuncao.forEach((f,p) -> p.forEach(System.out::println));

        System.out.printf("\nImprimindo funcionários que fazem aniversário nos meses 10, 11 e 12\n");
        funcionarios.getPorMesNascimento(10,12).forEach(System.out::println);

        System.out.printf("\nImprimindo funcionário com maior idade\n");
        funcionarios.maisVelho();

        System.out.printf("\nImprimindo funcionários em ordem alfabetica\n");
        funcionarios.getEmOrdemAlfabetica().forEach(System.out::println);

        System.out.printf("\nImprimindo o salário total dos funcionários\n");
        System.out.println(funcionarios.getSalarioTotal());

        System.out.printf("\nImprimindo quantos salários minimos (1212) cada funcionário recebe\n");
        funcionarios.salarioPorMinimo();
    }
}
