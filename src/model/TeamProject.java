package model;

public class TeamProject {

    private String empl1;
    private String empl2;
    private int daysOnTeam;
    private String project;

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

    public String getEmpl1() {
        return empl1;
    }

    public String getEmpl2() {
        return empl2;
    }

    public int getDaysOnTeam() {
        return daysOnTeam;
    }

    public String getProject() {
        return project;
    }
}
