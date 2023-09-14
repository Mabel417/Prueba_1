package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Productos;

public class Demo06 {
// listado de los usuario, segun su cod 
 public static void main(String[] args) {
	 //lamar a la conexion 
	 EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("jpa_sesion01");
	 
	 //crear un manejador de las entidades
	 EntityManager manager = fabrica.createEntityManager();
	 //select * from tb_xx nombre de tabla 
	 String sql= "select p from Productos p";
	 List<Productos> lstProductos = manager.createQuery(sql,Productos.class).getResultList();
	 
	 //recorrre el listado y ñlo muestra 
	 for (Productos p : lstProductos) {
		 System.out.println("Codigo.........:" + p.getId_prod());
		 System.out.println("Nombre.........:" + p.getDes_prod());
		 System.out.println("Categoria.........:" + p.getObjCategoria().getDescripcion());
		 System.out.println("Stock.........:" + p.getStk_prod());
		 System.out.println("Precio.........:" + p.getPre_prod());
		 System.out.println("Proveedor......:" + p.getObjProveedor());
		 
		 
		 System.out.println("---------------------------------" );
	 }
	 
	 manager.close();
	 
	 

	
} 
}


