/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.models;


/**
 *
 * @author andx
 */
public class Semester {

    private String id;
    private String dateStart;
    private String dateEnd;

    public String getId() {
        return id;
    }

    public void setId(String semsID) {
        this.id = semsID;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String beginDate) {
        this.dateStart = beginDate;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String closeDate) {
        this.dateEnd = closeDate;
    }

    public Semester(String smsId, String smsFrom, String smsTo){
    this.id = smsId;
    this.dateStart = smsFrom;
    this.dateEnd = smsTo;    
    }
    
}
