package model;

import date.DateFormat;

import java.util.Calendar;
import java.util.Date;

public class Project {

    private String empId;
    private String projId;

    private Date dateFrom;
    private Date dateTo;

    public Project(){

    }

    public Project(Project project){

    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        DateFormat dateFormatFrom = new DateFormat(dateFrom);
        this.dateFrom = dateFormatFrom.getDate();
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        if(dateTo.equals("NULL")){
            this.dateTo = Calendar.getInstance().getTime();
        }
        else{
            DateFormat dateFormatFrom = new DateFormat(dateTo);
            this.dateTo = dateFormatFrom.getDate();
        }
    }
}
