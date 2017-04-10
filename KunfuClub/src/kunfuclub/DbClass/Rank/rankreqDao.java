/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kunfuclub.DbClass.Rank;

import java.util.List;

/**
 *
 * @author Mithi
 */
public interface rankreqDao {
    
    public List<rankreq> getAllRankreq();
    
    public void addRankreq(rankreq req);
    
    public List<rankreq> getRankreq(int Rank_r_id);
    
    public rankreq getRankreqId(int id);
    
    public void updateRankreq(rankreq req);
    
    public void deleteRankreqAll(int Rank_r_id);
    
    public void deleteSingleRankReq(int id);
    
}
