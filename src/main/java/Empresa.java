import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String cnpj;
    private String endereco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)    
    private Set<Funcionario> funcionarios = new HashSet<Funcionario>();


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Cargo> cargo = new HashSet<>();


	public Empresa(String nome, String cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }


    public Integer getId() {
        return id;
    }


  

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCnpj() {
        return cnpj;
    }


    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    


    public Set<Cargo> getCargo() {
        return cargo;
    }

    public void adicionarCargo(Cargo c){
        this.cargo.add(c);
        c.setEmpresa(this);
    }

    public void excluirCargo(Cargo c){
        this.cargo.remove(c);
        c.setEmpresa(null);
    }
            

    public void adicionarFuncionario(Funcionario f) {
        this.funcionarios.add(f);
        f.setEmpresa(this);
    }
    public void removerFuncionario(Funcionario f) {
        this.funcionarios.remove(f);
        f.setEmpresa(null);
    }
    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }


    @Override
    public String toString() {
        return "Empresa [cargo=" + cargo + ", cnpj=" + cnpj + ", endereco=" + endereco + ", funcionarios="
                + funcionarios + ", id=" + id + ", nome=" + nome + "]";
    }


   
   
   
   

   
   
   
   

   
   
   

    

    


    
    
}
