/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kunfuclub.DbClass.ClassAttendance;

import java.util.List;

/**
 *
 * @author Mithi
 */
public interface classesDao {
    
    public List<Classes> getAllClasses();
    
    public void addClass(Classes value);
    
    public Classes getClass(int c_id);
    
    public void updateClass(Classes value);
    
    public void deleteClass(int c_id);
    
}
