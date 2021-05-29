import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ExtratoDeSalario")
public class ExtratoDeSalario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int ano;
    private int mes;
    private LocalDate data;
    private float totalComDesconto;
    private float totalSemDesconto;
    private int horasTrabalhadas;
    private int horasFalta;
    private float irpf;
    private float inss;

    @ManyToOne
    private Funcionario funcionario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<ItemDeExtratoDeSalario> item = new HashSet<>();

    public ExtratoDeSalario(int ano, int mes, LocalDate data, float totalComDesconto, float totalSemDesconto,
            int horasTrabalhadas, int horasFalta, float irpf, float inss) {
        this.ano = ano;
        this.mes = mes;
        this.data = data;
        this.totalComDesconto = totalComDesconto;
        this.totalSemDesconto = totalSemDesconto;
        this.horasTrabalhadas = horasTrabalhadas;
        this.horasFalta = horasFalta;
        this.irpf = irpf;
        this.inss = inss;
    }

    public Integer getId() {
        return id;
    }
   

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getTotalComDesconto() {
        return totalComDesconto;
    }

    public void setTotalComDesconto(float totalComDesconto) {
        this.totalComDesconto = totalComDesconto;
    }

    public float getTotalSemDesconto() {
        return totalSemDesconto;
    }

    public void setTotalSemDesconto(float totalSemDesconto) {
        this.totalSemDesconto = totalSemDesconto;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getHorasFalta() {
        return horasFalta;
    }

    public void setHorasFalta(int horasFalta) {
        this.horasFalta = horasFalta;
    }

    public float getIrpf() {
        return irpf;
    }

    public void setIrpf(float irpf) {
        this.irpf = irpf;
    }

    public float getInss() {
        return inss;
    }

    public void setInss(float inss) {
        this.inss = inss;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

   

    public Set<ItemDeExtratoDeSalario> getItem() {
        return item;
    }

    public void inserirItem(ItemDeExtratoDeSalario i){

        this.item.add(i);
        i.setExtrato(this);
    }

    public void removerItem(ItemDeExtratoDeSalario i){

        this.item.remove(i);
        i.setExtrato(null);
    }


    @Override
    public String toString() {
        return "ExtratoDeSalario [ano=" + ano + ", data=" + data + ", funcionario=" + funcionario + ", horasFalta="
                + horasFalta + ", horasTrabalhadas=" + horasTrabalhadas + ", id=" + id + ", inss=" + inss + ", irpf="
                + irpf + ", item=" + item + ", mes=" + mes + ", totalComDesconto=" + totalComDesconto
                + ", totalSemDesconto=" + totalSemDesconto + "]";
    }
    
    
 
    
   
    
}
