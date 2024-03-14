package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String SERVER_NAME = "PostgreSQL 15";
    private static final String DATABASE_NAME = "postgres";
    private static final int PORTA = 5432;
    private static final String URL = "jdbc:postgresql://" + SERVER_NAME + ":" + PORTA + "/" + DATABASE_NAME;
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1526jujuba";
    
    protected Connection conexao;
    
    public DAO() {
        conexao = null;
    }
    
    public boolean conectar() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER_NAME);
            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return true;
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Driver não encontrado", e);
        } catch (SQLException e) {
            throw new SQLException("Falha na conexão com o PostgreSQL", e);
        }
    }
    
    public boolean close() {
        try {
            if (conexao != null) {
                conexao.close();
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
