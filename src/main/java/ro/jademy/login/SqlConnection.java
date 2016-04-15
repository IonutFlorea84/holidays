package ro.jademy.login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
    private String dbUsername ="johnbc8_razvan" ;
    private String dbPassword = "root88" ;
    private String dbName = "johnbc8_concedii";
    private String tableName = "useri";
    
    protected SqlConnection (String dbName, String dbUser, String dbPass){
        this.dbName = dbName;
        this.dbUsername = dbUser;
        this.dbPassword = dbPass;
    }    
    protected SqlConnection(){
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
    protected User getUserDetails (String username){
        PreparedStatement state = null;
        User toReturn = null;
        String query = "select * from" + tableName + "where username= ?;";
        
        try {
            state = conn.prepareStatement(query);
            state.setString(1, username);
            ResultSet result = state.executeQuery();
            
            while (result.next()){
                toReturn = new User(result.getString("username"), result.getString("password"), result.getString("name"), result.getString("surname"),
                        result.getString("email"), result.getString("department"), result.getDate("hir_date"), result.getString("address"),
                        result.getInt("phone"), result.getString("gender"));
            }
        } catch (Exception e) {
        }
        return toReturn;
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
    protected void addUserToDB (User user){
        PreparedStatement statement;
        String query = "INSERT INTO " + tableName + " (username, password, name, surname, email, department, hir_date,address,  phone, gender)"
                + " values (?, ?, ?, ?, ?, ?,?, ?, ?, ?);";
        
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getDepartment());
            statement.setDate(7, new java.sql.Date(user.getHir_date().getTime()));
            statement.setString(8, user.getAddress());
            statement.setInt(9, user.getPhone());
            statement.setString(10, user.getGender());
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Cannot add user to Db", e);
        }
    }
    
    protected ResultSet listDB(String tableName){
        PreparedStatement statement;
        String query;
        if (tableName == null){
            query = "select * from " + this.tableName + ";";
        } else {
            query = "select * from " + tableName + ";";
        }
        
        try {
            
            statement = conn.prepareStatement(query);
            
            return statement.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException("cannot retrieve database", e);
        }
    }
    protected ResultSet listDB(){
        return this.listDB();
    }
    protected ArrayList<User> listUsers (String tableName){
        PreparedStatement statement;
        String query = "select * from " + tableName + ";";
        ArrayList<User> toReturn = new ArrayList<>();
        
        try {
            ResultSet result = conn.prepareStatement(query).executeQuery();
            
            while (result.next()){
                toReturn.add(new User(result.getString("username"), result.getString("password"), result.getString("name"), result.getString("surname"),
                        result.getString("email"), result.getString("department"), result.getDate("hir_date"), result.getString("address"),
                        result.getInt("phone"), result.getString("gender")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return toReturn;
    }
    protected boolean sendVacationForm(Vacation form){
        boolean toReturn = false;
        String query = "insert into vacation_forms (username, startDate, length, type, comments) "
                + "value (?, CURDATE(), ?, ?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, form.getUsername());
            statement.setInt(2, form.getLength());
            statement.setString(3, form.getType());
            statement.setString(4, form.getComments());
            
            toReturn = statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toReturn;
    }
    
    protected String getTableName() {
        return tableName;
    }

    protected void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
        
}
