package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;

public class Demo05 {
// listado de los usuario, segun su cod 
 public static void main(String[] args) {
	 //lamar a la conexion 
	 EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("jpa_sesion01");
	 
	 //crear un manejador de las entidades
	 EntityManager manager = fabrica.createEntityManager();
	 //select * from tb_xx nombre de tabla 
	 String sql= "select u from Usuario u";
	 List<Usuario> lstUsuarios = manager.createQuery(sql,Usuario.class).getResultList();
	 
	 //recorrre el listado y ñlo muestra 
	 for (Usuario u : lstUsuarios) {
		 System.out.println("Codigo.........:" + u.getCod_usua());
		 System.out.println("Nombre.........:" + u.getNom_usua() +"" + u.getApe_usua());
		 System.out.println("Tipo.........:" + u.getIdtipo() +  ""  + u.getObjTipo().getDescripcion());
		 System.out.println("---------------------------------" );
	 }
	 
	 manager.close();
	 
	 

	
} 
}
