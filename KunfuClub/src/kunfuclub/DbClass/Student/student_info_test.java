/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kunfuclub.DbClass.Student;

import java.sql.Date;


public class student_info_test {

    public static void main(String[] args){
    
        student_infoDao studentinfoDao  = new student_infoDaoImp();
   
  
        //1st
    
        student_info student3 = new student_info
                (10
                        ,"Mithe","Lash",Date.valueOf("1991-02-01"),Date.valueOf("2016-11-11"),
                90,"mithe@email.com","Available");  
 
       //2nd
         student_info student1 = new student_info
                (11,"Mithelash","C",Date.valueOf("1991-02-01"),Date.valueOf("2016-11-11"),
                90,"mithe@email.com","Available");
   
        //3rd
        student_info student2 = new student_info
                (12,"Mithe","c",Date.valueOf("1991-02-01"),Date.valueOf("2016-11-11"),
                90,"mithe@email.com","Available");
   
        studentinfoDao.addStudent(student3);
        studentinfoDao.addStudent(student1);
        studentinfoDao.addStudent(student2);
        
        
        
        
        
        System.out.println();
        System.out.println("----------------------All Students ------------------");
        
        //Print all students
        studentinfoDao.getAllStudents().forEach((students) -> {
            System.out.println(
                    "Id:" +students.getS_id()+
                            ", Name:" +students.getS_fname()+ students.getS_lname()+
                            ", DOB:" +students.getS_dob()+
                            ", DOJ:" +students.getS_doj()+
                            ", Mobile:" +students.getS_mobile()+"\n");
        });
        System.out.println("-------------------End--------------");
        
        
        
        //Get
        
        System.out.println();
        System.out.println("--------------Where ID is 1-------------");
        
        student_info searchstudent = studentinfoDao.getStudent(1);
            System.out.println(
                    "Id:" +searchstudent.getS_id()+
                            ", Name:" +searchstudent.getS_fname()+ searchstudent.getS_lname()+
                            ", DOB:" +searchstudent.getS_dob()+
                            ", DOJ:" +searchstudent.getS_doj()+
                            ", Mobile:" +searchstudent.getS_mobile()+"\n");
 
         System.out.println("-------------------End--------------"); 
         
         
         //Update
        
        System.out.println();
        System.out.println("--------------Where ID is 1-------------");
        student_info ustudent = studentinfoDao.getStudent(1);
        ustudent.setS_email("mi@email.com");
        studentinfoDao.updateStudent(ustudent);
        System.out.println();
        System.out.println("--------------End-------------");
        System.out.println();
        System.out.println("--------------Where ID is 1-------------");
        
        student_info searchstudent1 = studentinfoDao.getStudent(1);
            System.out.println(
                    "Id:" +searchstudent1.getS_id()+
                            ", Name:" +searchstudent1.getS_fname()+ searchstudent1.getS_lname()+
                            ", DOB:" +searchstudent1.getS_dob()+
                            ", DOJ:" +searchstudent1.getS_doj()+
                            ", Mobile:" +searchstudent1.getS_mobile()+"\n");
 
         System.out.println("-------------------End--------------"); 
         
        
        //delete
        
        System.out.println();
        System.out.println("--------------Where ID is 1-------------");
        studentinfoDao.deleteStudent(2);
        System.out.println();
        System.out.println("--------------End-------------");
        
        System.out.println();
        System.out.println("--------------Where ID is 1-------------");
        
        student_info searchstudent2 = studentinfoDao.getStudent(1);
            System.out.println(
                    "Id:" +searchstudent2.getS_id()+
                            ", Name:" +searchstudent2.getS_fname()+ searchstudent.getS_lname()+
                            ", DOB:" +searchstudent2.getS_dob()+
                            ", DOJ:" +searchstudent2.getS_doj()+
                            ", Mobile:" +searchstudent2.getS_mobile()+"\n");
 
         System.out.println("-------------------End--------------"); 
         
       //getOne
       
         
    }
}