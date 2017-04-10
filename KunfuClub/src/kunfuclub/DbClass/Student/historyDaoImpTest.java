/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kunfuclub.DbClass.Student;

import java.sql.Date;

/**
 *
 * @author Mithi
 */
public class historyDaoImpTest {

    public static void main(String[] args) {
        
        historyDao histry = new historyDaoImp();

        //add value
        history h1 = new history("Chumma", 200, Date.valueOf("1991-02-01"), 1);
        history h2 = new history("Chumma01", 200, Date.valueOf("1991-02-01"), 1);
        history h3 = new history("Chumma", 200, Date.valueOf("1991-02-01"), 1);
        histry.addHistory(h1);
        histry.addHistory(h2);
        histry.addHistory(h3);
        
        //Print Values
        System.out.println();
        System.out.println("----------------------All Students ------------------");
        histry.getAllHistory().forEach((histrys) -> {
            System.out.println(
                    "Id:" +histrys.getId()+
                            ", Reason" +histrys.getReason()+
                            ", Paid:" +histrys.getPaid()+
                            ", PaidDate:" +histrys.getPaid_date()+
                            ", S_id" +histrys.getHisfk_sid()+"\n");
        });
        System.out.println("-------------------End--------------");
        
        //Print 1 values
        System.out.println();
        System.out.println("----------------------Single Students ------------------");
        histry.getUserHistory(1).forEach((histrys) -> {
            System.out.println(
                    "Id:" +histrys.getId()+
                            ", Reason" +histrys.getReason()+
                            ", Paid:" +histrys.getPaid()+
                            ", PaidDate:" +histrys.getPaid_date()+
                            ", S_id" +histrys.getHisfk_sid()+"\n");
        });
        System.out.println("-------------------End--------------");
        
        //update all userid
        System.out.println();
        System.out.println("--------------Where SID is 1-------------");
           histry.getUserHistory(1).forEach((histrys) -> {
            
            histrys.setReason("No Chumma");
            histry.updateHistory(histrys);
        });
        System.out.println("-------------------End--------------");
        
        
        System.out.println();
        System.out.println("--------------Where ID is 1-------------");
        histry.deleteHistory(2);
        System.out.println();
        System.out.println("--------------End-------------");
        
        
    }
    
    
}
