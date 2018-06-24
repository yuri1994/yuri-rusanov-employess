package read;

/*
  Created by y.rusanov on 22.06.2018
 */

import model.Project;
import model.TeamProject;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadProjFile {

    private String path; //path in type String
    private String separator; //separator in type String
    private List<Project> projects; //projects in type List<T>
    private File file;
    /*
     * method process read the text file and separate each line in object Project
     * in the end of line add object Project to list collection
     */
    public void process() throws IOException {
        Project project;
        FileReader fileReader;
        if(path == null){
            fileReader = new FileReader(file);
        } else {
            fileReader = new FileReader(path);
        }
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
            project.setDays();
            projects.add(project);
        }
    }

    /*
     * @param path path to set the file path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /*
     * @param separator separator to set the separator on line
     */
    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public void setFile(File file) {
        this.file = file;
    }

    /*
     * @return current list collection of Projects
     */
    public List<Project> getProjects() {
        return projects;
    }
}
