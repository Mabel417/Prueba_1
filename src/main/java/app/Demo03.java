package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;

public class Demo03 {
	//Encontrar y mostrar los datos de un usuario, segun su cod 
 public static void main(String[] args) {
	 //lamar a la conexion 
	 EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("jpa_sesion01");
	 
	 //crear un manejador de las entidades
	 EntityManager manager = fabrica.createEntityManager();
	 //objeto a encontar
	 Usuario u = new Usuario();

	 // si queremos registrar, actualizar o eliminar ->transa....
	 try {
//SELECT * FROM TB_XXX WHERE..... FINE REMPLAZA A ESTE COMANDO -------QUE ES JPA INTERFACE LLIBRERIA PARA MAEJAR BASE DE DATOS 
		u= manager.find(Usuario.class, 1);
		if (u==null) {
			System.out.println("usuario no existe");
		}else {
		System.out.println(u);}
	} catch (Exception e) {
		System.out.println("Error:"+ e.getCause().getMessage());
	}
	 manager.close();
	 
	 
	 manager.persist(args);
	
} 
}
