/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kunfuclub.DbClass.Student;

import java.util.List;

/**
 *
 * @author Mithi
 */
public interface historyDao {
 
    public List<history> getAllHistory();
    
    public void addHistory(history his);
    
    public history getHistory(int id);
            
    public List<history> getUserHistory(int s_id);
    
    public void updateHistory(history his);
    
    public void deleteHistory(int id);
    
    public void updateUserHistory(history his);
    
}
