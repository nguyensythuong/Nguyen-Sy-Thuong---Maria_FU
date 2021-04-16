/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.context.DBContext;
import entity.Cake;
import entity.Infor;
import entity.Intro;
import entity.Share;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Win 10
 */
public class DAO {
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public Intro getIntro(){
        String query="Select * from intro";
        try {
            conn=new DBContext().getConnection();
            ps=conn.prepareStatement(query);                    
            rs=ps.executeQuery();
            while(rs.next()){
                return new Intro(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Share> getShare(){
        List<Share> list=new ArrayList<>();
        String query="Select * from share";
        try {
            conn=new DBContext().getConnection();
            ps=conn.prepareStatement(query);                    
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Share(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Cake> getTop2(){
        List<Cake> list=new ArrayList<>();
        String query="Select top 2 * from Products";
        try {
            conn=new DBContext().getConnection();
            ps=conn.prepareStatement(query);                    
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Cake(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDouble(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Infor getInfor(){
        String query="Select * from information";
        try {
            conn=new DBContext().getConnection();
            ps=conn.prepareStatement(query);                    
            rs=ps.executeQuery();
            while(rs.next()){
                return new Infor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public int countProducts(){
        String query = "select count (*) from products";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        
        return 0;
    }
    
    public List<Cake> getListByPaging(int index){
        List<Cake> list=new ArrayList<>();
        String query="with result as (select ROW_NUMBER() over (order by id) as [row],* from Products)\n" +
"select * from result where row between ? and ?";
        try {
            conn=new DBContext().getConnection();
            ps=conn.prepareStatement(query); 
            ps.setInt(1, index*4-3);
            ps.setInt(2, index*4);
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Cake(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getDouble(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    
    public static void main(String[] args) {
        DAO dao=new DAO();
        Intro intro=dao.getIntro();
        List<Share> listShare=dao.getShare();
        List<Cake> listCake=dao.getTop2();
        Infor infor=dao.getInfor();
        
        for (Share o : listShare) {
            System.out.println(o);
        }
        
//        List<Cake> listCCC=dao.getListByPaging(1);
//        for (Cake o : listCCC) {
//            System.out.println(o);
//        }

//        Cake cake=dao.getSingle(2);
//        System.out.println(cake);
    }
    public Cake getSingle(int id){
        String query="Select * from Products where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Cake(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7));
            }
        } catch (Exception e) {
        }
        
        return null;
    }
}
