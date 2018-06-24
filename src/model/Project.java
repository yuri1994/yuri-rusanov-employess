package model;

/*
  Created by y.rusanov on 22.06.2018
 */

import date.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Project implements Comparable<Project>{

    private String empId; //empId in String type
    private String projId; //projId in String type
    private Date dateFrom; //dateFrom in Date type
    private Date dateTo; //dateTo in Date type
    private int days; // days in int type

    public Project(){

    }

    /*
     * @return current employee
     */
    public String getEmpId() {
        return empId;
    }

    /*
     * @param empId empId to set employee
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /*
     * @return current project
     */
    public String getProjId() {
        return projId;
    }

    /*
     * @param projId projId to set project
     */
    public void setProjId(String projId) {
        this.projId = projId;
    }

    /*
     * @return current date from
     */
    public Date getDateFrom() {
        return dateFrom;
    }

    /*
     * @param dateFrom dateFrom in String type to set dateFrom in Date type
     */
    public void setDateFrom(String dateFrom) {
        DateFormat dateFormatFrom = new DateFormat(dateFrom);
        this.dateFrom = dateFormatFrom.getDate();
    }

    /*
     * @return current date to
     */
    public Date getDateTo() {
        return dateTo;
    }

    /*
     * @param dateTo dateTo in String type to set dateTo in Date type
     */
    public void setDateTo(String dateTo) {
        if(dateTo.equals("NULL")){
            this.dateTo = Calendar.getInstance().getTime();
        }
        else{
            DateFormat dateFormatFrom = new DateFormat(dateTo);
            this.dateTo = dateFormatFrom.getDate();
        }
    }

    /*
     * @return current days: different between date to and date from
     */
    public int getDays() {
        return days;
    }

    /*
     * setDayse get the different between dateTo and dateFrom in int type.
     */
    public void setDays() {
        long diff = dateTo.getTime() - dateFrom.getTime();
        days = (int) TimeUnit.MILLISECONDS.toDays(diff);
    }

    /*
     * In The Override method compareTo compare the incoming object Project field days with the current object Project field days.
     * The mehtod is used by Collection.sort(List<T>)
     * @param project project incoming object for comparison of days
     */
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
