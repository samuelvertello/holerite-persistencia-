import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ItemDeExtratoDeSalario")
public class ItemDeExtratoDeSalario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int cod;
    private String descricao;
    private String ref;
    private float valor;

    @OneToOne
    private ExtratoDeSalario extrato;

    
    public ItemDeExtratoDeSalario(int cod, String descricao, String ref, float valor) {
        this.cod = cod;
        this.descricao = descricao;
        this.ref = ref;
        this.valor = valor;
    }


    public Integer getId() {
        return id;
    }   


    public int getCod() {
        return cod;
    }


    public void setCod(int cod) {
        this.cod = cod;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getRef() {
        return ref;
    }


    public void setRef(String ref) {
        this.ref = ref;
    }


    public float getValor() {
        return valor;
    }


    public void setValor(float valor) {
        this.valor = valor;
    }    


    public ExtratoDeSalario getExtrato() {
        return extrato;
    }


    public void setExtrato(ExtratoDeSalario extrato) {
        this.extrato = extrato;
    }


    @Override
    public String toString() {
        return "ItemDeExtratoDeSalario [cod=" + cod + ", descricao=" + descricao + ", extrato=" + extrato + ", id=" + id
                + ", ref=" + ref + ", valor=" + valor + "]";
    }   
    
    
    
}
