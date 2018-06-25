package filter;

/*
  Created by y.rusanov on 23.06.2018
 */

import model.Project;
import model.TeamProject;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FilterProject {

    private List<Project> projects; //Collection List contain Project objects
    private TeamProject teamProject; //Object TeamProject

    public FilterProject(List<Project> projectList){
        this.projects = projectList;
        this.process();
    }

    /*
     * Process method get collection List and remove all Projects where working on them only one employee.
     * After this procedure the collection has sorted in descending order by field Days.
     */
    private void process(){

        int countProjects = 0;

        for (int i = 0; i < projects.size(); i++){
            Iterator<Project> iterator = projects.iterator();
            while (iterator.hasNext()){
                if(iterator.next().getProjId().equals(projects.get(i).getProjId())){
                    countProjects ++;
                }
            }
            if(countProjects == 1){
                projects.remove(i);
                i = 0;
            }
            countProjects = 0;
        }
        Collections.sort(projects);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for(Project project : projects){
            System.out.println(project.getDays() + " / " + project.getEmpId() + " / " + project.getProjId() + " / " + simpleDateFormat.format(project.getDateFrom()) + " / " + simpleDateFormat.format(project.getDateTo()));
        }

        //fix get couple team worked on project longest period
        for(int i = 0; i < projects.size(); i++){
            if(projects.get(i).getProjId().equals(projects.get(i+1).getProjId())){
                teamProject = new TeamProject(projects.get(i), projects.get(i+1));
                break;
            }
        }

        //teamProject = new TeamProject(projects.get(0), projects.get(1));
    }

    /*
     * @return object TeamProject, were contain the longest team worked on project
     */
    public TeamProject getTeamProject() {
        return teamProject;
    }
}
