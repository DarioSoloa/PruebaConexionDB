
package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    private String url;
    private String user;
    private String pass;
    
    private Connection conexion;

    public ConexionDB(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.conexion = null;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Connection getConexion() {
        return conexion;
    }
    
    public Connection connect() {
        try {
            // Se registra el Driver de MySQL
            //DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            this.conexion = DriverManager.getConnection(
                    this.url,
                    this.user, 
                    this.pass);
            
        }
        catch (Exception e){
            switch(e.getClass().getName()){
                case "java.sql.SQLSyntaxErrorException":
                    System.out.println("Pasaron cosas..."+e);
                    break;
                case "java.sql.SQLException":
                    System.out.println("No tiene permiso "+e);
                    break;
                default:
                    System.out.println("Error desconocido "+e);
                    break;
            }   
        } finally{
            System.out.println("Conexion iniciada");
            return this.conexion;
        }
    }
    
    public void disconnect(){
        conexion = null;
        if (conexion == null) {
            System.out.println("Conexion terminada");
        }
    }
        
}
    
