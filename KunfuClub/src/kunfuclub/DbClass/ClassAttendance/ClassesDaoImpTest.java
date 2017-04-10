/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kunfuclub.DbClass.ClassAttendance;

/**
 *
 * @author Mithi
 */
public class ClassesDaoImpTest {
     public static void main(String[] args){
         classesDao sclass = new ClassesDaoImp();
         
         //adding values
         Classes c1 = new Classes(1,"Basic","Monday","5:00 PM");
         Classes c2 = new Classes(2,"Intermediate","Tuesday","4:00 AM");
         sclass.addClass(c1);
         sclass.addClass(c2);
         
         System.out.println("----------------\n");
          sclass.getAllClasses().forEach((students) -> {
            System.out.println(
                            "Id:" +students.getC_id()+
                            ", Level:" +students.getC_level()+
                            ", Day:" +students.getC_day()+
                            ", Time" +students.getC_time()+
                            "\n");
        });
         System.out.println("---------------\n");
     
     
        //update
        Classes uclass = sclass.getClass(1);
        uclass.setC_level("Advance");
        sclass.updateClass(uclass);
        
        sclass.deleteClass(2);
     }
     
}
