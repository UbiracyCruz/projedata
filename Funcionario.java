import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.salario = salario;
        this.funcao = funcao;

        new Funcionarios().addFuncionarios(this);
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void aumentarSalario(Double percentual){
        setSalario(getSalario().multiply(new BigDecimal( String.valueOf((100+ percentual)/100) )));
    }
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getMesAniversario(){
        return this.getDataNascimento().getMonthValue();
    }

    @Override
    public String toString() {
        DecimalFormat formato = new DecimalFormat("#,###,##0.00");

        return this.getNome()
                + " | "
                + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + " | "
                + this.funcao
                + " | "
                + formato.format(this.salario);
    }
}
