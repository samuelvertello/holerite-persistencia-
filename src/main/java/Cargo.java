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
@Table( name = "cargo")
public class Cargo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int codigo;
    private String nome;
    private float salarioBaseHora;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)    
    private Set<Funcionario> funcionario = new HashSet<>(); 
    
    @ManyToOne
    private Empresa empresa; 
   

	public Cargo(int codigo, String nome, float salarioBaseHora, int i) {
        this.codigo = codigo;
        this.nome = nome;
        this.salarioBaseHora = salarioBaseHora;
    }

    public Integer getId() {
        return id;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalarioBaseHora() {
        return salarioBaseHora;
    }

    public void setSalarioBaseHora(float salarioBaseHora) {
        this.salarioBaseHora = salarioBaseHora;
    }

    public void adicionarCargoFuncionario(Funcionario f){
        this.funcionario.add(f);
        f.setCargo(this);
    }

    public void removerCargoFuncionario(Funcionario f){
        this.funcionario.remove(f);
        f.setCargo(null);
    }    
   
    public Set<Funcionario> getFuncionario() {
		return funcionario;
	}

    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
	

	@Override
    public String toString() {
        return "Cargo [codigo=" + codigo + ", empresa=" + empresa + ", funcionario=" + funcionario + ", id=" + id
                + ", nome=" + nome + ", salarioBaseHora=" + salarioBaseHora + "]";
    }

    
}
