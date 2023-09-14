package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;

public class Demo02 {
	//Actualizar los datos de un usuario existente
 public static void main(String[] args) {
	 //lamar a la conexion 
	 EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("jpa_sesion01");
	 
	 //crear un manejador de las entidades
	 EntityManager manager = fabrica.createEntityManager();
	 //objeto a modificar
	 Usuario u = new Usuario();
	 u.setCod_usua(3);
	 u.setNom_usua("Zolia");
	 u.setApe_usua("Toro");
	 u.setUsr_usua("ztoro@mnail.com");
	 u.setCla_usua("4545644");
	 u.setFna_usua( "2007/02/08" );
	 u.setIdtipo(1);
	 u.setEst_usua(1);
	 // si queremos registrar, actualizar o eliminar ->transa....
	 try {
		manager.getTransaction().begin();
		//UPDATE PARA NO HACER ESTE POCESO SE UNA MERGE 
		 manager.merge(u);
		 manager.getTransaction().commit();
		System.out.println("Actualizacion ok");
	} catch (Exception e) {
		System.out.println("Error:"+ e.getCause().getMessage());
	}
	 manager.close();
	 
	 
	 manager.persist(args);
	
} 
}
