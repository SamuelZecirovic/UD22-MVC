package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Modelo {

public static Connection conexion;

public static String db = "MVCclientes";
	//METODO QUE ABRE LA CONEXION CON SERVER MYSQL
		public static void openConnection() {
			
			try {
				String user = "remote", password = "adaw";
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.30:3306?useTimezone=true&serverTimezone=UTC",user,password);//credenciales temporales
				System.out.print("Server Connected");
				
			}catch(SQLException | ClassNotFoundException ex  ){
				System.out.print("No se ha podido conectar con mi base de datos");
				System.out.println(ex.getMessage());
				
			}
			
		}
			
		//METODO QUE CIERRA LA CONEXION CON SERVER MYSQL
		public static void closeConnection() {
			try {
		
				conexion.close();
				System.out.print("Server Disconnected");
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.print("Error cerrando conexion");
			}
		}
		
		//METODO QUE CREA LA BASE DE DATOS
		public static void createDB() {
			try {
				String Query="CREATE DATABASE if not exists " + db;
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("DB creada con exito!");
				
			JOptionPane.showMessageDialog(null, "Se ha creado la DB losCientificos de forma exitosa.");
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error creando la DB.");
			}	
		}
		
		//METODO QUE ELIMINA LA BASE DE DATOS
		public static void deleteDB() {
			try {
				String Query="DROP DATABASE " + db;
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("\nDB eliminada con exito!");
				
			JOptionPane.showMessageDialog(null, "Se ha eliminado la DB losCientificos de forma exitosa.");
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error eliminando la DB.");
			}	
		}
		
		//METODO QUE CREA TABLAS MYSQL
		public static void createTableCliente() {
			try {
				String Querydb = "USE " + db;
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE cliente"
						+ "(id int not null auto_increment, nombre varchar(250) default null, apellido varchar(250) default null, direccion varchar(250) default null, dni int default null, fecha date default null, primary key (id))";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
		}
		
		public static void createTableVideos() {
			try {
				String Querydb = "USE " + db;
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE videos"
						+ "(id int not null auto_increment, title VARCHAR(250) default null, director varchar(250), cli_id int default null, primary key (id), constraint videos_fk foreign key (cli_id) references cliente(id)ON DELETE CASCADE)";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
		}
		
		
		//METODO QUE INSERTA DATOS EN TABLAS MYSQL
		public static void insertDataCliente() {
			try {
				String Querydb = "USE " + db;
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO cliente (id,nombre,apellido,direccion,dni,fecha) VALUES" 
						+"(1,\"nombre1\",\"apellido1\",\"direccion1\",\"11111111\",\"2001-01-01\"),(2,\"nombre2\",\"apellido2\",\"direccion2\",\"21111111\",\"2002-02-02\"),(3,\"nombre3\",\"apellido3\",\"direccion3\",\"31111111\",\"2003-03-03\"),(4,\"nombre4\",\"apellido4\",\"direccion4\",\"41111111\",\"2004-04-04\"),(5,\"nombre5\",\"apellido5\",\"direccion5\",\"51111111\",\"2005-05-05\")";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}			
		}
		
		//METODO QUE INSERTA DATOS DE LA VISTA EN TABLAS MYSQL
				public static void insertCliente(int id,String nombre,String apellido,String direccion,String dni,String fecha) {
					try {
						String Querydb = "USE " + db;
						Statement stdb= conexion.createStatement();
						stdb.executeUpdate(Querydb);
									
						String Query = "INSERT INTO cliente (id,nombre,apellido,direccion,dni,fecha) VALUES" 
								+"("+id+",\""+nombre+"\",\""+apellido+"\",\""+direccion+"\",\""+dni+"\",\""+fecha+"\")";
						Statement st = conexion.createStatement();
						st.executeUpdate(Query);
						
						System.out.println("Datos almacenados correctamente");
						
					} catch (SQLException ex ) {
						System.out.println(ex.getMessage());
						JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
					}			
				}
		
				//METODO QUE INSERTA DATOS EN TABLAS MYSQL
				public static void insertDataVideos() {
					try {
						String Querydb = "USE " + db;
						Statement stdb= conexion.createStatement();
						stdb.executeUpdate(Querydb);
						
						String Query = "INSERT INTO videos (id,title,director,cli_id) VALUES" 
								+"(1,\"titulo1\",\"director1\",1),(2,\"titulo2\",\"director2\",2),(3,\"titulo3\",\"director3\",3),(4,\"titulo4\",\"director4\",4),(5,\"titulo5\",\"director5\",5)";
						Statement st = conexion.createStatement();
						st.executeUpdate(Query);
						
						System.out.println("Datos almacenados correctamente");
						
					} catch (SQLException ex ) {
						System.out.println(ex.getMessage());
						JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
					}			
				}
				
				//METODO QUE INSERTA DATOS EN TABLAS MYSQL
				public static void UpdateDataClientes(int id,String nombre,String apellido,String direccion,String dni,String fecha) {
					try {
						String Querydb = "USE " + db;
						Statement stdb= conexion.createStatement();
						stdb.executeUpdate(Querydb);
						
						String Query = "UPDATE cliente SET"
								+" nombre = \""+nombre+"\", apellido = \""+apellido
								+"\", direccion = \"" +direccion+"\", dni = " +dni+", fecha = \"" +fecha
								+ "\" WHERE id = "+ id;
						Statement st = conexion.createStatement();
						st.executeUpdate(Query);
						
						System.out.println("Datos editados correctamente");
						
					} catch (SQLException ex ) {
						System.out.println(ex.getMessage());
						JOptionPane.showMessageDialog(null, "Error en al editar");
					}			
				}
				
				//METODO QUE INSERTA DATOS EN TABLAS MYSQL
				public static void UpdateDataVideos(int id,String titulo,String director,int id2) {
					try {
						String Querydb = "USE " + db;
						Statement stdb= conexion.createStatement();
						stdb.executeUpdate(Querydb);
						
						String Query = "UPDATE videos SET"
								+" title = \""+titulo+"\",director = \""+director+"\", cli_id = " +id2
								+ " WHERE id = "+ id;
						System.out.println(Query);
						Statement st = conexion.createStatement();
						st.executeUpdate(Query);
						
						System.out.println("Datos editados correctamente");
						
					} catch (SQLException ex ) {
						System.out.println(ex.getMessage());
						
						JOptionPane.showMessageDialog(null, "Error en al editar");
					}			
				}
				
				//METODO QUE INSERTA DATOS DE LA VISTA EN TABLAS MYSQL
				public static void insertVideos(int id,String titulo,String director,int id2) {
					try {
						String Querydb = "USE " + db;
						Statement stdb= conexion.createStatement();
						stdb.executeUpdate(Querydb);
						
						String Query = "INSERT INTO videos (id,title,director,cli_id) VALUES" 
								+"("+id+",\""+titulo+"\",\""+director+"\","+id2+")";
						Statement st = conexion.createStatement();
						st.executeUpdate(Query);
						
						System.out.println("Datos almacenados correctamente");
						
					} catch (SQLException ex ) {
						System.out.println(ex.getMessage());
						JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
					}			
				}
				
		
		//METODO QUE OBTIENE VALORES MYSQL
		public static void getValuesCliente() {
			try {
				String Querydb = "USE " + db;
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "SELECT * FROM cliente";
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);

				while (resultSet.next()) {
					System.out.println("Id: " +  resultSet.getString("id") + " "
							+ "Nombre: " +  resultSet.getString("Nombre") + " "
							+ "apellido: " +  resultSet.getString("apellido") + " "
							+ "direccion: " +  resultSet.getString("direccion") + " "
							+ "dni: " +  resultSet.getString("dni") + " "
							+ "fecha: " +  resultSet.getString("fecha")
							);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}
		}
		
		public static void getValuesvideos() {
			try {
				String Querydb = "USE " + db;
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "SELECT * FROM videos";
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);
				while (resultSet.next()) {
					System.out.println("Id: " +  resultSet.getString("id") + " "
							+ "title: " +  resultSet.getString("title") + " "
							+ "director: " +  resultSet.getString("director") + " "
							+ "cli_id: " +  resultSet.getString("cli_id")
							);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}
		}
		
		//METODO QUE LIMPIA TABLAS MYSQL
		public static void deleteRecord(String table_name, int ID) {
			try {
				String Querydb = "USE " + db;
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Registros de tabla ELIMINADOS con exito!");
							
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
			}
		}	

		
		//METODO QUE ELIMINA TABLAS MYSQL
		public static void deleteTAbla(String table_name) {
			try {
				String Querydb = "USE " + db;
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "DROP TABLE " + table_name + ";";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("TABLA ELIMINADA con exito!");
							
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error borrando la tabla");
			}
		}
	
}
