package model;

import date.DateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Project implements Comparable<Project>{

    private String empId;
    private String projId;

    private Date dateFrom;
    private Date dateTo;


    private int days;



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

    public int getDays() {
        return days;
    }

    public void setDays() {
        long diff = dateTo.getTime() - dateFrom.getTime();
        days = (int) TimeUnit.MILLISECONDS.toDays(diff);
    }

    @Override
    public int compareTo(Project project) {
        if(this.getDays() < project.getDays()){
            return 1;
        }
        else {
            return -1;
        }

    }


}
