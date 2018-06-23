package date;

import java.util.*;

public class DateFormat {

    private String dateStr;
    private Date date;
    private String[] dateFields;

    private String[] monthsShort = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    private String[] monthsLong = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    public DateFormat(String dateStr){
        this.dateStr = dateStr;
        this.process();
    }

    private void process(){
        Calendar calendar = Calendar.getInstance();
        String separator = this.getDateSep();

        if(separator != null){
            dateFields = dateStr.split(separator);
            int year = this.getYear();
            int month = 0;
            if(this.monthType() == 0){
                month = this.getMonth();
            }
            else {
                month = this.getMonthByTxt();
            }

            int day = this.getDay();
            calendar.set(year,month-1,day);
            date = calendar.getTime();
        }

    }

    private String[] removeElement(int index){

        List<String> stringList = new ArrayList<String>(Arrays.asList(dateFields));

        stringList.remove(index);

        return stringList.toArray(new String[0]);
    }

    private int getYear(){

        int year = 0;

        for (int i = 0; i < dateFields.length; i++) {
            if (dateFields[i].length() == 4) {
                if(!Character.isAlphabetic(dateFields[i].charAt(0))){
                    year = Integer.valueOf(dateFields[i]);
                    dateFields = this.removeElement(i);
                    break;
                }
            }
        }

        return year;
    }

    private int getMonth(){

        int month = 0;

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

        return month;
    }

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

    public Date getDate(){
        return date;
    }

    private String getDateSep(){
        char separator;

        for(int i = 0; i < dateStr.length(); i++){
            separator = dateStr.charAt(i);
            if(!Character.isDigit(separator) && !Character.isAlphabetic(separator))
                return String.valueOf(separator);
        }

        return null;
    }

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
