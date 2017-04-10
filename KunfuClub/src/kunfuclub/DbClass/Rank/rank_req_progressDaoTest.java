/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kunfuclub.DbClass.Rank;

import java.sql.Date;

/**
 *
 * @author Mithi
 */
public class rank_req_progressDaoTest {
    
    public static void main(String[] args){
        
        
        rankDao ranks = new rankDaoImp();
        rankreqDao rankreqs = new rankreqDaoImp();
        ProgressDao progs = new ProgressDaoImp();
        
        //adding rank
        rank r1 = new rank(1,"Tiger","Yellow");
        rank r2 = new rank(2,"Panther","Black");
        rank r3 = new rank(3,"Cat","White");
        ranks.addRank(r1);
        ranks.addRank(r2);
        ranks.addRank(r3);
        
        //adding rank req
        rankreq rq1 = new rankreq("able",1);
        rankreq rq2 = new rankreq("50 nl",1);
        rankreq rq3 = new rankreq("new",1);
        rankreqs.addRankreq(rq1);
        rankreqs.addRankreq(rq2);
        rankreqs.addRankreq(rq3);
        
        //adding progress
        Progress pr1 = new Progress(Date.valueOf("1991-02-01"),1,1);
        Progress pr2 = new Progress(Date.valueOf("1991-02-01"),2,1);
        Progress pr3 = new Progress(Date.valueOf("1991-02-01"),3,1);
        progs.addProgress(pr1);
        progs.addProgress(pr2);
        progs.addProgress(pr3);
        
        System.out.println("----------------------AlL Rank ------------------");
        ranks.getAllRank().forEach((students) -> {
            System.out.println(
                    "Id:" +students.getR_id()+
                            ", Name:" +students.getR_name()+
                            ", Belt:" +students.getR_belt()+"\n");
                            
        });
        System.out.println("----------------------End ---------------------------");
        
        System.out.println("----------------------All Rank req ------------------");
            rankreqs.getAllRankreq().forEach((students) -> {
                System.out.println(
                    "Id:" +students.getId()+
                            ", Rankid" +students.getFk_r_id()+
                            ", Req" +students.getReq()+"\n");
                            
        });
        System.out.println("----------------------End ---------------------------");
    
        System.out.println("----------------------All Progress ------------------");
            progs.getAllProgress().forEach((students) -> {
                System.out.println(
                            "Id:" +students.getId()+
                            ", date" +students.getPr_date()+
                            ", r_id" +students.getProgfk_rid()+        
                            ", sid" +students.getProgfk_sid()+"\n");                   
        });
        System.out.println("----------------------End ---------------------------");
    
        //Single value
        System.out.println("----------------------All single Method------------------");
        
        rank getr = ranks.getRank(1);
        System.out.println(
                    "Id:" +getr.getR_id()+
                            ", Name:" +getr.getR_name()+
                            ", Belt:" +getr.getR_belt()+"\n");
        
        /*Progress getp = progs.getProgress(2);
        System.out.println(
                            "Id:" +getp.getId()+
                            ", date" +getp.getPr_date()+
                            ", r_id" +getp.getProgfk_rid()+        
                            ", sid" +getp.getProgfk_sid()+"\n");
                           */ 
        
        rankreqs.getRankreq(1).forEach((students) -> {
                System.out.println(
                    "Id:" +students.getId()+
                            ", Rankid" +students.getFk_r_id()+
                            ", Req" +students.getReq()+"\n");
                            
        });
        
        progs.getrankProgress(1).forEach((students) -> {
                System.out.println(
                            "Id:" +students.getId()+
                            ", date" +students.getPr_date()+
                            ", r_id" +students.getProgfk_rid()+        
                            ", sid" +students.getProgfk_sid()+"\n");                   
        });
        
        progs.getstudentProgress(1).forEach((students) -> {
                System.out.println(
                            "Id:" +students.getId()+
                            ", date" +students.getPr_date()+
                            ", r_id" +students.getProgfk_rid()+        
                            ", sid" +students.getProgfk_sid()+"\n");                   
        });
        System.out.println("----------------------End ---------------------------");
    
        
        
     //update
      System.out.println("----------------------Starts ---------------------------");
        
        rank urank = ranks.getRank(1);
        urank.setR_belt("Red");
        ranks.updateRank(urank);
        
        rankreq urr = rankreqs.getRankreqId(1);
        urr.setReq("bye");
        rankreqs.updateRankreq(urr);
        
        Progress uprog = progs.getProgress(1);
        uprog.setProgfk_rid(2);
        progs.updateProgress(uprog);
        
      System.out.println("----------------------End ---------------------------");
    
     //delete
     System.out.println("----------------------Starts ---------------------------");
        ranks.deleteRank(1);
       // progs.deleteProgforUser(1, 1);
        rankreqs.deleteSingleRankReq(1);
     System.out.println("----------------------Starts ---------------------------");
    }    
}
