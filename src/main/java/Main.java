import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

   private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("holerite");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	private static void salvar(Object a){


		entityManager.getTransaction().begin();
		entityManager.persist(a);
		entityManager.getTransaction().commit();

		System.out.println("salvo...");

	}

	private static void atualizar(Object a){


		entityManager.getTransaction().begin();
		entityManager.merge(a);
		entityManager.getTransaction().commit();

		System.out.println("atualizado..");

	}

	private static void remover(Object a){


		entityManager.getTransaction().begin();
		entityManager.remove(a);
		entityManager.getTransaction().commit();

		System.out.println("excluido...");

	}

	private static void fechar(){

		entityManager.close();
		entityManagerFactory.close();
	}

	public static void main(String[] args) {

		LocalDate data = LocalDate.parse("2021-05-24");        

		//salvando e persistindo empresa
		Empresa empresa = new Empresa("newton paiva", "123.321/0001-12", "av. carlos luz");        

		//salvando e persistindo cargo
		Cargo cargo = new Cargo(4, "programador", 9000,00);       
		
		//salvando e persistindo funcionario
		Funcionario f = new Funcionario("0001", "guilherme", "123456789-10", data, "1245");          

		//adicionando funcionario a empresa                      
		empresa.adicionarFuncionario(f);                

		//definindo cargo ao funcionario
		cargo.adicionarCargoFuncionario(f);

		//adicionando cargo a empresa
		empresa.adicionarCargo(cargo);

		//adicionando um novo funcionario a empresa mas ainda sem definir seu cargo
		Funcionario f2 = new Funcionario("0002", "Samuel Vertello", "123456789-15", LocalDate.now(), "1240");
		empresa.adicionarFuncionario(f2);

		//salvando em cascata todos os objetos em relacionamento
		salvar(empresa);

		//atualizando nome funcionario
		f.setNome("Guilherme Miranda");
		atualizar(f);

		//remover funcionario
		empresa.removerFuncionario(f2);
		remover(f2);
		
		fechar();
		
	}
	
}
