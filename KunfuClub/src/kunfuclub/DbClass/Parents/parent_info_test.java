/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kunfuclub.DbClass.Parents;
import java.sql.Date;

/**
 *
 * @author Mithi
 */
public class parent_info_test {
    
     public static void main(String[] args){
    
        parent_infoDao parentinfoDao  = new parent_infoDaoImp();
   
  
        //1st
    
        parent_info parent = new parent_info
                ("Mithe","Lash","Father",
                90,"mithe@email.com",1);  
 
       //2nd
        
       parent_info parent1 = new parent_info
                ("Mithde","Lash","Father",
                90,"mithe@email.com",2);  
 
        //3rd
        parent_info parent2 = new parent_info
                ("Mithe","Lash","Father",
                90,"mithe@email.com",1);  
 
        
        parentinfoDao.addParent(parent);
        parentinfoDao.addParent(parent1);
        parentinfoDao.addParent(parent2);
        
        System.out.println();
        System.out.println("----------------------All Students ------------------");
        
        //Print all students
        parentinfoDao.getAllparents().forEach((students) -> {
            System.out.println(
                    "Id:" +students.getP_id()+
                            ", Name:" +students.getP_fname()+ students.getP_lname()+
                            ", Relation:" +students.getP_relation()+
                            ", SID" +students.getParentfk_s_sid()+
                            ", Mobile:" +students.getP_mobile()+"\n");
        });
        System.out.println("-------------------End--------------");
        
        
        
        //Get
        
        System.out.println();
        System.out.println("--------------Where ID is 1-------------");
        
        parent_info searchstudent = parentinfoDao.getParent(1);
            System.out.println(
                    "Id:" +searchstudent.getP_id()+
                            ", Name:" +searchstudent.getP_fname()+ searchstudent.getP_lname()+
                            ", Relation" +searchstudent.getP_relation()+
                            ", SID:" +searchstudent.getParentfk_s_sid()+
                            ", Mobile:" +searchstudent.getP_mobile()+"\n");
 
         System.out.println("-------------------End--------------"); 
         
         
         //Update
        
        System.out.println();
        System.out.println("--------------Where ID is 1-------------");
        parent_info ustudent = new parent_info();
        ustudent.setP_email("mi@email.com");
        parentinfoDao.updateParent(ustudent);
        System.out.println();
        System.out.println("--------------End-------------");
        
        //delete
        
        System.out.println();
        System.out.println("--------------Where ID is 1-------------");
        parentinfoDao.deleteParent(2);
        System.out.println();
        System.out.println("--------------End-------------");
        
    }
}
