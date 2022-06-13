import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClienteDAOImpl implements ClienteDAO{
    @Override
    public Connection connect(String urlConexao) {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(urlConexao);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }

    @Override
    public void createTable(String urlConexao) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(urlConexao);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE cliente " +
                    "(ID INTEGER PRIMARY KEY autoincrement, " +
                    "nome CHAR(50) NOT NULL, " +
                    "idade INTEGER NOT NULL, " +
                    "cpf CHAR(50) NOT NULL, " +
                    "rg CHAR(50) NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        Connection c = null;
        Statement stmt = null;
        try {
             c = DriverManager.getConnection(url_conexao);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String query = "INSERT INTO cliente VALUES (null, '"+cliente.getNome()+"', '"+cliente.getIdade()+"', '"+cliente.getCpf()+"', '"+cliente.getRg()+"')";
            stmt.executeUpdate(query);

            stmt.close();
            c.commit();
            c.close();
            System.out.println("Inserido com sucesso!");
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(urlConexao);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM cliente;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("nome");
                Integer  idade = rs.getInt("idade");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                System.out.println( "ID : " + id );
                System.out.println( "Nome : " + name );
                System.out.println( "Idade : " + idade );
                System.out.println( "CPF : " + cpf );
                System.out.println( "RG : " + rg );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(urlConexao);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "UPDATE cliente set nome = '"+name+"', idade = '"+idade+"'  where ID='"+id+"';";
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
            c.close();
          }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    @Override
    public void delete(String urlConexao, int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(urlConexao);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "DELETE from cliente where ID='"+id+"';";
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
