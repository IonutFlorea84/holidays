package ro.jademy.login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
class SqlConnection {
    private Connection conn;
    private String dbUsername;
    private String dbPassword;
    private String dbName;
    
    protected SqlConnection (String dbName, String dbUser, String dbPass){
        this.dbName = dbName;
        this.dbUsername = dbUser;
        this.dbPassword = dbPass;
    }    
    protected SqlConnection(){
        this("johnbc8_concedii","johnbc8_razvan", "root88");
    }
    // Use for DB changes, no return
    
    protected void makeConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://216.218.192.170:3306/"+  dbName, dbUsername, dbPassword);                 
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected boolean checkIfUserExists(String username){
        boolean toReturn = false;
        
        PreparedStatement state = null;
        String query = "Select * from useri where username=?;";
        
        try {
            state = conn.prepareStatement(query);
            state.setString(1, username);
            ResultSet result = state.executeQuery();
            
            return result.next();
        } catch (SQLException ex) {
            throw new RuntimeException ("Cannot found user!", ex);
        }
    }
    protected boolean loginUser (String username, String password){
        PreparedStatement statement = null;
        String query = "Select * from useri where username=?and password=?;";
        ResultSet result;
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            result = statement.executeQuery();
            
            return result.next();
        } catch (SQLException ex) {
            throw new RuntimeException("User/password incorrect", ex);
        }
    }
    
    protected void addUserToDB(String username, String password){
        PreparedStatement statement;
        String query = "INSERT INTO useri (username, password) values (?, ?);";
        
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Cannot add user to Db", e);
        }
        
    }
    protected ResultSet listDB(String DBname){
        PreparedStatement statement;
        String query = "select * from " + DBname + ";";
        
        try {
            statement = conn.prepareStatement(query);
            
            return statement.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException("cannot retrieve users", e);
        }
    }
    protected ResultSet listDB(){
        return this.listDB();
    }
    
        
}
