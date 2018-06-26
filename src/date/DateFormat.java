package date;

/*
  Created by y.rusanov on 24.06.2018
 */

import java.util.*;

public class DateFormat {

    private String dateStr;     //date in String type
    private Date date;  //date in Date type
    private String[] dateFields; //array with fields year, month and day.

    private String[] monthsShort = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}; //Array with months name present in short version
    private String[] monthsLong = {"January","February","March","April","May","June","July","August","September","October","November","December"}; //Array with months name present in short version

    public DateFormat(String dateStr){
        this.dateStr = dateStr;
        this.process();
    }

    private boolean positionYearLast = false;

    /*
     * Process method set date in type Date from string where coming from file.
     *
     */
    private void process(){
        Calendar calendar = Calendar.getInstance();
        String separator = this.getDateSep();

        if(separator != null){
            dateFields = dateStr.split(separator);
            int year = this.getYear();
            int month = 0;
            if(this.monthType() == 0){
                month = this.getMonth();
            } else {
                month = this.getMonthByTxt();
            }

            int day = this.getDay();
            calendar.set(year,month-1,day);
            date = calendar.getTime();
        }

    }

    /*
     * removeElement method remove element from array. The array contain year, month and day.
     * @param index index of date fields array
     */
    private String[] removeElement(int index){

        List<String> stringList = new ArrayList<String>(Arrays.asList(dateFields));

        stringList.remove(index);

        return stringList.toArray(new String[0]);
    }

    /*
     * getYear method is for to recognize and get year from array with year, month and day. After recognizing of year, the element is deleted from array.
     * @return year in type int
     */
    private int getYear(){

        int year = 0;

        for (int i = 0; i < dateFields.length; i++) {
            if (dateFields[i].length() == 4) {
                if(!Character.isAlphabetic(dateFields[i].charAt(0))){
                    year = Integer.valueOf(dateFields[i]);
                    dateFields = this.removeElement(i);
                    if(i == 2){
                        positionYearLast = true;
                    }
                    break;
                }
            }
        }

        return year;
    }

    /*
     * getMonth method is for to recognize and get month from array with year, month and day. After recognizing of month, the element is deleted from array.
     * @return month in type int
     */
    private int getMonth(){

        int month = 0;

        if(positionYearLast){
            int num = Integer.valueOf(dateFields[1]);
            if(num >= 1 && num <= 12) {
                month = Integer.valueOf(dateFields[1]);
                dateFields = this.removeElement(1);
            }else {
                month = Integer.valueOf(dateFields[0]);
                dateFields = this.removeElement(0);
            }
        } else {
            int num = Integer.valueOf(dateFields[0]);
            if(num >= 1 && num <= 12) {
                month = Integer.valueOf(dateFields[0]);
                dateFields = this.removeElement(0);
            }else {
                month = Integer.valueOf(dateFields[1]);
                dateFields = this.removeElement(1);
            }
        }


/*
      for (int i = 0; i < dateFields.length; i++) {
            if (dateFields[i].length() == 2) {
                int num = Integer.valueOf(dateFields[i]);
                if(num >= 1 && num <= 12){
                    month = Integer.valueOf(dateFields[i]);
                    dateFields = this.removeElement(i);
                    break;
                }
            }
        }

 */

        return month;
    }

    /*
     * getDay method is for to recognize and get day from array with year, month and day. After recognizing of day, the element is deleted from array.
     * @return day in type int
     */
    private int getDay(){

        int day = 0;

        for (int i = 0; i < dateFields.length; i++) {
            if (dateFields[i].length() == 2) {
                int num = Integer.valueOf(dateFields[i]);
                if(num >= 1 && num <= 31){
                    day = Integer.valueOf(dateFields[i]);
                    dateFields = this.removeElement(i);
                    break;
                }
            }
        }

        return day;
    }

    /*
     * getDate is for return the final date after separating
     * @return the final date in type Date
     */
    public Date getDate(){
        return date;
    }

    /*
     * getDateSep method is for recognize the separator in date where coming from file.
     * @return separator in type String
     */
    private String getDateSep(){
        char separator;

        for(int i = 0; i < dateStr.length(); i++){
            separator = dateStr.charAt(i);
            if(!Character.isDigit(separator) && !Character.isAlphabetic(separator))
                return String.valueOf(separator);
        }

        return null;
    }

    /*
     * monthType method recognize the type of month. The Month can be present in text or in number.
     * @return the type of month in type int.
     * type 0: the month is in Number, type 1: the month is in Text
     */
    private int monthType(){

        for(String field : dateFields){
            try {
                Integer.valueOf(field);
            }
            catch (NumberFormatException ignored){
                return 1;
            }
        }
        return 0;
    }

    /*
     * getMonthByTxt method recognize the month in text which number is.
     * @return the number of month in int type.
     */
    private int getMonthByTxt(){

        for(int i = 0; i < dateFields.length; i++){
            if(Character.isAlphabetic(dateFields[i].charAt(0))){
                for(int k = 0; k < monthsShort.length; k++){
                    if(dateFields[i].equals(monthsShort[k])){
                        return k + 1;
                    }
                }
                for(int k = 0; k < monthsLong.length; k++){
                    if(dateFields[i].equals(monthsLong[k])){
                        return k + 1;
                    }
                }
                break;
            }
        }

        return 0;
    }
}
