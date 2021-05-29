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
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String codigo;
    private String nome;
    private String cpf;
    private LocalDate dataAdm;
    private String cbo;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Cargo cargo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<ExtratoDeSalario> extrato = new HashSet<>();    
        

	public Funcionario(String codigo, String nome, String cpf, LocalDate dataAdm, String cbo) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.dataAdm = dataAdm;
        this.cbo = cbo;     
        
        
    }




    public Integer getId() {
        return id;
    }
 


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public LocalDate getDataAdm() {
        return dataAdm;
    }


    public void setDataAdm(LocalDate dataAdm) {
        this.dataAdm = dataAdm;
    }


    public String getCbo() {
        return cbo;
    }


    public void setCbo(String cbo) {
        this.cbo = cbo;
    }


    public Cargo getCargo() {
		return cargo;
	}


	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

    
	public Empresa getEmpresa() {
		return empresa;
	}




	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

    


	public Set<ExtratoDeSalario> getExtrato() {
        return extrato;
    }


   public void adicionarExtrato(ExtratoDeSalario ex){
       
        this.extrato.add(ex);
        ex.setFuncionario(this);
   }

   public void removerExtrato(ExtratoDeSalario ex){

        this.extrato.remove(ex);
        ex.setFuncionario(null);
   }


    @Override
    public String toString() {
        return "Funcionario [cargo=" + cargo + ", cbo=" + cbo + ", codigo=" + codigo + ", cpf=" + cpf + ", dataAdm="
                + dataAdm + ", empresa=" + empresa + ", extrato=" + extrato + ", id=" + id + ", nome=" + nome + "]";
    }

    
}
