package read;

import model.Project;

import java.io.*;
import java.util.LinkedList;

public class ReadProjFile {

    private String path;
    private String separator;
    private LinkedList<Project> projects;

    public ReadProjFile(){

    }

    public void process() throws IOException {
        Project project;
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        projects = new LinkedList<>();

        while ((line = bufferedReader.readLine()) != null){
            String clearLine = line.replaceAll("\\s+","");
            String sepField[] = clearLine.split(separator);
            project = new Project();
            project.setEmpId(sepField[0]);
            project.setProjId(sepField[1]);
            project.setDateFrom(sepField[2]);
            project.setDateTo(sepField[3]);
            projects.add(project);
        }
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public LinkedList<Project> getProjects() {
        return projects;
    }
}
