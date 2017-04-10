/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kunfuclub.DbClass.Student;
import java.sql.*;
import kunfuclub.DbClass.dao.*;
import java.util.*;

/**
 *
 * @author Mithi
 */
public class student_infoDaoImp implements student_infoDao {
    
    @Override
    public List<student_info> getAllStudents() {
        
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        List<student_info> studentList;
        studentList = new ArrayList<student_info>();
        
        try{
            String query = "SELECT * FROM Student_info";
            stmt = conn.createStatement();
            rs =stmt.executeQuery(query);
            while(rs.next()){
                student_info student = new student_info();
                student.setS_id(rs.getInt("s_id"));
                student.setS_fname(rs.getString("s_fname"));
                student.setS_lname(rs.getString("s_lname"));
                student.setS_dob(rs.getDate("s_dob"));
                student.setS_doj(rs.getDate("s_doj"));
                student.setS_mobile(rs.getInt("s_mobile"));
                student.setS_email(rs.getString("s_email"));
                student.setS_status(rs.getString("s_status"));
                studentList.add(student);
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
            
    return studentList;
    }

    @Override
    public void addStudent(student_info student) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "INSERT INTO Student_info VALUES(?,?,?,?,?,?,?,?)";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,student.getS_id());
            pstmt.setString(2, student.getS_fname());
            pstmt.setString(3, student.getS_lname());
            pstmt.setDate(4, student.getS_dob());
            pstmt.setDate(5, student.getS_doj());
            pstmt.setInt(6,student.getS_mobile());
            pstmt.setString(7, student.getS_email());
            pstmt.setString(8, student.getS_status());
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
    public student_info getStudent(int s_id) {
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        try{
            
            String query = "SELECT * FROM Student_info where s_id = "+s_id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                student_info student = new student_info();
                student.setS_id(rs.getInt("s_id"));
                student.setS_fname(rs.getString("s_fname"));
                student.setS_lname(rs.getString("s_lname"));
                student.setS_dob(rs.getDate("s_dob"));
                student.setS_doj(rs.getDate("s_doj"));
                student.setS_mobile(rs.getInt("s_mobile"));
                student.setS_email(rs.getString("s_email"));
                student.setS_status(rs.getString("s_status"));
                return student;
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

    @Override
    public void updateStudent(student_info student) {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE Student_info "
                + "SET s_fname = ?,"
                + "s_lname = ?,"
                + "s_dob = ?,"
                + "s_doj = ?,"
                + "s_mobile = ?,"
                + "s_email = ?,"
                + "s_status = ? "
                + "WHERE s_id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, student.getS_fname());
            pstmt.setString(2, student.getS_lname());
            pstmt.setDate(3, student.getS_dob());
            pstmt.setDate(4, student.getS_doj());
            pstmt.setInt(5,student.getS_mobile());
            pstmt.setString(6, student.getS_email());
            pstmt.setString(7, student.getS_status());
            pstmt.setInt(8,student.getS_id());
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
    public void deleteStudent(int s_id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "DELETE FROM Student_info WHERE s_id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,s_id);
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
    
}
