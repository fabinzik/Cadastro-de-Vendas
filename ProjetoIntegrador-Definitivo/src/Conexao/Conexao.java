
package conexao;

import java.sql.*;
public class Conexao {
    public static Connection conexao(){
        Connection conexao=null;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost/sistema_loja";
        String usuario="root";
        String senha="";
        
        try{
            Class.forName(driver);
            conexao=DriverManager.getConnection(url,usuario,senha);
            return conexao;
        }catch(Exception e){
            return null;
        }
    }
}
