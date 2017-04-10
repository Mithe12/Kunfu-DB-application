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
public class attendanceDaImpTest {
    
    public static void main(String[] args) {
        
        attendanceDao attend = new attendanceDaoImp();

        //adding values
        attendance c1 = new attendance(1, 11);
        attendance c2 = new attendance(1, 12);
        attend.addAttendance(c1);
        attend.addAttendance(c2);
        
        System.out.println("----------------\n");
        attend.getAllattendance().forEach((students) -> {
            System.out.println(
                    "Id:" + students.getId()
                    + ", Class" + students.getFk_c_id()
                    + ", Sid" + students.getAttfk_s_id()
                    + "\n");
        });
        System.out.println("---------------\n");

        //update
        attendance uatt = attend.getAttendance(3);
        uatt.setFk_c_id(1);
        attend.updateAttendance(uatt);
        
        attend.deleteAttendance(1);
    }
}
