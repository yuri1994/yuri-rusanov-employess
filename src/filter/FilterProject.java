package filter;

import model.Project;
import model.TeamProject;

import java.io.FileReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FilterProject {

    private List<Project> projects;
    private TeamProject teamProject;
    public FilterProject(List<Project> projectList){
        this.projects = projectList;
        this.process();
    }

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
        teamProject = new TeamProject(projects.get(0), projects.get(1));
    }

    public TeamProject getTeamProject() {
        return teamProject;
    }
}
