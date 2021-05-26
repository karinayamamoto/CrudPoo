/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.util.ArrayList;
import web.DbListener;

/**
 *
 * @author cutekah
 */
public class TasksConnector {
    public static ArrayList<String> getTasks() throws Exception{
        Connection con = DbListener.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select rowId, * from Tasks");
        ArrayList<String> list = new ArrayList<>();
        while(rs.next()){
            list.add(rs.getString("name"));
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }
    
    public static void addTask(String name) throws Exception{
        Connection con = DbListener.getConnection();
        Statement stmt = con.createStatement();
        stmt.execute("insert into Tasks values('"+name+"')");
        stmt.close();
        con.close();
    }
    
    public static void removeTask(String name) throws Exception{
        Connection con = DbListener.getConnection();
        Statement stmt = con.createStatement();
        stmt.execute("delete from Tasks where name = '"+name+"'");
        stmt.close();
        con.close();
    }
}