/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kunfuclub.DbClass.Rank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kunfuclub.DbClass.dao.Dbconnection;

/**
 *
 * @author Mithi
 */
public class rankreqDaoImp implements rankreqDao {

    @Override
    public List<rankreq> getAllRankreq() {
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        List<rankreq> rankreqList;
        rankreqList = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM rank_req";
            stmt = conn.createStatement();
            rs =stmt.executeQuery(query);
            while(rs.next()){
                rankreq rankvalue = new rankreq();
                rankvalue.setId(rs.getInt("id"));
                rankvalue.setReq(rs.getString("r_req"));
                rankvalue.setFk_r_id(rs.getInt("Rank_r_id"));
                rankreqList.add(rankvalue);
            }
        }
        
        catch(SQLException e){
            System.out.println(e);
        }
        
        finally{
            try{
                if(conn != null){
                    conn.close();
                }
                if(stmt != null){
                    stmt.close();
                }
                if(rs != null){
                    rs.close();
                }
            }
            catch(SQLException e){
                System.out.println(e);
            }
        }
            
    return rankreqList;
    }

    @Override
    public void addRankreq(rankreq value) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "INSERT INTO rank_req(r_req,Rank_r_id) VALUES(?,?)";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, value.getReq());
            pstmt.setInt(2, value.getFk_r_id());
            pstmt.executeUpdate();
            System.out.println("Record is inserted");
        }
        
        catch(SQLException e){
            
            System.out.println(e);
        }
        
        finally{
            
            try{
                if(pstmt!=null) pstmt.close();
            }
            catch( SQLException e){
                System.out.print(e);
            }
            
            if(con != null){
                
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }
        }
    }

    @Override
    public List<rankreq> getRankreq(int Rank_r_id) {
     
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        List<rankreq> rankreqList;
        rankreqList = new ArrayList<>();
        
        try{
            
            String query = "SELECT * FROM rank_req where Rank_r_id = "+Rank_r_id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                rankreq rankvalue = new rankreq();
                rankvalue.setId(rs.getInt("id"));
                rankvalue.setReq(rs.getString("r_req"));
                rankvalue.setFk_r_id(rs.getInt("Rank_r_id"));
                rankreqList.add(rankvalue);
            }
   
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        finally{
         
            try{
                if(conn != null){
                    conn.close();
                }
                if(stmt != null){
                    stmt.close();
                }
                if(rs != null){
                    rs.close();
                }
            }
            
            catch(SQLException e){
                System.out.println(e);
            }
            
        }
         return rankreqList;
    }

    @Override
    public void updateRankreq(rankreq value) {
       
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE rank_req "
                + "SET r_req = ?,"
                + "Rank_r_id = ? "
                + "WHERE id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, value.getReq());
            pstmt.setInt(2, value.getFk_r_id());
            pstmt.setInt(3, value.getId());
            pstmt.executeUpdate();
            
            System.out.println("\nRecord is updated\n");
        }
        
        catch(SQLException e){
            
            System.out.println(e);
        }
        
        finally{
            
            try{
                if(pstmt != null) pstmt.close();
            }
            catch( SQLException e){
                System.out.print(e);
            }
            
            if(con != null){
                
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }
        }
    }

    @Override
    public void deleteRankreqAll(int Rank_r_id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "DELETE FROM rank_req WHERE Rank_r_id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,Rank_r_id);
            pstmt.executeUpdate();
            
            System.out.println("Record is Deleted");
        }
        
        catch(SQLException e){
            
            System.out.println(e);
        }
        
        finally{
            
            try{
               if(pstmt != null) pstmt.close();
            }
            catch( SQLException e){
                System.out.print(e);
            }
            
            if(con != null){
                
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }
        }
    
    }

    @Override
    public void deleteSingleRankReq(int id) {
    Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "DELETE FROM rank_req WHERE id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            
            System.out.println("Sinle Record is Deleted");
        }
        
        catch(SQLException e){
            
            System.out.println(e);
        }
        
        finally{
            
            try{
               if(pstmt != null) pstmt.close();
            }
            catch( SQLException e){
                System.out.print(e);
            }
            
            if(con != null){
                
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }
        }
    }

    @Override
    public rankreq getRankreqId(int id) {
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            String query = "SELECT * FROM rank_req where id = "+id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                rankreq rankvalue = new rankreq();
                rankvalue.setId(rs.getInt("id"));
                rankvalue.setReq(rs.getString("r_req"));
                rankvalue.setFk_r_id(rs.getInt("Rank_r_id"));
                return rankvalue;
            }
   
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        finally{
         
            try{
                if(conn != null){
                    conn.close();
                }
                if(stmt != null){
                    stmt.close();
                }
                if(rs != null){
                    rs.close();
                }
            }
            
            catch(SQLException e){
                System.out.println(e);
            }
            
        }
         return null;
    }
}
    
