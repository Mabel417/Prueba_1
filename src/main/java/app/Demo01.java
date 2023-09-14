package app;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;

public class Demo01 {
	//registro de un nuevo usuario usando valores fijos 
 public static void main(String[] args) {
	 //lamar a la conexion 
	 EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("jpa_sesion01");
	 
	 //crear un manejador de las entidades
	 EntityManager manager = fabrica.createEntityManager();
	 Usuario u = new Usuario();
	 u.setCod_usua(123);
	 u.setNom_usua("Maria");
	 u.setApe_usua("Lopez");
	 u.setUsr_usua("lop");
	 u.setCla_usua("455454");
	 u.setFna_usua( "2006/02/18" );
	 u.setIdtipo(1);
	 u.setEst_usua(1);
	 // si queremos registrar, actualizar o eliminar ->transa....
	 manager.getTransaction().begin();
	 //insert into TB_XX VALUES(?,? 
	 manager.persist(u);
	 manager.getTransaction().commit();
    System.out.println("registro ok");
	 manager.close();
	 
	 
	 manager.persist(args);
	
} 
}
