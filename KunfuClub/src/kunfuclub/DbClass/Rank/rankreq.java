/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kunfuclub.DbClass.Rank;

/**
 *
 * @author Mithi
 */
public class rankreq {
    private String req;
    private int fk_r_id;
    private int id;
    public rankreq(){
        
    }
    public rankreq( String req, int fk_r_id) {
     
        this.req = req;
        this.fk_r_id = fk_r_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    public int getFk_r_id() {
        return fk_r_id;
    }

    public void setFk_r_id(int fk_r_id) {
        this.fk_r_id = fk_r_id;
    }
    
    
    
}
