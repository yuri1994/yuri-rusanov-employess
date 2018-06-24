package model;

/*
  Created by y.rusanov on 23.06.2018
 */

public class TeamProject {

    private String empl1; //emp1 in String type
    private String empl2; //emp2 in String type
    private int daysOnTeam; //daysOnTeam in int type
    private String project; //project in String type

    public TeamProject(Project project1, Project project2) {
        this.empl1 = project1.getEmpId();
        this.empl2 = project2.getEmpId();
        this.project = project1.getProjId();

        if(project1.getDays() < project2.getDays()){
            this.daysOnTeam = project1.getDays();
        }
        else{
            this.daysOnTeam = project2.getDays();
        }
    }

    /*
     * @return current employee 1
     */
    public String getEmpl1() {
        return empl1;
    }

    /*
     * @return current employee 2
     */
    public String getEmpl2() {
        return empl2;
    }

    /*
     * @return current days worked on project
     */
    public int getDaysOnTeam() {
        return daysOnTeam;
    }

    /*
     * @return current project
     */
    public String getProject() {
        return project;
    }
}
